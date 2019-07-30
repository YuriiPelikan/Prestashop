package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductListComponent {

    private WebDriver driver;
    private List<ProductComponent> productComponents;

    public ProductListComponent(WebDriver driver) {
        this.driver = driver;
        initProductComponent();
    }

    private void initProductComponent() {
        productComponents = new ArrayList<ProductComponent>();
        for (WebElement current : driver.findElements(By.cssSelector(".product-miniature"))) {
            productComponents.add(new ProductComponent(current));
        }
    }

    //productComponents
    public List<ProductComponent> getProductComponents() {
        return productComponents;
    }


    public ProductComponent getProductComponentByPartialName(String partialProductName) {
        ProductComponent result = null;
        for (ProductComponent current : getProductComponents()) {
            if (current.getNameText().toLowerCase().contains(partialProductName.toLowerCase())) {
                result = current;
                break;
            }
        }
        return result;

    }

    public List<String> getProductsNameList() {
        List<String> result = new ArrayList<String>();
        for (ProductComponent current : getProductComponents()) {
            result.add(current.getNameText());
        }
        return result;
    }

    public void AddToCartByPartialName(String partialProductName) {
        getProductComponentByPartialName(partialProductName);
    }
}
