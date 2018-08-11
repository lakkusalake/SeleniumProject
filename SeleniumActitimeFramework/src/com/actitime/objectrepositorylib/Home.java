package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	
	@FindBy(xpath="//div[text()='Tasks']/..")
	private WebElement taskImg;
	
	@FindBy(xpath="//div[text()='Users']/..")
	private WebElement userImg;
	
	public void navigateToTaskPage(){
		taskImg.click();
	}
	public void navigateToUSerPage(){
		userImg.click();
	}
}






