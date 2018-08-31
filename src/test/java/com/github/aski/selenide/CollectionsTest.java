package com.github.aski.selenide;

import com.github.aski.selenide.modules.TextField;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class CollectionsTest {

    public void method() {
        // create a collection for all web elements with class 'foo'
        PageModuleCollection<TextField> allTextFields =
                new PageModuleCollection<>(() -> $$(By.className("foo")), TextField.class);

        // assert that there are 5 of them
        allTextFields.shouldHaveSize(5);

        // assert that all text fields are editable
        allTextFields.filterBy(readonly).shouldBe(empty);

        // or another way to check the same:
        allTextFields.filterBy(not(readonly)).shouldHaveSize(5);

        // the first text field should have '1', ...
        allTextFields.shouldHave(texts("1", "2", "3", "4", "5"));

        // the text field with the '1' in it should be focused
        allTextFields.findBy(text("1")).shouldBe(focused);

    }
}
