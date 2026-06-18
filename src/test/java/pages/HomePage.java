package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.WaitUtils;

public class HomePage
{
    WebDriver driver;

    // Frame locators
    By loginFrame =
            By.id("loginFrame");

    By emailBox =
            By.id("email");

    // Page locators
    By accountMenu =
            By.id("nav-link-accountList");

    By categoryDropdown =
            By.cssSelector("#searchDropdownBox");

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

    public void keyboardActionsSearch(String product)
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

    public void selectCategory(String category)
    {
        WaitUtils.waitForVisibility(
                driver,
                categoryDropdown
        );

        Select select =
                new Select(
                        driver.findElement(
                                categoryDropdown
                        )
                );

        select.selectByVisibleText(
                category
        );
    }

    public void switchToLoginFrame()
    {
        WaitUtils.waitForVisibility(
                driver,
                loginFrame
        );

        driver.switchTo()
                .frame(
                        driver.findElement(
                                loginFrame
                        )
                );
    }

    public void enterEmail(String email)
    {
        WaitUtils.waitForVisibility(
                driver,
                emailBox
        );

        driver.findElement(emailBox)
                .sendKeys(email);
    }

    public void switchBackToMainPage()
    {
        driver.switchTo()
                .defaultContent();
    }
    public void switchToNewTab()
    {
        String mainWindow =
                driver.getWindowHandle();

        for(String window :
                driver.getWindowHandles())
        {
            if(!window.equals(mainWindow))
            {
                driver.switchTo()
                        .window(window);

                break;
            }
        }
    }

    public void jsClickSearchButton()
    {
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                driver.findElement(searchButton)
        );
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