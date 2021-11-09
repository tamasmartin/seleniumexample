package com.epam.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EpamPage {

    private WebDriver driver;

    private By careersLink = By.xpath("//ul[@class='top-navigation__row']//a[text() = 'Careers']");

    public EpamPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://epam.com");
    }

    public JobSearchPage clickCareersLink() {
        driver.findElement(careersLink).click();
        return new JobSearchPage(driver);
    }
}
