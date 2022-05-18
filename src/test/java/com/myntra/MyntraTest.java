package com.myntra;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MyntraTest extends BrowserInit{
	
	@Test
	public void myntratest() throws InterruptedException
	{
		WebElement men_tab = driver.findElement(By.xpath("//a[text()=\"Men\"]"));
	
		Actions act = new Actions(driver);
		act.moveToElement(men_tab).build().perform();
		
		Thread.sleep(2000);
		
		WebElement phonecase_btn =driver.findElement(By.xpath("//a[text()=\"Phone Cases\"]"));
		phonecase_btn.click();
		
		
		WebElement selectproduct =driver.findElement(By.xpath("//ul[@class=\"results-base\"]/li[11]/a/div[2]/div/span"));
		String price = selectproduct.getText().replaceAll("[^0-9]", "");
		int priceis=Integer.parseInt(price);  
		
		System.out.println("Product Price is  :" +priceis);
		if(priceis >10)
		{
			System.out.println("Product is Right");
			assertTrue(true);
			
			selectproduct.click();
			
			Thread.sleep(2000);
			window_Handle_util();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()=\"ADD TO BAG\"]")).click();
			
		}
		else
		{
			assertTrue(false);
		}
		
		
	}
	
	
	public void window_Handle_util()
	{
		String parentID  =driver.getWindowHandle();
	    Set<String> allid =driver.getWindowHandles();
	    String childid= "";
	    for(String id : allid)
	    {
	    	if(!id.equals(parentID))
	    	{
	    		childid = id;
	    	}
	    }
	    
	    driver.switchTo().window(childid);
	}

}
