package StepDefinitions;

import PageObject.AddToCart;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import BaseClass.BaseClass;

public class AddToCartSteps extends AddToCart {

    public AddToCartSteps(BaseClass base) {
        super(base);
    }

    @When("^I add \"([^\"]*)\" to the cart$")
    public void addProductToCart(String productName) {
        super.addProductToCart(productName);
    }

    @Then("^I see that the shopping cart badge should show (\\d+) item$")
    public void verifyCartBadge(int expectedItemCount) {
        int actualItemCount = super.getCartBadgeCount();
        Assertions.assertEquals(expectedItemCount, actualItemCount);
    }

    @When("^I click on \"([^\"]*)\" button$")
    public void click(String elementName) {
        super.clickOnElement(elementName);
    }

    @Then("^I verify that \"([^\"]*)\" product is displayed$")
    public void verifyCartContainsCorrectProduct(String productName) {
        Assertions.assertTrue(super.verifyProductIsDisplayedInCart(productName));
    }

    @When("^I add \"([^\"]*)\" to the Shopping cart$")
    public void addMultipleProductsToCart(String productName) {
        super.addProductToCart(productName);
    }

    @When("^I remove \"([^\"]*)\" product from the Shopping cart$")
    public void removeProductFromCart(String productName) {
        super.RemoveProduct(productName);
    }

    @Then("^I verify that \"([^\"]*)\" product is not displayed$")
    public void verifyProductIsNotDisplayed(String productName) {
        Assertions.assertFalse(super.verifyProductIsDisplayedInCart(productName));
    }
    
    @When("^I add product with index (\\d+) in the cart$")
    public void iAddProductWithIndexInTheCart(int productIndex) {
        super.addToCartByIndex(productIndex);
    }
    
    @Then("^I verify that the correct product should be in the cart$")
    public void theCorrectProductShouldBeInCart() {
        super.verifyTheCorrectProductShouldBeInTheCart();
    }
}