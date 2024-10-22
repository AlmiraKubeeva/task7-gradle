package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static org.example.utils.Urls.CHECKBOXES;

import org.aeonbits.owner.ConfigFactory;
import org.example.utils.UIProps;



public class CheckboxesPage {
    UIProps props = ConfigFactory.create(UIProps.class);

    ElementsCollection checkboxes = $$x("//input");

    private CheckboxesPage getThis() {
        return this;
    }

    @Step ("Открыть страницу чекбоксов")
    public void openCheckboxes() {
        open(props.baseUrl() + CHECKBOXES);
    }

    @Step("Кликнуть по чекбоксу {index}")
    public void clickCheckbox(int index) {
        checkboxes.get(index).click();
    }

    @Step("Проверить, выбран ли чекбокс с индексом {index}")
    public boolean isCheckboxChecked(int index) {
        return checkboxes.get(index).isSelected();
    }
}
