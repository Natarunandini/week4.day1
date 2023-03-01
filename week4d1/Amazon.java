package week4d1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		String text1 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]")).getText();
		System.out.println("Product Price: "+text1);
		
		String text2=driver.findElement(By.xpath("(//div/span/span[@class='a-size-base'])[1]")).getText();
		System.out.println("product ratings: " +text2);
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Thread.sleep(2000);
	
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle=new ArrayList<String>(windowHandles);	
		driver.switchTo().window(windowHandle.get(1));
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destn=new File("./snap/oneplus.png");
		FileUtils.copyFile(screenshotAs, destn);
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(2000);
		String text3 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The Cart Subtotal is : " +text3);
		if(text1.equals(text3)) {
			System.out.println("The Price of the Product and Cart Subtotal is same");
		}
		else {
			System.out.println("The Price of the Product and Cart Subtotal is different");
		}
		Thread.sleep(2000);
	}

		
		

	}


