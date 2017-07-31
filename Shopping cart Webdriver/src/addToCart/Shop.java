package addToCart; 


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;  
import org.openqa.selenium.TimeoutException;
import java.lang.ClassCastException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Shop { 
	//WebDriver driver = new ChromeDriver();   
	WebDriver driver = new FirefoxDriver();  
	//WebDriver driver = new EdgeDriver();
	WebElement dynamicElement;
	 
	
	
	@BeforeTest  
	public void beforeTesting() {
		
		/*String currentWindowHandle = this.driver.getWindowHandle();
		((JavascriptExecutor)this.driver).executeScript("alert('Shopping cart WebDriver')");
		this.driver.switchTo().alert().accept();*/
	
		WebDriver driver = new FirefoxDriver(); 
		 driver.manage().window().maximize();
		
	} 
	
	@Test 
	public void seleniumTsting() {
		
		driver.get("http://automationpractice.com/"); 
		
		// Login
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.className("login")).click();   
				
				
				 
				try {
					 Assert.assertTrue(driver.getTitle().contains("Login - My Store")); 					
				}
	            catch(AssertionError e){
	            	
	            	System.out.println("Assert Error");  
	            	
	            	
	            }
				driver.findElement(By.id("email")).sendKeys("yijiun1@stateside.com"); 
				driver.findElement(By.id("passwd")).sendKeys("12345678"); 
				driver.findElement(By.id("SubmitLogin")).click();     
				
				
				
		//Select dresses and evening dresses 
	
				
				Actions action = new Actions(driver);
				WebElement we = driver.findElement(By.cssSelector("ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows > li:nth-child(2)"));
				action.moveToElement(we).build().perform();
				 new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows > li:nth-child(2) > ul")));
				 action.moveToElement(driver.findElement(By.cssSelector("ul.sf-menu.clearfix.menu-content.sf-js-enabled.sf-arrows > li:nth-child(2) > ul > li:nth-child(2)"))).click().build().perform();

	// Add to cart
				 
					
				Actions action0 = new Actions(driver);
				//WebElement addCart = driver.findElement(By.cssSelector(".product-container"));
				WebElement addCart = driver.findElement(By.cssSelector("ul.product_list.grid.row > li")); 
				
				WebElement scroll = driver.findElement(By.cssSelector(".row"));
				scroll.sendKeys(Keys.PAGE_DOWN); 
				driver.manage().window().setPosition(new Point(0, 0));
				 driver.manage().window().setSize(new Dimension(1180,632)); 
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				action0.moveToElement(addCart).build().perform(); 
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Add to cart']")));
				action0.moveToElement(driver.findElement(By.cssSelector("a[title='Add to cart']"))).click().build().perform();

		
	
   // Proceed to checkout 
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Proceed to checkout']")));
			WebElement proceed = driver.findElement(By.cssSelector("a[title='Proceed to checkout']"));	 
			proceed.click();

  // Summary checkout 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement scroll1 = driver.findElement(By.cssSelector(".address.last_item.alternate_item.box"));
			scroll1.sendKeys(Keys.PAGE_DOWN);
			Actions action1 = new Actions(driver);
			WebElement checkout1 = driver.findElement(By.cssSelector("a[href='http://automationpractice.com/index.php?controller=order&step=1']"));  
			action1.moveToElement(checkout1).build().perform(); 
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='http://automationpractice.com/index.php?controller=order&step=1']")));
			action1.moveToElement(driver.findElement(By.cssSelector("a[href='http://automationpractice.com/index.php?controller=order&step=1']"))).click().build().perform();

 //	Address checkout  
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement scroll2 = driver.findElement(By.id("ordermsg"));
			scroll2.sendKeys(Keys.PAGE_DOWN);
			Actions action2 = new Actions(driver);
			WebElement checkout2 = driver.findElement(By.cssSelector("[name='processAddress']"));  
			action1.moveToElement(checkout2).build().perform(); 
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='processAddress']")));
			action2.moveToElement(driver.findElement(By.cssSelector("[name='processAddress']"))).click().build().perform();  
			

// Checkbox I agree
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement scroll3 = driver.findElement(By.cssSelector(".resume.table.table-bordered"));
			scroll3.sendKeys(Keys.PAGE_DOWN);
			driver.findElement(By.id("cgv")).click();
			
 // Shipping checkout 
			
			Actions action3 = new Actions(driver);
			WebElement checkout3 = driver.findElement(By.cssSelector("[name='processCarrier']"));  
			action1.moveToElement(checkout3).build().perform(); 
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='processCarrier']")));
			action3.moveToElement(driver.findElement(By.cssSelector("[name='processCarrier']"))).click().build().perform();  
			
	// Payment checkout
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement scroll4 = driver.findElement(By.cssSelector(".total_price_container.text-right"));
			scroll4.sendKeys(Keys.PAGE_DOWN);
			Actions action4 = new Actions(driver);
			/*WebElement checkout4 = driver.findElement(By.cssSelector(".bankwire"));  
			action1.moveToElement(checkout4).build().perform();*/ 
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bankwire")));
			action4.moveToElement(driver.findElement(By.cssSelector(".bankwire"))).click().build().perform();  
			
	// I confirm my order 
			
			 driver.findElement(By.xpath("//span[contains(text(), 'I confirm my order')]")).click();
			 
	 //Logout
		 		driver.findElement(By.className("logout")).click(); 		   
				 
	}  
	
	
	
	@AfterTest 
	public void afterTesting() {
		
		
	}

}
