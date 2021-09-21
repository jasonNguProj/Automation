package highlightsElements;

import java.util.ArrayList;
import java.util.List;

import highlightsElements.Admin.AdminOptions;
import highlightsElements.Admin.CompletedProjects;
import highlightsElements.Admin.ComplexDeliveryProjectStats;
import highlightsElements.Admin.DeliveryProjects;
import highlightsElements.Admin.SearchOptions;
import highlightsElements.Admin.WeeklyAccomplishments;
import highlightsElements.PM.PMSelectWeek;
import highlightsWork.HighlightsDoWork;
import highlightsWork.HighlightsDriverFactory;

public class UserDoWork implements HighlightsElement {
	private String url;

	public UserDoWork(String url) {
		super();
		this.url = url;
	}

	@Override
	public void doWork() {
		HighlightsDoWork.doNavigateWork(url, 2000, true);
		;
		List<HighlightsElement> highlightsElementsElement = new ArrayList<HighlightsElement>() {};
		
		if(HighlightsDoWork.isAdmin()) { // logged in as an Admin
			highlightsElementsElement.add(new AdminOptions());
			highlightsElementsElement.add(new ComplexDeliveryProjectStats());
			highlightsElementsElement.add(new SearchOptions());
			highlightsElementsElement.add(new WeeklyAccomplishments());
			highlightsElementsElement.add(new CompletedProjects());
			highlightsElementsElement.add(new DeliveryProjects());
		} else { // logged in as a PM
			highlightsElementsElement.add(new PMSelectWeek());
			highlightsElementsElement.add(new SearchOptions());
		}
		for (HighlightsElement highlightsElement : highlightsElementsElement) {
			highlightsElement.doWork();
		}
		HighlightsDriverFactory.getInstance().getDriver().quit();
	}

}
