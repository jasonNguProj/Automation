package highlightsElements.Admin;

import highlightsElements.HighlightsElement;
import highlightsWork.HighlightsDoWork;

public class SearchOptions implements HighlightsElement {

	@Override
	public void doWork() {
		selectOptionAndLoad(new int[]{2, 2, 2, 2});
		selectOptionAndLoad(new int[]{1, 1, 1, 1});
	}

	private void selectOptionAndLoad(int[] options) {
		for(int option = 1; option < 5; option++) {
			String optionXpathString = String.format("//*[@id=\"searchopts\"]/div/div[%d]/select/option[%d]", option, options[option - 1]);
			HighlightsDoWork.doClickWork(optionXpathString, 500);
		}
		
		// click on the load button
		String loadBtnXpathString = "//*[@id=\"searchopts\"]/div/center/div/button[1]";
		HighlightsDoWork.doClickWork(loadBtnXpathString, 500);
		
		HighlightsDoWork.sleepWork(1000);
	}
}
