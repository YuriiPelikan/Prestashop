package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformation extends MyAccount {
    @FindBy(css = "#customer-form > section >" +
            " div:nth-child(6) > div.col-md-6 > div > input")
    private WebElement password;

    @FindBy(css = "#customer-form > section >" +
            " div:nth-child(7) > div.col-md-6 > div > input")
    private WebElement newPassword;

    @FindBy(css = "#customer-form > footer > button")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[6]/div[1]/div/span/button")
    private WebElement showButton;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[6]/div[1]/div/span/button")
    private WebElement hideButton;

    @FindBy(css = "#_desktop_user_info > div > a.logout.hidden-sm-down")
    private WebElement signOutButton;

    @FindBy(css = "#customer-form > section > div:nth-child(5) > div.col-md-6 > input")
    private WebElement email;

    @FindBy(css = "#customer-form > section > div:nth-child(4) > div.col-md-6 > input")
    private WebElement lastname;


    public UserInformation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // passwordField
    @Step("get new password field")
    public WebElement getPassword() {
        return password;
    }

    @Step("get text of new password")
    public String getPasswordText() {
        return getPassword().getText();
    }

    @Step("set new password")
    public void setPassword(String text) {
        getPassword().sendKeys(text);
    }

    @Step("clear new password field")
    public void clearPassword() {
        getPassword().clear();
    }

    @Step("click new password field")
    public void clickPassword() {
        getPassword().click();
    }

    //new password Field
    @Step("get password field")
    public WebElement getNewPassword() {
        return newPassword;
    }

    @Step("get text of password")
    public String getNewPasswordText() {
        return getNewPassword().getText();
    }

    @Step("set password")
    public void setNewPassword(String text) {
        getNewPassword().sendKeys(text);
    }

    @Step("clear password field")
    public void clearNewPassword() {
        getNewPassword().clear();
    }

    @Step("click password field")
    public void clickNewPassword() {
        getNewPassword().click();
    }

    // email Field
    @Step("get email")
    public WebElement getEmail() {
        return email;
    }

    @Step("get text of email")
    public String getEmailText() {
        return getEmail().getText();
    }

    @Step("set email")
    public void setEmail(String text) {
        getEmail().sendKeys(text);
    }

    @Step("clear email field")
    public void clearEmail() {
        getEmail().clear();
    }

    @Step("click email field")
    public void clickEmail() {
        getEmail().click();
    }

    // Last name field
    @Step("get last name")
    public WebElement getLastname() {
        return lastname;
    }

    @Step("get text of last name")
    public String getLastnameText() {
        return getLastname().getText();
    }

    @Step("set last name")
    public void setLastname(String text) {
        getLastname().sendKeys(text);
    }

    @Step("clear last name field")
    public void clearLastname() {
        getLastname().clear();
    }

    @Step("click last name field")
    public void clickLastname() {
        getLastname().click();
    }


    //Save button
    @Step("get(find) save button")
    public WebElement getSaveButton() {
        return saveButton;
    }

    @Step("click save button")
    public void clickSaveButton() {
        getSaveButton().click();
    }


    //Show button
    @Step("get(find) show button")
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

    //Sign out button
    @Step("get(find) sign out button")
    public WebElement getSignOutButton() {
        return signOutButton;
    }

    @Step("click sign out button")
    public void clickSignOutButton() {
        getSignOutButton().click();
    }

    //error
    @Step("Search error message")
    public boolean Exists_err() {

        if (driver.findElement(By.xpath("//*[@class=\"alert alert-danger\"]")).isDisplayed()) {
            return false;
        }
        return true;
    }

}
