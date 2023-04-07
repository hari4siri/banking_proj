package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.base;
import pages.homepage;
import pages.login;
import utilities.ReadExcel;

public class LoginTest extends base{
	
	login lp;
	homepage hp;
	
	
	@Test(dataProviderClass=ReadExcel.class, dataProvider="getdata")
	public void loginTest(String uname, String pass) {
		lp=new login(driver);
		hp=new homepage(driver);
		log.info("entering username");
		lp.enterUsername(uname);
		log.info("entering password");
		lp.enterPassword(pass);
		log.info("click confirm");
		lp.clickConfirm();
		String actual=hp.getTitle();
		Assert.assertEquals(actual, "Guru99 Bank Manager HomePage");
		
	}
}
