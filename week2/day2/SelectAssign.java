package week2.day2;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectAssign {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		
		System.out.println("Which is your favorite UI Automation tool?");
		WebElement elementFavTool = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select dd = new Select(elementFavTool);
		dd.selectByVisibleText("Selenium");
		
		System.out.println("Choose your preferred country.");
		WebElement elementCountry = driver
				.findElement(By.xpath("(//label[@class='ui-selectonemenu-label ui-inputfield ui-corner-all'])[1]"));
		elementCountry.click();
		Thread.sleep(2000);
		WebElement elementCountry1 = driver.findElement(By.xpath("//li[text()='India']"));
		elementCountry1.click();
		
		System.out.println("Confirm Cities belongs to Country is loaded");
		Thread.sleep(2000);
		WebElement elementCity = driver.findElement(By.xpath("//label[text()='Select City']"));
		elementCity.click();
		List<WebElement> elementCity1 = driver.findElements(By.xpath(
				"(//ul[@class='ui-selectonemenu-items ui-selectonemenu-list ui-widget-content ui-widget ui-corner-all ui-helper-reset'])[2]/li[@class='ui-selectonemenu-item ui-selectonemenu-list-item ui-corner-all']"));
		ArrayList<String> elementExpectedCity = new ArrayList<String>();
		elementExpectedCity.add("Bengaluru");
		elementExpectedCity.add("Chennai");
		elementExpectedCity.add("Delhi");

		for (int i = 0; i < elementCity1.size(); i++) {
			if (elementCity1.get(i).getText().equals(elementExpectedCity.get(i))) {
				System.out.println("I confirm " + elementCity1.get(i).getText() + " is present");
			} else {
				System.out.println("I confirm " + elementCity1.get(i).getText() + " is not present");
			}
		}
		
		System.out.println("Choose the Course");
		Thread.sleep(2000);
		WebElement elementCourse1 = driver.findElement(By.xpath("//input[@placeholder='Choose Course']"));
		elementCourse1.sendKeys("Selenium WebDriver");
		elementCourse1.sendKeys(Keys.ARROW_DOWN);
		elementCourse1.sendKeys(Keys.ARROW_DOWN);
		elementCourse1.sendKeys(Keys.ARROW_DOWN);
		elementCourse1.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		elementCourse1.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		WebElement elementLanguage1 = driver.findElement(By.xpath("//label[text()='Select Language']"));
		elementLanguage1.click();
		String language = "Tamil";
		Thread.sleep(2000);
		WebElement elementLanguage2 = driver.findElement(By.xpath(
				"//li[@class='ui-selectonemenu-item ui-selectonemenu-list-item ui-corner-all' and contains(text(),'"
						+ language + "')]"));
		elementLanguage2.click();
		Thread.sleep(5000);
		
		System.out.println("Select 'Two' irrespective of the language chosen");
		driver.findElement(By.xpath("//label[text()='Select Values']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[text()='இரண்டு']")).click();

		/*
		 * //label[text()='Select Values']//li[text()='இரண்டு'] //h5[text()='Choose the
		 * Course'] //li[text()='Selenium WebDriver'] List<String> supplierNames = new
		 * List<String>();//span[@class='ui-button-text']//li[text()='Selenium
		 * WebDriver']
		 * supplierNames.add("sup1");//ul[@class='ui-autocomplete-multiple-container
		 * ui-autocomplete-dd-multiple-container ui-widget ui-inputfield
		 * ui-state-default ui-corner-left'] supplierNames.add("sup2");
		 * supplierNames.add("sup3"); li[text()='India'] new
		 * ArrayList<String>("Bengaluru","Chennai","Delhi");List<String> supplierNames =
		 * Arrays.asList("sup1", "sup2", "sup3"); Select dd1=new Select(elementFavTool);
		 * dd1.selectByVisibleText("elementCountry");
		 * dd1.selectByVisibleText("Selenium");
		 */

	}

}
