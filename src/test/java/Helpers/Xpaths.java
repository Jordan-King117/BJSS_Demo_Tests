package Helpers;

public interface Xpaths {

    //B
    String BANNER_MESSAGE_SUCCESS       = "//div[@class='flash success']";
    String BANNER_MESSAGE_FAILURE       = "//div[@class='flash error']";

    //F
    String FILE_DOWNLOAD_PAGE           = "//div//h3[text()='File Downloader']";

    //H
    String HOVERS_PAGE                  = "//div//h3[text()='Hovers']";

    //L
    String LINK_FORM_AUTHENTICATION     = "//a[text()='Form Authentication']";
    String LINK_FILE_DOWNLOADER         = "//a[text()='File Download']";
    String LINK_HOVER                   = "//a[text()='Hovers']";
    String LOGIN_PAGE_HEADER            = "//div//h2[text()='Login Page']";

    //N
    String NOT_FOUND_PAGE               = "//h1[text()='Not Found']";

    //S
    String SECURE_AREA                  = "//div//h2[text()=' Secure Area']";

    //U
    String USER_AVATAR_PARENT_VALUE     = "//parent::div//parent::div";
    String USER_ONE                     = "//a[@href='/users/1']";
    String USER_TWO                     = "//a[@href='/users/2']";
    String USER_THREE                   = "//a[@href='/users/3']";
}
