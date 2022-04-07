package com.example.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HTWGProfessorPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"c7471\"]/p[1]")
    WebElement we;

    public HTWGProfessorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement verify() {
        return we;
    }
}
