package com.juaracoding.ujian5.moduletest;

import com.juaracoding.ujian5.modules.PlaceOrderModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PlaceOrderTest {
    public static WebDriver driver;
    public static PlaceOrderModule po = new PlaceOrderModule();

    public PlaceOrderTest() {
        driver = Hooks.driver;
    }

    @Given("^User in Shop page$")
    public void user_in_shop_page(){
        driver.get("https://shop.demoqa.com/shop");
    }

    @When("^User click picture of any items$")
    public void user_click_picture_of_any_items() throws Throwable {
        Hooks.delay(1);
        po.pickProduct();
    }

    @Then("^User get confirmation message$")
    public void user_get_confirmation_message(){
        Assert.assertTrue(po.fetchAlertMsg().contains("has been added to your cart"));
    }

    @And("^User choose color$")
    public void user_choose_color() {
        Hooks.delay(1);
        po.pickColor();
    }

    @And("^User choose size$")
    public void user_choose_size() {
        Hooks.delay(1);
        po.pickSize();
    }

    @And("^User click Add To Cart button$")
    public void user_click_add_to_cart_button(){
        po.addToCart();
    }

    @Given("^User in main page$")
    public void user_in_main_page() {
        driver.get("https://shop.demoqa.com/");
    }

    @When("^User click Cart button$")
    public void user_click_cart_button() {
        Hooks.delay(1);
        po.cartFromMainPage();
    }

    @Then("^User redirected to Checkout page$")
    public void user_redirected_to_checkout_page() {
        po.checkoutPageValidation();
    }

    @And("^User click Proceed To Checkout button$")
    public void user_click_proceed_to_checkout_button() {
        Hooks.delay(1);
        po.checkoutProduct();
    }
}
