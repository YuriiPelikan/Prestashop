package test;

import tools.TestRunner;
import data.SocialTitle;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;



public class CreateAccountWithoutCred extends TestRunner {
    @Description("Test checks if user can be created without credentials")
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
        createAccount.setFirstName("");
        createAccount.getLastName();
        createAccount.setLastName("");
        createAccount.getEmail();
        createAccount.setEmail("iggi1234@gmail.com");
        createAccount.getPassword();
        createAccount.setPassword("");
        createAccount.getReceiveOffers().click();
        createAccount.getSaveButton().click();

        //Assert
        Assert.assertTrue(createAccount.getFirstName().isEnabled());
        Assert.assertTrue(createAccount.getLastName().isEnabled());
        Assert.assertTrue(createAccount.getPassword().isEnabled());
    }
}
