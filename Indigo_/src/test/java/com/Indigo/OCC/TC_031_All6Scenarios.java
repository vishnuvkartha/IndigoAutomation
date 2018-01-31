package com.Indigo.OCC;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_031_All6Scenarios extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_031_All6Scenarios(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,
			String Destination,	String reason,String station,String communication,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			AU_SelectFirstFlight();
			AU_GetFlightDetails();
			SelectReason(reason);
			ClickSendButton();
			VerifyConfirmation();
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			Reporter.SuccessReport("TC_031_All6Scenarios", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_031_All6Scenarios,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_019", "Username"),
	    			xls.getCellValue("TC_019", "Password"),
	    			xls.getCellValue("TC_019", "MainMenu"),
	    			xls.getCellValue("TC_019", "SubMenu"),
	    			xls.getCellValue("TC_019", "From"),
	    			xls.getCellValue("TC_019", "To"),
	    			xls.getCellValue("TC_019", "Origin"),
	    			xls.getCellValue("TC_019", "Destination"),
	    			xls.getCellValue("TC_019", "Reason"),
	    			xls.getCellValue("TC_019", "AffectedStation"),
	    			xls.getCellValue("TC_019", "Communication"),
	    		
	    			
	    			"To verify IVR/SMS Information in Aims Uploader"
	    		}};
	}

}

