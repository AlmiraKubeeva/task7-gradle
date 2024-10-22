package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class CheckBoxesPage {

    ElementsCollection checkboxes = $$x("//input");

    public void checkFirstCheckbox() {
        checkboxes.get(0).click();
    }

    public void uncheckSecondCheckbox() {
        checkboxes.get(1).click();
    }

    public boolean isFirstCheckboxChecked() {
        return checkboxes.get(0).should(Condition.attribute("checked", "true"));
    }

    public boolean isSecondCheckboxUnchecked() {
        return checkboxes.get(1).should(Condition.attribute("checked", ""));
    }

}
