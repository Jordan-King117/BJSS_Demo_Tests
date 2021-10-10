package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Helpers.Browser.driver;

public class Functions {


    public static void clickOnElement(String identifier, String pathValue){
        FetchElements clickPath = new FetchElements();
        clickPath.getWebElement(identifier, pathValue).click();
    }

    public static void enterText(String fieldName, String value){
        driver.findElement(By.name(fieldName)).sendKeys(value);
    }

    public static void hoverMouse(String hoverPath){
        //hover on the menu
        WebElement searchMenu = driver.findElement(By.xpath(hoverPath));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchMenu).perform();
    }

}
