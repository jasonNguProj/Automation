package highlightsElements.PM;

import highlightsElements.HighlightsElement;
import highlightsWork.HighlightsDoWork;

public class PMSelectWeek implements HighlightsElement {

	@Override
	public void doWork() {
		HighlightsDoWork.doClickWork("//*[@id=\"PMOpts\"]/div/div/select/option[12]", 5000); 
	}

}
