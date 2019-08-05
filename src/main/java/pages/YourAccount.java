package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccount extends AHeadComponent {

    @FindBy(css = "a#identity-link[href*='identity']")
    private WebElement informationButton;
    @FindBy(css = "a#address-link[href*='address']")
    private WebElement addressesButton;
    @FindBy(xpath = "//a[@id='history-link']//span[1]")
    private WebElement orderHistoryAndDetailsButton;
    @FindBy(xpath = "//a[@id='order-slips-link']//span[1]")
    private WebElement creditSlipsButton;
    @FindBy(css = ".page-footer a[href*='mylogout']")
    private WebElement logOutButton;


    public YourAccount(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public WebElement getInformationButton() {
        return informationButton;
    }

    public WebElement getAddressesButton() {
        return addressesButton;
    }

    public WebElement getOrderHistoryAndDetailsButton() {
        return orderHistoryAndDetailsButton;
    }

    public WebElement getCreditSlipsButton() {
        return creditSlipsButton;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    @Step("click Information button")
    public CreateAccount clickInformationButton(){
        informationButton.click();
        return new CreateAccount(driver);
    }

    @Step("click Log-out button")
    public LoginPage clickLogOutButton() {
        logOutButton.click();
        return new LoginPage(driver);
    }
}
