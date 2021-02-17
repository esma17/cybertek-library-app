package com.cybertek.library.pages;

import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement boxEmailAdress;

    @FindBy(id = "inputPassword")
    public WebElement boxPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement buttonSignIn;

    @FindBy(xpath = "//section[@id='dashboard']/div")
    public WebElement dashBoardForLibrarian;
    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle']/span")
    public WebElement avatarName;


    public boolean loginStudent() {
        StudentHomePage student = new StudentHomePage();
        boolean canLogin = false;
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        boxEmailAdress.sendKeys(ConfigurationReader.getProperty("studentUser"));
        boxPassword.sendKeys(ConfigurationReader.getProperty("studentPassword"));
        buttonSignIn.click();
        if (student.booksForStudent.isDisplayed()) {
            canLogin = true;
        }
        return canLogin;
    }

    public boolean loginLibrarian() {
        boolean canLogin = false;
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        boxEmailAdress.sendKeys(ConfigurationReader.getProperty("librarianUser"));
        boxPassword.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        buttonSignIn.click();
        if (dashBoardForLibrarian.isDisplayed()) {
            canLogin = true;
        }
        return canLogin;
    }


}
