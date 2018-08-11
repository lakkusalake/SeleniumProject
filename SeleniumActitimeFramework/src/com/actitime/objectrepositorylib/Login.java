package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
   @FindBy(name="username")             //IDentify All element using @findBy & FindBys
   private WebElement usernameEdt;
   
   @FindBy(name="pwd")
   private WebElement passwordEdt;
   
   @FindBy(id="loginButton")
   private WebElement loginButton;
   //======================================================
   public WebElement getUsernameEdt() {  //getters
	return usernameEdt;
	}
   public WebElement getPasswordEdt() {
		return passwordEdt;
	}
   public WebElement getLoginButton() {
		return loginButton;
	}
   //============================================================
//Reusable business lib / Action
   public void login(String username,String password){
	   usernameEdt.sendKeys(username);
	   passwordEdt.sendKeys(password);
	   loginButton.click();
	   
   }

}
