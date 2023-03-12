package com.juaracoding.ujian5.modules;

import com.juaracoding.ujian5.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PlaceOrderModule {
    private WebDriver driver;

    public PlaceOrderModule() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='noo-row']//div[2]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//a[1]//img[1]")
    WebElement product;

    @FindBy(id = "pa_color")
    WebElement listColor;

    @FindBy(id = "pa_size")
    WebElement listSize;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement btnAddCart;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement cartAlert;

    @FindBy(xpath = "//span[@class='cart-name-and-total']")
    WebElement mainPageCartBtn;

    @FindBy(xpath = "//a[normalize-space()='Proceed to checkout']")
    WebElement checkoutBtn;

    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement checkoutPage;

    public void pickProduct() {
        product.click();
    }

    public void addToCart() {
        btnAddCart.click();
    }

    public void cartFromMainPage() {
        mainPageCartBtn.click();
    }

    public void checkoutProduct() {
        checkoutBtn.click();
    }

    public String checkoutPageValidation(){
        return checkoutPage.getText();
    }

    public void pickColor() {
        Select colorDropDown = new Select(listColor);
        colorDropDown.selectByIndex(1);
    }

    public void pickSize() {
        Select sizeDropDown = new Select(listSize);
        sizeDropDown.selectByIndex(3);
    }

    public String fetchAlertMsg() {
        return cartAlert.getText();
    }
}
