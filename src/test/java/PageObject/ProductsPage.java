package PageObject;

import BaseClass.BaseClass;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BaseClass {

    private final BaseClass base;

    public ProductsPage(BaseClass base) {
        this.base = base;
    }

    By filterBy = By.cssSelector("[data-test=product_sort_container]");
    By itemNames = By.className("inventory_item_name");
    By itemPrices = By.className("inventory_item_price");
    By pageTitle = By.className("title");
    By items = By.className("inventory_item");

    public void filterItems(String filter) {
        Select filters = new Select(base.driver.findElement(filterBy));
        filters.selectByVisibleText(filter);
    }

    public String currentPage() {
        return base.driver.findElement(pageTitle).getText();
    }

    public List<WebElement> getProductList() {
        return base.driver.findElements(items);
    }

    public void nameAToZ() {
        List<WebElement> filteredProductList = getProductList();
        Collections.sort(filteredProductList, new Comparator<WebElement>() {
            @Override
            public int compare(WebElement item1, WebElement item2) {
                String name1 = item1.findElement(itemNames).getText();
                String name2 = item1.findElement(itemNames).getText();
                return name1.compareTo(name2);
            }

        });
        Assertions.assertEquals(filteredProductList, getProductList(), "order is not as expected");
    }

    public void nameZToA() {
        List<WebElement> filteredProductList = getProductList();
        Collections.sort(filteredProductList, new Comparator<WebElement>() {
            @Override
            public int compare(WebElement item1, WebElement item2) {
                String name1 = item1.findElement(itemNames).getText();
                String name2 = item2.findElement(itemNames).getText();
                return name2.compareTo(name1);
            }
        });
        Assertions.assertEquals(filteredProductList, getProductList(), "order is not as expected");
    }

    public void priceLowToHigh() {
        List<WebElement> filteredProductList = getProductList();
        Collections.sort(filteredProductList, new Comparator<WebElement>() {
            @Override
            public int compare(WebElement item1, WebElement item2) {
                String price1 = item1.findElement(itemPrices).getText();
                String price2 = item2.findElement(itemPrices).getText();
                return Double.compare(Double.parseDouble(price1.replace("$", "")),
                        Double.parseDouble(price2.replace("$", "")));
            }
        });
        Assertions.assertEquals(filteredProductList, getProductList(), "order is not as expected");
    }

    public void priceHighToLow() {
        List<WebElement> filteredProductList = getProductList();
        Collections.sort(filteredProductList, new Comparator<WebElement>() {
            @Override
            public int compare(WebElement item1, WebElement item2) {
                String price1 = item1.findElement(itemPrices).getText();
                String price2 = item2.findElement(itemPrices).getText();
                return Double.compare(Double.parseDouble(price2.replace("$", "")),
                        Double.parseDouble(price1.replace("$", "")));
            }
        });
        Assertions.assertEquals(filteredProductList, getProductList(), "order is not as expected");
    }

}
