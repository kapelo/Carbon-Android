package utility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

class DriverHelper {
     private AndroidDriver driver;

     DriverHelper(AndroidDriver androidDriver) {
        driver = androidDriver;
     }

    private MobileElement waitForElementToBeDisplayed(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 21);
            return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    void clickElement(By locator) {
        MobileElement element = waitForElementToBeDisplayed(locator);

        try {
            element.click();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    void enterText(By locator, String text) {
        MobileElement element = waitForElementToBeDisplayed(locator);

        try {
            element.sendKeys(text);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    String getText(By locator) {
        MobileElement element = waitForElementToBeDisplayed(locator);

        try {
            return element.getText();
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    void pressKey(AndroidKey key) {
        try {
            driver.pressKey(new KeyEvent(key));
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }
}