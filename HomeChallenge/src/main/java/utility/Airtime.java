package utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;

public class Airtime {
    private AndroidDriver driver;
    private DriverHelper driverHelper;
    private String successMessage;

    private By purchaseAirtimeLabel = By.id("category_label");
    private By phoneNumberField = By.id("edit_text_phone_number");
    private By priceField = By.id("edit_text_airtime_price");
    private int naijaIndex = 0;
    int airtelIndex = 1;
    int gloIndex = 2;
    int mtnIndex = 3;
    private By naijaLabel = By.xpath("//android.widget.GridView[contains(@index, '0')]//android.widget.FrameLayout[contains(@index, '" + naijaIndex + "')]");
    private By nextButton = By.id("button_next");
    private By walletBalanceOption = By.id("tvWalletBalance");
    private By confirmButton = By.id("button_confirm_payment");
    private By payButton = By.id("button_pay");
    private By successMessageLabel = By.id("fontTextView18");
    private By backToHomescreenButton = By.id("success_home_button");


    public Airtime(AndroidDriver androidDriver) {
        driver = androidDriver;
        driverHelper = new DriverHelper(driver);
    }

    public void purchase(int amount) throws InterruptedException {
        driverHelper.clickElement(purchaseAirtimeLabel);
        driverHelper.enterText(phoneNumberField, "09087417089");
        driverHelper.enterText(priceField, String.valueOf(amount));
        driverHelper.clickElement(naijaLabel);
        driverHelper.clickElement(nextButton);
        driverHelper.clickElement(walletBalanceOption);
        driverHelper.clickElement(confirmButton);
        driverHelper.clickElement(payButton);
        Thread.sleep(1000);
        driverHelper.pressKey(AndroidKey.DIGIT_1);
        driverHelper.pressKey(AndroidKey.DIGIT_2);
        driverHelper.pressKey(AndroidKey.DIGIT_3);
        driverHelper.pressKey(AndroidKey.DIGIT_4);
        successMessage = driverHelper.getText(successMessageLabel);
        driverHelper.clickElement(backToHomescreenButton);
        Thread.sleep(3000);
    }

    public String getSuccessMessage() {
        return successMessage;
    }
}
