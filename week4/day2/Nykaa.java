package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
	
		/*Assignment 4:*Nykaa*

         1) Go to https://www.nykaa.com/
         2) Mouseover on Brands and Search L'Oreal Paris
         3) Click L'Oreal Paris
         4) Check the title contains L'Oreal Paris(Hint-GetTitle)
         5) Click sort By and select customer top rated
         6) Click Category and click Hair->Click haircare->Shampoo
         7) Click->Concern->Color Protection
         8)check whether the Filter is applied with Shampoo
         9) Click on L'Oreal Paris Colour Protect Shampoo
        10) GO to the new window and select size as 175ml
        11) Print the MRP of the product
        12) Click on ADD to BAG
        13) Go to Shopping Bag 
        14) Print the Grand Total amount
        15) Click Proceed
        16) Click on Continue as Guest
        17) Check if this grand total is the same in step 14
        18) Close all windows
*/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//2) Mouseover on Brands and Search L'Oreal Paris
		Actions act=new Actions(driver);
		WebElement brands=driver.findElement(By.xpath("//a[text()='brands']"));
		act.moveToElement(brands).perform();
		Thread.sleep(1000);
		
		//Searching L'Oreal Paris
		driver.findElement(By.id("brandSearchBox")).sendKeys("Loreal");
		Thread.sleep(1000);
		WebElement LorealP= driver.findElement(By.xpath("//span[text()='2839']"));
		LorealP.click();
		
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		System.out.println("Title of the page is: "+driver.getTitle());
		
		//5) Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		//6) Click Category and click Hair->Click haircare->Shampoo
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();	
		Thread.sleep(2000);
		WebElement hair = driver.findElement(By.xpath("//span[text()='Hair']"));
		act.moveToElement(hair).click().perform();
		Thread.sleep(2000);
		WebElement hairCare = driver.findElement(By.xpath("//span[text()='Hair Care']"));
		act.moveToElement(hairCare).click().perform();
		Thread.sleep(1000);
		WebElement shampoo =driver.findElement(By.xpath("//span[text()='Shampoo']"));
		act.moveToElement(shampoo).click().perform();
		
		//7) Click->Concern->Color Protection
		Thread.sleep(2000);
		WebElement hair1 = driver.findElement(By.xpath("//span[text()='Hair']"));
		act.moveToElement(hair1).click().perform();
		Thread.sleep(2000);
		WebElement concern =driver.findElement(By.xpath("//span[text()='Shop By Concern']"));
		act.moveToElement(concern).click().perform();
		Thread.sleep(2000);
		WebElement colorProtection =driver.findElement(By.xpath("//span[text()='Color Protection']"));
		act.moveToElement(colorProtection).click().perform();
		
		//8)check whether the Filter is applied with Shampoo
		//we can also use this|
		//System.out.println("Selected items are: "+driver.findElement(By.xpath("//span[@class='filter-value']")).getText());
		WebElement inFilter =driver.findElement(By.xpath("//span[@class='filter-value']"));
		if(inFilter.getText().equals("Shampoo")){
			System.out.println("The Filter is applied with Shampoo");
		}
		
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		Thread.sleep(1000);
		WebElement lp = driver.findElement(By.xpath("(//div[@class='css-wkluxr']/following::a)[5]"));
		act.moveToElement(lp).click().perform();
		Thread.sleep(1000);
		
		//10) GO to the new window and select size as 175ml
	    Set<String> windowHandles = driver.getWindowHandles();
		List<String>list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//select[@title='SIZE']")).click();	
		driver.findElement(By.xpath("(//select[@title='SIZE']/option)[2]")).click();
		
		//11) Print the MRP of the product
		System.out.println("MRP of the product is: "+driver.findElement(By.xpath("(//span[text()='₹189'])[1]")).getText());
		
		//12) Click on ADD to BAG
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();	
		
		//13) Go to Shopping Bag 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();	
		
		//14) Print the Grand Total amount
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='/mobileCartIframe?ptype=customIframeCart']"));
		driver.switchTo().frame(frame1);
		WebElement grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']"));
		String gt1=grandTotal.getText();
	    System.out.println("Grand total amount is: "+gt1);
		
	    //15) Click Proceed
	    driver.findElement(By.xpath("//span[text()='Proceed']")).click();
	    
	    //16) Click on Continue as Guest
	    driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
	    
	    //17) Check if this grand total is the same in step 14
	    WebElement grandTotal2 = driver.findElement(By.xpath("(//div[@class='value'])[2]"));
	    String gt2=grandTotal2.getText();
		if(gt2.equalsIgnoreCase(gt1)) {
			System.out.println("Grand total is the same");
		}
	    //18) Close all windows
		driver.quit();
	    
	    
	}
	
}
