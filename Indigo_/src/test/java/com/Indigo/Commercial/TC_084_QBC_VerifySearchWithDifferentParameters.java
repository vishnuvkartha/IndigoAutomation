package com.Indigo.Commercial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_084_QBC_VerifySearchWithDifferentParameters extends HelperClass {
	//202,203,204,205,206,207,208,209
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Commercial");
	
	@Test(dataProvider = "testData")
	public void TC_084_VerifySearchWithDifferentParameters(String Username,String Password,String Mainmenu,String Submenu,
			String From,String To,String type,String start,String end,String origin,String dest,String queue,String DaysOut,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			SelectFromDate1(From);
			SelectToDate1(To);
			ClickGenerate();
			CommQBC_VerifySearchResults();
			ClickResetButton();
			Comm_QBC_SelectFlightType(type);
			ClickGenerate();
			CommQBC_VerifySearchResults();
			ClickResetButton();
			QBC_Startime(start);
			QBC_EndTime(end);
			ClickGenerate();
			CommQBC_VerifySearchResults();
			ClickResetButton();
			CommQBC_SelectOrigin(origin);
			ClickGenerate();
			CommQBC_VerifySearchResults();
			ClickResetButton();
			CommQBC_SelectDestination(dest);
			ClickGenerate();
			CommQBC_VerifySearchResults();
			ClickResetButton();
			SelectFirstFlight();
			ClickGenerate();
			CommQBC_VerifySearchResults();
			ClickResetButton();
			Reporter.SuccessReport("TC_084", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_084,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_084", "Username"),
	    			xls.getCellValue("TC_084", "Password"),
	    			xls.getCellValue("TC_084", "MainMenu"),
	    			xls.getCellValue("TC_084", "SubMenu"),
	    			xls.getCellValue("TC_084", "From"),
	    			xls.getCellValue("TC_084", "To"),
	    			xls.getCellValue("TC_084", "FlightType"),
	    			xls.getCellValue("TC_084", "Starttime"),
	    			xls.getCellValue("TC_084", "Endtime"),
	    			xls.getCellValue("TC_084", "Origin"),
	    			xls.getCellValue("TC_084", "Destination"),
	    			xls.getCellValue("TC_084", "Queue"),
	    			xls.getCellValue("TC_084", "DaysOut"),
	    			
	    			
	    			"To verify PAX Adhoc in Commercial Module"
	    		}};
	}

}

