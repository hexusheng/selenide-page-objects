package com.github.aski.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.util.function.Supplier;
import static com.codeborne.selenide.Selenide.$;

public abstract class AbstractPageModule {
    protected final Supplier<SelenideElement> selector;

    public AbstractPageModule(Supplier<SelenideElement> selector) {
        this.selector = selector;

    }

    public final void should(Condition... conditions) {
        $(selector.get()).should(conditions);
    }

    public final void shouldBe(Condition... conditions) {
        selector.get().shouldBe(conditions);

    }

    public final void shouldHave(Condition... conditions) {
        selector.get().shouldHave(conditions);

    }

    public final void shouldNot(Condition... conditions) {
        selector.get().shouldNot(conditions);
    }

    public final void shouldNotBe(Condition... conditions) {
        selector.get().shouldNotBe(conditions);

    }

    public final void shouldNotHave(Condition... conditions) {
        selector.get().shouldNotHave(conditions);
    }
}
