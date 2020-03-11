package highlightsElements.Admin;

import java.util.Random;

import org.openqa.selenium.Keys;

import highlightsElements.HighlightsElement;
import highlightsWork.HighlightsDoWork;

public class DeliveryProjects implements HighlightsElement {
	private String closeBtn = "/html/body/div[1]/div/div/div[2]/button";

	@Override
	public void doWork() {
		// get number of delivery projects
		String weeklyAccTableXpathString = "//*[@id=\"searchSpinnerHide2\"]/div";
		int rows = HighlightsDoWork.findItems(weeklyAccTableXpathString);
		if(rows < 3) { // the first item is search, the last item is email ending
			return;
		}
//		for(int row = 2; row < rows; row++) { // if there are 43 rows, projects are from 2 to 42
		for(int row = 2; row < rows; row++) { 
			String webProjectIndexString = String.format("projectHeadingText%d", (row - 2));
			String showHideXpathString = String.format("//*[@id=\"projectHeadingText%d\"]", (row - 2));
		
			// open project
			HighlightsDoWork.doClickWork(showHideXpathString, 500);
			// get the section id
			int webProjectID = Integer.parseInt(HighlightsDoWork.getAttribute(String.format("//*[@id=\"projectHeading%d\"]/table", (row - 2)), "id").replaceAll("[\\D]", ""));
			doWorkTitle(String.format("hightlightTableTop%d", webProjectID));
			doWorkContent(String.format("hightlightTable%d", webProjectID), webProjectIndexString);
			
			HighlightsDoWork.doClickWork(showHideXpathString, 500);
		}
	}
	
	private void doWorkTitle(String webProjectID) {
		// lock or unlock
		String unlockedIconXpathString = String.format("//*[@id=\"%s\"]/thead/tr/th[1]/center/div[1]/div[1]/label/i[1]", webProjectID);
		String lockedIconXpathString = String.format("//*[@id=\"%s\"]/thead/tr/th[1]/center/div[1]/div[1]/label/i[2]", webProjectID);
		
		if(HighlightsDoWork.isDisplayed(unlockedIconXpathString)) {
			// lock and unlock
			HighlightsDoWork.doClickWork(unlockedIconXpathString, 500);
			HighlightsDoWork.doClickWork(lockedIconXpathString, 500);
		}
		else {
			// unlock and lock
			HighlightsDoWork.doClickWork(lockedIconXpathString, 500);
			HighlightsDoWork.doClickWork(unlockedIconXpathString, 500);
		}
		
		// project Name edit and view history log
		String projNameEditXpathString = String.format("//*[@id=\"%s\"]/thead/tr/th[2]/i[1]", webProjectID);
		String projNameHistoryXpathString = String.format("//*[@id=\"%s\"]/thead/tr/th[2]/i[2]", webProjectID);
		 
		String projNameInputXpathString = String.format("//*[@id=\"%s\"]/thead/tr/th[2]/form/div/input", webProjectID);
		String projNameCheckXpathString = String.format("//*[@id=\"%s\"]/thead/tr/th[2]/form/div/span/button[1]", webProjectID);
		
		if(HighlightsDoWork.isDisplayed(projNameEditXpathString)) {
			HighlightsDoWork.doUpdates(projNameEditXpathString, projNameInputXpathString, projNameCheckXpathString, 0);
		}
		
		HighlightsDoWork.checkHistory(projNameHistoryXpathString, closeBtn);
		
		// financials edit and view history log
		String iconXpathTemplate = "//*[@id=\"%s\"]/thead/tr/th[%d]/div/i[%d]";
		String listXpathTemplateString = "//*[@id=\"%s\"]/thead/tr/th[%d]/div/ul/li[%d]/a";
		
		doWorkTitleFSIC(webProjectID, iconXpathTemplate, listXpathTemplateString, 8);
		doWorkTitleFSIC(webProjectID, iconXpathTemplate, listXpathTemplateString, 10);
		doWorkTitleFSIC(webProjectID, iconXpathTemplate, listXpathTemplateString, 15);
		doWorkTitleFSIC(webProjectID, iconXpathTemplate, listXpathTemplateString, 17);
	}
	
	private void doWorkTitleFSIC(String webProjectID, String iconXpathTemplate, String listXpathTemplateString, int th) {
		// pencil icon
		String pencilXpathString = String.format(iconXpathTemplate, webProjectID, th, 1);
		// select an item from the color list
		int randomInt = random.nextInt(3) + 1; // 1: green, 2: yellow, 3: red, 4: w
		String colorListXpathString = String.format(listXpathTemplateString, webProjectID, th, randomInt); // 2 is yellow
		
		if(HighlightsDoWork.isDisplayed(pencilXpathString)) {
			HighlightsDoWork.doClickWork(pencilXpathString, 500);
			HighlightsDoWork.doClickWork(colorListXpathString, 500);
		}
		
		// history icon
		String historyXpathString = String.format(iconXpathTemplate, webProjectID, th, 2);
		if(HighlightsDoWork.isDisplayed(pencilXpathString)) {
			HighlightsDoWork.checkHistory(historyXpathString, closeBtn);
		}
		
	}

	private void doWorkContent(String webProjectID, String webProjectIndexString) {
		// for all pencil icons, edit
		String pencilIconsXpathPatternString = String.format("//*[@id=\"%s\"]//*[contains(@class, 'fa-pencil-square-o')]", webProjectID);
		int pencils = HighlightsDoWork.findItems(pencilIconsXpathPatternString);
		for(int index = 1; index <= pencils; index++) {
			String pencilIconIndexXpathString = String.format("(%s)[%d]", pencilIconsXpathPatternString, index);
			String inputFieldXpathString = String.format("//*[@id=\"%s\"]//*[contains(@class, 'editable-input')]", webProjectID);
			String checkFieldXpathString = String.format("//*[@id=\"%s\"]//*[contains(@class, 'btn-xs')]", webProjectID);
			
			// modify the field by clicking backspace and then click number 1
			String calendarIconXpathString = "//*[contains(@class, 'glyphicon-calendar')]";
			if(HighlightsDoWork.isDisplayed(pencilIconIndexXpathString)) {
				HighlightsDoWork.doClickWork(pencilIconIndexXpathString, 500);
				if(HighlightsDoWork.isDisplayed(calendarIconXpathString)) { // if it is a datepicker field
					HighlightsDoWork.doClickWork(calendarIconXpathString, 500);
					String todayButtonString = "//*[contains(@class, 'uib-datepicker-current')]";
					if(HighlightsDoWork.isDisplayed(todayButtonString)) { // click on today to change date
						HighlightsDoWork.doClickWork(todayButtonString, 500);
					}					
					
				} else {
					HighlightsDoWork.doSendKeys(inputFieldXpathString, Keys.BACK_SPACE, 0);
					
					int randomInt = random.nextInt(10);
					String str1 = Integer.toString(randomInt); 
					HighlightsDoWork.doSendKeys(inputFieldXpathString, str1, 0);
				}
				
				if(HighlightsDoWork.isDisplayed(checkFieldXpathString)) {
					HighlightsDoWork.doClickWork(checkFieldXpathString, 500);
				}
				
			}
		}
		
		// for all bullet icons
		String bulletIconsXpathPatternString = String.format("//*[@id=\"%s\"]//*[contains(@class, 'fa-list-ul')]", webProjectID);
		int bullets = HighlightsDoWork.findItems(bulletIconsXpathPatternString);
		for(int index = 1; index <= bullets; index++) {
			String bulletIconIndexXpathString = String.format("(%s)[%d]", bulletIconsXpathPatternString, index);
			
			// click on bullets
			if(HighlightsDoWork.isDisplayed(bulletIconIndexXpathString)) {
				HighlightsDoWork.doClickWork(bulletIconIndexXpathString, 500);
			}
		}
		
		// for all history icons
		String historyIconsXpathPatternString = String.format("//*[@id=\"%s\"]//*[contains(@class, 'fa-history')]", webProjectID);
		int histories = HighlightsDoWork.findItems(historyIconsXpathPatternString);
		for(int index = 1; index <= histories; index++) {
			String historyIconIndexXpathString = String.format("(%s)[%d]", historyIconsXpathPatternString, index);
			
			// click on history icons to check update history
			if(HighlightsDoWork.isDisplayed(historyIconIndexXpathString)) {
				HighlightsDoWork.doClickWork(historyIconIndexXpathString, 500);
				HighlightsDoWork.doClickWork(closeBtn, 500);
			}
		}
		
		// for project resources
		String addressbookIconsXpathPatternString = String.format("//*[@id=\"%s\"]//*[contains(@class, 'fa-address-book-o')]", webProjectID);
		int addressbooks = HighlightsDoWork.findItems(addressbookIconsXpathPatternString);
		for(int index = 1; index <= addressbooks; index++) {
			String addressbookIconIndexXpathString = String.format("(%s)[%d]", addressbookIconsXpathPatternString, index);
			
			// click on history icons to check update history
			if(HighlightsDoWork.isDisplayed(addressbookIconIndexXpathString)) {
				HighlightsDoWork.doClickWork(addressbookIconIndexXpathString, 500);
				HighlightsDoWork.doClickWork(closeBtn, 500);
			}
		}
	}
}
