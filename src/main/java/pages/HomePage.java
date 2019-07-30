package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends AHeadComponent {

    private ProductListComponent productsListComponent;

    public HomePage(WebDriver driver) {
        super(driver);
        initProductsListComponent();
    }

    private void initProductsListComponent() {
        productsListComponent = new ProductListComponent(driver);
    }

    public ProductListComponent getProductsListComponent() {
        return productsListComponent;
    }
}
