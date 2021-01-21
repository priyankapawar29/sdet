package test;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class jobBoardTest {
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	 @Test (groups = "jobboard")
	 public void verifyWebsiteTitleAcitivityOne() {
	 driver.get("https://alchemy.hguy.co/jobs/");
	 assertTrue(driver.getTitle().equals("Alchemy Jobs – Job Board Application"));
	 }
	

	 @Test (groups = "jobboard")
	 public void verifyWebsiteHeadingAcitivityTwo() {
	 driver.get("https://alchemy.hguy.co/jobs/");
	 assertTrue((driver.findElement(By.xpath("//*[@class='entry-title']")).getText().equals("Welcome to Alchemy Jobs"))); 
	 }
	
	@Test (groups = "jobboard")
	public void getTheUrlOfHeaderImageActivityThree() {
		driver.get("https://alchemy.hguy.co/jobs/");
		System.out.println((driver.findElement(By.xpath("//header//img")).getAttribute("src")));
	}
	
	@Test (groups = "jobboard")
	public void verifyWebsiteSecondHeadingActivityfour() {
		driver.get("https://alchemy.hguy.co/jobs/");
		assertTrue((driver.findElement(By.xpath("//h2")).getText().equals("Quia quis non")));
	}
	
	@Test (groups = "jobboard")
	public void navigateToAnotherPageActivityFive() {
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.findElement(By.linkText("Jobs")).click();
		assertTrue((driver.findElement(By.xpath("//h1")).getText().equals("Jobs")));
	}
	
	@Test (groups = "jobboard")
	public void applyToJobActivitySix() {
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.findElement(By.linkText("Jobs")).click();
		assertTrue((driver.findElement(By.xpath("//h1")).getText().equals("Jobs")));
		driver.findElement(By.xpath("//*[@id=\"search_keywords\"]")).sendKeys("Test Specialist");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//h3")).click();
		driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@class='job_application_email']")).getText());
	}
	
	@Test (groups = "jobboard")
	public void createNewJobListingActivitySeven() {
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.findElement(By.linkText("Post a Job")).click();
		assertTrue((driver.findElement(By.xpath("//h1")).getText().equals("Post a Job")));
		driver.findElement(By.xpath("//input[@name='create_account_email']")).sendKeys("testxystest1@gmail.com");
		driver.findElement(By.id("job_title")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@name='job_location']")).sendKeys("India");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("Job Description");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='application']")).sendKeys("https://www.abc.com");
		driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("Company name");
		driver.findElement(By.xpath("//input[@value='Preview']")).click();
		driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
		driver.findElement(By.linkText("click here")).click();
	}
	
	
	@Test (groups = "jobboard")
	public void loginToWebsiteBackendActivityEight() {
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		assertTrue(driver.findElement(By.xpath("(//h1)[1]")).getText().equals("Dashboard"));
	}
	
	
	@Test (groups = "jobboard")
	public void createJobListingUsingBackendActivityNine() {
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		assertTrue(driver.findElement(By.xpath("(//h1)[1]")).getText().equals("Dashboard"));
		driver.findElement(By.xpath("//div[contains(text(),'Job Listings')]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Add New')])[7]")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/div/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"post-title-0\"]")).sendKeys("Tester");
		driver.findElement(By.xpath("//input[@name='_application']")).sendKeys("testxystest4@gmail.com");
		driver.findElement(By.xpath("//input[@id='_company_website']")).sendKeys("https://www.abc.com");
		driver.findElement(By.xpath("//input[@id='_company_name']")).sendKeys("Company name");
		driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")).click();
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
