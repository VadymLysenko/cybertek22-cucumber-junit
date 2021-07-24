package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {}

    /*
    Making our driver instance private so that it is not reachable from outside of the class
    We make it static, because we want it run it before everything else, and we will use it in static method
     */
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    /*

    Creating re-usable utility method that will return same 'driver' instance everytime we call it
     */
    public static WebDriver getDriver() {
        if(driverPool.get()==null){

            /*
            We reed our browser type from conf.prop file using
            .getProperty method we creating in ConfReader class
             */

            String browserType = ConfigurationReader.getProperty("browser");
            /*

            Depending on the browser type our switch statement will determine
            to open specific type of browser/driver
             */
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }
        /*

        same driver instance will be return all the time we will call Driver.getDriver(); method
         */
        return driverPool.get();
    }
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}
