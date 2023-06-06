package StepDefinitions;

import PageObject.ProductsPage;
import BaseClass.BaseClass;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class ProductsSteps extends ProductsPage {

    public ProductsSteps(BaseClass base) {
        super(base);
    }

    @Given("^\"([^\"]*)\" page is open$")
    public void currentPage(String title) {
        Assertions.assertEquals(title, super.currentPage());
    }

    @When("^I filter items by \"([^\"]*)\"$")
    public void iFilterItemsBy(String filter) {
        super.filterItems(filter);  
    }

    @Then("^I veify that items are filtered by \"([^\"]*)\"$")
    public void iVerifyThatItemsAreFilteredBy(String filterType) {
       

        switch (filterType) {

            case "Name (A to Z)":
                super.nameAToZ();
                break;

            case "Name (Z to A)":
                super.nameZToA();
                break;

            case "Price (low to high)":
                super.priceLowToHigh();
                break;

            case "Price (high to low)":
                super.priceHighToLow();
                break;  
            
        }

        
    }
}