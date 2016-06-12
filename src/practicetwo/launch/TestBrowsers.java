package practicetwo.launch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestBrowsers {
	
	private WebDriver driver;
	
	
	@BeforeClass
	public void beforeClass(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
	}

	@Test
	public void start(){
		
		
		driver.get("https://www.baidu.com/");
		driver.findElement(By.xpath("//input[@id='kw']")).clear();
		driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("FireflyAutomation");
		
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Firefly");
		driver.findElement(By.xpath("//input[@id='su']")).submit();
		
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
	
	
}
