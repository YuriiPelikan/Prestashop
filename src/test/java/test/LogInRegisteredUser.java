package test;

import tools.TestRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.YourAccount;



public class LogInRegisteredUser extends TestRunner {

    @Description("This test verifies if registered user can log-in")
    @Test
    public void checkCreaing(){
        //Arrange
        LoginPage login_page = new LoginPage(driver);
        String eMail = "iggi@gmail.com";
        String password = "qwerty";
        boolean expected;

        //Act
        login_page.clickSignInButton();
        login_page.setEmailFIeld(eMail);
        login_page.setPasswordField(password);
        login_page.clickLoginButton();

        //Assert
        String actual = driver.getCurrentUrl();
        expected = actual.contains("my-account");
        Assert.assertTrue(expected);

        YourAccount myAccount = new YourAccount(driver);
        myAccount.clickLogOutButton();


    }
}
