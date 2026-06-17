package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.WaitUtils;
import org.openqa.selenium.interactions.Actions;
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

        WaitUtils.waitForClickable(
                driver,
                searchButton
        );

        driver.findElement(searchButton)
                .click();
    }
    public void hoverOverAccount()
    {
        By accountMenu =
                By.id("nav-link-accountList");

        WaitUtils.waitForVisibility(
                driver,
                accountMenu
        );

        Actions actions =
                new Actions(driver);

        actions.moveToElement(
                driver.findElement(accountMenu)
        ).perform();
    }
    public void doubleClickSearchButton()
    {
        WaitUtils.waitForClickable(
                driver,
                searchButton
        );

        Actions actions =
                new Actions(driver);

        actions.doubleClick(
                driver.findElement(searchButton)
        ).perform();
    }
    public boolean isResultsDisplayed()
    {
        WaitUtils.waitForVisibility(
                driver,
                resultsText
        );

        return driver.findElement(resultsText)
                .isDisplayed();
    }
}