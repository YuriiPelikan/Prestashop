package test;

import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SelectSomeClothesPage;
import pages.ShoppingCartPage;
import tools.TestRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;


@Epic("@Epic AllureTestCurrency")
@Feature("@Feature Check_Exchange_Currency")
public class AllureTestCurrency extends TestRunner {

    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveImageAttach() {
        byte[] result = null;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            result = Files.readAllBytes(scrFile.toPath());
        } catch (IOException e) {
            // TODO Create Custom Exception
            e.printStackTrace();
        }
        return result;
    }

    @Description("@Description class AllureTestCurrency; checkExchangeCurrency().")
    @Severity(SeverityLevel.CRITICAL)
    @Story("@Story check_Product_Currency STORY")

    @Test
    public void checkExcangeCurrency() throws Exception {
        HomePage homePage = new HomePage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();

        SelectSomeClothesPage clothesPage = new SelectSomeClothesPage(driver);
        clothesPage.clickToAddButton();
        delayExecution(1000);

        shoppingCartPage.clickOrderButton();
        delayExecution(2000);

        double usd = Double.parseDouble(shoppingCartPage.getProductPriceText().substring(1));
        final double UAH = 25.9;
        DecimalFormat f = new DecimalFormat("##.00");
        double exchange = UAH * usd;

        Assert.assertEquals(f.format(exchange), 495.21);

    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            saveImageAttach();
        }

    }
}

