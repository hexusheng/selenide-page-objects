package com.github.aski.selenide;

import com.github.aski.selenide.modules.TextField;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class CollectionsTest {

    public void method() {
        // create a collection for all web elements with class 'foo'
        PageModuleCollection<TextField> textFields =
                new PageModuleCollection<>(() -> $$(By.className("foo")), TextField.class);

        // assert that there are 5 of them
        textFields.shouldHaveSize(5);

        textFields.shouldAll(appear);

        // assert that all text fields are enabled - can text fields be enabled ?
        textFields.shouldAllBe(enabled);

        // or another way to check the same:
        textFields.filterBy(not(readonly)).shouldHaveSize(5);

        // the first text field should have '1', ...
        textFields.shouldHave(texts("1", "2", "3", "4", "5"));

        // the text field with the '1' in it should be focused
        textFields.findBy(text("1")).shouldBe(focused);

        // the rest of the text fields should all be hidden
        textFields.last(4).shouldAllNotBe(visible);
    }
}
