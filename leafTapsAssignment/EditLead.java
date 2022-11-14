package leafTapsAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends BaseClass {
	
	@Test(dataProvider="importData")

	public void editLead(String firstName, String companyName) throws InterruptedException {

		    
		
			
			
			//7.Click Find leads
			WebElement clickFindLeads = driver.findElement(By.linkText("Find Leads"));
			clickFindLeads.click();
			
			//8.Enter first name
			WebElement firstNameField = driver.findElement(By.xpath("(//div[@class='x-form-element']/child::input[@name='firstName'])[3]"));
			firstNameField.sendKeys(firstName);
			
			//9.Click Find leads button
			WebElement findLeadsButton = driver.findElement(By.xpath("//button[text()='Find Leads']"));
			findLeadsButton.click();
			Thread.sleep(3000);
			
			//10.Click on first resulting lead
			WebElement clickFirstResultingLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/child::a[@class='linktext'])[1]"));
			clickFirstResultingLead.click();
					
			//11.Verify title of the page
			String title = driver.getTitle();
			System.out.println("Title of the page is "+title);
			
			//12.Click Edit
			WebElement clickEdit = driver.findElement(By.xpath("//a[text()='Edit']"));
			clickEdit.click();
			
			//13.Change the company name
			WebElement updateCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
			updateCompanyName.clear();
			updateCompanyName.sendKeys(companyName);
			
			//14.Click Update
			WebElement clickUpdateButton = driver.findElement(By.xpath("//input[@type='submit']"));
			clickUpdateButton.click();
			
			//15.Confirm the changed name appears
			Thread.sleep(3000);
			WebElement confirmChanges = driver.findElement(By.id("viewLead_companyName_sp"));
			String updatedCompanyName = confirmChanges.getText();
			System.out.println("Updated Company Name "+updatedCompanyName);
			
			
	}
	
	@BeforeTest
	public void importData()
	{
		fileName="TestData";
		sheetName="EditLead";
	
		
	}
}	
