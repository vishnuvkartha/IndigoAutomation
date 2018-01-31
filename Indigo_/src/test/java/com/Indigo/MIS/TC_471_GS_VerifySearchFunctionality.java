package com.Indigo.MIS;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_471_GS_VerifySearchFunctionality extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"MIS");
//471,473,474,475,476,478,480
	@Test(dataProvider = "testData")
	public void TC_471_GS_VerifySearchfunctionality(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String queue,String department,
			String Commtype,String Status,String application,String daysout,String from2,String to2,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			
			//FROM DATE,TO DATE
			SelectFromDate(From);
			SelectToDate(To);
			MIS_ClickSearch();			
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			//QUEUE
			MIS_GS_SelectQueue(queue);
			AU_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			//COMMUNICATION TYPE
			MIS_GS_SelectCommunicationType(Commtype);
			AU_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			//APPLICATION
			MIS_GS_SelectApplication(application);
			AU_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
		
			//Department	
			MIS_GS_SelectDepartment(department);
			AU_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			//DAYS OUT FOR TRAVEL
			MIS_GS_DaysOut(daysout);
			AU_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			
			
			//STATUS
			MIS_GS_SelectStatus(Status);
			AU_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			ClickResetButton();
			
			
			//from date less than to date
			SelectFromDate(from2);
			SelectToDate(to2);
			
			AU_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			
			SelectFromDate(From);
			SelectToDate(To);
			MIS_GS_SelectCommunicationType(Commtype);
			MIS_GS_SelectDepartment(department);
			MIS_ClickSearch();		
			Reporter.SuccessReport("TC_471", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_471,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_471", "Username"),
	    			xls.getCellValue("TC_471", "Password"),
	    			xls.getCellValue("TC_471", "MainMenu"),
	    			xls.getCellValue("TC_471", "SubMenu"),
	    			xls.getCellValue("TC_471", "From"),
	    			xls.getCellValue("TC_471", "To"),
	    			xls.getCellValue("TC_471", "Queue"),
	    			xls.getCellValue("TC_471", "Department"),
	    			xls.getCellValue("TC_471", "CommType"),
	    			xls.getCellValue("TC_471", "Status"),
	    			xls.getCellValue("TC_471", "Application"),
	    			xls.getCellValue("TC_471", "DaysOut"),
	    			"26-01-2018",
	    			"25-01-2018",
	    	
	    			
	    			"To verify Search Functionality"
	    		}};
	}

}

