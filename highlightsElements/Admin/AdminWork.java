package highlightsElements.Admin;

import highlightsElements.HighlightsElement;
import highlightsWork.HighlightsDoWork;

public class AdminWork implements HighlightsElement {

	private String url;
	
	public AdminWork(String url) {
		super();
		this.url = url;
	}

	@Override
	public void doWork() {
		// navigate to the page
		HighlightsDoWork.doNavigateWork(url, 2000, true);
		HighlightsDoWork.isAdmin();
		HighlightsElement[] highlightsElementsElement = {
				new AdminOptions(), 
				new ComplexDeliveryProjectStats(),
				new SearchOptions(),
				new WeeklyAccomplishments(),
				new CompletedProjects(), 
				new DeliveryProjects()
				};
//		for (HighlightsElement highlightsElement : highlightsElementsElement) {
//			highlightsElement.doWork();
//		}
	}

}
