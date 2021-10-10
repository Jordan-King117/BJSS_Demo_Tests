package DemoTests;

import Helpers.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Download_Files {

    public static String DOWNLOAD_FOLDER      = new File("downloadFiles").getAbsolutePath();
    public static String GENERIC_TEXT_PATH    = "//a[text()='";


    @BeforeTest
    public void openBrowser(){
        Browser.openBrowser(Constants.URL);
    }

    @Test(description = "navigate to download files")
    public void File_Downloader(){
        //Navigate to the file downloader page
        Functions.clickOnElement("XPATH", Xpaths.LINK_FILE_DOWNLOADER);

        //assert correct page has loaded
        TestAssertions.verifyPathExists(Xpaths.FILE_DOWNLOAD_PAGE, "File Downloader page not loaded");

        //assert all files appear on page
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.FIRST_FLOWER_PICTURE + "']", "First flower image does not exist");
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.SECOND_FLOWER_PICTURE + "']", "Second flower image does not exist");
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.THIRD_FLOWER_PICTURE + "']", "Violet image does not exist");
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.SAMPLE_IMAGE + "']", "Sample png does not exist");
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.SAMPLE_PDF + "']", "Sample pdf does not exist");
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.PUP_KITTY_IMG + "']", "Puppy and Kitty image does not exist");
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.KOZICA_IMAGE + "']", "Kozica image does not exist");
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.TEXT_FILE + "']", "Text file does not exist");
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.SECOND_TEXT_FILE + "']", "Number file does not exist");
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.YASH_DOC + "']", "Yash doc does not exist");
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.SOME_TEXT_FILE + "']", "Some text file does not exist");
        TestAssertions.verifyPathExists(GENERIC_TEXT_PATH + Var.LUCK_PNG + "']", "luck image does not exist");
    }

    @Test(dependsOnMethods = {"File_Downloader"}, description = "download all files")
    public void Download_Files() throws InterruptedException {
        //download all available files
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.FIRST_FLOWER_PICTURE + "']");
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.SECOND_FLOWER_PICTURE + "']");
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.THIRD_FLOWER_PICTURE + "']");
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.SAMPLE_IMAGE + "']");
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.SAMPLE_PDF + "']");
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.PUP_KITTY_IMG + "']");
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.KOZICA_IMAGE + "']");
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.TEXT_FILE + "']");
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.SECOND_TEXT_FILE + "']");
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.YASH_DOC + "']");
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.SOME_TEXT_FILE + "']");
        Functions.clickOnElement("XPATH", GENERIC_TEXT_PATH + Var.LUCK_PNG + "']");

        //assert all files exist in download folder
        assertFileExistsInFolder(Var.FIRST_FLOWER_PICTURE);
        assertFileExistsInFolder(Var.SECOND_FLOWER_PICTURE);
        assertFileExistsInFolder(Var.THIRD_FLOWER_PICTURE);
        assertFileExistsInFolder(Var.SAMPLE_IMAGE);
        assertFileExistsInFolder(Var.SAMPLE_PDF);
        assertFileExistsInFolder(Var.PUP_KITTY_IMG);
        assertFileExistsInFolder(Var.KOZICA_IMAGE);
        assertFileExistsInFolder(Var.TEXT_FILE);
        assertFileExistsInFolder(Var.SECOND_TEXT_FILE);
        assertFileExistsInFolder(Var.YASH_DOC);
        assertFileExistsInFolder(Var.SOME_TEXT_FILE);
        assertFileExistsInFolder(Var.LUCK_PNG);
    }

    @Test(dependsOnMethods = {"Download_Files"}, description = "delete downloaded files and ensure they no longer exist in folder")
    public void Delete_Files() throws InterruptedException {
        //delete all files in the folder
        Utils.emptyTheFolder(DOWNLOAD_FOLDER);

        //assert downloaded files can no longer be found in folder
        assertFileDoesNotExistsInFolder(Var.FIRST_FLOWER_PICTURE);
        assertFileDoesNotExistsInFolder(Var.SECOND_FLOWER_PICTURE);
        assertFileDoesNotExistsInFolder(Var.THIRD_FLOWER_PICTURE);
        assertFileDoesNotExistsInFolder(Var.SAMPLE_IMAGE);
        assertFileDoesNotExistsInFolder(Var.SAMPLE_PDF);
        assertFileDoesNotExistsInFolder(Var.PUP_KITTY_IMG);
        assertFileDoesNotExistsInFolder(Var.KOZICA_IMAGE);
        assertFileDoesNotExistsInFolder(Var.TEXT_FILE);
        assertFileDoesNotExistsInFolder(Var.SECOND_TEXT_FILE);
        assertFileDoesNotExistsInFolder(Var.YASH_DOC);
        assertFileDoesNotExistsInFolder(Var.SOME_TEXT_FILE);
        assertFileDoesNotExistsInFolder(Var.LUCK_PNG);
    }

    @AfterTest
    public void closeBrowser(){
        Browser.driver.quit();
    }
    

    private boolean assertFileExistsInFolder(String fileName) throws InterruptedException {
        Boolean isFileNameInFolder = Utils.getListOfFileNames_InFolder(DOWNLOAD_FOLDER).contains(fileName);
        int count = 1;
        while (isFileNameInFolder == false && count < 3) {
            Thread.sleep(3000);
            isFileNameInFolder = Utils.getListOfFileNames_InFolder(DOWNLOAD_FOLDER).contains(fileName);
            count++;
        }
        Assert.assertTrue(isFileNameInFolder);
        return true;
    }

    private boolean assertFileDoesNotExistsInFolder(String fileName) throws InterruptedException {
        Boolean fileNameIsNotInFolder = !Utils.getListOfFileNames_InFolder(DOWNLOAD_FOLDER).contains(fileName);
        Assert.assertTrue(fileNameIsNotInFolder);
        return true;
    }
}
