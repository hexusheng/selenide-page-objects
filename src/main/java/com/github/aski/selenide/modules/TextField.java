package com.github.aski.selenide.modules;

import com.codeborne.selenide.SelenideElement;
import com.github.aski.selenide.AbstractPageModule;
import org.openqa.selenium.By;

import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.$;

public class TextField extends AbstractPageModule {

    public TextField(Supplier<SelenideElement> selector) {
        super(selector);
    }

    public void setValue(final String value) {
        selector.get().setValue(value);
    }
}
