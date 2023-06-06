package PageObject;

import org.openqa.selenium.By;

public enum Elements {

    SHOPPING_CART("shoppingCart", By.xpath("//a[contains(@class, 'shopping_cart_link')]")),
    CHECKOUT("checkout", By.xpath("//button[contains(text(), 'Checkout')]")),
    CONTINUE("continue", By.className("btn_action")),
    FINISH("finish", By.className("cart_button")),
    FIRST_NAME("firstName", By.id("first-name")),
    LAST_NAME("lastName", By.id("last-name")),
    POSTAL_CODE("postalCode", By.id("postal-code"));
    

    private final String name;
    private final By by;

    Elements(String name, By by) {
        this.name = name;
        this.by = by;
    }

    public String getName() {
        return name;
    }

    public By getBy() {
        return by;
    }

}
