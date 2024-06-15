package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import utilities.ExcelUtilityProject;

public class Pro_ResetPageTest extends Base
{
@Test

    public void verifyResetPageTitle()
{
	WebElement forgotPassword=driver.findElement(By.xpath("//a[@class=\"btn btn-link\"]"));
	forgotPassword.click();
	String actualTitle=driver.getTitle();
	System.out.println("RESET PAGE TITLE : "+actualTitle);
	String expectedTitle=ExcelUtilityProject.getStringData(1,0,"ResetPage");
	Assert.assertEquals(actualTitle,expectedTitle,"RESET PAGE TITLE MISMATCH");
	
}
@Test
	public void verifyErrorMessageWithInvalidEmailId()
	{
	WebElement forgotPassword=driver.findElement(By.xpath("//a[@class=\"btn btn-link\"]"));
	forgotPassword.click();
	WebElement eMailIdField=driver.findElement(By.xpath("//input[@class=\"form-control\"]"));
	eMailIdField.sendKeys(ExcelUtilityProject.getStringData(1,1,"ResetPage"));
	WebElement resetLinkButton=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	resetLinkButton.click();
	WebElement invalidEmailText=driver.findElement(By.xpath("//strong[text()=\"The email must be a valid email address.\"]"));
	String actualErrorText=invalidEmailText.getText();
	String expectedErrorText=ExcelUtilityProject.getStringData(1,2,"ResetPage");
	Assert.assertEquals(actualErrorText,expectedErrorText,"PASSWORD RESET MESSAGE MISMATCH");
	}
	
}
