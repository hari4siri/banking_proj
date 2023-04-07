package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.base;
import pages.addCustomer;
import pages.homepage;
import utilities.helpermethods;

public class NewCustomer extends base{
	
	addCustomer ac;
	homepage hp;
	helpermethods hm = new helpermethods();
	
	String cus_name= "New Customer";
	String email=hm.randomname()+"@mailinator.com";
	
	@Test
	public void addCustomerTest() {
		hp = new homepage(driver);
		ac= new addCustomer(driver);
		hp.selectTab(cus_name);
		ac.enterName("test name");
		ac.enterDob("12-03-1980");
		ac.enterAddress("test adress");
		ac.enterCity("some city");
		ac.enterState("some state");
		ac.enterPin("234432");
		ac.enterTelno("1234567898");
		ac.enterEmail(email);
		ac.enterPass("12345");
		ac.clickconfirm();
		String msg=ac.getsuccessmsg();
		Assert.assertEquals(msg, "Customer Registered Successfully!!!");
		
	}

}
