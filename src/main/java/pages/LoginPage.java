package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AHeadComponent {

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "#submit-login")
    private WebElement loginButton;

    @FindBy(css = "div.no-account>a")
    private WebElement noAccountButton;

    @FindBy(css = "form#login-form a")
    private WebElement forgotPassword;



    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //getters,setters, cleaners
    //email field
    public WebElement getEmailField(){
        return emailField;
    }
    @Step("set email")
    public void setEmailFIeld(String eMail){
        this.emailField.click();
        this.emailField.clear();
        this.emailField.sendKeys(eMail);
    }


    //password field
    public WebElement getPasswordField(){
        return passwordField;
    }
    @Step("set password")
    public void setPasswordField(String password){
        this.passwordField.click();
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
    }


    //login button
    public WebElement getLoginButton() {
        return loginButton;
    }
    @Step("click the Login button")
    public void clickLoginButton(){
        getLoginButton().click();
    }

    //no account
    public WebElement getNoAccountButton() {
        return noAccountButton;
    }
    @Step("click No account button")
    public void clickNoAccountButton(){
        getNoAccountButton().click();
    }

    //forgot password
    public WebElement getForgotPassword(){
        return forgotPassword;
    }
    @Step("click Forgot Password button")
    public Forgot_password clickForgotPassword(){
        getForgotPassword().click();
        return new Forgot_password(driver);
    }


}
