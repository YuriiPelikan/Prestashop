package pages;

import data.SocialTitle;

import io.qameta.allure.Step;
import jdk.nashorn.internal.runtime.UserAccessorProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateAccount extends AHeadComponent {

    //Gender
    @FindBy(css = "input[name='id_gender']")
    private List<WebElement> socialTitle;


    @FindBy(name = "firstname")
    private WebElement firstName;


    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy (name = "email")
    private WebElement eMail;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath ="//input[@name='optin']" )
    private WebElement receiveOffers;

    @FindBy(xpath ="//input[@name='newsletter']")
    private WebElement receiveNewsletter;

    @FindBy(xpath ="//button[@class='btn btn-primary form-control-submit float-xs-right']" )
    private WebElement saveButton;

    @FindBy(xpath = "//li[@class='alert alert-danger']")
    private WebElement allert;

    public CreateAccount(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    //Getters and Setters
    //SocialTitle
    public List<WebElement> getSocialTitle() {
        return socialTitle;
    }

    @Step("set social title")
    public void setSocialTitle(SocialTitle socialTitle) {
        switch (socialTitle) {
            case MR:
                this.socialTitle.get(0).click();
                break;
            case MRS:
                this.socialTitle.get(1).click();
                break;
        }

    }
    //First name
    public WebElement getFirstName() {
        return firstName;
    }

    @Step("User set First name")
    public void setFirstName(String firstName) {
        this.firstName.click();
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }

    //Last name
    public WebElement getLastName() {
        return lastName;
    }

    @Step("User set Last name")
    public void setLastName(String lastName) {
        this.lastName.click();
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    //eMail
    public WebElement getEmail() {
        return eMail;
    }

    @Step("User set eMail")
    public void setEmail(String email) {
        this.eMail.click();
        this.eMail.clear();
        this.eMail.sendKeys(email);
    }


    //password
    public WebElement getPassword() {
        return password;
    }

    @Step("User set password")
    public void setPassword(String password) {
        this.password.click();
        this.password.clear();
        this.password.sendKeys(password);
    }
    //allert
    public WebElement getAllert() {
        return allert;
    }




    //Receive offers from our partners
    public WebElement getReceiveOffers(){
        return receiveOffers;
    }
    @Step("Check the Receive offers from our partners")
    public void checkReceiveOffers(){
        getReceiveOffers().click();
    }

   //Sign up for our newsletter
    public WebElement getReceiveNewsletter() {
        return receiveNewsletter;
    }

    @Step("Check the Sign up for our newsletter")
    public void checkReceiveNewsletter(){
        getReceiveNewsletter().click();
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    @Step("Click the Step button")
    public void clickSaveButton() {
        this.saveButton.click();

    }

}



