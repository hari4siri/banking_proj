package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.base;

public class login extends base{
	
	WebDriver dr;
	
	public login(WebDriver ddr){
		dr=ddr;
	}
	
	By username = By.xpath("//input[@name='uid']");
	By password = By.xpath("//input[@name='password']");
	By loginbtn = By.xpath("//input[@name='btnLogin']");
	
	public void enterUsername(String name) {
		dr.findElement(username).sendKeys(name);
	}
	
	public void enterPassword(String pass) {
		dr.findElement(password).sendKeys(pass);
	}
	
	public void clickConfirm() {
		dr.findElement(loginbtn).click();
	}	
}
