package org.test;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scipttask 
{
	public static void main(String[] args) throws AWTException, IOException, InterruptedException
	{		
		WebDriverManager.chromedriver().setup();		
	WebDriver driver= new ChromeDriver();
	driver.get("https://d3pv22lioo8876.cloudfront.net/tiptop/");
	driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 
	WebElement disable = driver.findElement(By.xpath("//input[@placeholder='Disabled input']"));
	boolean enabled = disable.isEnabled();
	System.out.println("is the button is enabled:" + enabled );
	
	WebElement readonly = driver.findElement(By.xpath("//input[@value='Readonly input']"));
	boolean equals = readonly.getAttribute("readonly").equals(readonly);
	System.out.println("Is field readonly: " + equals);
	WebElement readonly2 = driver.findElement(By.xpath("//label[@class='form-label w-100'][4]/input[1]"));
	//dropdown
	WebElement dropdown = driver.findElement(By.xpath("//select[@name='my-select']"));
	Select s=new Select(dropdown);
	List<WebElement> option = s.getOptions();
	int Size = option.size();
	if(Size == 8)
	{
		System.out.println("Dropdown have 8 colors");
	}
	else
	{
		System.out.println("dropdown not have 8 color");
	}
	
	WebElement dropdown1 = driver.findElement(By.xpath("//select[@class='form-select']"));
	Select s1=new Select(dropdown1);
	List<WebElement> option1 = s1.getOptions();
	System.out.println(option1.size());

	WebElement submitdis = driver.findElement(By.xpath("//button[@type='submit']"));
	Boolean val = submitdis.isEnabled();
	if(val == true)
	{
		System.out.println("Submit button is enabled");
	}
	else
	{
		System.out.println("submit button is disabled");
	}
	
	WebElement name = driver.findElement(By.xpath("//input[@id='my-name-id']"));
	name.sendKeys("thulas");
	WebElement password = driver.findElement(By.xpath("//input[@id='my-password-id']"));
	password.sendKeys("1223");
	Thread.sleep(1000);
	Boolean val2 = submitdis.isEnabled();
	if(val2 == true)
	{
		System.out.println("after enter the name and password, now Submit button is enabled");
	}
	else
	{
		System.out.println("submit button is disabled");
	}
	submitdis.click();
	
	String text = driver.findElement(By.xpath("//p[text()='Received!']")).getText();
	System.out.println(text);
	
	String currentUrl = driver.getCurrentUrl();
	URL url = new URL(currentUrl);
	String queryParameters = url.getQuery(); 
	System.out.println("Query parameters: " + queryParameters);
	
	}
	

}
