package org.example.pages;

import static org.junit.jupiter.api.Assertions.*;

public class PageAssert {
    public static void assertCheckboxesState(CheckboxesPage page, int firstIndex, int secondIndex,
                                             boolean firstExpected, boolean secondExpected) {
        assertEquals(firstExpected, page.isCheckboxChecked(firstIndex));
        assertEquals(secondExpected, page.isCheckboxChecked(secondIndex));
    }

    public static void assertDropdownState(DropdownPage page, String expectedText) {
        assertEquals(page.getSelectedOptionText(), expectedText, "Dropdown should select the expected option");
    }

    public static void assertCountOfDisappearingElementsIs5(DisappearingElementsPage page) {
        assertEquals(5, page.countOfElements(), "Count of elements should be 5");
    }

    public static void assertNumIsInputed(InputsPage page, String expected) {
        assertEquals(expected, page.getValue(), "Input value should be " + expected);
    }

    public static void assertNumIsNotInputed(InputsPage page, String unexpected) {
        assertNotEquals(unexpected, page.getValue(), "Input value not should be " + unexpected);
    }
}
