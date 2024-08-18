package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseTest;

public class ElementFetch {
	
	
	public WebElement getWebElement(String identifierType, String identifierValue) {
		
		switch(identifierType) {
		
		case "xpath":
			return BaseTest.getDriver().findElement(By.xpath(identifierValue));
		
		case "css":
			return BaseTest.getDriver().findElement(By.cssSelector(identifierValue));
			
		case "id":
			return BaseTest.getDriver().findElement(By.id(identifierValue));
			
		case "name":
			return BaseTest.getDriver().findElement(By.partialLinkText(identifierValue));
			
		case "tagname":
			return BaseTest.getDriver().findElement(By.tagName(identifierValue));
			
		    default :
		    	return null;	
		}
			
	}
	
	
public List<WebElement> getWebElements(String identifierType, String identifierValue) {
		
		switch(identifierType) {
		
		case "xpath":
			return BaseTest.getDriver().findElements(By.xpath(identifierValue));
		
		case "css":
			return BaseTest.getDriver().findElements(By.cssSelector(identifierValue));
			
		case "id":
			return BaseTest.getDriver().findElements(By.id(identifierValue));
			
		case "name":
			return BaseTest.getDriver().findElements(By.partialLinkText(identifierValue));
			
		case "tagname":
			return BaseTest.getDriver().findElements(By.tagName(identifierValue));
			
		    default :
		    	return null;	
		}
			
	}

}
