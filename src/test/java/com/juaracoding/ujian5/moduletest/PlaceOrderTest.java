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
    public static PlaceOrderModule cart = new PlaceOrderModule();

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
        cart.pickProduct();
    }

    @Then("^User get confirmation message$")
    public void user_get_confirmation_message(){
        Assert.assertTrue(cart.fetchAlertMsg().contains("has been added to your cart"));
    }

    @And("^User choose color$")
    public void user_choose_color() {
        Hooks.delay(1);
        cart.pickColor();
    }

    @And("^User choose size$")
    public void user_choose_size() {
        Hooks.delay(1);
        cart.pickSize();
    }

    @And("^User click Add To Cart button$")
    public void user_click_add_to_cart_button(){
        cart.addToCart();
    }
}
