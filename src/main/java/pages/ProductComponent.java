package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductComponent {

    private WebElement productLayout;//тримає в собі один елемент
    private WebElement name;
    private WebElement price;

    //отримує з якої компоненти її проініціалізувати
    public ProductComponent(WebElement productLayout) {
        this.productLayout = productLayout;
        initProductComponent();
    }

    private void initProductComponent() {
        this.name = productLayout.findElement(By.cssSelector(".h3.product-title"));
        this.price = productLayout.findElement(By.cssSelector("span.price"));
    }

    //productLayout
    public WebElement getProductLayout() {
        return productLayout;
    }

    //name
    public WebElement getName() {
        return name;
    }

    @Step("Get text from name")
    public String getNameText() {
        return getName().getText().trim();
    }

    //price
    public WebElement getPrice() {
        return price;
    }

    @Step("Get text from price")
    public String getPriceText() {
        return getPrice().getText();
    }

    @Step("Click to product")
    public void clickToProduct() {
        getName().click();
    }

}