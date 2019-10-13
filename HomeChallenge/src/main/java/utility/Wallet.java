package utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;

public class Wallet {
    private DriverHelper driverHelper;

    private By walletBalanceLabel = By.id("walletBalanceView");

    private By fundWalletButton = By.id("fundWalletButton");
    private By fundWithDebitCard = By.id("fundWalletCard");
    private By walletAmountField = By.id("walletAmountToFund");
    private By proceedWithWalletFunding = By.id("proceedWalletFunding");
    private By savedCardOption = By.id("card_item");
    private By confirmPaymentButton = By.id("button_confirm_payment");
    private By securePayButton = By.id("secure_pay_button");
    private By backToHomescreenButton = By.id("success_home_button");

    private By walletTransactionsButton = By.id("viewWalletTransactionsButton");
    private By viewTransactionsFilterButton = By.id("title_menu_item_others");
    private By fromButton = By.id("createdAtEditText");
    private By confirmDateButton = By.id("android:id/button1");
    private By toButton = By.id("endAtEditText");

    public Wallet(AndroidDriver androidDriver) {
        driverHelper = new DriverHelper(androidDriver);
    }

    public int getWalletBalance() {
        String balance = driverHelper.getText(walletBalanceLabel);
        return getDigitsFromText(balance);
    }

    private int getDigitsFromText(String text){
        String str = text.substring(1, text.length()-3);
        str = str.replace(",", "");

        return Integer.parseInt(str);
    }

    public void fund(int amount) throws InterruptedException {
        driverHelper.clickElement(fundWalletButton);
        driverHelper.clickElement(fundWithDebitCard);
        driverHelper.enterText(walletAmountField, String.valueOf(amount));
        driverHelper.clickElement(proceedWithWalletFunding);
        driverHelper.clickElement(savedCardOption);
        driverHelper.clickElement(confirmPaymentButton);
        driverHelper.clickElement(securePayButton);
        Thread.sleep(1000);
        driverHelper.pressKey(AndroidKey.DIGIT_1);
        driverHelper.pressKey(AndroidKey.DIGIT_2);
        driverHelper.pressKey(AndroidKey.DIGIT_3);
        driverHelper.pressKey(AndroidKey.DIGIT_4);
        driverHelper.clickElement(backToHomescreenButton);
        Thread.sleep(3000);
    }

    public void viewRecentTransactions() {
        driverHelper.clickElement(walletTransactionsButton);
        driverHelper.clickElement(viewTransactionsFilterButton);
        driverHelper.clickElement(fromButton);
        driverHelper.clickElement(confirmDateButton);
        driverHelper.clickElement(toButton);
        driverHelper.clickElement(confirmDateButton);
    }
}
