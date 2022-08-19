package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Click and confirm title");
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		driver.navigate().back();
		System.out.println("Confirm if the button is disabled");
		boolean enabled = driver.findElement(By.xpath("//span[text()='Disabled']")).isEnabled();
		if (!enabled) {
			System.out.println("The button is disabled");
		} else {
			System.out.println("The button is enabled");
		}

		System.out.println("Find the position of the Submit button");
		Point location = driver.findElement(By.xpath("(//span[text()='Submit'])[1]")).getLocation();
		System.out.println(location);
		System.out.println("Find the Save button color");
		String cssValue = driver.findElement(By.xpath("//span[text()='Save']")).getCssValue("color");
		System.out.println(cssValue);
		System.out.println("Find the height and width of this button");
		Dimension size = driver.findElement(By.xpath("(//span[text()='Submit'])[2]")).getSize();
		System.out.println(size);
		System.out.println("Mouse over and confirm the color changed");
		WebElement success = driver.findElement(By.xpath("(//span[text()='Success'])[1]"));
		String color1 = success.getCssValue("background-color");
		Actions builder = new Actions(driver);
		builder.moveToElement(success).perform();
		String color2 = success.getCssValue("background-color");
		if (!color1.equals(color2)) {
			System.out.println("Color changed");
		} else {
			System.out.println("Color not changed");
		}

		System.out.println("Click Image Button and Click on any hidden button");
		driver.findElement(By.xpath("//span[text()='Image']")).click();
		driver.findElement(By.xpath("//div[@class='card ui-fluid']")).click();
		System.out.println("How many rounded buttons are there?");
		List<WebElement> roundButtons = driver.findElements(By.xpath("//button[contains(@class,'rounded-button')]"));
		int size2 = roundButtons.size();
		System.out.println(size2);

	}

}
//span[text()='Click']