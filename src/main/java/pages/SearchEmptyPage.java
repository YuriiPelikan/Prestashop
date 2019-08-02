package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchEmptyPage extends AHeadComponent {
    public SearchEmptyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#content > h4")
    private WebElement searchResultStatus;

    @Step("Get text from page status")
    public String getTextSearchResultStatus() {
        return searchResultStatus.getText();
    }


}
