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

    @When("^Logout from account dashboard$")
    public void logout_from_account_dashboard() {
        lm.logout();
    }

    @When("^User enter valid username and password$")
    public void user_enter_valid_username_and_password(){
        Hooks.delay(1);
        lm.loginCredentials("hood101","Hood_Bismarck101");
    }

    @And("^User enter invalid username and valid password$")
    public void user_enter_invalid_username_and_valid_password() {
        lm.loginCredentials("bismarck101","Hood_Bismarck101");
    }

    @When("^User enter valid username and invalid password$")
    public void user_enter_valid_username_and_invalid_password() {
        lm.loginFormPurge();
        Hooks.delay(2);
        lm.loginCredentials("hood101","aselolejoss");
    }

    @And("^User click login button$")
    public void user_click_login_button(){
        lm.clickLoginBtn();
    }

    @Then("^User redirected to MyAccount dashboard page$")
    public void user_redirected_to_myaccount_dashboard_page(){
        Assert.assertEquals(lm.validatePageAfterLogin(),"hood101");
    }

    @Then("^Error message shown to user$")
    public void error_message_shown_to_user() {
        Assert.assertTrue(lm.fetchLoginErrorMsg().contains("ERROR: The username or password you entered is incorrect"));
    }
}
