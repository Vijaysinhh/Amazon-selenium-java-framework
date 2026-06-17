package pages;
import org.openqa.selenium.Keys;
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
    public void rightClickSearchBox()
    {
        WaitUtils.waitForVisibility(
                driver,
                searchBox
        );

        Actions actions =
                new Actions(driver);

        actions.contextClick(
                driver.findElement(searchBox)
        ).perform();
    }
    public void keyboardActionsSearch(
            String product)
    {
        WaitUtils.waitForVisibility(
                driver,
                searchBox
        );

        Actions actions =
                new Actions(driver);

        actions.click(
                        driver.findElement(searchBox)
                )
                .sendKeys(product)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.ENTER)
                .perform();
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