package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Browser {

    public static WebDriver driver;

    public static void openBrowser(String url){
        setupDriver(Constants.BROWSER_UNDER_TEST);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void setupDriver(String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            //set default download path
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers/chromedriver.exe");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory",  System.getProperty("user.dir")+ File.separator + "downloadFiles");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);

        }else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

    }
}
