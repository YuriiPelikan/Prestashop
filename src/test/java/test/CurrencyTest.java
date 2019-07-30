package test;

import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.TestRunner;


public class CurrencyTest extends TestRunner {


//    @DataProvider//(parallel = true)
//    public Object[][] currencyData() {
//        // Read from ...
//        return new Object[][]{
//                {Data.Currencies.EURO, "Euro"},
//                {Data.Currencies.UAH, "Ukrainian Hryvnia"},
//                {Data.Currencies.USD, "US DOLLAR"}
//                };
//    }

    @Test//(dataProvider = "currencyData")
    public void checkCurrency() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        // Steps
        homePage.clickCurrencyMenu();
        homePage.clickCurrencyEu();
        delayExecution(1000);
        homePage.clickCurrencyMenu();
        homePage.clickCurrencyUa();
        delayExecution(1000);
        homePage.clickCurrencyMenu();
        homePage.clickCurrencyUsd();
        // Check
        Assert.assertEquals(homePage.getCurrencyTextEu(), "Euro");
        Assert.assertEquals(homePage.getCurrencyTextUa(), "Ukrainian Hryvnia");
        Assert.assertEquals(homePage.getCurrencyTextUsd(), "US Dollar");
        delayExecution(2000);
    }

    @Test
    public void checkCurrencyForOneElement() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        delayExecution(1000);
        // Steps
        homePage.clicktShirt();
        homePage.clickCurrencyMenu();
        homePage.clickCurrencyUa();
        delayExecution(1000);
        // Check
        Assert.assertEquals(homePage.getProductPriceText(), "495.21");
        delayExecution(2000);
    }


}

