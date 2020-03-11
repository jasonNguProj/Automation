package highlightsWork;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import highlights.Resources;

public class HighlightsDriverFactory {
	private static HighlightsDriverFactory highlightsDriverFactory;
	private WebDriver webDriver;
	private JavascriptExecutor javascriptExecutor;
	
	public static HighlightsDriverFactory getInstance() {
		if(highlightsDriverFactory == null) {
			highlightsDriverFactory = new HighlightsDriverFactory();
		}
		return highlightsDriverFactory;
	}
	
	public static enum Browser {
		CHROME,
		IE,
		MOZILLA
	} 

	public void CreateDriver(Browser theBrowser) {
		String absolutePath;
		switch(theBrowser) {
		case CHROME:
			absolutePath = new File(Resources.chromDriver).getAbsolutePath();
			System.setProperty("webdriver.chrome.driver", absolutePath);
			webDriver = new ChromeDriver();  
			driverSetup();
			break;
		case IE:
			absolutePath = new File(Resources.ieDriver).getAbsolutePath();
			System.setProperty("webdriver.ie.driver", absolutePath);
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			webDriver = new InternetExplorerDriver(ieOptions);  
			webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driverSetup();
			break;
		case MOZILLA:
			break;
		}
	}
	
	public void driverSetup() {
		javascriptExecutor = (JavascriptExecutor)webDriver;  
		webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS); // wait time
		webDriver.manage().window().maximize();  
	}
	
	public JavascriptExecutor getJavascriptExecutor() {
		return javascriptExecutor;
	}
	
	public WebDriver getDriver() {
		return webDriver;
	}
}
