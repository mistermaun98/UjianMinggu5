package com.juaracoding.ujian5.modules;

import com.juaracoding.ujian5.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginModule {
    private WebDriver driver;

    public LoginModule() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/p/a")
    WebElement cookieReminder;
    @FindBy(xpath = "//a[normalize-space()='My Account']")
    WebElement myAccount;
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    WebElement btnLogin;
    @FindBy(xpath = "//strong[1]")
    WebElement validatePage;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logoutBtn;

    public String validatePageAfterLogin() {
        return validatePage.getText();
    }

    public void dismissCookie() {
        cookieReminder.click();
    }

    public void goToMyAccount() {
        myAccount.click();
    }

    public void clickLoginBtn() {
        btnLogin.click();
    }

    public void logout() {
        logoutBtn.click();
    }

    public void loginCredentials(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }
}
