package uat;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.DriverManager;
import utility.SignIn;

import java.io.IOException;

public class SignInTest {

    private AndroidDriver driver;
    SignIn signin;

    DriverManager driverManager = new DriverManager();

    @BeforeTest
    public void setUp() throws IOException {
        driver = driverManager.setUpAndStartServer();
    }

    @Test
    public void verifySignIn() throws InterruptedException {
        iSignInToApp();
        iAmRedirectedToHomescreen();
    }

    public void iSignInToApp() throws InterruptedException {
        signin = new SignIn(driver);
        driver = signin.login();
    }

    public void iAmRedirectedToHomescreen() {
        Assert.assertTrue(signin.isHomeScreenDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driverManager.killServer();
    }
}