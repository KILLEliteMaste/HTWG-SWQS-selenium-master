package com.example.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * IMDB Search Page POM (Page Object Model)
 */
public class HTWGSearchResultPage {
    WebDriver driver;

    //@FindBy(linkText = "Eiglsperger")
    WebElement webElement;

    public HTWGSearchResultPage(WebDriver driver, String name) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        this.webElement = driver.findElement(By.linkText(name));
    }

    public void openPage() {
        webElement.click();
    }
}

