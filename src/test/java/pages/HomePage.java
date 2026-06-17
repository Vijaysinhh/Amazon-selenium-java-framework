package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.WaitUtils;

public class HomePage {

    WebDriver driver;

    By searchBox =
            By.id("twotabsearchtextbox");

    By searchButton =
            By.id("nav-search-submit-button");

    By resultsText =
            By.xpath("//span[contains(text(),'results')]");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void searchProduct(String product)
    {
        WaitUtils.waitForVisibility(
                driver,
                searchBox
        );
        driver.findElement(searchBox)
                .sendKeys(product);

        driver.findElement(searchButton)
                .click();
    }

    public boolean isResultsDisplayed()
    {
        return driver.findElement(resultsText)
                .isDisplayed();
    }
}