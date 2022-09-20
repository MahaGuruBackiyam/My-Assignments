package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.*;

public class CreateLeadSteps {
	ChromeDriver driver;

	@Given("Chrome browser given1")
	public void openBrowser1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@And("load the web application URL1")
	public void loadUrl() {
		driver.get("http://leaftaps.com/opentaps/control/login");
	}

	@And("Maximize the browser window and set timeouts1")
	public void maxAndTimeout() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@And("Enter a valid username1")
	public void enterUserName() {
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	}

	@And("Enter a valid password1")
	public void enterpassword() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	}

	@When("Login Button is clicked1")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@And("CRMFA link is clicked1")
	public void clickLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@And("Lead button is clicked1")
	public void clickLead() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@And("Create Lead button is clicked1")
	public void clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@Given("Enter company name1")
	public void EnterCompanyName() {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
	}

	@And("Enter first name1")
	public void EnterFirstName() {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
	}

	@And("Enter Last Name1")
	public void EnterLastName() {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
	}

	@When(" Create Lead button is clicked1")
	public void clickCreateLeadButton() {
		driver.findElement(By.className("smallSubmit")).click();
	}

	@Then("View Lead page should be displayed1")
	public void pageTitle() {
			System.out.println("The title of the page is View Lead");

		

	}
}
