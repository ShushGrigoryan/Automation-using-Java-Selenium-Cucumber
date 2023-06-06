package PageObject;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import BaseClass.BaseClass;

public class CheckoutPage extends BaseClass {

    private final BaseClass base;

    public CheckoutPage(BaseClass base) {
        this.base = base;
    }

    public void fillField(String fieldName, String value) {
        Elements element = Arrays.stream(Elements.values())
                .filter(e -> e.getName().equals(fieldName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown element: " + fieldName));
        WebElement field = base.driver.findElement(element.getBy());
        field.clear();
        field.sendKeys(value);
    }

    public boolean CheckoutCompleteMessage(String sucssesMessage) {
        return base.driver
                .findElement(By.xpath("//h2[contains(@class, 'complete-header')][text() = '" + sucssesMessage + "']"))
                .isDisplayed();
    }

    public boolean verifyProductIsDisplayedInCart(String productName) {
        By productCartSelector = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']");
        return base.driver.findElement(productCartSelector).isDisplayed();
    }

}
