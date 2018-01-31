package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_014_VerifyPasengerAdhocMessagBySelectingSMSOption extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_014_VerifyPasengerAdhocMessagBySelectingSMSOption(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String FlightType,String LegType,String SMSTemplate,String Origin,
			String Destination,	String reason,String station,String communication,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			SelectFromDate(From);
			SelectToDate(To);
			PAD_SelectFlightType(FlightType);
			PAD_SelectLegType(LegType);
			PAD_SelectOrigin(Origin);
			PAD_SelectDestination(Destination);
			SelectFlightNo();
			PAD_SMSTemplate(SMSTemplate);
			PAD_ClickGenerate();
			AU_SelectFirstFlight();
			SelectCommunicationOption(communication);
			PAD_GetFlightDetails();
			ClickSendButton();
			VerifyAdhocConfirmation();
			ClickOKButton();
			Reporter.SuccessReport("TC_014", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_014,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_014", "Username"),
	    			xls.getCellValue("TC_014", "Password"),
	    			xls.getCellValue("TC_014", "MainMenu"),
	    			xls.getCellValue("TC_014", "SubMenu"),
	    			xls.getCellValue("TC_014", "From"),
	    			xls.getCellValue("TC_014", "To"),
	    			xls.getCellValue("TC_014", "FlightType"),
	    			xls.getCellValue("TC_014", "LegType"),
	    			xls.getCellValue("TC_014", "SMSTemplate"),
	    			xls.getCellValue("TC_014", "Origin"),
	    			xls.getCellValue("TC_014", "Destination"),
	    			
	    			xls.getCellValue("TC_014", "Reason"),
	    			xls.getCellValue("TC_014", "AffectedStation"),
	    			xls.getCellValue("TC_014", "Communication"),
	    		
	    			
	    			"To verify the Pasenger Adhoc Message tab by selecting SMS option"
	    		}};
	}

}

