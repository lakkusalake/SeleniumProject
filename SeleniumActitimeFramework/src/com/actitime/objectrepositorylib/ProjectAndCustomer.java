package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectAndCustomer {
	@FindBy(xpath="//input[@value='Create New Customer']")
	private WebElement createCustomerBtn;
	
	@FindBy(xpath="//span[@class='successmsg']")
	private WebElement sucMsg;
	
	public void navigteToCreateCutomerPage() {
		createCustomerBtn.click();
	}
	
	public WebElement getSucMsg() {
		return sucMsg;
	}
}
