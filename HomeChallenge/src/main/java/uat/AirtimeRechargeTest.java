package uat;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Airtime;
import utility.DriverManager;
import utility.SignIn;
import utility.Wallet;

import java.io.IOException;

public class AirtimeRechargeTest {

    private SignIn signin;
    private Wallet wallet;
    AndroidDriver driver;
    private Airtime airtime;
    private int initialWalletBalance;

    DriverManager driverManager = new DriverManager();

    @BeforeTest
    public void setUp() throws IOException {
        driver = driverManager.setUpAndStartServer();
    }

    @Test
    public void verifyAirtimeRecharge() throws InterruptedException {
        iHaveMoreThanNairaInMyWallet(100);
        iPurchasenairaAirtime(100);
        myWalletBalanceShouldBeLessByNaira(100);
    }

    private void iHaveMoreThanNairaInMyWallet(int amountToPurchase) throws InterruptedException {
        signin = new SignIn(driver);
        driver = signin.login();

        wallet = new Wallet(driver);
        Assert.assertTrue(wallet.getWalletBalance() > amountToPurchase);
    }

    private void iPurchasenairaAirtime(int amountToPurchase) throws InterruptedException {
        initialWalletBalance = wallet.getWalletBalance();

        airtime = new Airtime(driver);
        airtime.purchase(amountToPurchase);
        String successMessage = airtime.getSuccessMessage();
        Assert.assertEquals(successMessage, "Your airtime purchase was successful!");
    }

    private void myWalletBalanceShouldBeLessByNaira(int amountToPurchase) {
        int newWalletBalance = wallet.getWalletBalance();

        Assert.assertEquals(initialWalletBalance - amountToPurchase, newWalletBalance);
    }

    @AfterTest
    public void tearDown() {
        driverManager.killServer();
    }
}