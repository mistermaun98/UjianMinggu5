package com.juaracoding.ujian5.modules;

import com.juaracoding.ujian5.drivers.DriverSingleton;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddToCartModule {
    private WebDriver driver;

    public AddToCartModule() {
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

    public void pickProduct() {
        product.click();
    }

    public void addToCart() {
        btnAddCart.click();
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
