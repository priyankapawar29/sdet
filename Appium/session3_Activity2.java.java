package AppiumActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class session3AppiumActivity2
{
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void beforeSetUp()
	{
		DesiredCapabilities dsc = new DesiredCapabilities();
		dsc.setCapability("deviceId", "emulator-5554");
		dsc.setCapability("deviceName", "Pixel4Emulator");
		dsc.setCapability("platformName", "android");
		dsc.setCapability("appPackage", "com.android.chrome");
		dsc.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		dsc.setCapability("noReset", true);
		try 
		{
			driver = new AndroidDriver <MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"), dsc);
			wait = new WebDriverWait(driver, 10);
		} 
		catch (MalformedURLException e) 
		{
			System.out.println(e.getMessage());
		}		
	}
	@Test
	public void scrollGooglePage() 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/lazy-loading");

		MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
		wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));

		List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
		System.out.println("Number of image shown currently: " + numberOfImages.size());

		Assert.assertEquals(numberOfImages.size(), 4);
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));

		numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
		System.out.println("Number of image shown currently: " + numberOfImages.size());

		Assert.assertEquals(numberOfImages.size(), 4);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}