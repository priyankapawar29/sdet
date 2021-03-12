package AppiumActivities;

import java.net.MalformedURLException;
import java.net.URL;
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

public class session3AppiumActivity1 
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
		dsc.setCapability("appPackage", "com.google.android.apps.messaging");
		dsc.setCapability("appActivity", ".ui.ConversationListActivity");
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
	public void message() 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(MobileBy.AndroidUIAutomator("description(\"Create New Message\")")).click();
		String contactField= "com.google.android.apps.messaging:id/recipient_text_view";
		driver.findElement(MobileBy.AndroidUIAutomator(contactField)).sendKeys("8310004216");

		String selectContact= "com.google.android.apps.messaging:id/contact_picker_create_group";
		driver.findElement(MobileBy.AndroidUIAutomator(selectContact)).click();

		String messageField= "com.google.android.apps.messaging:id/compose_message_text";
		driver.findElement(MobileBy.AndroidUIAutomator(messageField)).sendKeys("Hello from Appium");

		driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text_view")));

		String messageLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/message_text_view\")";
		String sentMessage = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
		Assert.assertEquals(sentMessage, "Hello from Appium");
	}
	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}
}