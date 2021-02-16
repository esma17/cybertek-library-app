package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LibrarianHomePage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.StudentHomePage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Login_Step_Definitions {
    LoginPage login = new LoginPage();
    LibrarianHomePage librarianHomePage=new LibrarianHomePage();
    StudentHomePage student=new StudentHomePage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("I login as a librarian")
    public void iLoginAsALibrarian() {
        login.boxEmailAdress.sendKeys(ConfigurationReader.getProperty("librarianUser"));
        login.boxPassword.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        login.buttonSignIn.click();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
       Assert.assertTrue(login.dashBoardForLibrarian.isDisplayed());
    }


    @When("I login as a student")
    public void iLoginAsAStudent() {
        login.boxEmailAdress.sendKeys(ConfigurationReader.getProperty("studentUser"));
        login.boxPassword.sendKeys(ConfigurationReader.getProperty("studentPassword"));
        login.buttonSignIn.click();

    }

    @Then("books page should be displayed")
    public void books_page_should_be_displayed() {
Assert.assertTrue(student.booksForStudent.isDisplayed());
    }

    // **************************************************
    @When("I enter username {string}")
    public void i_enter_username(String string) {
        login.boxEmailAdress.sendKeys(string);
    }
    @When("I enter password {string}")
    public void i_enter_password(String string) {
        login.boxPassword.sendKeys(string);
    }
    @When("I click to the sign in button")
    public void i_click_to_the_sign_in_button() {
        login.buttonSignIn.click();
    }

    @Then("there should be {string} users")
    public void there_should_be_users(String string) {
        String actualResult= librarianHomePage.userCount.getText();
        Assert.assertEquals(actualResult,string);
    }


    @When("I enter username {string} and {string}")
    public void iEnterUsernameAnd(String arg0, String arg1) {
        login.boxEmailAdress.sendKeys(arg0);
        login.boxPassword.sendKeys(arg1);
        login.buttonSignIn.click();
    }

}
