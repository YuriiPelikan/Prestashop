package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.List;


public class SearchResultPage extends AHeadComponent {

    @FindBy(css = "button.btn-unstyle.select-title")
    private WebElement sortButtonBy;

    @FindBy(css = "a[rel=\"nofollow\"].select-list")
    private List<WebElement> ddmenu;

    @FindBy(css = "h2.h3>a")
    private List<WebElement> searchResult;

    public List<WebElement> getSearchResult() {
        return searchResult;
    }
    //private List<WebElement> ddmenu = driver.findElements(By.cssSelector("a[rel=\"nofollow\"].select-list"));
    // List<WebElement> relev=driver.findElements(By.cssSelector("input.ui-autocomplete-input"));


    public ArrayList<WebElement> getListSortElements() {
        return listSortElements;
    }

    public ArrayList<WebElement> listSortElements = new ArrayList<WebElement>();

    public SearchResultPage(WebDriver driver) {
        super(driver);
        ////*[@id="js-product-list-top"]//a

    }


    public List<WebElement> setListSortsEelements(List<WebElement> elements) {
        for (WebElement el : elements) {
            listSortElements.add(el);
        }
        return listSortElements;
    }

    public List<WebElement> getDdmenu() {
        return ddmenu;
    }


    public WebElement getSortBy() {
        return sortButtonBy;
    }

    public void clickSortButtonBy() {
        getSortBy().click();
    }

}
