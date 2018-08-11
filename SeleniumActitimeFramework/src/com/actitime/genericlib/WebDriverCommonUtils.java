package com.actitime.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonUtils {
	public void waitForPageLoad()
	{
		BaseClass.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void waitForElementPresent(WebElement wb)
	{
		WebDriverWait wait = new WebDriverWait(BaseClass.driver,20);
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	public void select(WebElement swb, String value)
	{
		Select sel = new Select(swb);
		sel.selectByVisibleText(value);
	}
	public void select(WebElement swb, int index)
	{
		Select sel = new Select(swb);
		sel.selectByIndex(index);
	}

}
