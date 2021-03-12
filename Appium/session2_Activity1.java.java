package AppiumActivities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class session2AppiumActivity2 
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
		dsc.setCapability("appPackage", "com.android.calculator2");
		dsc.setCapability("appActivity", ".Calculator");
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
	public void add() 
	{
		driver.findElementById("digit_5").click();
		driver.findElementById("op_add").click();
		driver.findElementById("digit_9").click();
		driver.findElementById("eq").click();
		
		//Add result validation
		String addResult= driver.findElementById("result").getText();
		System.out.println("The sum of 5 and 9 is: "+addResult);
		Assert.assertEquals(addResult, "14");		
	}
	@Test
	public void subtract()
	{
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("op_sub").click();
		driver.findElementById("digit_5").click();
		driver.findElementById("eq").click();
		
		//Subtract result validation
		String subResult= driver.findElementById("result").getText();
		System.out.println("10-5 is: "+subResult);
		Assert.assertEquals(subResult, "5");		
	}
	@Test
	public void multiply()
	{
		driver.findElementById("digit_5").click();
		driver.findElementById("op_mul").click();
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("eq").click();
		
		//Multiplication result validation
		String multiResult= driver.findElementById("result").getText();
		System.out.println("5 * 100 is: "+multiResult);
		Assert.assertEquals(multiResult, "500");		
	}
	@Test
	public void division()
	{
		driver.findElementById("digit_5").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("op_div").click();
		driver.findElementById("digit_2").click();
		driver.findElementById("eq").click();
		
		//Division result validation
		String divResult= driver.findElementById("result").getText();
		System.out.println("50 / 2 is: "+divResult);
		Assert.assertEquals(divResult, "25");		
	}
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
}