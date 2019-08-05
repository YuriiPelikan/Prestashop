package test;


import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class TestLoginForm extends tools.TestRunner {

    @Description("Test changing password")
    @Test
    protected void testChangePassword() throws InterruptedException {
        HomePage page = new HomePage(driver);

        page.clickSignIn();

        LoginPage loginpage = new LoginPage(driver);
        loginpage.clickEmailField();
        loginpage.setEmailField("horak.orest@gmail.com");
        loginpage.setPasswordField("orgo98");
        loginpage.clickSignInButton();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MyAccount accountpage = new MyAccount(driver);
        accountpage.clickInformationButton();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        UserInformation userpage = new UserInformation(driver);
        userpage.setPassword("orgo98");
        userpage.setNewPassword("orgo98orgo98");
        userpage.clickShowButton();
        userpage.clickSaveButton();
        Thread.sleep(2000);//only for presentation
        userpage.setPassword("orgo98orgo98");
        userpage.setNewPassword("orgo98");
        userpage.clickShowButton();
        userpage.clickSaveButton();
        userpage.clickSignOutButton();

    }

    @Description("Test sign in")
    @Test
    private void AtestSignIn() throws InterruptedException {
        HomePage page = new HomePage(driver);
        page.clickSignIn();

        LoginPage loginpage = new LoginPage(driver);

        Thread.sleep(1000);//only for presentation

        loginpage.setEmailField("horak.orest@gmail.com");

        Thread.sleep(1000);//only for presentation

        loginpage.setPasswordField("orgo98");

        loginpage.clickShowButton();
        Thread.sleep(1000);//only for presentation
        loginpage.clickHideButton();

        loginpage.clickSignInButton();


        MyAccount accountpage = new MyAccount(driver);
        Assert.assertFalse(accountpage.getSignOutButton().isDisplayed());
        accountpage.clickSignOutButton();

    }

    //Some negative tests for better example in allure doc
    @Description("Test change user information and cause error")
    @Test
    private void testChangeUserInfo() throws InterruptedException {
        HomePage page = new HomePage(driver);
        page.clickSignIn();

        LoginPage loginpage = new LoginPage(driver);
        loginpage.clickEmailField();
        loginpage.setEmailField("horak.orest@gmail.com");
        loginpage.setPasswordField("orgo98");
        loginpage.clickSignInButton();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MyAccount accountpage = new MyAccount(driver);
        accountpage.clickInformationButton();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        UserInformation userpage = new UserInformation(driver);
        userpage.clearEmail();
        userpage.clearLastname();
        Thread.sleep(2000);//only for presentation
        userpage.setEmail("orgo98@ukr.net");
        Thread.sleep(2000);//only for presentation
        userpage.setLastname("Ihor");
        Thread.sleep(2000);//only for presentation
        userpage.setPassword("orgo98orgo98");
        userpage.setNewPassword("orgo98");
        userpage.clickShowButton();
        Thread.sleep(2000);//only for presentation

        userpage.clickSaveButton();
        Thread.sleep(2000);//only for presentation

        Assert.assertFalse(userpage.Exists_err());

    }
}
