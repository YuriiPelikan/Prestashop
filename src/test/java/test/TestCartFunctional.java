package test;

import tools.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SelectSomeClothesPage;
import pages.ShoppingCartPage;

public class TestCartFunctional extends TestRunner {

    @Test
    protected void addProductToCart() {

        HomePage homePage = new HomePage(driver);
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();

        SelectSomeClothesPage clothesPage = new SelectSomeClothesPage(driver);
        clothesPage.clickToAddButton();
        delayExecution(1000);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOrderButton();

        Assert.assertTrue(shoppingCartPage.getProductNameText().equals("Hummingbird printed t-shirt"));
    }

    @Test
    protected void deleteProductFromShoppingCart() {

        HomePage homePage = new HomePage(driver);
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();

        SelectSomeClothesPage clothesPage = new SelectSomeClothesPage(driver);
        clothesPage.clickToAddButton();
        delayExecution(1000);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOrderButton();
        delayExecution(1000);
        shoppingCartPage.clickDeleteButton();

        Assert.assertTrue(shoppingCartPage.getProductMessageText().equals("There are no more items in your cart"));
    }

    @Test
    protected void priceProductFromShoppingCart() {

        HomePage homePage = new HomePage(driver);
        homePage.getProductsListComponent().getProductComponentByPartialName("Hummingbird Printed T-Shirt").clickToProduct();

        SelectSomeClothesPage clothesPage = new SelectSomeClothesPage(driver);
        clothesPage.clickToAddButton();
        delayExecution(1000);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOrderButton();
        delayExecution(1000);
        
        shoppingCartPage.clickIncreaseAmountButton();
        delayExecution(1000);

        Assert.assertTrue(shoppingCartPage.getProductPriceText().equals("$38.24"));
    }

}
