package com.juaracoding.ujian5.moduletest;

import com.juaracoding.ujian5.modules.BillingModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BillingTest {
    public static WebDriver driver;
    public static BillingModule bill = new BillingModule();

    public BillingTest() {
        driver = Hooks.driver;
    }

    @When("^User filled the form with correct UK credentials$")
    public void user_filled_the_form_with_correct_uk_credentials() {
        bill.clearForm();
        Hooks.delay(3);
        bill.fillCredentials();
    }

    @And("^User clicked Terms and Conditions agreements$")
    public void user_clicked_terms_and_conditions_agreements() {
        Hooks.delay(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, -500)");
        Hooks.delay(2);
        bill.acceptTerms();
    }

    @And("^User clicked Place Order button$")
    public void user_clicked_place_order_button() {
        Hooks.delay(2);
        bill.placeOrder();
    }

    @Then("^User receieve an Order Receieved message$")
    public void user_receieve_an_order_receieved_message() {
        Hooks.delay(2);
        String actualMsg = bill.fetchOrderStatusMsg();
        Assert.assertTrue(actualMsg.contains("Thank you. Your order has been received."));
    }
}
