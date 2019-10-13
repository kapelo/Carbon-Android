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

public class ViewWalletTransactionsTest {

    private AndroidDriver driver;
    private Wallet wallet;

    DriverManager driverManager = new DriverManager();

    @BeforeTest
    public void setUp() throws IOException {
        driver = driverManager.setUpAndStartServer();
    }

    @Test
    public void verifyWalletTransactions() throws IOException, InterruptedException {
        iAmOnTheHomeScreen();
        iFilterWalletTransactionsByCurrentDate();
    }

    public void iAmOnTheHomeScreen() throws InterruptedException {
        SignIn signin = new SignIn(driver);
        driver = signin.login();
        Assert.assertTrue(signin.isHomeScreenDisplayed());
    }

    public void iFilterWalletTransactionsByCurrentDate() {
        wallet = new Wallet(driver);
        wallet.viewRecentTransactions();
    }

    @AfterTest
    public void tearDown() {
        driverManager.killServer();
    }
}
