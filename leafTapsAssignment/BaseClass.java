package leafTapsAssignment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver;
	public String fileName;
	public String sheetName;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition( String url, String username, String password) throws InterruptedException
	{
	        //1. Launch URL "http://leaftaps.com/opentaps/control/login"
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
		
			driver.get(url);
			driver.manage().window().maximize();
			
			//2.(a) Enter value to UserName field "username = "demosalesManager""
			WebElement userNameTextBox = driver.findElement(By.id("username"));
			userNameTextBox.sendKeys(username);
			//Thread.sleep(3000);
			
			//2. (b) Enter value to PassWord field "password = "crmsfa""
			WebElement passwordTextBox = driver.findElement(By.id("password"));
			passwordTextBox.sendKeys(password);
			//Thread.sleep(3000);
			
			//3. Click on loginButton
			WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
			loginButton.click();
			Thread.sleep(3000);
			
			//4. Click on CRM/SFA link
			WebElement linkText = driver.findElement(By.linkText("CRM/SFA"));
			linkText.click();
			//Thread.sleep(3000);
			
			//5. Click on leadsButton		
			WebElement leadsButton = driver.findElement(By.linkText("Leads"));
			leadsButton.click();
			//Thread.sleep(3000);
	}
	
	@DataProvider(name="importData")
	public String[][] setDataFile() throws IOException
	{
		return ImportData.excelData(fileName,sheetName);
	}
	@AfterMethod
	public void postConditon()
	{
		driver.close();
	}

}
