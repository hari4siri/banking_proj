package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.base;

public class addCustomer extends base{

	WebDriver dr;
	
	public addCustomer(WebDriver ddr) {
		dr=ddr;
	}
	
	By cus_name = By.xpath("//input[@name='name']");
	By dob = By.xpath("//input[@name='dob']");
	By addr = By.xpath("//textarea[@name='addr']");
	By city = By.xpath("//input[@name='city']");
	By state = By.xpath("//input[@name='state']");
	By pin = By.xpath("//input[@name='pinno']");
	By telno = By.xpath("//input[@name='telephoneno']");
	By email = By.xpath("//input[@name='emailid']");
	By pass = By.xpath("//input[@name='password']");
	By confirm = By.xpath("//input[@name='sub']");
	By successtext = By.xpath("//p[text()='Customer Registered Successfully!!!']");
	
	public void enterName(String name) {
		dr.findElement(cus_name).sendKeys(name);
	}
	
	public void enterDob(String name) {
		dr.findElement(dob).sendKeys(name);
	}
	
	public void enterAddress(String name) {
		dr.findElement(addr).sendKeys(name);
	}
	
	public void enterCity(String name) {
		dr.findElement(city).sendKeys(name);
	}
	
	public void enterState(String name) {
		dr.findElement(state).sendKeys(name);
	}
	
	public void enterPin(String name) {
		dr.findElement(pin).sendKeys(name);
	}
	
	public void enterTelno(String name) {
		dr.findElement(telno).sendKeys(name);
	}
	
	public void enterEmail(String name) {
		dr.findElement(email).sendKeys(name);
	}
	
	public void enterPass(String name) {
		dr.findElement(pass).sendKeys(name);
	}
	
	public void clickconfirm() {
		dr.findElement(confirm).click();
	}
	
	public String getsuccessmsg() {
		return dr.findElement(successtext).getText();
	}
}
