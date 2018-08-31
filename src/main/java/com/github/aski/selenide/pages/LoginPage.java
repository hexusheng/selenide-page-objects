package com.github.aski.selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.github.aski.selenide.Page;
import com.github.aski.selenide.modules.Button;
import com.github.aski.selenide.modules.TextField;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage implements Page {

    private final TextField username = new TextField(() -> $(By.id("username")));
    private final TextField password = new TextField(() -> $(By.id("password")));

    private final TextField complicated = new TextField(() ->
            $(By.id("foo")).$$(By.tagName("input")).find(Condition.text("Hello")));

    private final TextField complicated2 = new TextField(() -> {
        // find an element with id 'container', look for a label in there and get its 'for' attribute
        // which is another element 'id'.
        String id = $(By.id("container")).$(By.tagName("label")).getAttribute("for");
        // get that other element and return it
        return $(By.id(id));
    });



    private final Button<LandingPage> button = new Button<>(() -> $(By.id("login")), LandingPage.class);

    public TextField username() {
        return username;
    }

    public LoginPage username(String value) {
        username.setValue(value);
        return this;
    }

    public TextField password() {
        return password;
    }

    public LoginPage password(String value) {
        password.setValue(value);
        return this;
    }

    public Button loginButton() {
        return button;
    }

    public LandingPage submit() {
        return button.click();
    }

    @Override
    public boolean isDisplayed() {
        // check by comparing url stored in the page object against the webdriver's current url
        // and also against the content of the page.
        return $(By.id("login-page-section")).isDisplayed() &&
                Objects.equals(getUrl(), WebDriverRunner.url());
    }

    @Override
    public String getUrl() {
        return "http://example.com/login";
    }
}
