package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectSomeClothesPage extends AHeadComponent {

    @FindBy(css = "h1[itemprop = 'name']")
    private WebElement productName;

    @FindBy(css = ".product-prices")
    private WebElement productPrice;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement addToCartButton;

    public SelectSomeClothesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //    addToCartButton
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    @Step("Click add to cart button")
    public void clickToAddButton() {
        getAddToCartButton().click();
    }
}