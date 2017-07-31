package YourLogo;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
	WebDriver driver = new ChromeDriver();
	WebElement dynamicElement;   


	
	

	@BeforeTest
	public void beforeTesting(){
		
		String currentWindowHandle = this.driver.getWindowHandle();
		((JavascriptExecutor)this.driver).executeScript("alert('Test')"); 
		this.driver.switchTo().alert().accept();

	}
	
	
	@Test
public void seleniumTesting(){
	driver.get("http://automationpractice.com/");
	driver.manage().window().maximize();
	String title = driver.getTitle();
	Assert.assertTrue(title.contains("My Store"));
	driver.findElement(By.className("login")).click();
	driver.findElement(By.id("email_create")).sendKeys("yijiun6@stateside.com");
	driver.findElement(By.id("SubmitCreate")).click();
	
	try{
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement error; 
		error= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_error")));
		System.out.println("There is an Error message");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//If account has already been created it will login 
	    driver.findElement(By.id("email")).sendKeys("yijiun6@stateside.com");
	    driver.findElement(By.id("passwd")).sendKeys("12345678");
	    driver.findElement(By.id("SubmitLogin")).click();
	    
	}catch(TimeoutException|NoSuchElementException e){
		
		System.out.println("Error is not present");
				//Enters the information
				String[] ids = {"customer_firstname","customer_lastname","passwd",
				"company","address1","address2","city","postcode","other","phone",
				"phone_mobile","alias"};
				String[] values = {"Yi","Liu","12345678","Stateside","Barrio Turnon",
				"San Jose","San Jose","10080","Here is some additional information",
				"2222222222","1234233123","Costa Rican Address"};
				for(int i=0;i<values.length;i++){
					driver.findElement(By.id(ids[i])).sendKeys(values[i]);
				}
				
                //Does the clicks
				String[] clickId = {"id_gender2","newsletter","optin"};
				for(int i=0;i<clickId.length;i++){
					driver.findElement(By.id(clickId[i])).click();
					if(i==0){
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					}
				}
				
				//Enters the date
				Select day = new Select(driver.findElement(By.id("days")));
				day.selectByIndex(28);
				Select month = new Select(driver.findElement(By.id("months")));
				month.selectByIndex(12);
				Select year = new Select(driver.findElement(By.id("years")));
				year.selectByIndex(15);


				Select state = new Select(driver.findElement(By.id("id_state")));
				state.selectByValue("1");
				
				//creates account
				driver.findElement(By.id("submitAccount")).click();

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				//Logout
				driver.findElement(By.className("logout")).click();
				}
  }
	
	
	
	@AfterTest
public void afterTesting(){
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.close();
	}
}
