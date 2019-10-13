package utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {

    DriverHelper driverHelper;
    private AndroidDriver driver;
    private WebDriverWait wait;

    private By carbonUpButton = By.id("carbonUpButton");
    private By skipTutorialButton = By.id("tutorial_skip");
    private By allowPermissionButton = By.id("com.android.packageinstaller:id/permission_allow_button");

    private By userExistButton = By.id("user_type_existing");
    private By phoneNumberField = By.id("sign_in_phone");
    private By pinField = By.id("sign_in_pin");
    private By signInButton = By.id("sign_in_next");

    private By hideAdvertLink = By.id("tvRightNow");

    private By homescreenTitleLabel = By.id("title_text");

    public SignIn(AndroidDriver androidDriver) {
        driver = androidDriver;
    }

    public AndroidDriver login() throws InterruptedException {
        //driver = driverManager.setUpAndStartServer();
        navigateToSignInScreen();

        driverHelper.enterText(phoneNumberField, "08990001099");
        driverHelper.enterText(pinField, "1234");
        driverHelper.clickElement(signInButton);

        Thread.sleep(10000);
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));

        try {
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tvRightNow"))) != null) {
                driverHelper.clickElement(hideAdvertLink);
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            //Continue if not present
        }

        return driver;
    }

    private void navigateToSignInScreen() {
        driverHelper = new DriverHelper(driver);

        driverHelper.clickElement(carbonUpButton);
        driverHelper.clickElement(skipTutorialButton);
        driverHelper.clickElement(allowPermissionButton);

        wait = new WebDriverWait(driver, 3);

        try {
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button1"))) != null) {
                driver.findElement(By.id("button1")).click();
            }
        } catch (Exception e) {
            //Continue if not present
        }

        driverHelper.clickElement(userExistButton);
    }

    public boolean isHomeScreenDisplayed() {
        return "Home".equals(driverHelper.getText(homescreenTitleLabel));
    }
}
