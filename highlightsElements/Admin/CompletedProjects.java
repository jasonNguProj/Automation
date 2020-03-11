package highlightsElements.Admin;

import highlightsElements.HighlightsElement;
import highlightsWork.HighlightsDoWork;

public class CompletedProjects implements HighlightsElement {

	@Override
	public void doWork() {
		
		
		//HighlightsDoWork.doClickWork("//*[@id=\"completedspinnerhide1\"]/tbody/tr[1]/td[1]/i", 2000); 
		
		//HighlightsDoWork.doSendKeys("//*[@id=\"completedspinnerhide1\"]/tbody/tr[1]/td[1]/i", "test",  2000); 
		
		
		
	//	 get number of completed projects
		String completedProjTableXpathString = "//*[@id=\"completedspinnerhide1\"]/thead/tr";
		int rows = HighlightsDoWork.findItems(completedProjTableXpathString);
		if(rows < 1) {
			return;
		}
		for(int row = 1; row < 1 + rows; row++) {
			// get number of columns in the project info row
			String completedProjColXpathString = "//*[@id=\"completedspinnerhide1\"]/tbody/tr[1]/td";
			int cols = HighlightsDoWork.findItems(completedProjColXpathString);
			if(cols < 1) {
				continue;
			}

			for(int col = 1; col < 1 + cols; col++) {
				if(col == 2 || col ==4) {
					System.out.println("");
					HighlightsDoWork.doClickWork("//*[@id=\"ui-select-choices-6\"]/div[4]/a", 2000); 
				}
				else {
				// update field if there is a pencil icon
				String pencilIconXpathString = String.format("//*[@id=\"completedspinnerhide1\"]/tbody/tr[%d]/td[%d]/i", row, col);
				if(HighlightsDoWork.isDisplayed(pencilIconXpathString)) {
					String inputXpathString = String.format("//*[@id=\"completedspinnerhide1\"]/tbody/tr[%d]/td[%d]/form/div/textarea", row, col);
					String checkIconXpathString = String.format("//*[@id=\"completedspinnerhide1\"]/tbody/tr[%d]/td[%d]/form/div/span/button[1]", row, col);
					HighlightsDoWork.doUpdates(pencilIconXpathString, inputXpathString, checkIconXpathString, 1000);
				}
				
				// check if there is a comment area
				String commentIconXpathString = String.format("//*[@id=\"completedspinnerhide1\"]/tbody/tr[%d]/td[%d]/*[@id=\"TrumpKick4001\"]/i", row, col);
				if(HighlightsDoWork.isDisplayed(commentIconXpathString)) {
					String inputXpathString = String.format("//*[@id=\"completedspinnerhide1\"]/tbody/tr[%d]/td[%d]/*[@id=\"TrumpKick4001\"]/form/div/textarea", row, col);
					String checkIconXpathString = String.format("//*[@id=\"completedspinnerhide1\"]/tbody/tr[%d]/td[%d]/*[@id=\"TrumpKick4001\"]/form/div/span/button[1]", row, col);
					HighlightsDoWork.doUpdates(commentIconXpathString, inputXpathString, checkIconXpathString, 1000);
					}
				}
			
			}
		}

	}
}
