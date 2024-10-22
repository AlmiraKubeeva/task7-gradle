package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.example.utils.UIProps;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.example.utils.Urls.INPUTS;

public class InputsPage {
    UIProps props = ConfigFactory.create(UIProps.class);

    SelenideElement input = $x("//input");

    @Step ("Открыть страницу с вводом")
    public void openInputs() {
        open(props.baseUrl() + INPUTS);
    }

    @Step("Ввести значение '{value}'")
    public void enterValue(String value) {
        input.sendKeys(value);
    }

    @Step("Получить значение")
    public String getValue() {
        return input.getAttribute("value");
    }
}
