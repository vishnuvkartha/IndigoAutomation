package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_013_VerifyPaxSMSIVRManualBySelectingSMSOption extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_013(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,
			String Destination,	String reason,String station,String communication,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			SelectFromDate(From);
			SelectToDate(To);
			PAX_SelectOrigin(Origin);
			PAX_SelectFlightNo();
			ClickGenerate();
			AU_SelectFirstFlight();
			getFlightInfo();
			GetTailNo();
			getETD();
			SelectReason(reason);
			SelectAffectedStation(station);
			SelectCommunicationOption(communication);
			ClickSendButton();
			VerifyConfirmation();
			Reporter.SuccessReport("TC_013", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_013,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_013", "Username"),
	    			xls.getCellValue("TC_013", "Password"),
	    			xls.getCellValue("TC_013", "MainMenu"),
	    			xls.getCellValue("TC_013", "SubMenu"),
	    			xls.getCellValue("TC_013", "From"),
	    			xls.getCellValue("TC_013", "To"),
	    			xls.getCellValue("TC_013", "Origin"),
	    			xls.getCellValue("TC_013", "Destination"),
	    			xls.getCellValue("TC_013", "Reason"),
	    			xls.getCellValue("TC_013", "AffectedStation"),
	    			xls.getCellValue("TC_013", "Communication"),
	    		
	    			
	    			"To verify PAX SMS/IVR Manual BY selecting SMS Option"
	    		}};
	}

}

