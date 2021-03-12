package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRM_Activities_StepDefinition 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Open the browser$")
	public void openBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C://geckodriver latest/geckodriver-v0.29.0-win64/geckodriver.exe"); 
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);		
	}
	
	@When("^Login OrangeHRM page$")
	public void loginHRM()
	{
		driver.get("http://alchemy.hguy.co/orangehrm");
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("orange");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
	}
	@Then("^Navigate to Recruitment page$")
	public void navigateToRecruitmentPage()
	{
		driver.findElement(By.xpath("//*[@id='menu_recruitment_viewRecruitmentModule']")).click();
		driver.findElement(By.xpath("//*[@id='menu_recruitment_viewRecruitmentModule']")).click();
	}
	
	@And("^Click on Vacancies and navigate to vacancies page$")
	public void navigateToVacanciesPage() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='menu_recruitment_viewJobVacancy']")).click();
		Thread.sleep(10000);
	}
	
	@And("^Click on Add button and navigate to Add Job Vacancy form$")
	public void navigateToAddJobVacancyForm()
	{
		driver.findElement(By.xpath("//*[@id='btnAdd']")).click();		
	}
	@And("^Fill necessary details and save$")
	public void fillVacancyFormAndSave()
	{
		driver.findElement(By.xpath("//*[@id='addJobVacancy_jobTitle']")).click();
		driver.findElement(By.xpath("//option[contains (text(),'DevOps Engineer')]")).click();
		driver.findElement(By.xpath("//*[@id='addJobVacancy_name']")).sendKeys("SDET HRM PROJECT TESTER");
		driver.findElement(By.xpath("//*[@id='addJobVacancy_hiringManager']")).sendKeys("orange hrm");
		driver.findElement(By.xpath("//*[@class='savebutton']")).click();
	}
	
	@And("^Verify vacancy has been created$")
	public void verifyVacancyCreated()
	{
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		driver.findElement(By.xpath("//*[@id='vacancySearch_jobTitle']")).click();
		driver.findElement(By.xpath("(//option[contains (text(),'DevOps Engineer')])[1]")).click();
		driver.findElement(By.xpath("//*[@id='vacancySearch_jobVacancy']")).click();
		driver.findElement(By.xpath("//option[contains (text(),'SDET HRM PROJECT TESTER')]")).click();
		driver.findElement(By.xpath("//*[@id='vacancySearch_hiringManager']")).click();
		driver.findElement(By.xpath("//option[contains (text(),'orange hrm')]")).click();
		driver.findElement(By.xpath("//*[@id='btnSrch']")).click();
		Boolean vacancyadded= driver.findElement(By.xpath("(//*[@id='resultTable']//tr)[2]")).isDisplayed();
		Assert.assertTrue(vacancyadded);		
	}
	
	@And("^Click on candidate button and add button$")
	public void addCandidatepage()
	{
		driver.findElement(By.xpath("//*[@id='menu_recruitment_viewCandidates']")).click();
		driver.findElement(By.xpath("//*[@id='btnAdd']")).click();
	}
	
	@And("^Fill all the details, upload resume and save$")
	public void fillCandidateFormSave()
	{
		driver.findElement(By.xpath("//*[@id='addCandidate_firstName']")).sendKeys("Amrutha");
		driver.findElement(By.xpath("//*[@id='addCandidate_lastName']")).sendKeys("V");
		driver.findElement(By.xpath("//*[@id='addCandidate_email']")).sendKeys("amrutha345@gmail.com");
		driver.findElement(By.xpath("//*[@id='addCandidate_vacancy']")).click();
		driver.findElement(By.xpath("//option[contains (text(), 'SDET HRM PROJECT TESTER')]")).click();
	    driver.findElement(By.xpath("//*[@id='addCandidate_resume']")).sendKeys("C:\\Users\\AmruthavV\\Desktop\\Resume.docx");
	    driver.findElement(By.xpath("//*[@id='btnSave']")).click();		
	}
	
	@And("^Verify candidate has been added$")
	public void verifyCandidateAdded()
	{
		driver.findElement(By.xpath("//*[@id='menu_recruitment_viewCandidates']")).click();
		driver.findElement(By.xpath("//*[@id='menu_recruitment_viewRecruitmentModule']")).click();
		driver.findElement(By.xpath("//a[contains (text(), 'Amrutha  V')]")).isDisplayed();
	}
	
	@Then("^Navigate PIM page$")
	public void navigateToPIMpage() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@href='/orangehrm/symfony/web/index.php/pim/viewPimModule']")).click();
		driver.findElement(By.xpath("//a//b[contains (text(), 'PIM')]")).click();
	}
	
    @And("^Click add button to add employee$")
    public void addEmployeePage() throws InterruptedException
    {
    	Thread.sleep(10000);
    	driver.findElement(By.xpath("//*[@id='btnAdd']")).click();
    }
    
    @And("^Check Create Login Details checkbox$")
    public void checkInCreateLoginBox()
    {
    	driver.findElement(By.xpath("//*[@id='chkLogin']")).click();
    }
     
    @And("^Enter \"(.*)\" and \"(.*)\" and \"(.*)\" save$")
    public void fillEmployeeFormAndSave(String FirstName, String LastName, String UserName)
    {
    	driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(FirstName);
    	driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(LastName);
    	driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys(UserName);
    	driver.findElement(By.xpath("//*[@id='btnSave']")).click();
    }
    
    @And("^Verify employee have been added$")
    public void verifyEmployeeAdded() throws InterruptedException
    {
    	Thread.sleep(10000);
    	String EmployeeID= driver.findElement(By.xpath("//*[@id='personal_txtEmployeeId']")).getAttribute("value");
    	driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    	driver.findElement(By.xpath("//*[@id='empsearch_id']")).sendKeys(EmployeeID);
    	driver.findElement(By.xpath("//*[@id='searchBtn']")).click();
    	driver.findElement(By.xpath("(//*[@id='resultTable']//tr)[2]")).isDisplayed();
    	String addedEmployeeID= driver.findElement(By.xpath("(//*[@id='resultTable']//tr)[2]//td[2]//a")).getText();
    	Assert.assertEquals(addedEmployeeID, EmployeeID);
    }    
    
	@Then("^User select \"(.*)\" and \"(.*)\" and \"(.*)\" save$")
	public void CreatemultipleVacancies(String JobTitle, String VacancyName, String HiringManager) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='addJobVacancy_jobTitle']")).click();
		driver.findElement(By.xpath("//option[contains (text(),'"+JobTitle+"')]")).click();
		driver.findElement(By.xpath("//*[@id='addJobVacancy_name']")).sendKeys(VacancyName);
		driver.findElement(By.xpath("//*[@id='addJobVacancy_hiringManager']")).sendKeys(HiringManager);
		driver.findElement(By.xpath("//*[@class='savebutton']")).click();
	}
	
	@And("^Verify all the vacancies have been created$")
	public void verifyAllVacanciesCreated()
	{
		driver.findElement(By.xpath("//*[@value='Edit']")).isDisplayed();
	}
	
	@And("^Close FF browser$")
	public void closebrowser()
	{
		driver.close();
	}
}