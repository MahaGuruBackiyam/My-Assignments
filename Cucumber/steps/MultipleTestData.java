package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleTestData{
	ChromeDriver driver;
	String leadID;
	WebDriverWait webDriverWait;
	Set<String> allWindows;
	List<String> allhandles;
	Set<String> allWindows2; 
	List<String> allhandles2; 
	
	@Given("Chrome browser given")	
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@And("load the web application URL")
	public void loadUrl() {
		driver.get("http://leaftaps.com/opentaps/control/login");
	}

	@And("Maximize the browser window and set timeouts")
	public void maxAndTimeout() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@And("Enter a valid username")
	public void enterUserName() {
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	}

	@And("Enter a valid password")
	public void enterpassword() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	}

	@When("Login Button is clicked")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@And("CRMFA link is clicked")
	public void clickLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@And("Lead button is clicked")
	public void clickLeadsButton() {
		driver.findElement(By.linkText("Leads")).click();
	}


//common for create lead, delete lead and duplicate lead		
		@When("Centre Find Leads button is clicked")
		public void clickCentreLeadsButton() {
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		}
		//create lead
	@When("Create Lead button is clicked")
	public void clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@Given("Enter company name as(.+)$")
	public void enterCompanyName(String Company_name) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Company_name);
		
	}
	@And("Enter First name as(.+)$")
	public void enterFirstName(String First_name ) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(First_name);
	
	}
	@And("Enter Last Name as(.+)$")
	public void enterLastName(String Last_name) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Last_name);
		
	}
	@When("Create Lead button2 is clicked")
	public void clickCentreCreatLead() {
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("View Lead page should be displayed")
	public void display() {
		System.out.println("View page is displayed");
	}
	
	//delete lead
	//common for delete lead, duplicate lead and edit lead
			@When ("Side Find Leads button is clicked")
			public void clickSideLeadsButton() {
				driver.findElement(By.linkText("Find Leads")).click();
			}
			@And("Phone is clicked")
			public void clickPhone() {
				driver.findElement(By.xpath("//span[text()='Phone']")).click();
			}
			@Given("Enter phone number")
			public void enterPhone() {
				driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8");
			}
		    @Then("Wait for sometime")
		    	public void sleep() throws InterruptedException {
		    		Thread.sleep(1000);
		    	}

		    @When("First resulting Lead ID is clicked")
		    public void click_first_resulting_lead_id(){
		   
		    	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		    	
		    	/* webdriver wait usage exp
		    	 webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(80));
		    	WebElement firstLead=driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		    	webDriverWait.until(ExpectedConditions.visibilityOf(firstLead)).click();
		    	 */
		    }
		    
	    //delete lead continues
		    @Then("Copy Lead ID of first resulting Lead")
		    public void clickFirstLeadID(){
		    	
		    	leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
		    	System.out.println(leadID);
		    }
		    @And("Delete is clicked")
		    public void clickDelete() {
		    	driver.findElement(By.linkText("Delete")).click();
		    }
		    @Given("Enter Lead ID")
		    public void enter_lead_id(){
		    	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		    	 
		    }
		    @But("Error message id displayed")
		    public void error_message(){
		    	String text = driver.findElement(By.className("x-paging-info")).getText();
				if (text.equals("No records to display")) {
					System.out.println("Text matched");
				} else {
					System.out.println("Text not matched");
				}
		    }
		    //Duplicate Lead
		    @And("Duplicate Lead is clicked")
		    public void clickDup() {
		    	driver.findElement(By.linkText("Duplicate Lead")).click();
		    }
	
	//edit lead
		   @And("Edit button is clicked")
		   public void clickEdit() {
			   driver.findElement(By.linkText("Edit")).click();
		   }
		   @Given("Enter new company name as(.+)$")
		   public void enterCm(String cm) {
			   driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cm);
		   }
		   @When("Update button is clicked")
		   public void clickButton() {
			   driver.findElement(By.name("submitButton")).click();
		   }
		   
    //merge lead
		   @When("Merge Leads button is clicked")
		    public void clickMerge_leads_button()  {
			   driver.findElement(By.linkText("Merge Leads")).click();
		    }

		    @And("Widget of From Contact is clicked")
		    public void clickWidget_of_from_contact()  {
		    	driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		    }
		    @Then("Focus is moved to Second window")
		    public void moveFocusTo_second_window() {
		    	//Set<String> allWindows = driver.getWindowHandles();
		    	allWindows = driver.getWindowHandles(); //global Set
				//List<String> allhandles = new ArrayList<String>(allWindows);
		    	allhandles = new ArrayList<String>(allWindows);//global list
				driver.switchTo().window(allhandles.get(1));
		       
		    }
		    @Given("Enter the first name as(.+)$")
		    public void enterFn(String fn) {
		    	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fn);
		    }
		    @Then("Focus is moved to first window")
		    public void moveFocusTo_first_window(){
		    	driver.switchTo().window(allhandles.get(0));
		    }
		    @And("Widget of to Contact is clicked")
		    public void clickWidget_of_to_contact() {
		    	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		    }

		    @Then("Focus is moved to Second window2")
		    public void moveFocustoSecondWindow2(){
		    	 allWindows2 = driver.getWindowHandles();//global declaration
				 allhandles2 = new ArrayList<String>(allWindows2);//global list
				driver.switchTo().window(allhandles2.get(1));
		    }
		    @Given("Enter the first name2 as(.+)$")
		    public void enterFn2(String fn2) {
		    	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fn2);
		    }
		    @Then("Focus is moved to first window2")
		    public void moveFocustoFirstWindow2(){
		    	driver.switchTo().window(allhandles2.get(0));
		    }
		    @When("Merge button is clicked")
		    public void merge() {
		    	driver.findElement(By.xpath("//a[text()='Merge']")).click();
		    }
		    @Then("Alert is accepted")
		    public void acceptAlert() {
		    	driver.switchTo().alert().accept();
		    }
		    @Then("Verify the title of the page")
		    public void verify() {
		    	String text2 = driver.findElement(By.className("x-paging-info")).getText();
				if (text2.equals("No records to display")) {
					System.out.println("Text matched");
				} else {
					System.out.println("Text not matched");
				}
		    }

		    

	
	
	
	
	
	
}
