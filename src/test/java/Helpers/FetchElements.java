package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FetchElements {

    public WebElement getWebElement(String identifierType, String identifierValue){
        switch(identifierType){
            case"ID":
                return  Browser.driver.findElement(By.id(identifierValue));
            case"CSS":
                return  Browser.driver.findElement(By.cssSelector(identifierValue));
            case"XPATH":
                return  Browser.driver.findElement(By.xpath(identifierValue));
            case"NAME":
                return  Browser.driver.findElement(By.name(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getListWebElements(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return Browser.driver.findElements(By.id(identifierValue));
            case "CSS":
                return Browser.driver.findElements(By.cssSelector(identifierValue));
            case "XPATH":
                return Browser.driver.findElements(By.xpath(identifierValue));
            case "NAME":
                return Browser.driver.findElements(By.name(identifierValue));
            default:
                return null;
        }
    }
}
