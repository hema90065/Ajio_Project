package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import javax.swing.*;

public class ClickUtil {
    public static void click(WebDriver driver,WebElement element){
        WaitUtil.waitTillVisible(driver,element);
        element.click();
    }

    public static void mouseClick(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public static void clickJs(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript("arguments[0].click();", element);
    }
}
