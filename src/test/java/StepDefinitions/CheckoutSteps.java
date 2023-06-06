package StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import BaseClass.BaseClass;
import PageObject.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    public CheckoutSteps(BaseClass base) {
        super(base);
    }

    
    @When("^I fill in (.*) field with \"(.*)\" value$")
    public void fillField(String fieldName, String value) {
        super.fillField(fieldName, value);
    }

   
    @Then("^I should see the succsessfuly message \"([^\"]*)\"$")
    public void verifySuccessfulMessage(String succsessMessage) {
     Assertions.assertTrue(super.CheckoutCompleteMessage(succsessMessage));
       
    }

}
