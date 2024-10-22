package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.example.utils.UIProps;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static org.example.utils.Urls.DISAPPEARING_ELEMENTS;

public class DisappearingElementsPage {
    UIProps props = ConfigFactory.create(UIProps.class);

    ElementsCollection elements = $$x("//*[@id=\"content\"]//li");

    @Step ("Открыть страницу с исчезающими элементами")
    public void openDisappearingElements() {
        open(props.baseUrl() + DISAPPEARING_ELEMENTS);
    }

    @Step("Вывести количество не исчезнувших элементов")
    public int countOfElements() {
        return elements.size();
    }
}
