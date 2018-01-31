package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_002_VerifySMSDetailsInManualFlightCancellation extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_002(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,
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
			VerifyCommunicationTable(communication);
			Reporter.SuccessReport("TC_002", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_002,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_002", "Username"),
	    			xls.getCellValue("TC_002", "Password"),
	    			xls.getCellValue("TC_002", "MainMenu"),
	    			xls.getCellValue("TC_002", "SubMenu"),
	    			xls.getCellValue("TC_002", "From"),
	    			xls.getCellValue("TC_002", "To"),
	    			xls.getCellValue("TC_002", "Origin"),
	    			xls.getCellValue("TC_002", "Destination"),
	    			xls.getCellValue("TC_002", "Reason"),
	    			xls.getCellValue("TC_002", "AffectedStation"),
	    			xls.getCellValue("TC_002", "Communication"),
	    		
	    			
	    			"To verify the SMS Details in Manual Flight Cancellation"
	    		}};
	}

}

