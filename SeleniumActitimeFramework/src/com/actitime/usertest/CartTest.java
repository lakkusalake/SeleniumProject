package com.actitime.usertest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest {
	@Test(dataProvider ="getData")
	public void addToCart(String catagary , String product){
		System.out.println("execute===>"+catagary  + ", product ==>"+product);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr = new Object[5][2];
		
		objArr[0][0]="tv";
		objArr[0][1]="sony";
		
		objArr[1][0]="tv";
		objArr[1][1]="lg";
		
		objArr[2][0]="tv";
		objArr[2][1]="Samsung";
		
		objArr[3][0]="mobile";
		objArr[3][1]="apple";
		
		objArr[4][0]="mobile";
		objArr[4][1]="andriod";
		return objArr;
	}

}
