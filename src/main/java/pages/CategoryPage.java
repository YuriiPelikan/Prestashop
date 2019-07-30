package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage extends AHeadComponent {

    private WebElement categoryName;

    public CategoryPage(WebDriver driver) {
        super(driver);
        categoryName = driver.findElement(By.cssSelector(".block-category.card.card-block.hidden-sm-down > h1.h1"));
    }

    public String getCategoryName() {
        return categoryName.getText().trim().toUpperCase();
    }

}
