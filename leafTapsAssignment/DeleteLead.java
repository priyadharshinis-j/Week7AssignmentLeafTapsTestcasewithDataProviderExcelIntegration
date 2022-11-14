package leafTapsAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*http://leaftaps.com/opentaps/control/main
Delete Lead:
1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Click on Phone
9	Enter phone number
10	Click find leads button
11	Capture lead ID of First Resulting lead
12	Click First Resulting lead
13	Click Delete
14	Click Find leads
15	Enter captured lead ID
16	Click find leads button
17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
18	Close the browser (Do not log out)
*/

public class DeleteLead extends BaseClass
{
	@Test(dataProvider="importData")
	public void deleteLead(String company_Name,String first_Name, String last_Name, String country_Code, String area_Code, String primary_Code,String countryCode_1, String area_Code1, String primary_Code1) throws InterruptedException
	{
		
		
		//Create Leads with phone number
		
		WebElement createLead = driver.findElement(By.linkText("Create Lead"));
		createLead.click();
		
		WebElement companyName = driver.findElement(By.id("createLeadForm_companyName"));
		companyName.sendKeys(company_Name);
		
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.sendKeys(first_Name);
		
		WebElement lastName = driver.findElement(By.id("createLeadForm_lastName"));
		lastName.sendKeys(last_Name);
		
		
		WebElement countryCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		countryCode.clear();
		countryCode.sendKeys(country_Code);
		
		WebElement areaCode = driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode"));
		areaCode.sendKeys(area_Code);
		
		WebElement phoneNumber = driver.findElement(By.id("createLeadForm_primaryPhoneNumber"));
		phoneNumber.sendKeys(primary_Code);
		
		WebElement clickCreateLeads = driver.findElement(By.name("submitButton"));
		clickCreateLeads.click();
		
		//7.Click Find leads
		WebElement clickFindLeads = driver.findElement(By.linkText("Find Leads"));
		clickFindLeads.click();
		
		//8.Click on Phone
		WebElement clickPhone = driver.findElement(By.xpath("//span[text()='Phone']"));
		clickPhone.click();
		
		//9.Enter phone number
		//Enter country code
		WebElement countryCode_ = driver.findElement(By.xpath("(//input[contains(@name,'Country')])[4]"));
		countryCode_.clear();
		countryCode_.sendKeys(countryCode_1);
		
		//Enter Area code
		WebElement areaCode_ = driver.findElement(By.xpath("(//input[contains(@name,'Area')])[4]"));
		areaCode_.sendKeys(area_Code1);
		
		//Enter phone number
		WebElement phoneNumber_ = driver.findElement(By.xpath("(//input[contains(@name,'Number')])[4]"));
		phoneNumber_.sendKeys(primary_Code1);
		
		//10.Click find leads button
		WebElement clickFindLeadsButton = driver.findElement(By.xpath("//button[text()='Find Leads']"));
		clickFindLeadsButton.click();
		Thread.sleep(4000);
		
		//11.Capture lead ID of First Resulting lead
		WebElement firstResultingLead = driver.findElement(By.xpath("(//div[contains(@class,'cell-inner')]/child::a[@class='linktext'])[1]"));
		String resultingLead = firstResultingLead.getText();
		System.out.println("Lead ID of First Resulting Lead "+resultingLead);
		
		//12.Click First Resulting lead
		WebElement clickFirstResultingLead = driver.findElement(By.xpath("(//div[contains(@class,'cell-inner')]/child::a[@class='linktext'])[1]"));
		clickFirstResultingLead.click();
		Thread.sleep(2000);
		
		//13.Click Delete
		WebElement clickDeleteButton = driver.findElement(By.xpath("//a[text()='Delete']"));
		clickDeleteButton.click();
		Thread.sleep(2000);
		
		//14.Click Find leads
		WebElement click_FindLeads = driver.findElement(By.linkText("Find Leads"));
		click_FindLeads.click();
		Thread.sleep(2000);

		//15.Enter captured lead ID
		WebElement enterCaptureLeadID = driver.findElement(By.xpath("//input[@name='id']"));
		enterCaptureLeadID.sendKeys(resultingLead);
		Thread.sleep(2000);

		//16.Click find leads button
		WebElement click_FindLeadsButton = driver.findElement(By.xpath("//button[text()='Find Leads']"));
		click_FindLeadsButton.click();
		Thread.sleep(2000);

		//17.Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement verifyMessage = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String recordsDisplay = verifyMessage.getText();
		System.out.println("Successful Deletion "+recordsDisplay);
		

		
	}
	@BeforeTest
	public void importData()
	{
		fileName="TestData";
		sheetName="DeleteLead";
	
		
	}
	
	
}