package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentHomePage {
public StudentHomePage(){
    PageFactory.initElements(Driver.getDriver(),this);
}
    @FindBy(xpath = "//div[@id='tbl_books_wrapper']")
    public WebElement booksForStudent;
}
