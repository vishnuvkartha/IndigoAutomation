package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_004_VerifyManualFlightCancellationUsingIVROption extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_004(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,
			String Destination,	String reason,String station,String communication,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			SelectFromDate(From);
			SelectToDate(To);
			SelectOrigin(Origin);
			SelectDestination(Destination);
			SelectFlightNo();
			ClickGenerate();
			SelectAllFlightsCheckbox();
			getFlightInfo();
			GetTailNo();
			getETD();
			SelectReason(reason);
			SelectAffectedStation(station);
			SelectCommunicationOption(communication);
			ClickSendButton();
			VerifyConfirmation();
			Reporter.SuccessReport("TC_004", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_004,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_004", "Username"),
	    			xls.getCellValue("TC_004", "Password"),
	    			xls.getCellValue("TC_004", "MainMenu"),
	    			xls.getCellValue("TC_004", "SubMenu"),
	    			xls.getCellValue("TC_004", "From"),
	    			xls.getCellValue("TC_004", "To"),
	    			xls.getCellValue("TC_004", "Origin"),
	    			xls.getCellValue("TC_004", "Destination"),
	    			xls.getCellValue("TC_004", "Reason"),
	    			xls.getCellValue("TC_004", "AffectedStation"),
	    			xls.getCellValue("TC_004", "Communication"),
	    		
	    			
	    			"To verify the Manual Flight Cancellation using IVR Option"
	    		}};
	}

}

