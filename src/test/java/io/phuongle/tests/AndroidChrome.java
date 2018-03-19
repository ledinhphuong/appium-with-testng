package io.phuongle.tests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidChrome {
  protected AppiumDriver<WebElement> driver = null;

  @Parameters({"deviceName", "appiumUrl"})
  @BeforeClass
  public void setup(String deviceName, String appiumUrl) throws MalformedURLException {
    System.out.println("Initialize driver to run test on " + deviceName);

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("deviceName", deviceName);
    capabilities.setCapability("browserName", "chrome");
    capabilities.setCapability("sessionName", "Android Chrome testing");
    capabilities.setCapability("sessionDescription", "Android Chrome testing description");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("automationName", "UIAutomator2");
    capabilities.setCapability("platformVersion", "7.0");
    capabilities.setCapability("deviceOrientation", "portrait");
    capabilities.setCapability("captureScreenshots", true);
    capabilities.setCapability("autoGrantPermissions", true);

    driver = new AppiumDriver<WebElement>(new URL(appiumUrl), capabilities);
  }

  @AfterClass
  public void tearDown() {
    System.out.println("Destroy driver");
    if (driver != null) driver.quit();
  }

  @Test(description = "Launch google website and search 'phuong le' text")
  public void launchGoogleSite() {
    driver.get("https://www.google.com");

    WebElement textField = driver.findElement(By.name("q"));
    textField.sendKeys("phuong le");
    textField.submit();
  }
}
