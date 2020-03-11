package highlightsElements.Admin;

import highlightsElements.HighlightsElement;
import highlightsWork.HighlightsDoWork;

public class ComplexDeliveryProjectStats implements HighlightsElement {

	@Override
	public void doWork() {
		// click on the Enable Edit button of the grid
		HighlightsDoWork.doClickWork("//*[@id=\"statspinnerhide1\"]/thead/tr[1]/th[3]/button[1]", 500); 
		
		for(int row = 2; row < 5; row++) { // iterate 3 rows
			for(int col = 3; col < 7; col++) { // iterate 4 cols
				String pencilIconXpathString = String.format("//*[@id=\"statspinnerhide1\"]/tbody/tr[%d]/td[%d]/p/i", row, col);
				String numberInputXpathString = String.format("//*[@id=\"statspinnerhide1\"]/tbody/tr[%d]/td[%d]/p/form/div/input", row, col);
				String checkButtonXpathString = String.format("//*[@id=\"statspinnerhide1\"]/tbody/tr[%d]/td[%d]/p/form/div/span/button[1]", row, col);
				HighlightsDoWork.doClickWork(pencilIconXpathString, 500);
				// remove last integer and input a random number between 0 to 10 to the input field
				int randomInt = random.nextInt(10);
				String str1 = Integer.toString(randomInt); 
				HighlightsDoWork.doSendKeys(numberInputXpathString, str1, 0);
				// click on the check mark
				HighlightsDoWork.doClickWork(checkButtonXpathString, 500);
			}
		}
		
		// click on the disable edit button to end editing
		HighlightsDoWork.doClickWork("//*[@id=\"statspinnerhide1\"]/thead/tr[1]/th[3]/button[2]", 500); 
		
	}

}
