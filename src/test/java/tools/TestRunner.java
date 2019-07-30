package tools;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class TestRunner {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://35.225.39.45/index.php?id_lang=1");
    }

    protected HomePage loadApplication() {
        return new HomePage(driver);
    }

    protected void delayExplicitExecution(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void delayExecution(long miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String getFileName() {
        String currentTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        return "./" + currentTime + "_screenshot.png";
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveImageAttach(String attachName) {
        byte[] result = null;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            result = Files.readAllBytes(scrFile.toPath());
        } catch (IOException e) {
            // TODO Create Custom Exception
            e.printStackTrace();
        }
        return result;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            saveImageAttach(getFileName());
            driver.get("http://regres.herokuapp.com/logout");
        }
    }

}
