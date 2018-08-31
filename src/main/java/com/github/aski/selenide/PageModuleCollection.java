package com.github.aski.selenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

public final class PageModuleCollection<T extends AbstractPageModule> {
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

    public void shouldAll(Condition condition) {
        selector.get().excludeWith(condition).shouldHaveSize(0);
    }

    public void shouldAllBe(Condition condition) {
        shouldAll(condition);
    }

    public void shouldAllHave(Condition condition) {
        shouldAll(condition);
    }

    public void shouldAllNot(Condition condition) {
        selector.get().filterBy(condition).shouldHaveSize(0);
    }

    public void shouldAllNotBe(Condition condition) {
        shouldAllNot(condition);
    }

    public void shouldAllNotHave(Condition condition) {
        shouldAllNot(condition);
    }

    public void shouldHaveSize(int size) {
        selector.get().shouldHaveSize(size);
    }

    public PageModuleCollection<T> filterBy(Condition condition) {
        return new PageModuleCollection<>(() -> selector.get().filterBy(condition), pageModuleClass);
    }

    public PageModuleCollection<T> excludeWith(Condition condition) {
        return new PageModuleCollection<>(() -> selector.get().excludeWith(condition), pageModuleClass);
    }

    public T first() {
        return makePageModule(() -> selector.get().first());
    }

    public PageModuleCollection<T> first(int elements) {
        return new PageModuleCollection<>(() -> selector.get().first(elements), pageModuleClass);
    }

    public T last() {
        return makePageModule(() -> selector.get().last());
    }

    public PageModuleCollection<T> last(int elements) {
        return new PageModuleCollection<>(() -> selector.get().last(elements), pageModuleClass);
    }

    public T findBy(final Condition condition) {
        return makePageModule(() -> selector.get().findBy(condition));
    }

    private T makePageModule(Supplier<SelenideElement> supplier) {
        try {
            Constructor<T> constructor = pageModuleClass.getConstructor(Supplier.class);
            return constructor.newInstance(supplier);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
