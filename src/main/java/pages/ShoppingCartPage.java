package pages;

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

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
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

    public String getProductNameText() {
        return getProductName().getText();
    }

    //deleteButton
    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public void clickDeleteButton() {
        getDeleteButton().click();
    }

    //price button
    public WebElement getProductPrice() {
        return productPrice;
    }

    public String getProductPriceText() {
        return getProductPrice().getText();
    }

    //orderButton
    public WebElement getOrderButton() {
        return orderButton;
    }

    public void clickOrderButton() {
        getOrderButton().click();
    }

    //message
    public WebElement getProductMessage() {
        return ProductMessage;
    }

    public String getProductMessageText() {
        return getProductMessage().getText();
    }

    //increaseButton
    public WebElement getIncreaseAmountButton() {
        return increaseAmountButton;
    }

    public void clickIncreaseAmountButton() {
        getIncreaseAmountButton().click();
    }

}
