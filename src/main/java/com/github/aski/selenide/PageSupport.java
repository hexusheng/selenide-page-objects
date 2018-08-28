package com.github.aski.selenide;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public final class PageSupport {
    private PageSupport() {
        // no instances
    }

    public static <T extends Page> T to(Class<T> pageClazz) {
        T page = page(pageClazz);
        open(page.getUrl());
        return page;

    }

    public static <T extends Page> T at(Class<T> pageClazz) {
        T page = page(pageClazz);
        if (!page.isDisplayed()) {
            throw new AssertionError("current page is not " + pageClazz);
        }
        return page;
    }
}
