package test;

import data.Category;
import pages.CategoryPage;
import pages.HomePage;
import tools.TestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HorizontalAndVerticalTest extends TestRunner {

    public HomePage homePage;

    @BeforeMethod
    public void init() {
        homePage = loadApplication();
    }

    @Test
    public void checkClothes() {
        //Arrange
        CategoryPage clothesPage;
        String actual;
        String expected = Category.CLOTHES.toString();

        //Act
        clothesPage = homePage.clickClothesButton();
        actual = clothesPage.getCategoryName();

        //Assert
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkAccessories() {
        //Arrange
        CategoryPage accessoriesPage;
        String actual;
        String expected = Category.ACCESSORIES.toString();

        //Act
        accessoriesPage = homePage.clickAccessoriesButton();
        actual = accessoriesPage.getCategoryName();

        //Assert
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkArt() {
        //Arrange
        CategoryPage artPage;
        String actual;
        String expected = Category.ART.toString();

        //Act
        artPage = homePage.clickArtButton();
        actual = artPage.getCategoryName();

        //Assert
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testMouseHoverWorksProperlyClothes() {
        //Arrange
        String expected = Category.MEN.toString();

        //Act
        homePage.hoverClothesButton();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category-4")));
        WebElement menElement = driver.findElement(By.cssSelector("#category-4"));
        String actual = menElement.getText();

        //Assert
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testMouseHoverWorksPropertyAccessories() {
        //Arrange
        String expected = Category.STATIONERY.toString();

        //Act
        homePage.hoverAccessoriesButton();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category-7")));
        WebElement stationeryElement = driver.findElement(By.cssSelector("#category-7"));
        String actual = stationeryElement.getText();

        //Assert
        Assert.assertEquals(actual, expected);
    }
}
