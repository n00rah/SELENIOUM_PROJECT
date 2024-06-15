package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import pro_dataprovider.Pro_DataProvider;
import utilities.ExcelUtilityProject;

public class Pro_LoginPageTest extends Base
{
	@Test
	public void verifyLoginPageTitle()
	{
		String actualtitle=driver.getTitle();
		System.out.println("WEB PAGE TITLE : "+actualtitle);
		String expectedtitle=ExcelUtilityProject.getStringData(1,0,"LoginPage");
		Assert.assertEquals(actualtitle,expectedtitle,"LOGIN PAGE TITLE MISMATCH"); 

	}
@Test
	public static void verifyLoginWithValidCredentials()
	{
		WebElement userNameField=driver.findElement(By.xpath("//input[@id=\"username\"]"));
		userNameField.sendKeys(ExcelUtilityProject.getStringData(1,1,"LoginPage"));
		WebElement passwordField=driver.findElement(By.xpath("//input[@id=\"password\"]"));
		passwordField.sendKeys(ExcelUtilityProject.getStringData(1,2,"LoginPage"));
		WebElement loginButton=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		loginButton.click();
		
	}

@Test(dataProvider="InvalidUserCredentials",dataProviderClass=Pro_DataProvider.class)
public void verifyErrorMessageWithInvalidCredentials(String username,String password)
{
	WebElement userNameField=driver.findElement(By.xpath("//input[@id=\"username\"]"));
	userNameField.sendKeys(username);
	WebElement passwordField=driver.findElement(By.xpath("//input[@id=\"password\"]"));
	passwordField.sendKeys(password);
	WebElement loginButton=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	loginButton.click();
	WebElement errorText=driver.findElement(By.xpath("//strong[text()=\"These credentials do not match our records.\"]"));
	String actualErrorText=errorText.getText();
	String expectedErrorText=ExcelUtilityProject.getStringData(1,3,"LoginPage");
	Assert.assertEquals(actualErrorText,expectedErrorText,"LOGIN SUCCESSFULL WITH INAVLID CREDENTIALS");
}
}
