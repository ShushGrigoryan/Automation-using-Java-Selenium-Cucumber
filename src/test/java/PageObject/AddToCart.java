package PageObject;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import BaseClass.BaseClass;

public class AddToCart extends BaseClass {

    private final BaseClass base;

    public AddToCart(BaseClass base) {
        this.base = base;
    }

    By pageTitle = By.className("title");
    By cartBadge = By.className("shopping_cart_badge");
    By addToCartButtons = By.xpath("//button[text()='Add to cart']");

    public String currentPage() {
        return base.driver.findElement(pageTitle).getText();
    }

    public void addProductToCart(String productName) {
        String addProductToCart = "//div[contains(@class, 'inventory_item')]//div[contains(text(), '" + productName
                + "')]/ancestor::div[@class='inventory_item']//button";
        base.driver.findElement(By.xpath(addProductToCart)).click();
    }

    public boolean verifyProductIsDisplayedInCart(String productName) {
        try {
            By productCartSelector = By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']");
            return base.driver.findElement(productCartSelector).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public int getCartBadgeCount() {
        return Integer.parseInt(base.driver.findElement(cartBadge).getText());
    }

    public void clickOnElement(String elementName) {
        Elements element = Arrays.stream(Elements.values())
                .filter(e -> e.getName().equals(elementName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown element: " +
                        elementName));
        List<WebElement> elem = base.driver.findElements(element.getBy());
        elem.get(0).click();
    }

    public void RemoveProduct(String productName) {
        String removeProductFromCart = "//div[contains(@class, 'cart_item')]//div[contains(text(), '" + productName
                + "')]/ancestor::div[@class='cart_item']//button";
        base.driver.findElement(By.xpath(removeProductFromCart)).click();
    }

    public String expectedProductName;
    public String actualProductName;

    public void addToCartByIndex(int productIndex) {
        By addToCartButton = By.xpath("//div[@class='inventory_item'][" + productIndex + "]//button");
        WebElement product = base.driver.findElement(
                By.xpath("//div[@class='inventory_item'][" + productIndex + "]//div[@class='inventory_item_name']"));
        expectedProductName = product.getText();
        System.out.println(expectedProductName);
        base.driver.findElement(addToCartButton).click();
    }

    public void verifyTheCorrectProductShouldBeInTheCart() {
        By productInCart = By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name']");
        WebElement cartProductName = base.driver.findElement(productInCart);
        actualProductName = cartProductName.getText();
        System.out.println(actualProductName);
        Assertions.assertEquals(expectedProductName, actualProductName);
    }

}