package com.github.aski.selenide;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AbstractPageModule {
    protected final By selector;

    public AbstractPageModule(By selector) {
        this.selector = selector;
    }

    public final void should(Condition... conditions) {
        $(selector).should(conditions);
    }

    public final void shouldBe(Condition... conditions) {
        $(selector).shouldBe(conditions);

    }

    public final void shouldHave(Condition... conditions) {
        $(selector).shouldHave(conditions);

    }

    public final void shouldNot(Condition... conditions) {
        $(selector).shouldNot(conditions);
    }

    public final void shouldNotBe(Condition... conditions) {
        $(selector).shouldNotBe(conditions);

    }

    public final void shouldNotHave(Condition... conditions) {
        $(selector).shouldNotHave(conditions);
    }
}
