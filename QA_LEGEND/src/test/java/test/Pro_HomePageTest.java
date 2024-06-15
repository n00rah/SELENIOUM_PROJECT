package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation_core.Base;

public class Pro_HomePageTest extends Base{
@Test

	public void verifyThisWeekTotalPurchaseNPurchaseDue()
	{
		Pro_LoginPageTest.verifyLoginWithValidCredentials();
		WebElement thisWeekTab=driver.findElement(By.xpath("//label[@class=\"btn btn-info active\"]"));
		thisWeekTab.click();
		WebElement totalPurchaseAmountField=driver.findElement(By.xpath("//span[@class=\"info-box-number total_purchase\"]"));
		String totalPurchaseAmount=totalPurchaseAmountField.getText();
		System.out.println("THIS WEEK TOTAL PURCHASE AMOUNT : "+totalPurchaseAmount);
		WebElement purchaseDueField=driver.findElement(By.xpath("//span[@class=\"info-box-number purchase_due\"]"));
		String purchaseDue=purchaseDueField.getText();
		System.out.println("THIS WEEK TOTAL PURCHASE DUE AMOUNT : "+purchaseDue);
	}
@Test
public void verifyDate()
{
	
}
}
