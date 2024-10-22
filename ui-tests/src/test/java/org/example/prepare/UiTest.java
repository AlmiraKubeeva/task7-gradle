package org.example.prepare;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.pages.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UiTest {
    protected CheckboxesPage checkboxesPage = new CheckboxesPage();
    protected DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage();
    protected DropdownPage dropdownPage = new DropdownPage();
    protected InputsPage inputsPage = new InputsPage();

    @BeforeEach
    void setup() {
        Configuration.browser = "firefox";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "0, true, 1, false", // Клик по первому чекбоксу, затем по второму
            "1, false, 0, true"  // Клик по второму чекбоксу, затем по первому
    })
    void checkboxesTest(int firstIndex, boolean resultOfFirstClick, int secondIndex, boolean resultOfSecondClick) {
        checkboxesPage.openCheckboxes();
        checkboxesPage.clickCheckbox(firstIndex);
        checkboxesPage.clickCheckbox(secondIndex);
        PageAssert.assertCheckboxesState(checkboxesPage, firstIndex, secondIndex, resultOfFirstClick, resultOfSecondClick);
    }

    static boolean countOfElementsIs5 = false;
    @RepeatedTest(value = 10)
    void disappearingElementsTest() {
        if (!countOfElementsIs5) {
            disappearingElementsPage.openDisappearingElements();
            PageAssert.assertCountOfDisappearingElementsIs5(disappearingElementsPage);
            countOfElementsIs5 = true;
        }

    }

    @Test
    void dropdownTest() {
        dropdownPage.openDropdown();
        dropdownPage.selectOption(1);
        PageAssert.assertDropdownState(dropdownPage, "Option 1");
        dropdownPage.selectOption(2);
        PageAssert.assertDropdownState(dropdownPage, "Option 2");
    }

        @TestFactory
        List<DynamicTest> inputShowNumberTest() {
        List<String> validInputs = Arrays.asList("1", "5", "10", "100", "1000", "10000");
        List<String> invalidInputs = Arrays.asList("d", "()", " 5", "5 ");

        List<DynamicTest> tests = new ArrayList<>();

        // Тесты для валидных значений
        validInputs.forEach(value -> {
            tests.add(DynamicTest.dynamicTest("Valid Input: " + value, () -> {
                inputsPage.openInputs();
                inputsPage.enterValue(value);
                PageAssert.assertNumIsInputed(inputsPage, value);
            }));
        });

        // Тесты для невалидных значений
        invalidInputs.forEach(value -> {
            tests.add(DynamicTest.dynamicTest("Invalid Input: " + value, () -> {
                inputsPage.openInputs();
                inputsPage.enterValue(value);
                PageAssert.assertNumIsNotInputed(inputsPage, value);
            }));
        });

        return tests;
    }


    @AfterAll
    static void tearDown() {
        getWebDriver().quit();
    }
}
