package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.example.utils.UIProps;

import static com.codeborne.selenide.Selenide.*;
import static org.example.utils.Urls.DROPDOWN;

public class DropdownPage {
    UIProps props = ConfigFactory.create(UIProps.class);

    private final ElementsCollection options = $$x("//option");
    private final SelenideElement dropdown = $x("//select[@id='dropdown']");

    @Step ("Открыть страницу с выбором опций")
    public void openDropdown() {
        open(props.baseUrl() + DROPDOWN);
    }

    @Step("Выбрать опцию номер {index}")
    public void selectOption(int index) {
        dropdown.selectOption(index);
    }

    @Step("Получить текст выбранной опции")
    public String getSelectedOptionText() {
        return dropdown.getText();
    }
}