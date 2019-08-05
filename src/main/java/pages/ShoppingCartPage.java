package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends AHeadComponent {
    @FindBy(css = ".product-line-info [href]")
    private WebElement productName;

    @FindBy(css = "span.product-price")
    private WebElement productPrice;

    @FindBy(css = ".bootstrap-touchspin-up")
    private WebElement increaseAmountButton;

    @FindBy(css = "a.remove-from-cart>i")
    private WebElement deleteButton;

    @FindBy(xpath = "//a[@class=\"btn btn-primary\"]")
    private WebElement orderButton;

    @FindBy(css = ".no-items")
    private WebElement ProductMessage;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //productname
    public WebElement getProductName() {
        return productName;
    }

    @Step("Get text from product name")
    public String getProductNameText() {
        return getProductName().getText();
    }

    //deleteButton
    public WebElement getDeleteButton() {
        return deleteButton;
    }

    @Step("Click on delete button")
    public void clickDeleteButton() {
        getDeleteButton().click();
    }

    //price button
    public WebElement getProductPrice() {
        return productPrice;
    }

    @Step("Get text from product price")
    public String getProductPriceText() {
        return getProductPrice().getText();
    }

    //orderButton
    public WebElement getOrderButton() {
        return orderButton;
    }

    @Step("Click on order button")
    public void clickOrderButton() {
        getOrderButton().click();
    }

    //message
    public WebElement getProductMessage() {
        return ProductMessage;
    }

    @Step("Get text from product message")
    public String getProductMessageText() {
        return getProductMessage().getText();
    }

    //increaseButton
    public WebElement getIncreaseAmountButton() {
        return increaseAmountButton;
    }

    @Step("Click on increase button")
    public void clickIncreaseAmountButton() {
        getIncreaseAmountButton().click();
    }

}