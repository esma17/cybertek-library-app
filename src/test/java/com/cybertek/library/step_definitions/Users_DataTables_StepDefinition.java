package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LibrarianHomePage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.UsersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Users_DataTables_StepDefinition {
    LoginPage loginPage = new LoginPage();
    LibrarianHomePage librarianHomePage = new LibrarianHomePage();
    UsersPage usersPage = new UsersPage();

    @When("I click on Users link")
    public void i_click_on_users_link() {
        loginPage.loginLibrarian();
//        librarianHomePage.buttontoggle.click();
        librarianHomePage.buttonUsers.click();
    }

    @Then("show records default value should be {int}")
    public void showRecordsDefaultValueShouldBe(int arg0) {
        Select select = new Select(usersPage.dropDownShowRecords);
        int selectedOption = Integer.parseInt(select.getFirstSelectedOption().getText());
        Assert.assertEquals(selectedOption, arg0);
    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(io.cucumber.datatable.DataTable dataTable) {
        List<String> options = dataTable.asList(String.class);
        Select select = new Select(usersPage.dropDownShowRecords);
        List<WebElement> actualOptions = select.getOptions();
        List<String> actualOptionsString = new ArrayList<>();
        for (WebElement each : actualOptions) {
            actualOptionsString.add(each.getText());
        }
        Assert.assertEquals(actualOptionsString, options);

    }


    @And("I click on {string} link")
    public void iClickOnLink(String arg0) {
        librarianHomePage.clickOnLinksByText("users");

    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(io.cucumber.datatable.DataTable dataTable) {
        List<String> columnNames = dataTable.asList(String.class);
        List<String> actualResult = new ArrayList<>();
        for (WebElement element : usersPage.headOfTable) {
            actualResult.add(element.getText());
        }
        Assert.assertEquals(actualResult, columnNames);
    }


}
