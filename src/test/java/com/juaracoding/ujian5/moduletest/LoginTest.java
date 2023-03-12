package com.juaracoding.ujian5.moduletest;

import com.juaracoding.ujian5.modules.LoginModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {
    public static WebDriver driver;
    public static LoginModule lm = new LoginModule();

    public LoginTest() {
        driver = Hooks.driver;
    }

    @Given("^User open browser and access MyAccount page$")
    public void user_open_browser_and_access_myaccount_page(){
        driver.get("https://shop.demoqa.com/");
        Hooks.delay(1);
        lm.dismissCookie();
        Hooks.delay(1);
        lm.goToMyAccount();
    }

    @When("^User enter valid username and password$")
    public void user_enter_valid_username_and_password(){
        Hooks.delay(1);
        lm.loginCredentials("hood101","Hood_Bismarck101");
    }
    @And("^User click login button$")
    public void user_click_login_button(){
        lm.clickLoginBtn();
    }

    @Then("^User redirected to MyAccount dashboard page$")
    public void user_redirected_to_myaccount_dashboard_page(){
        Assert.assertEquals(lm.validatePageAfterLogin(),"hood101");
    }
}
