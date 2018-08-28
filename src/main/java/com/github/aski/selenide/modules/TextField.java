package com.github.aski.selenide.modules;

import com.github.aski.selenide.AbstractPageModule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TextField extends AbstractPageModule {

    public TextField(By selector) {
        super(selector);
    }

    public void setValue(final String value) {
        $(selector).setValue(value);
    }
}
