package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AHeadComponent {
    private final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
    private final String TAG_ATTRIBUTE_VALUE = "value";

    protected WebDriver driver;
    //
    @FindBy(css = "#_desktop_user_info > div > a > span")
    private WebElement signIn;

    @FindBy(css = "#category-6")
    private WebElement accessoriesButton;

    @FindBy(css = "#category-3")
    private WebElement clothesButton;

    @FindBy(css = "#category-9")
    private WebElement artButton;

    @FindBy(css = "#category-4")
    private WebElement menButton;

    private DropdownOptions dropdownOptions;
    @FindBy(xpath = "//div[@id=\"_desktop_cart\"]")
    private WebElement cartButton;
    @FindBy(css = "#_desktop_currency_selector > div > button ")
    private WebElement currencyMenu;

    @FindBy(xpath = "//*[@title=\"US Dollar\"]")
    private WebElement currencyUsd;

    @FindBy(xpath = "//*[@title=\"Ukrainian Hryvnia\"]")
    private WebElement currencyUa;

    @FindBy(xpath = "//*[@title=\"Euro\"]")
    private WebElement currencyEu;

    @FindBy(xpath = "//*[@alt=\"Hummingbird printed t-shirt\"]")
    private WebElement tShirt;

    @FindBy(xpath = "//*[@class='btn btn-primary add-to-cart']")
    private WebElement buttonAddToCart;

    //Shevchuk Oleksii
    @FindBy(css = "input.ui-autocomplete-input")
    private WebElement searchField;

    @FindBy(css = "button>i.material-icons.search")
    private WebElement searchButton;
    //-----


    @FindBy(css = ".logo.img-responsive")
    private WebElement logo;

    @FindBy(xpath = "//*[@itemprop=\"price\"]")
    private WebElement productPrice;

    //CurrencyMenu
    public WebElement getCurrencyMenu() {
        return currencyMenu;
    }

    public void clickCurrencyMenu() {
        getCurrencyMenu().click();
    }

    //CurrencyUsd
    public WebElement getCurrencyUsd() {
        return currencyUsd;
    }

    public void clickCurrencyUsd() {
        getCurrencyUsd().click();
    }

    public String getCurrencyTextUsd() {
        return getCurrencyUsd().getAttribute("title");
    }

    public WebElement getSearchField() {
        return searchField;
    }

    //--------------Shevchuk Oleksii
    @Step("Add text in search field")
    public void setTextSearchField(String text) {
        getSearchField().sendKeys(text);
    }

    @Step("Clear serach field")
    public void clearTextInSearchField() {
        getSearchField().clear();
    }

    //search Button //--------------Shevchuk Oleksii


    public WebElement getSearchButton() {
        return searchButton;
    }

    public void clickSearchButton() {
        getSearchButton().click();
    }

    // CurrencyUa
    public WebElement getCurrencyUa() {
        return currencyUa;
    }

    public void clickCurrencyUa() {
        getCurrencyUa().click();
    }

    public String getCurrencyTextUa() {
        return getCurrencyUa().getAttribute("title");
    }

    // CurrencyEu
    public WebElement getCurrencyEu() {
        return currencyEu;
    }

    public void clickCurrencyEu() {
        getCurrencyEu().click();
    }

    public String getCurrencyTextEu() {
        return getCurrencyEu().getAttribute("title");
    }


    //Product

    public WebElement gettShirt() {
        return tShirt;
    }


    public void clicktShirt() {
        gettShirt().click();
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public String getProductPriceText() {
        return getProductPrice().getAttribute("content");
    }

    public WebElement getButtonAddToCart() {
        return buttonAddToCart;
    }

    public void clickButtonAddToCart() {
        getButtonAddToCart().click();
    }

    //Pelikan Yurii
    //CartButton...........

    public WebElement getCartButton() {
        return cartButton;
    }

    @Step("Click on shopping cart button")
    public void clickShoppingCart() {
        getCartButton().click();
    }

    protected AHeadComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //......................

    private class DropdownOptions {

        private List<WebElement> listOptions;

        public DropdownOptions(By searchLocator) {
            initListOptions(searchLocator);
        }

        private void initListOptions(By searchLocator) {
            listOptions = driver.findElements(searchLocator);
        }

        public List<WebElement> getListOptions() {
            return listOptions;
        }

        public WebElement getDropdownOptionByPartialName(String optionName) {
            WebElement result = null;
            for (WebElement current : getListOptions()) {
                if (current.getText().toLowerCase().contains(optionName.toLowerCase())) {
                    result = current;
                    break;
                }
            }
            return result;
        }

        public List<String> getListOptionsText() {
            List<String> result = new ArrayList<String>();
            for (WebElement current : getListOptions()) {
                result.add(current.getText());
            }
            return result;
        }

        public void clickDropdownOptionByPartialName(String optionName) {
            getDropdownOptionByPartialName(optionName).click();
        }
    }

    //PageObject Atomic Operation

    //logo
    public WebElement getLogo() {
        return logo;
    }

    public String getLogoText() {
        return getLogo().getText();
    }

    public void clickLogo() {
        getLogo().click();
    }


    // menuTop
    public CategoryPage clickAccessoriesButton() {
        accessoriesButton.click();
        return new CategoryPage(driver);
    }

    public CategoryPage clickClothesButton() {
        clothesButton.click();
        return new CategoryPage(driver);
    }

    public CategoryPage clickArtButton() {
        artButton.click();
        return new CategoryPage(driver);
    }

    public void hoverClothesButton() {
        Actions builder = new Actions(driver);
        builder.moveToElement(clothesButton).perform();
    }

    public void hoverAccessoriesButton() {
        Actions builder = new Actions(driver);
        builder.moveToElement(accessoriesButton).perform();
    }

    // dropdownOptions
    protected DropdownOptions getDropdownOptions() {
        return dropdownOptions;
    }

    private void createDropdownOptions(By searchLocator) {
        dropdownOptions = new DropdownOptions(searchLocator);
    }

    private boolean findDropdownOptionByPartialName(String optionName) {
        boolean isFound = false;
        if (getDropdownOptions() == null) {
            throw new RuntimeException("DropdownOption is null");
        }
        for (String current : getDropdownOptions().getListOptionsText()) {
            if (current.toLowerCase().contains(optionName.toLowerCase())) {
                isFound = true;
            }
        }
        return isFound;
    }

    private void clickDropdownOptionByPartialName(String optionName) {
        if (!findDropdownOptionByPartialName(optionName)) {
            throw new RuntimeException(String.format("OPTION_NOT_FOUND_MESSAGE %s %s",
                    optionName, dropdownOptions.getListOptionsText().toString()));
        }
        getDropdownOptions().clickDropdownOptionByPartialName(optionName);
        dropdownOptions = null;
    }

    //-------Sign in--------- Horak Orest ------------
    @Step("get sign in button")
    public WebElement getSignIn() {
        return signIn;
    }

    @Step("get text of sign in")
    public String getSignInText() {
        return getSignIn().getText();
    }

    @Step("click sign in button")
    public void clickSignIn() {
        getSignIn().click();
    }

}
