package uat;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.DriverManager;
import utility.SignIn;
import utility.Wallet;

import java.io.IOException;

public class FundWalletTest {

    private AndroidDriver driver;
    private Wallet wallet;
    private int initialWalletBalance;

    DriverManager driverManager = new DriverManager();

    @BeforeTest
    public void setUp() throws IOException {
        driver = driverManager.setUpAndStartServer();
    }

    @Test
    public void verifyWalletFund() throws IOException, InterruptedException {
        iFundMyWalletWithNaira(1000);
        myWalletBalanceShouldBeMoreByNaira(1000);
    }

    public void iFundMyWalletWithNaira(int amount) throws InterruptedException {
        SignIn signin = new SignIn(driver);
        driver = signin.login();

        wallet = new Wallet(driver);
        initialWalletBalance = wallet.getWalletBalance();
        wallet.fund(amount);

        int newWalletBalance = wallet.getWalletBalance();
        Assert.assertEquals(initialWalletBalance, newWalletBalance - amount);
    }

    public void myWalletBalanceShouldBeMoreByNaira(int amount) {
        int newWalletBalance = wallet.getWalletBalance();

        Assert.assertEquals(newWalletBalance, initialWalletBalance + amount);
    }

    @AfterTest
    public void tearDown() {
        driverManager.killServer();
    }
}
