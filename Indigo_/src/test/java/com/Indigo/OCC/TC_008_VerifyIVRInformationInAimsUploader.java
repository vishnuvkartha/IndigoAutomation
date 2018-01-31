package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_008_VerifyIVRInformationInAimsUploader extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_008_VerifyIVRInformationInAimsUploader(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,
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
			VerifyCommunicationTable(communication);
			Reporter.SuccessReport("TC_008", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_008,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_008", "Username"),
	    			xls.getCellValue("TC_008", "Password"),
	    			xls.getCellValue("TC_008", "MainMenu"),
	    			xls.getCellValue("TC_008", "SubMenu"),
	    			xls.getCellValue("TC_008", "From"),
	    			xls.getCellValue("TC_008", "To"),
	    			xls.getCellValue("TC_008", "Origin"),
	    			xls.getCellValue("TC_008", "Destination"),
	    			xls.getCellValue("TC_008", "Reason"),
	    			xls.getCellValue("TC_008", "AffectedStation"),
	    			xls.getCellValue("TC_008", "Communication"),
	    		
	    			
	    			"To verify IVR Information in Aims Uploader"
	    		}};
	}

}

