package test;

//import Tools.TestRunner;
import data.SocialTitle;
import io.qameta.allure.Description;
import net.bytebuddy.utility.RandomString;
import org.testng.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import tools.TestRunner;
//import static org.junit.Assert.assertTrue;

public class CreateAccount extends TestRunner {

    @Description("This test verifies account creating")
    @Test
    public void createAccount(){
        //Arrange
        LoginPage login_page = new LoginPage(driver);
        pages.CreateAccount createAccount = new pages.CreateAccount(driver);
        login_page.clickSignInButton();
        login_page.getNoAccountButton().click();
        String email= RandomString.make(10)+"@gmail.com";

        //Act
        createAccount.getSocialTitle();
        createAccount.setSocialTitle(SocialTitle.MR);
        createAccount.getFirstName();
        createAccount.setFirstName("Iggi");
        createAccount.getLastName();
        createAccount.setLastName("Pop");
        createAccount.getEmail();
        createAccount.setEmail(email);
        createAccount.getPassword();
        createAccount.setPassword("qwerty");
        createAccount.getReceiveOffers().click();
        createAccount.getSaveButton().click();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        //Assert
        Assert.assertTrue(createAccount.getSighOutButton().isDisplayed());
        System.out.println("Test passed");
        createAccount.getSighOutButton().click();
    }
}
