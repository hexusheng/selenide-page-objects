package com.github.aski.selenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public class PageModuleCollection<T extends AbstractPageModule> {
    private final Supplier<ElementsCollection> selector;
    private final Class<T> pageModuleClass;

    public PageModuleCollection(Supplier<ElementsCollection> selector, Class<T> pageModuleClass) {
        this.selector = selector;
        this.pageModuleClass = pageModuleClass;
    }

    public void shouldBe(CollectionCondition... conditions) {
        selector.get().shouldBe(conditions);
    }

    public void shouldHave(CollectionCondition... conditions) {
        selector.get().shouldHave(conditions);
    }

    public void shouldHaveSize(int size) {
        selector.get().shouldHaveSize(size);
    }

    public PageModuleCollection<T> filterBy(Condition condition) {
        return new PageModuleCollection<>(() -> selector.get().filterBy(condition), pageModuleClass);
    }

    public T findBy(Condition condition) {
        Supplier<SelenideElement> element = () -> selector.get().findBy(condition);
        try {
            Constructor<T> constructor = pageModuleClass.getConstructor(Supplier.class);
            return constructor.newInstance((Supplier) () -> selector.get().findBy(condition));
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
