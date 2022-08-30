package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LearnWindow {

	public static void main(String[] args) throws InterruptedException {
		/*.http://www.leafground.com/pages/Window.html
*/
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[text()='Browser']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Window']")).click();
		Thread.sleep(1000);
		
		System.out.println("Click and Confirm new Window Opens");	
		String titleOfFirstWindow=driver.getTitle();
		System.out.println("Title of first window: "+titleOfFirstWindow);
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Thread.sleep(1000);
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles1);
		//we have to switch the focus to new window in order to get the title of new window
		driver.switchTo().window(list1.get(1));
		String titleOfSecondWindow=driver.getTitle();
		
		System.out.println("Title of Second window: "+titleOfSecondWindow);
		if(!titleOfSecondWindow.equals(titleOfFirstWindow)) {
			System.out.println("I confirm that new Window Opens");
			System.out.println("Title of the new window is: " + titleOfSecondWindow);
		}
		else {
			System.out.println("No new Window");
		}
		driver.close();
		  
		System.out.println("Find the number of opened tabs");
		Thread.sleep(1000);
		driver.switchTo().window(list1.get(0));
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		//System.out.println(list);
		//size of list is 3, list.size()-1 so we can get the no. of new windows excluding the base window
		int numberOfOpenedWindows=list.size()-1;
		System.out.println("Number of tabes opened is: " +numberOfOpenedWindows);
		for (int i = 1; i < list.size(); i++) {
			String str = list.get(i);
			driver.switchTo().window(str).close();
		}
		driver.switchTo().window(list1.get(0));
		
		System.out.println("Close all windows except Primary");
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> list2 = new ArrayList<String>(windowHandles2);
		//System.out.println(list2);
		System.out.println("Number of tabes opened before closing is: " + list2.size());
		for (int i = 1; i < list2.size(); i++) {
			String s = list2.get(i);
			driver.switchTo().window(s).close();
		}
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> list3 = new ArrayList<String>(windowHandles3);
		System.out.println("All the tabs are closed. Presently opened tab is: "+list3.size());
		driver.switchTo().window(list1.get(0));
		System.out.println("Title of presently opened tab is: "+driver.getTitle());
		
		System.out.println("Wait for 2 new tabs to open");
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> windowHandles4 = driver.getWindowHandles();
		List<String> list4 = new ArrayList<String>(windowHandles4);
		for(int i=1;i<list4.size();i++) {
			driver.switchTo().window(list4.get(i));
			Thread.sleep(1000);
			   System.out.println("Title of opened tab: "+driver.getTitle());
		}
		driver.quit();
		
	}

}
