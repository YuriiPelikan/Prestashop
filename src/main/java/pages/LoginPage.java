package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AHeadComponent {
    @FindBy(css = "#login-form > section > div:nth-child(2) " +
            "> div.col-md-6 > input")
    private WebElement emailField;

    @FindBy(css = "#login-form > section > div:nth-child(3) " +
            "> div.col-md-6 > div > input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"submit-login\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@class=\"btn\"]")
    private WebElement showButton;

    @FindBy(xpath = "//*[@class=\"btn\"]")
    private WebElement hideButton;

    @FindBy(css = "#login-form > section > div.forgot-password > a")
    private WebElement forgotPasswordButton;

    @FindBy(css = "#content > div > a")
    private WebElement createAccountButton;

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // PageObject Atomic Operation

    // emailField
    @Step("get email")
    public WebElement getEmailField() {
        return emailField;
    }

    @Step("get text of email")
    public String getEmailFieldText() {
        return getEmailField().getText();
    }

    @Step("set email")
    public void setEmailField(String text) {
        getEmailField().sendKeys(text);
    }

    @Step("clear email field")
    public void clearEmailField() {
        getEmailField().clear();
    }

    @Step("click email field")
    public void clickEmailField() {
        getEmailField().click();
    }

    // passwordField
    @Step("get password field")
    public WebElement getPasswordField() {
        return passwordField;
    }

    @Step("get text of password")
    public String getPasswordFieldText() {
        return getPasswordField().getText();
    }

    @Step("set password")
    public void setPasswordField(String text) {
        getPasswordField().sendKeys(text);
    }

    @Step("clear password field")
    public void clearPasswordField() {
        getPasswordField().clear();
    }

    @Step("click password field")
    public void clickPasswordField() {
        getPasswordField().click();
    }

    //Sign in button
    @Step("get sign in button")
    public WebElement getSignInButton() {
        return signInButton;
    }

    @Step("click sign in button")
    public void clickSignInButton() {
        getSignInButton().click();
    }

    //Show button
    @Step("get show button")
    public WebElement getShowButton() {
        return showButton;
    }

    @Step("click show button")
    public void clickShowButton() {
        getShowButton().click();
    }

    //Hide button
    @Step("get hide button")
    public WebElement getHideButton() {
        return hideButton;
    }

    @Step("click hide button")
    public void clickHideButton() {
        getHideButton().click();
    }

    //Forgot your password button
    @Step("get forgot your password button")
    public WebElement getForgotPasswordButton() {
        return forgotPasswordButton;
    }

    @Step("click forgot your password button")
    public void clickForgotPasswordButton() {
        getForgotPasswordButton().click();
    }

    //Create account button
    @Step("get create account button")
    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    @Step("click create account button")
    public void clickCreateAccountButton() {
        getCreateAccountButton().click();
    }
}

