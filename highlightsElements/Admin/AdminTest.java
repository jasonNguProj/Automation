package highlightsElements;

import java.util.ArrayList;
import java.util.List;

import highlightsElements.Admin.AdminOptions;

import highlightsElements.Admin.AdminWork;
import highlightsElements.Admin.CompletedProjects;
import highlightsElements.Admin.ComplexDeliveryProjectStats;
import highlightsElements.Admin.DeliveryProjects;
import highlightsElements.Admin.SearchOptions;
import highlightsElements.Admin.WeeklyAccomplishments;
import highlightsElements.PM.PMSelectWeek;
import highlightsWork.HighlightsDoWork;
import highlightsWork.HighlightsDriverFactory;

import org.junit.Test;
import static org.junit.Assert.*;


public class AdminTest {

HighlightsDoWork highlights = null;
AdminOptions options = null;
AdminWork work = null;
CompletedProjects projects = null;
ComplexDeliveryProjectStats stats = null;
DeliveryProjects delivery = null;
SearchOptions search = null;
WeeklyAccomplishments accomplishments = null;
	
/*

test cases for testing the doWork implementation
in the various Admin implementation classes

*/

 @BeforeClass
     public void openBrowser(){
      try{
	 highlights = highlights.doNavigateWork(url, 2000, true);
		} catch (Extension e){}
		 Assert.assertNotNull(highlights);
		 
	 }
	 
	  @Test
	  public void AdminOptionsTest(){
	      try{
		 options = options.doWork();
			} catch (Extension e){}
			 Assert.assertNotNull(options);
		 
	 }
	 
	  @Test
	  public void AdminWorkTest(){
	      try{
		 work = work.doWork();
			} catch (Extension e){}
			 Assert.assertNotNull(work);
		 
	 }
	 
	  @Test
	  public void CompletedProjectsTest(){
	      try{
		 projects =  projects.doWork();
			} catch (Extension e){}
			 Assert.assertNotNull(projects);
		 
	 }
	 
	  @Test
	  public void ComplexDeliveryProjectStatsTest(){
	      try{
		  stats  = stats.doWork();
			} catch (Extension e){}
			 Assert.assertNotNull(stats);
		 
	 }
	 
	  @Test
	  public static void SearchOptionsTest(){
	      try{
		search  = search.doWork();
			} catch (Extension e){}
			 Assert.assertNotNull(search);
		 
	 }
	 
	  @Test
	   public static void DeliveryProjectsTest(){
	      try{
		 delivery = delivery.doWork();
			} catch (Extension e){}
			 Assert.assertNotNull(delivery);
		 
	 }
	 
	 @Test
	  public static void WeeklyAccomplishmentsTest(){
	      try{
		accomplishments = accomplishments.doWork();
			} catch (Extension e){}
			 Assert.assertNotNull(accomplishments);
		 
	 }
	 
	
}



