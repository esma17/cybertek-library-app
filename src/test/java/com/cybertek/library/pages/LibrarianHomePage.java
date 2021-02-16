package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LibrarianHomePage {
    public LibrarianHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@id='user_count']")
    public WebElement userCount;

    @FindBy(xpath = "//button[@class='navbar-toggler']")
    public WebElement buttontoggle;

    @FindBy(xpath = "//a[@href='#users']")
    public WebElement buttonUsers;

    @FindBy(xpath = "//a[contains(@href,'#')]")
    public List<WebElement> allLinks;

    public void clickOnLinksByText(String str) {
        for (WebElement element : allLinks) {
            if (element.getAttribute("href").contains(str)) {
                element.click();
            }
        }

    }
}