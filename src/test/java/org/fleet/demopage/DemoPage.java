package org.fleet.demopage;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.*;

public class DemoPage {
public static WebDriver driver;
	
	@BeforeSuite
	public void beforesuite()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\503829\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@BeforeTest
	public void beforeTest()
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}
	@Test
	public void emailAddress()
	{
		WebElement email=driver.findElement(By.id("input-email"));
		email.sendKeys("saranya.sri2510@gmail.com");
	}
	@Test
	public void password()
	{
		WebElement password=driver.findElement(By.id("input-password"));
		password.sendKeys("sara@12345");
	}
	@Test
	public void loginButton()
	{
		WebElement clickButton=driver.findElement(By.xpath("//input[@type='submit']"));
		clickButton.click();
	}
	@Test
	public void validation()
	{
		
		String title=driver.getTitle();
		System.out.println("Title: "+title);
		Assert.assertEquals("AccountLogin", title);
	}
	@AfterTest
	public void screenShotCall() throws IOException
	{
		Date d = new Date();
		String FileName = d.toString().replace(":", "").replace(" ", "") + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f=ts.getScreenshotAs(OutputType.FILE);
		File path= new File("C:\\Users\\503829\\Desktop\\New folder\\Screenshot\\"+FileName);
		FileHandler.copy(f, path);
	}
	@AfterSuite
	public void close()
	{
		driver.close();
	}

}
