package test;

import tools.TestRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.YourAccount;

import java.io.File;
import java.net.URL;

import static com.google.common.io.Files.toByteArray;


public class LogInRegisteredUserFail extends TestRunner {

    @Description("Only to take a screenshoot")
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
        expected = actual.contains("my-account12");
        Assert.assertTrue(expected);
        YourAccount myAccount = new YourAccount(driver);
        myAccount.clickLogOutButton();


    }

}
