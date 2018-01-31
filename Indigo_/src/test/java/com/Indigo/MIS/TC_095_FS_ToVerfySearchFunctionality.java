package com.Indigo.MIS;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_095_FS_ToVerfySearchFunctionality extends HelperClass {
	//95,96,98,99,100,101,102,103,104,108
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"MIS");

	@Test(dataProvider = "testData")
	public void TC_095_FS_ToVerfysearchFunctionality(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,String destination,
			String Commtype,String Status,String application,String from2,String to2,String testdescription) throws Throwable {
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
			AU_ClickSearch();
			MIS_FS_ValidateSearch();
			ClickResetButton();
			//ORIGIN
			MIS_FS_SelectOrigin(Origin);
			AU_ClickSearch();
			MIS_FS_ValidateSearch();
			ClickResetButton();
		    //DESTINATION	
			MIS_FS_SelectDestination(destination);
			AU_ClickSearch();
			MIS_FS_ValidateSearch();
			ClickResetButton();
			//FLIGHT NUMBER
			SelectFirstFlight();
			AU_ClickSearch();
			MIS_FS_ValidateSearch();
			ClickResetButton();
			
			//COMMUNICATION TYPE
			MIS_FS_SelectCommunicationType(Commtype);
			AU_ClickSearch();
			MIS_FS_ValidateSearch();
			ClickResetButton();
			
			//STATUS
			MIS_FS_SelectStatus(Status);
			AU_ClickSearch();
			MIS_FS_ValidateSearch();
			ClickResetButton();
			
			//APPLICATION
			MIS_FS_SelectApplication(application);
			AU_ClickSearch();
			MIS_FS_ValidateSearch();
			ClickResetButton();
			//from date less than to date
			SelectFromDate(from2);
			SelectToDate(to2);
			MIS_ClickSearch();			
			AU_ClickSearch();
			VerifyConfirmation();
			ClickOKButton();
			Reporter.SuccessReport("TC_095", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_095,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_095", "Username"),
	    			xls.getCellValue("TC_095", "Password"),
	    			xls.getCellValue("TC_095", "MainMenu"),
	    			xls.getCellValue("TC_095", "SubMenu"),
	    			xls.getCellValue("TC_095", "From"),
	    			xls.getCellValue("TC_095", "To"),
	    			xls.getCellValue("TC_095", "Origin"),
	    			xls.getCellValue("TC_095", "Destination"),
	    			xls.getCellValue("TC_095", "CommType"),
	    			xls.getCellValue("TC_095", "Status"),
	    			xls.getCellValue("TC_095", "Application"),
	    			"29-01-2018",
	    			"28-01-2018",
	    	
	    			
	    			"To verify Search Functionality"
	    		}};
	}

}

