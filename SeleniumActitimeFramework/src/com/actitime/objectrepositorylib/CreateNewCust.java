package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCust {
  
	@FindBy(name="name")
	private WebElement customerNameEdt;
	
	@FindBy(name="description")
	private WebElement customerdescriptionEdt;
	
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustomerBtn;
	//overloaded mtd
	public void createCustomer(String customerNAme){
		customerNameEdt.sendKeys(customerNAme);
		createCustomerBtn.click();
	}
	public void createCustomer(String customerNAme,String desc){
		customerNameEdt.sendKeys(customerNAme);
		customerdescriptionEdt.sendKeys(desc);
		createCustomerBtn.click();
	}
}


