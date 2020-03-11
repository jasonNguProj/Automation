package highlightsElements.Admin;

import highlightsElements.HighlightsElement;
import highlightsWork.HighlightsDoWork;

public class AdminOptions implements HighlightsElement {

	@Override
	public void doWork() {
		// select week
		HighlightsDoWork.doClickWork("//*[@id=\"AdminOpts\"]/div/div/select/option[18]", 2000); 
		// click on the PMs button
		HighlightsDoWork.doClickWork("//*[@id=\"AdminOpts\"]/div/center[2]/div/button[2]", 2000); 
		// scroll page by specified y coordinate 
		HighlightsDoWork.doScrollDown(0, 250, 5000);
		//when the pm dialogue is displayed do the following
		HighlightsDoWork.isDisplayed("//*[@id=\"ProjectManagerListModal\"]/div/div/div[1]/button/span");
		// make the prog wait 
		HighlightsDoWork.sleepWork(2000);
		// close the pop up
		HighlightsDoWork.doClickWork("//*[@id=\"ProjectManagerListModal\"]/div/div/div[1]/button/span", 2000); 
		// click on the lock all projects button
		HighlightsDoWork.doClickWork("//*[@id=\"AdminOpts\"]/div/center[2]/div/button[3]", 2000); 
		// click on the unlock all projects button
		HighlightsDoWork.doClickWork("//*[@id=\"AdminOpts\"]/div/center[2]/div/button[4]", 2000); 
	}

}
