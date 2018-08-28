package com.github.aski.selenide.pages;

import com.codeborne.selenide.WebDriverRunner;
import com.github.aski.selenide.Page;
import com.github.aski.selenide.modules.Button;
import com.github.aski.selenide.modules.TextField;

import java.util.Objects;

public class LandingPage implements Page {
    private TextField theTextField;
    private Button<LandingPage> aButton;

    public TextField theTextField() {
        return theTextField;
    }

    public Button<LandingPage> aButton() {
        return aButton;
    }

    @Override
    public boolean isDisplayed() {
        return Objects.equals(getUrl(), WebDriverRunner.url());
    }

    @Override
    public String getUrl() {
        // this shouldn't actually be an absolute url, just a path
        return "http://example.com/landing";
    }
}
