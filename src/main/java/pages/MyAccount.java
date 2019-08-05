package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount extends LoginPage {
    @FindBy(xpath = "//*[@id=\"identity-link\"]")
    private WebElement informationButton;

    @FindBy(xpath = "//*[@id=\"address-link\"]")
    private WebElement addFirstAdressButton;

    @FindBy(xpath = "//*[@id=\"history-link\"]")
    private WebElement orderHistoryButton;

    @FindBy(xpath = "//*[@id=\"order-slips-link\"")
    private WebElement creditSlipsButton;

    @FindBy(css = "#main > footer > div > a")
    private WebElement signOutButton;

    public MyAccount(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Get first Address button
    @Step("get add first address button")
    public WebElement getAddFirstAddressButton() {
        return addFirstAdressButton;
    }

    @Step("click add first address button")
    public void clickAddFirstAdressButton() {
        getAddFirstAddressButton().click();
    }

    //Order history and details button
    @Step("get(find) order history button")
    public WebElement getOrderHistoryButton() {
        return orderHistoryButton;
    }

    @Step("click order history button")
    public void clickOrderHistoryButton() {
        getOrderHistoryButton().click();
    }

    //Credit slips button
    @Step("get(find) credit slips button")
    public WebElement getCreditSlipsButton() {
        return creditSlipsButton;
    }

    @Step("click credit slips button")
    public void clickCreditSlipsButton() {
        getCreditSlipsButton().click();
    }

    //Information button
    @Step("get(find) information button")
    public WebElement getInformationButton() {
        return informationButton;
    }

    @Step("click information button")
    public void clickInformationButton() {
        getInformationButton().click();
    }

    //Sign out button
    @Step("get(find) sign out button")
    public WebElement getSignOutButton() {
        return signOutButton;
    }

    @Step("click sign out button")
    public void clickSignOutButton() {
        getSignOutButton().click();
    }
}
