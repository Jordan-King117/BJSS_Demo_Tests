package DemoTests;

import Helpers.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Form_Authentication {

    public static String LOGIN_BUTTON  = "//button[@type='submit']";
    public static String LOGOUT_BUTTON = "//i[contains(@class,'icon-signout')]";

    @BeforeTest
    public void openBrowser(){
        Browser.openBrowser(Constants.URL);
    }

    @Test(description = "After browser launches ensure the home page has loaded")
    public void assertHomePageLoaded(){
        //assert we have landed on the homepage by checking for the "The Internet" title
        String actualTitle = Browser.driver.getTitle();
        String expectedTitle = Var.HOMEPAGE_TITLE;
        Assert.assertEquals(expectedTitle,actualTitle);

        //Navigate to the form authentication section
        Functions.clickOnElement("XPATH", Xpaths.LINK_FORM_AUTHENTICATION);
    }

    @Test(dependsOnMethods = {"assertHomePageLoaded"}, description = "Enter an accepted username and password")
    public void Insert_Correct_Usrnm_And_Pwd() {
        //assert form authentication page has loaded
        TestAssertions.verifyPathExists(Xpaths.LOGIN_PAGE_HEADER, "Form Authentication page not loaded");

        //Enter username and password and click login
        Functions.enterText(Var.USERNAME_FIELD, Var.USERNAME_VALUE);
        Functions.enterText(Var.PASSWORD_FIELD, Var.PASSWORD_VALUE);
        Functions.clickOnElement("XPATH", LOGIN_BUTTON);

        //assert user have been taken to the "login successful" page
        TestAssertions.verifyText(Xpaths.SECURE_AREA,Var.SECURE_AREA);

        //assert login success banner appears
        TestAssertions.verifyText(Xpaths.BANNER_MESSAGE_SUCCESS, Var.SECURE_LOGIN_SUCCESS);

        //click logout button and logout success banner appears
        Functions.clickOnElement("XPATH", LOGOUT_BUTTON);
        TestAssertions.verifyText(Xpaths.BANNER_MESSAGE_SUCCESS, Var.LOGOUT_SUCCESS);
    }

    @Test(dependsOnMethods = {"Insert_Correct_Usrnm_And_Pwd"}, description = "Enter an incorrect username and correct password")
    public void Insert_Incorrect_Usrnm() {
        //Enter incorrect username and correct password and click login
        Functions.enterText(Var.USERNAME_FIELD, Var.INCORRECT_USERNAME);
        Functions.enterText(Var.PASSWORD_FIELD, Var.PASSWORD_VALUE);
        Functions.clickOnElement("XPATH", LOGIN_BUTTON);

        //assert incorrect username banner exists
        TestAssertions.verifyText(Xpaths.BANNER_MESSAGE_FAILURE, Var.INVALID_USERNAME_ERROR);
    }

    @Test(dependsOnMethods = {"Insert_Incorrect_Usrnm"}, description = "Enter a correct username and incorrect password")
    public void Insert_Incorrect_Pwd() {
        //Enter correct username and incorrect password and click login
        Functions.enterText(Var.USERNAME_FIELD, Var.USERNAME_VALUE);
        Functions.enterText(Var.PASSWORD_FIELD, Var.INCORRECT_PASSWORD);
        Functions.clickOnElement("XPATH", LOGIN_BUTTON);

        //assert incorrect password banner exists
        TestAssertions.verifyText(Xpaths.BANNER_MESSAGE_FAILURE, Var.INVALID_PASSWORD_ERROR);
    }

    @Test(dependsOnMethods = {"Insert_Incorrect_Pwd"}, description = "Enter an incorrect username and password")
    public void Insert_Incorrect_Usrnm_And_Pwd() {
        //Enter incorrect username and incorrect password and click login
        Functions.enterText(Var.USERNAME_FIELD, Var.INCORRECT_USERNAME);
        Functions.enterText(Var.PASSWORD_FIELD, Var.INCORRECT_PASSWORD);
        Functions.clickOnElement("XPATH", LOGIN_BUTTON);

        //assert incorrect username and password banner exists
        TestAssertions.verifyText(Xpaths.BANNER_MESSAGE_FAILURE, Var.INVALID_USERNAME_ERROR);
    }

    @AfterTest
    public void closeBrowser(){
        Browser.driver.quit();
    }
}
