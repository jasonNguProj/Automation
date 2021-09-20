package highlights;

import highlightsElements.HighlightsElement;
import highlightsElements.UserDoWork;
import highlightsElements.Admin.AdminWork;
import highlightsWork.HighlightsDoWork;
import highlightsWork.HighlightsDriverFactory;
import highlightsWork.HighlightsDriverFactory.Browser;

public class Controller {

	public static void main(String[] args) {
		String url = "";
		
		// create driver using factory, this should be done first
		HighlightsDriverFactory.getInstance().CreateDriver(Browser.CHROME);
		
		// navigate to the page
		if(HighlightsDriverFactory.getInstance().getDriver() == null || HighlightsDriverFactory.getInstance().getJavascriptExecutor() == null) {
			System.out.println("No web driver or Javascript executor found"); // if no driver found, exit the program
			return;
		}
		
		HighlightsElement userDoWork = new UserDoWork(url);
		userDoWork.doWork();

	}
}
