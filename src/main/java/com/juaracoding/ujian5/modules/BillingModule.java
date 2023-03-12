package com.juaracoding.ujian5.modules;

import com.juaracoding.ujian5.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingModule {
    private WebDriver driver;

    public BillingModule() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
    WebElement orderCompletedMsg;

    @FindBy(id = "billing_first_name")
    WebElement firstName;

    @FindBy(id = "billing_last_name")
    WebElement lastName;

    @FindBy(id = "billing_company")
    WebElement optionalCompanyName;

    @FindBy(id = "billing_address_1")
    WebElement mandatoryAddress;

    @FindBy(id = "billing_address_2")
    WebElement optionalAddress;

    @FindBy(id = "billing_city")
    WebElement city;

    @FindBy(id = "billing_state")
    WebElement optionalState;

    @FindBy(id = "billing_postcode")
    WebElement zipcode;

    @FindBy(id = "billing_phone")
    WebElement phoneNumber;

    @FindBy(id = "billing_email")
    WebElement email;

    @FindBy(id = "order_comments")
    WebElement optionalOrderNotes;

    @FindBy(id = "terms")
    WebElement termsAndConditions;

    @FindBy(id = "place_order")
    WebElement orderProductBtn;

    @FindBy(xpath = "//span[@id='select2-billing_country-container']")
    WebElement countryList;
    @FindBy(xpath = "//input[@role='combobox']")
    WebElement countryListCombobox;

    public void fillCredentials() {
        firstName.sendKeys("Arthur");
        lastName.sendKeys("Hood");
        delay(1);
        optionalCompanyName.sendKeys("United Kingdom Royal Navy");
        delay(1);
        
        countryList.click();
        delay(1);
        countryListCombobox.sendKeys("United Kingdom (UK)", Keys.ARROW_DOWN,Keys.ENTER);
        
        delay(1);
        mandatoryAddress.sendKeys("32 East St.");
        optionalAddress.sendKeys("Primrose Cottage 32");
        delay(1);
        city.sendKeys("Alford");
        delay(1);
        optionalState.sendKeys("Lincolnshire");
        delay(1);
        zipcode.sendKeys("LN13 9EH");
        delay(1);
        phoneNumber.sendKeys("+44 070 5192 7779");
        delay(1);
        email.sendKeys("kms.bismarck_tirpitz@azurlane.com");
        delay(1);
        optionalOrderNotes.sendKeys("If Bismarck and Tirpitz not available, send to Nimi or Eugen");
        delay(1);
    }

    public void clearForm() {
        firstName.clear();
        lastName.clear();
        optionalCompanyName.clear();
        mandatoryAddress.clear();
        optionalAddress.clear();
        city.clear();
        optionalState.clear();
        zipcode.clear();
        phoneNumber.clear();
        email.clear();
        optionalOrderNotes.clear();
    }

    public void acceptTerms() {
        termsAndConditions.click();
    }

    public void placeOrder() {
        orderProductBtn.click();
    }

    public String fetchOrderStatusMsg() {
        return orderCompletedMsg.getText();
    }

    static void delay(long secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
