package com.github.aski.selenide.modules;

import com.codeborne.selenide.SelenideElement;
import com.github.aski.selenide.AbstractPageModule;
import com.github.aski.selenide.Page;
import org.openqa.selenium.By;

import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class Button<T extends Page> extends AbstractPageModule {
    private Class<T> targetPageClazz;

    public Button(Supplier<SelenideElement> selector, Class<T> targetPageClazz) {
        super(selector);

        this.targetPageClazz = targetPageClazz;
    }

    public T click() {
        selector.get().click();
        return page(targetPageClazz);
    }
}
