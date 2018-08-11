package com.actitime.customertest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.actitime.genericlib.BaseClass;
import com.actitime.genericlib.FileUtilities;
import com.actitime.objectrepositorylib.CreateNewCust;
import com.actitime.objectrepositorylib.Home;
import com.actitime.objectrepositorylib.OpenTask;
import com.actitime.objectrepositorylib.ProjectAndCustomer;

public class CustomerTest extends BaseClass{
	@Test
	public void cerateCustomerTest() throws Throwable{
		//read test data 
		FileUtilities lib = new FileUtilities();
		String customerNAme = lib.getExcelData("Sheet1", 1, 2);
		//step 2 : navigate to Task PAge
		Home hp = PageFactory.initElements(driver, Home.class);
		hp.navigateToTaskPage();
		//step 3 : click on "Project & cust " link
		OpenTask op = PageFactory.initElements(driver, OpenTask.class);
		op.navigateToProjectAndCustPage();
		//step 4 : click on "create new Customer"
		ProjectAndCustomer pandc = PageFactory.initElements(driver, ProjectAndCustomer.class);
		pandc.navigteToCreateCutomerPage();
		//step 5: create Customer
		CreateNewCust createCust = PageFactory.initElements(driver, CreateNewCust.class);
		createCust.createCustomer(customerNAme);
		
        //verify
		String actmsg = pandc.getSucMsg().getText();
		String expmsg = "successfully created.";
		boolean stat = actmsg.contains(expmsg);
		Assert.assertTrue(stat);
	}

}