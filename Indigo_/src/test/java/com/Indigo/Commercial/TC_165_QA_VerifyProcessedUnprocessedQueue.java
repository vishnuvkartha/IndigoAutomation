package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_165_QA_VerifyProcessedUnprocessedQueue extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	//165,166
	@Test(dataProvider = "testData")
	public void TC_165_QA_VerifyprocessedUnprocessedQueue(String Username,String Password,String Mainmenu,String Submenu,String queue1,String DaysOut,String queue2,
			String queue3,String queue4,String queue5,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			Comm_QA_SelectQueue(queue1);
			Comm_QA_ClickSearch();		
			Comm_QA_VerifyUnProcessedSubqueue();
			QA_UncheckAllFlights();
			QA_SelectAFlight1();
			Comm_QA_ClickApprove();
			VerifyConfirmation();
			ClickOKButton();
			Comm_QA_VerifyProcessedSubqueue();
			Comm_QA_ClickEmailIcon();
			Comm_QA_VerifyMessageEmailPreview();
			Comm_QA_ClickTemplateCancel();
			
			
			Comm_QA_SelectQueue(queue2);
			Comm_QA_ClickSearch();		
			Comm_QA_VerifyUnProcessedSubqueue();
			QA_UncheckAllFlights();
			QA_SelectAFlight1();
			Comm_QA_ClickApprove();
			VerifyConfirmation();
			ClickOKButton();
			Comm_QA_VerifyProcessedSubqueue();
			Comm_QA_ClickEmailIcon();
			Comm_QA_VerifyMessageEmailPreview();
			Comm_QA_ClickTemplateCancel();
			
			Comm_QA_SelectQueue(queue3);
			Comm_QA_ClickSearch();		
			Comm_QA_VerifyUnProcessedSubqueue();
			QA_UncheckAllFlights();
			QA_SelectAFlight1();
			Comm_QA_ClickApprove();
			VerifyConfirmation();
			ClickOKButton();
			Comm_QA_VerifyProcessedSubqueue();
			Comm_QA_ClickEmailIcon();
			Comm_QA_VerifyMessageEmailPreview();
			Comm_QA_ClickTemplateCancel();
			
			Comm_QA_SelectQueue(queue4);
			Comm_QA_ClickSearch();		
			Comm_QA_VerifyUnProcessedSubqueue();
			QA_UncheckAllFlights();
			QA_SelectAFlight1();
			Comm_QA_ClickApprove();
			VerifyConfirmation();
			ClickOKButton();
			Comm_QA_VerifyProcessedSubqueue();
			Comm_QA_ClickEmailIcon();
			Comm_QA_VerifyMessageEmailPreview();
			Comm_QA_ClickTemplateCancel();
			
			Comm_QA_SelectQueue(queue5);
			Comm_QA_ClickSearch();		
			Comm_QA_VerifyUnProcessedSubqueue();
			QA_UncheckAllFlights();
			QA_SelectAFlight1();
			Comm_QA_ClickApprove();
			VerifyConfirmation();
			ClickOKButton();
			Comm_QA_VerifyProcessedSubqueue();
			Comm_QA_ClickEmailIcon();
			Comm_QA_VerifyMessageEmailPreview();
			Comm_QA_ClickTemplateCancel();
			
			Reporter.SuccessReport("TC_165", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_165,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_165", "Username"),
	    			xls.getCellValue("TC_165", "Password"),
	    			xls.getCellValue("TC_165", "MainMenu"),
	    			xls.getCellValue("TC_165", "SubMenu"),
	    			xls.getCellValue("TC_165", "Queue"),
	    			xls.getCellValue("TC_165", "DaysOut"),
	    			"Time Change Delay Less than 2 hours",
	    			"Time Change Prepone Greater than 1 hours",
	    			"Time Change Prepone Less than 1 hours",
	    			"Time Change Prepone Greater than 1 hours",
	    			"To verify Queue Approval page"
	    		}};
	}

}

