package test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SelectSomeClothesPage;
import pages.ShoppingCartPage;
import tools.TestRunner;

public class TestCartFunctional extends TestRunner {

    @Description("In this suite we will test function add product to cart")
    @Test
    protected void addProductToCart() {

        HomePage homePage = new HomePage(driver);
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();

        SelectSomeClothesPage clothesPage = new SelectSomeClothesPage(driver);
        clothesPage.clickToAddButton();
        delayExecution(1500);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOrderButton();

        Assert.assertTrue(shoppingCartPage.getProductNameText().equals("Hummingbird printed t-shirt"));
    }

    @Description("In this suite we will test function delete product from cart")
    @Test
    protected void deleteProductFromShoppingCart() {

        HomePage homePage = new HomePage(driver);
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();

        SelectSomeClothesPage clothesPage = new SelectSomeClothesPage(driver);
        clothesPage.clickToAddButton();
        delayExecution(1500);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOrderButton();
        delayExecution(1500);
        shoppingCartPage.clickDeleteButton();

        Assert.assertTrue(shoppingCartPage.getProductMessageText().equals("There are no more items in your cart"));
    }

    @Description("In this suite we will test whether the price will be correct in case of an increase in the quantity of product")
    @Test
    protected void priceProductFromShoppingCart() {

        HomePage homePage = new HomePage(driver);
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();

        SelectSomeClothesPage clothesPage = new SelectSomeClothesPage(driver);
        clothesPage.clickToAddButton();
        delayExecution(1500);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOrderButton();
        delayExecution(1500);

        shoppingCartPage.clickIncreaseAmountButton();
        delayExecution(1500);

        Assert.assertTrue(shoppingCartPage.getProductPriceText().equals("$38.24"));
    }

    @Description("In this suite we made an error")
    @Test
    protected void wrongAddProductToCart() {

        HomePage homePage = new HomePage(driver);
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();

        SelectSomeClothesPage clothesPage = new SelectSomeClothesPage(driver);
        clothesPage.clickToAddButton();
        delayExecution(1500);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOrderButton();

        Assert.assertTrue(shoppingCartPage.getProductNameText().equals("JHummingbird printed t-shirt"));
    }

}