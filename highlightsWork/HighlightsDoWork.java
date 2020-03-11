package highlightsWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HighlightsDoWork {
	
	// navigate to the page
	public static void doNavigateWork(String url, int sleepTime, boolean fullScreen) {
		getDriver().navigate().to(url); 
		sleepWork(sleepTime);
		if(fullScreen) {
			getDriver().manage().window().maximize();  
		}		
		sleepWork(sleepTime);

	}
	
	public static boolean isAdmin() {
		String loggedInRoleText = getDriver().findElement(By.xpath("//*[@id=\"main-navbar-collapse-1\"]/ul/li[2]/a")).getText();
		String loggedInRole	= loggedInRoleText.substring(loggedInRoleText.indexOf("(")+1,loggedInRoleText.indexOf(")")).trim().toLowerCase();
		if(loggedInRole.equalsIgnoreCase("admin")){
			return true;
		}
		return false;
	}
	
	// click on element
	public static void doClickWork(String xpathStr, int sleepTime) {
		String toastXpathString = " //*[@class='toast-top-right']";
		while(isDisplayed(toastXpathString)) {
			getDriver().findElement(By.xpath(toastXpathString)).click();
			sleepWork(100);
		}
		if(isDisplayed(xpathStr)) {
			getDriver().findElement(By.xpath(xpathStr)).click();
			sleepWork(sleepTime);
		}
		
	}
	
	// scroll down
	public static void doScrollDown(int start, int end, int sleepTime) {
		getJSExecutor().executeScript(String.format("scrollBy(%d, %d)", start, end));    
		sleepWork(sleepTime);
	}
	
	// send keyboard keys
	public static void doSendKeys(String xpathStr, String keys, int sleepTime) {
		getDriver().findElement(By.xpath(xpathStr)).sendKeys(keys);    
		sleepWork(sleepTime);
	}
	
	// send keyboard keys
	public static void doSendKeys(String xpathStr, Keys keys, int sleepTime) {
		getDriver().findElement(By.xpath(xpathStr)).sendKeys(keys);   
		sleepWork(sleepTime);
	}
	
	// find rows in a table element
	public static int findItems(String xpathStr) {
		setImplicitlyWait(0);
		int numOfItems = getDriver().findElements(By.xpath(xpathStr)).size();    
		setImplicitlyWait(30);
		return numOfItems;
	}
	
	// check if element exist on page
	public static boolean isDisplayed(String xpathStr) {
		setImplicitlyWait(0);
	    
		try {
			if(getDriver().findElements(By.xpath(xpathStr)).size() != 0) {
				setImplicitlyWait(30);
				return getDriver().findElement(By.xpath(xpathStr)).isDisplayed();
			}				
			setImplicitlyWait(30);
			return false;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	    	setImplicitlyWait(30);
	        return false;
	    }
	}
	
	private static void setImplicitlyWait(int sec)
	{
		getDriver().manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);  
	}
	
	public static String getAttribute(String xpathStr, String attribute) {
		return getDriver().findElement(By.xpath(xpathStr)).getAttribute(attribute);
	}
	
	// pencil icon info update
	public static void doUpdates(String pencilIconXpathStr, String inputAreaXpathStr, String checkXpathStr, int sleepTime) {
		doClickWork(pencilIconXpathStr, 100); 
		doSendKeys(inputAreaXpathStr, Keys.SPACE, 0);
		doSendKeys(inputAreaXpathStr, "test", 0);
		doClickWork(checkXpathStr, 1000);
		sleepWork(sleepTime);
	}
	
	// check history
	public static void checkHistory(String historyIconXpathStr, String closeBtnXpathStr) {
		doClickWork(historyIconXpathStr, 2000); 
		doClickWork(closeBtnXpathStr, 0); 
	}
	
	private static WebDriver getDriver() {
		return HighlightsDriverFactory.getInstance().getDriver();
	}
	
	private static JavascriptExecutor getJSExecutor() {
		return HighlightsDriverFactory.getInstance().getJavascriptExecutor();
	}
	
	public static void sleepWork(int sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
