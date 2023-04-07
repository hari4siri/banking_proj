package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.base;

public class homepage extends base{
	
	WebDriver dr;
	
	public homepage(WebDriver ddr) {
		dr=ddr;
	}
	
	public String getTitle() {
		return dr.getTitle();
	}
	
	public void selectTab(String tabname) {
		List<WebElement> tabs=dr.findElements(By.tagName("a"));
		for(WebElement tab: tabs) {
			if(tab.getText().equals(tabname)) {
				tab.click();
			}
		}
	}
}
