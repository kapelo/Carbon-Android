package utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.io.IOException;

public class DriverManager {
    private static DriverService service;
    private static AndroidDriver driver;

    private static String nodeJSath = ServerManager.getNodeHome() +"/bin/node";
    private static String appiumJSPath = ServerManager.getNodeHome() +"/lib/node_modules/appium/build/lib/main.js";

    private static DriverService createService () {
        return new AppiumServiceBuilder()
                .usingDriverExecutable(new File(nodeJSath))
                .withAppiumJS(new File(appiumJSPath))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .build();
    }

    public static AndroidDriver setUpAndStartServer() throws IOException {
        System.setProperty(AppiumServiceBuilder.NODE_PATH , nodeJSath);
        System.setProperty(AppiumServiceBuilder.APPIUM_PATH , appiumJSPath);

        service = DriverManager.createService();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException(
                    "An appium server node is not started!");
        }

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../HomeChallenge/app");
        File app = new File(appDir.getCanonicalPath(), "paylater-full-debug-v5.5.3-1909091739.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("appPackage", "com.lenddo.mobile.paylater.staging");
        capabilities.setCapability("appActivity", "com.lenddo.mobile.paylater.home.activity.RebrandIntroActivity");

        driver = new AndroidDriver<>(service.getUrl(), capabilities);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }

    public static void killServer() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}

