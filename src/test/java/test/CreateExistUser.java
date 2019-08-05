package test;

import tools.TestRunner;
import data.SocialTitle;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CreateExistUser extends TestRunner {
    @Description("This test checks if already registered user " +
            "can be registered with the same creds again")
    @Test
    public void createAccount(){
        //Arrange
        LoginPage login_page = new LoginPage(driver);
        pages.CreateAccount createAccount = new pages.CreateAccount(driver);
        login_page.clickSignInButton();
        login_page.getNoAccountButton().click();

        //Act
        createAccount.getSocialTitle();
        createAccount.setSocialTitle(SocialTitle.MR);
        createAccount.getFirstName();
        createAccount.setFirstName("Iggi");
        createAccount.getLastName();
        createAccount.setLastName("Pop");
        createAccount.getEmail();
        createAccount.setEmail("iggi1234@gmail.com");
        createAccount.getPassword();
        createAccount.setPassword("qwerty");
        createAccount.getReceiveOffers().click();
        createAccount.getSaveButton().click();

        //Assert
        Assert.assertTrue(createAccount.getAllert().isDisplayed());
    }
}
