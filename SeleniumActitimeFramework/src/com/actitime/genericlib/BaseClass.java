package com.actitime.genericlib;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.objectrepositorylib.Common;
import com.actitime.objectrepositorylib.Login;

public class BaseClass {
	public static WebDriver driver;
  	FileUtilities lib = new FileUtilities();

	@BeforeClass
	public void configBC() throws Throwable{
      System.out.println(" ==================launch the browser=====");
			Properties pObj = lib.getPropertiesFileObj();
			String bNAme = pObj.getProperty("browser");
			if(bNAme.equals("firefox")){
                driver = new FirefoxDriver();
			}else if(bNAme.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
				driver = new ChromeDriver();
			}
			
	}
		@BeforeMethod
	public void configBM() throws Throwable{
			Properties pObj = lib.getPropertiesFileObj();
		System.out.println("login");
		Login lp = PageFactory.initElements(driver, Login.class);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(pObj.getProperty("url"));
		lp.login(pObj.getProperty("username"), pObj.getProperty("password"));

	}
		
		
	@AfterMethod
	public void configAM(){
	    System.out.println("logout");
	    Common cp = PageFactory.initElements(driver, Common.class);
	    cp.logout();
	}
	@AfterClass
	public void configAC(){
		System.out.println("========close browser======");
		driver.close();
	}

}
