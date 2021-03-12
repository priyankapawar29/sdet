package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRM_activities_StepDefinition 
{
	WebDriver driver;
	WebDriverWait wait; 
	int NumberofDashlets= 0;

	@Given("^Open firefox browser$")
	public void openFFBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe"); 
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);		
	}

	@When("^User opens CRM portal$")
	public void openCRMPortal()
	{
		driver.get("https://alchemy.hguy.co/crm/");
	}

	@Then("^Login CRM portal$")
	public void loginCRMPortal()
	{
		driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='username_password']")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();		
	}
	
	@Given("^User count the number of dashlets$")
	public void countDashlets() throws InterruptedException
	{
		Thread.sleep(10000);
		NumberofDashlets = driver.findElements(By.xpath("(//*[@id='pageContainer']//table[@class='dashletTable'])//td[@class='dashlet-title']")).size();
		System.out.println("The number of dashlets in homepage: "+NumberofDashlets);
	}
	
    @When("^User print the number and title of each dashlet$")
    public void numberAndTitleOfDashlet()
    {
    	for (int i=1; i<=NumberofDashlets; i++)
    	{
    		String TitleOfDashlet= driver.findElement(By.xpath("((//table[@class='dashletTable'])//td[@class='dashlet-title']//h3[1]//span[2])["+i+"]")).getText();
        	System.out.println("The " +i+ " title is: "+TitleOfDashlet);
    	}   	
    }

    @Given("^User navigates to Sales, Leads and to create lead page$")
    public void navigatesToLeadPage() throws InterruptedException
    {
    	driver.findElement(By.xpath("(//a[contains (text(), 'Sales')])[1]")).click();
    	Thread.sleep(10000);
    	driver.findElement(By.xpath("//*[@href='?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DLeads%26action%3Dindex%26parentTab%3DSales']")).click();
    	Thread.sleep(10000);
    	driver.findElement(By.xpath("(//div[contains (text(), 'Create Lead')])[1]")).click();
    }
    
    @When("^User fills \"(.*)\" and \"(.*)\" to create lead account and save$")
    public void createLeadAccount(String FirstName, String LastName) throws InterruptedException
    {
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys(FirstName);
    	driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys(LastName);
    	driver.findElement(By.xpath("(//*[@id='SAVE'])[1]")).click();   	
    }
    
    @Then("^User navigates view lead page to verify lead account is created$")
    public void verifyLeadAccountCreated()
    {
    	driver.findElement(By.xpath("(//span[contains (text(), 'Amrutha V')])[3]")).isDisplayed();
    }
    
    @Given("^User navigates to activities, meetings and to schedule meeting page$")
    public void navigatesToSchuldemeetingpage() throws InterruptedException
    {
    	driver.findElement(By.xpath("//a[contains (text(), 'Activities')]")).click();
    	Thread.sleep(10000);
    	driver.findElement(By.xpath("//*[@href='?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DMeetings%26action%3Dindex%26parentTab%3DActivities']")).click();
    	Thread.sleep(10000);
    	driver.findElement(By.xpath("(//*[@href='?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DMeetings%26action%3DEditView%26return_module%3DMeetings%26return_action%3DDetailView'])[3]")).click();
    }
    
    @When("^User enters details of the meeting$")
    public void detailsOfMeeting() throws InterruptedException
    {
    	Thread.sleep(10000);
    	driver.findElement(By.id("name")).sendKeys("SDET BDD CLASS");
    	driver.findElement(By.xpath("//*[@id='date_start_hours']")).sendKeys("10");
    	driver.findElement(By.xpath("//*[@id='date_start_minutes']")).sendKeys("00");
    	driver.findElement(By.xpath("//*[@id='date_end_hours']")).sendKeys("10");
    	driver.findElement(By.xpath("//*[@id='date_end_minutes']")).sendKeys("30");
    }
    
    @Then("^User search for user \"(.*)\" and \"(.*)\" add them to meeting and save$")
    public void addMembersAndSave(String FirstName, String LastName) throws InterruptedException
    {
    	driver.findElement(By.xpath("//*[@id='search_first_name']")).sendKeys(FirstName);
    	driver.findElement(By.xpath("//*[@id='search_last_name']")).sendKeys(LastName);
    	driver.findElement(By.id("invitees_search")).click();
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	Thread.sleep(10000);
    	driver.findElement(By.xpath("(//*[@id='list_div_win']//table)//tr[2]//td[5]")).click();
    	driver.findElement(By.xpath("(//*[@id='SAVE_HEADER'])[2]")).click();
    }
    
    @And("^User navigates to meeting page to verify meeting invite is created$")
    public void verifyMeetingInviteCreated() throws InterruptedException
    {
    	Thread.sleep(10000);
    	driver.findElement(By.xpath("(//a//span[contains (text(), 'SDET BDD CLASS')])[3]")).isDisplayed();
    }
    
    @Given("^User navigates to products and create products page$")
    public void navigateToProductPage() throws InterruptedException
    {
    	driver.findElement(By.xpath("//a[contains (text(), 'All')]")).click();
    	Thread.sleep(10000);
    	driver.findElement(By.xpath("//*[@href='?action=ajaxui#ajaxUILoc=index.php%3Fmodule%3DAOS_Products%26action%3Dindex%26parentTab%3DAll']")).click();
    	Thread.sleep(10000);
    	driver.findElement(By.xpath("(//*[contains (text(), 'Create Product')])[3]")).click();
    	Thread.sleep(10000);
    }
       
    @When("^Enter details of the product \"(.*)\" and \"(.*)\" and save$") 
    public void productDetails(String ProductName, String Price)
    {
    	driver.findElement(By.id("name")).sendKeys(ProductName);
    	driver.findElement(By.id("price")).sendKeys(Price);
    	driver.findElement(By.xpath("(//*[@id='SAVE'])[1]")).click();
    }
    
    @Then("^User navigates to view products page to verify products listed$")
    public void verifyProductListed() throws InterruptedException
    {
    	Thread.sleep(10000);
    	driver.findElement(By.xpath("(//a//span[contains (text(), 'Laptop')])[3]")).isDisplayed();
    }
    
    @And("^Browser close$")
	public void closeBrowser()
	{
		driver.close();
	}
}