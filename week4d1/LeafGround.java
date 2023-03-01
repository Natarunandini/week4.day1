package week4d1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGround {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		System.out.println("click and confirm the window is opened");
		Set<String>windowHandles=driver.getWindowHandles();
		List<String>window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		System.out.println("Title is:"+driver.getTitle());
		if(window.size()>0)
		{System.out.println("New window opened");
		System.out.println("Title is:"+driver.getTitle());
		}
		else
		{
			System.out.println("New window not opened");
		}
		driver.close();
		driver.switchTo().window(window.get(0));
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String>window1=new ArrayList<String>(windowHandles2);
		System.out.print("Count of windows : ");
		System.out.println(window1.size()+" windows are opened");
		driver.switchTo().window(window.get(0));
		System.out.println("Closing all windows except primary");
		
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		driver.switchTo().window(window.get(0));
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]")).click();
		Thread.sleep(1000);
		driver.quit();
		
		
	}

		
		
		
		
		
		
		
		
		

	}


