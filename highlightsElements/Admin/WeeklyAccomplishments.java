package highlightsElements.Admin;

import org.openqa.selenium.Keys;

import highlightsElements.HighlightsElement;
import highlightsWork.HighlightsDoWork;

public class WeeklyAccomplishments implements HighlightsElement {

	@Override
	public void doWork() {
		// get number of weekly accomplished projects
		String weeklyAccTableXpathString = "//*[@id=\"storyspinnerhide11\"]/tbody/tr";
		int rows = HighlightsDoWork.findItems(weeklyAccTableXpathString);
		if(rows < 1) {
			return;
		}
		
		for(int row = 1; row < 1 + rows; row++) {
			// get number of columns in the project info row
			String weeklyAccColXpathString = "//*[@id=\"storyspinnerhide11\"]/tbody/tr[1]/td";
			int cols = HighlightsDoWork.findItems(weeklyAccColXpathString);
			if(cols < 1) {
				continue;
			}
			
			for(int col = 1; col < 1 + cols; col++) {
				if(col == 2) {
					System.out.println("");
					HighlightsDoWork.doClickWork("//*[@id=\"ui-select-choices-6\"]/div[4]/a", 2000); 
				}
				else {
					// click the pencil icon
					String pencilIconXpathString = String.format("//*[@id=\"storyspinnerhide11\"]/tbody/tr[%d]/td[%d]/i[1]", row, col);
					// put "test by Yan" into the field
					String inputFieldXpathString = String.format("//*[@id=\"storyspinnerhide11\"]/tbody/tr[%d]/td[%d]/form/div/textarea", row, col);
					String checkXpathString = String.format("//*[@id=\"storyspinnerhide11\"]/tbody/tr[%d]/td[%d]/form/div/span/button[1]", row, col);
					HighlightsDoWork.doUpdates(pencilIconXpathString, inputFieldXpathString, checkXpathString, 1000);
					
					// view history log
					String historyIconXpathString = String.format("//*[@id=\"storyspinnerhide11\"]/tbody/tr[%d]/td[%d]/i[2]", row, col);
					if(HighlightsDoWork.isDisplayed(historyIconXpathString)) {
						// check history and close
						String closeBtnXpathStr = "/html/body/div[1]/div/div/div[2]/button";
						HighlightsDoWork.checkHistory(historyIconXpathString, closeBtnXpathStr);
					}
					
					
					// add comments if there is a comment field
					String commentIconXpathString = String.format("//*[@id=\"storyspinnerhide11\"]/tbody/tr[%d]/td[%d]/*[@id=\"TrumpShorts2010\"]/i", row, col);
					if(HighlightsDoWork.isDisplayed(commentIconXpathString)) {
						String commentInputXpathString = String.format("//*[@id=\"storyspinnerhide11\"]/tbody/tr[%d]/td[%d]/*[@id=\"TrumpShorts2010\"]/form/div/textarea", row, col);
						String commentCheckIconXpathString = String.format("//*[@id=\"storyspinnerhide11\"]/tbody/tr[%d]/td[%d]/*[@id=\"TrumpShorts2010\"]/form/div/span/button[1]", row, col);
						HighlightsDoWork.doUpdates(commentIconXpathString, commentInputXpathString, commentCheckIconXpathString, 1000);
					}
				}
				
			}
			
		}
		

	}

}
