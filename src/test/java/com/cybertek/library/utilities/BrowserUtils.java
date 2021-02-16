package com.cybertek.library.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    public static void sleep(int seconds) {
        seconds *= 1000;

        try {
            Thread.sleep(seconds);

        } catch (InterruptedException e) {
            System.out.println("something happen in sleep method");
        }
    }

    public static void hoover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void clickOn(WebElement element, int timeout) {
        final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element)));
        element.click();
    }

}
