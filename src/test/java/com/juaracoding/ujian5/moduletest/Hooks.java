package com.juaracoding.ujian5.moduletest;

import com.juaracoding.ujian5.drivers.DriverSingleton;
import com.juaracoding.ujian5.modules.LoginModule;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;
    public static LoginModule login = new LoginModule();

    @BeforeAll
    public static void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
    }

    @AfterAll
    public static void quitBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    static void delay(long secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
