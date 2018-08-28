package com.github.aski.selenide;

import com.github.aski.selenide.pages.LandingPage;
import com.github.aski.selenide.pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.github.aski.selenide.PageSupport.at;
import static com.github.aski.selenide.PageSupport.to;

public class Playground {

    public void test() {
        // navigate to the login page
        LoginPage loginPage = to(LoginPage.class);

        loginPage.username().shouldBe(focused);
        loginPage.loginButton().shouldBe(disabled);

        loginPage
                .username("foo")
                .password("bar");

        loginPage.loginButton().shouldBe(enabled);
        loginPage.loginButton().click();

        // login should have been successful and we should have
        // been redirected to the landing page
        LandingPage landingPage = at(LandingPage.class);

        // there should be a hidden text field
        landingPage.theTextField().should(exist, not(visible));

        // and a clickable button
        landingPage.aButton().shouldBe(visible, enabled);
        // once we click that ...
        landingPage.aButton().click();

        // the text field should become visible and it should have the text 'lalala'
        landingPage.theTextField().should(be(visible), have(text("lalala")));
    }
}
