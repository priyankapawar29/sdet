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

public class session2AppiumActivity3 
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
		dsc.setCapability("appPackage", "com.android.contacts");
		dsc.setCapability("appActivity", ".activities.PeopleActivity");
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
	public void contacts() 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Creates new contact
		driver.findElementByAccessibilityId("Create new contact").click();
		driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aaditya");
		driver.findElementByXPath("//android.widget.EditText[@text='Last name']").sendKeys("Varma");
		driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("999148292");
		driver.findElementById("editor_menu_save_button").click();
		
		//Verification of saved contact
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));	
		MobileElement savedContact= driver.findElementById("toolbar_parent");
        Assert.assertTrue(savedContact.isDisplayed());
        
        String contactName = driver.findElementById("large_title").getText();
        System.out.println("Saved contact name is: "+contactName);
        Assert.assertEquals(contactName, "Aaditya Varma");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}