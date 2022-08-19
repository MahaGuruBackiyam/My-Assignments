package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();
		
		System.out.println("Take me to dashboard");
		WebElement elementCreate = driver.findElement(By.xpath("(//a[contains (text(),'Go to Dashboard')])[1]"));
		elementCreate.click();
		Thread.sleep(5000);
		driver.navigate().back();
		
		System.out.println("Find my destination");
		WebElement where = driver.findElement(By.xpath("//a[text()='Find the URL without clicking me.']"));
		System.out.println(where.getAttribute("href"));
		
		System.out.println("Am I broken link?");
		WebElement broken = driver.findElement(By.xpath("//a[text()='Broken?']"));
		broken.click();
		WebElement broken2 = driver.findElement(By.xpath("//a[text()='Powered by Jetty:// 9.4.36.v20210114']"));
		String originalUrl = broken2.getAttribute("href");

		if (!originalUrl.isEmpty()) {
			System.out.println("Broken");
		} else {
			System.out.println("Not Broken");
		}
		driver.navigate().back();
		
		System.out.println("Duplicate Link");
		driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[2]")).click();
		driver.navigate().back();
		
		System.out.println("Count Links");
		WebElement link = driver.findElement(By.xpath("//a[text()='How many links in this page?']"));
		link.click();
		/*
		 * String attribute = link.getAttribute("href"); driver.get(attribute);
		 */
		int number = driver.findElements(By.tagName("link")).size();
		System.out.println(number);
		driver.navigate().back();
		
		System.out.println("Count Layout Links");
		driver.findElement(By.xpath("//a[text()='How many links in this layout?']")).click();
		int links = driver.findElements(By.tagName("img")).size();
		System.out.println(links);
		driver.navigate().back();

	}
}

/*
 * if(driver.getTitle().
 * contains("HTTP ERROR 404 /lists.xhtml Not Found in ExternalContext as a Resource"
 * )) { System.out.println("Broken"); } else { System.out.println("Not Broken");
 * } } } /*String url1="/lists.xhtml"; String
 * originalUrl=broken.getAttribute("href");
 */
