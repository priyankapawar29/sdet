package AppiumActivities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class session1Activity2 
{
	@Test
	public void calculator()
	{
		DesiredCapabilities dsc = new DesiredCapabilities();
		dsc.setCapability("deviceId", "emulator-5554");
		dsc.setCapability("deviceName", "Pixel4Emulator");
		dsc.setCapability("platformName", "android");
		dsc.setCapability("appPackage", "com.android.calculator2");
		dsc.setCapability("appActivity", "com.android.calculator2.Calculator");

		AppiumDriver<MobileElement> driver = null;
		try 
		{
			driver = new AndroidDriver <MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"), dsc);
			System.out.println("Opened Calculator");
		} 
		catch (MalformedURLException e) 
		{
			System.out.println(e.getMessage());
		}
	}	
}