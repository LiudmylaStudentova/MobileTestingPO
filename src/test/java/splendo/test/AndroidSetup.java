package splendo.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.io.File;
import java.net.URL;


public class AndroidSetup {

  protected AndroidDriver driver;

  protected void prepareAndroidForAppium() throws MalformedURLException {
    File appDir = new File("app");
    File app = new File(appDir, "splendo.apk");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("device", "pixel (Google)");
    capabilities.setCapability("deviceName", "Pixel_API_26");
    capabilities.setCapability("appActivity", "com.splendapps.splendo.MainActivity");
    capabilities.setCapability("appPackage", "com.splendapps.splendo");
    capabilities.setCapability("app", app.getAbsolutePath());

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }
  @BeforeClass
  public void setUp() throws Exception {
    prepareAndroidForAppium();
  }

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
  }
}
