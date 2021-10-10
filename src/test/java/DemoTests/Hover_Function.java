package DemoTests;

import Helpers.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hover_Function {


    @BeforeTest
    public void openBrowser(){
        Browser.openBrowser(Constants.URL);
    }

    @Test(description = "navigate to download files")
    public void Navigate_To_Hover() {
        //Navigate to the hover functionality page
        Functions.clickOnElement("XPATH", Xpaths.LINK_HOVER);

        //assert correct page has loaded
        TestAssertions.verifyPathExists(Xpaths.HOVERS_PAGE, "File Downloader page not loaded");

        //assert 3 user profiles can be found
        TestAssertions.verifyPathExists(Xpaths.USER_ONE + Xpaths.USER_AVATAR_PARENT_VALUE, "User 1 cannot be found");
        TestAssertions.verifyPathExists(Xpaths.USER_TWO + Xpaths.USER_AVATAR_PARENT_VALUE, "User 2 cannot be found");
        TestAssertions.verifyPathExists(Xpaths.USER_THREE + Xpaths.USER_AVATAR_PARENT_VALUE, "User 3 cannot be found");
    }

    @Test(dependsOnMethods = {"Navigate_To_Hover"}, description = "Hover over each user and open the link")
    public void Hover_Over_Users()  {
        //click on user profile one and ensure you are navigated to the next page
        Functions.hoverMouse(Xpaths.USER_ONE + Xpaths.USER_AVATAR_PARENT_VALUE);
        Functions.clickOnElement("XPATH", Xpaths.USER_ONE);
        TestAssertions.verifyText(Xpaths.NOT_FOUND_PAGE, Var.PAGE_NOT_FOUND);

        //navigate back to hovers page
        Browser.driver.navigate().back();

        //click on user profile two and ensure you are navigated to the next page
        Functions.hoverMouse(Xpaths.USER_TWO + Xpaths.USER_AVATAR_PARENT_VALUE);
        Functions.clickOnElement("XPATH", Xpaths.USER_TWO);
        TestAssertions.verifyText(Xpaths.NOT_FOUND_PAGE, Var.PAGE_NOT_FOUND);
        Browser.driver.navigate().back();

        //click on user profile three and ensure you are navigated to the next page
        Functions.hoverMouse(Xpaths.USER_THREE + Xpaths.USER_AVATAR_PARENT_VALUE);
        Functions.clickOnElement("XPATH", Xpaths.USER_THREE);
        TestAssertions.verifyText(Xpaths.NOT_FOUND_PAGE, Var.PAGE_NOT_FOUND);
    }

    @AfterTest
    public void closeBrowser(){
        Browser.driver.quit();
    }
}
