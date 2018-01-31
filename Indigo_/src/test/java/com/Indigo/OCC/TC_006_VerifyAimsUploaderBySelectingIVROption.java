package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_006_VerifyAimsUploaderBySelectingIVROption extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_006(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,
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
			SelectAffectedStation(station);
			SelectCommunicationOption(communication);
			ClickSendButton();
			VerifyConfirmation();
			Reporter.SuccessReport("TC_006", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_006,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_006", "Username"),
	    			xls.getCellValue("TC_006", "Password"),
	    			xls.getCellValue("TC_006", "MainMenu"),
	    			xls.getCellValue("TC_006", "SubMenu"),
	    			xls.getCellValue("TC_006", "From"),
	    			xls.getCellValue("TC_006", "To"),
	    			xls.getCellValue("TC_006", "Origin"),
	    			xls.getCellValue("TC_006", "Destination"),
	    			xls.getCellValue("TC_006", "Reason"),
	    			xls.getCellValue("TC_006", "AffectedStation"),
	    			xls.getCellValue("TC_006", "Communication"),
	    		
	    			
	    			"To verify the Aims Uploader by selecting IVR option"
	    		}};
	}

}

