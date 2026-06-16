package tests;
import org.testng.annotations.Listeners;
import listeners.TestListener;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utility.TestDataProvider;
@Listeners(TestListener.class)
public class AmazonTest extends BaseTest {

    @Test(
            dataProvider = "productData",
            dataProviderClass = TestDataProvider.class
    )
    public void searchTest(
            String tcId,
            String product)
    {
        HomePage homePage =
                new HomePage(driver);

        System.out.println(
                "Executing: " + tcId
        );

        driver.get(
                "https://www.amazon.in/"
        );

        homePage.searchProduct(product);

        Assert.assertTrue(
                homePage.isResultsDisplayed()
        );
    }
}