package com.example.project.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * IMDB Search Page POM (Page Object Model)
 */
public class HTWGMainPage {
    WebDriver driver;

    @FindBy(css = ".magnifier")
    WebElement magnifierElement;

    @FindBy(css = ".search-input input")
    WebElement searchInputElement;

    public HTWGMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setQuery(String q) {
        q = q == null ? "" : q;
        searchInputElement.sendKeys(q);
    }

    public void startSearch() {
        searchInputElement.sendKeys(Keys.ENTER);
    }

    public void openMagnifier() {
        magnifierElement.sendKeys(Keys.ENTER);
    }
}

