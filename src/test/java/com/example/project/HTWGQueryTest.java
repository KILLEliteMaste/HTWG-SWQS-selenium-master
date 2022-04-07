package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import com.example.project.pages.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(value=Lifecycle.PER_CLASS)
public class HTWGQueryTest {

    private WebDriver driver;
    private HTWGMainPage htwgMainPage;
    private HTWGSearchResultPage htwgSearchResultPage;
    private HTWGProfessorPage htwgProfessorPage;

    @BeforeAll
    public void setup() throws URISyntaxException {
        System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testHTWGEiglSearch() throws InterruptedException {
        // Search on Home Page
        driver.get("https://www.htwg-konstanz.de/");
        htwgMainPage = new HTWGMainPage(driver);
        htwgMainPage.openMagnifier();
        htwgMainPage.setQuery("Eiglsperger");
        htwgMainPage.startSearch();

        htwgSearchResultPage = new HTWGSearchResultPage(driver, "Eiglsperger");
        htwgSearchResultPage.openPage();

        htwgProfessorPage = new HTWGProfessorPage(driver);
        WebElement webElement = htwgProfessorPage.verify();
        assertTrue(webElement.getText().contains("Software-Qualitätssicherung"));
    }

    private String getChromeDriverPath() {
        return Paths.get("src","main","resources","chromedriver").toString();
    }

    /**
     * Example using JUnit
     * https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/AfterAll.html
     */
    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
