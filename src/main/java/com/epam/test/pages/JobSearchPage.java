package com.epam.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobSearchPage {

    private WebDriver driver;

    private By inputKeyWordBy = By.cssSelector("input[placeholder='Keyword']");

    private By ddSelectLocation = By.cssSelector("span.select2-selection--single");

    @FindBy(css = "button.recruiting-search__submit")
    private WebElement btnFind;

    @FindBy(css = "h1.search-result__heading")
    private WebElement foundJob;

    public JobSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void typeSearchKeyword(String text) {
        driver.findElement(inputKeyWordBy).sendKeys(text);
    }

    public void clickFind() {
        btnFind.click();
    }

    public String getFindingHeading() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(foundJob));
        return foundJob.getText();
    }

    public void selectLocation(String location) {
        WebElement ddLocation = driver.findElement(ddSelectLocation);
        ddLocation.click();
        WebElement element = driver.findElement(By.cssSelector("ul.select2-results__options li[title='" + location + "']"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
}
