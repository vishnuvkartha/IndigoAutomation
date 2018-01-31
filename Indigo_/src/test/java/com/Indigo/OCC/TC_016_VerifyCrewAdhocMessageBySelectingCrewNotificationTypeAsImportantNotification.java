package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_016_VerifyCrewAdhocMessageBySelectingCrewNotificationTypeAsImportantNotification extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_016_VerifyCrewAdhocMessageBySelectingCrewNotificationTypeAsImportantNotification(String Username,String Password,String Mainmenu,String Submenu,
			String NotificationType,String From,String To,String Origin,
			String Destination,String Starttime,String Endtime,String Crewtype,String FlightStatus,	
			String SMSTemplate,String CCNo,String communication,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			CAM_SelectCrewNotificationType(NotificationType);
			SelectFromDate1(From);
			SelectToDate1(To);
			CAM_SelectOrigin(Origin);
			CAM_SelectDestination(Destination);
			SelectFlightNo();
			CAM_Startime(Starttime);
			CAM_EndTime(Endtime);
			CAM_SelectCrewType(Crewtype,NotificationType);
			CAM_SelectFlightStaus(FlightStatus);
			PAD_SMSTemplate(SMSTemplate);
			CAM_AddCCNo(CCNo);
			PAD_ClickGenerate();
			AU_SelectFirstFlight();
			SelectCommunicationOption(communication);
			ClickSendButton();
			VerifyConfirmation();
			Reporter.SuccessReport("TC_016", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_016,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_016", "Username"),
	    			xls.getCellValue("TC_016", "Password"),
	    			xls.getCellValue("TC_016", "MainMenu"),
	    			xls.getCellValue("TC_016", "SubMenu"),
	    			xls.getCellValue("TC_016", "NotificationType"),
	    			xls.getCellValue("TC_016", "From"),
	    			xls.getCellValue("TC_016", "To"),
	    			xls.getCellValue("TC_016", "Origin"),
	    			xls.getCellValue("TC_016", "Destination"),
	    			xls.getCellValue("TC_016", "Starttime"),
	    			xls.getCellValue("TC_016", "Endtime"),
	    			xls.getCellValue("TC_016", "CrewType"),
	    			xls.getCellValue("TC_016", "FlightStatus"),
	    			xls.getCellValue("TC_016", "SMSTemplate"),
	    			xls.getCellValue("TC_016", "CCNo"),
	    			xls.getCellValue("TC_016", "Communication"),
	    			
	    		
	    			
	    			"To verify Crew Adhoc Message by selecting Crew Notification type as Important Notification"
	    		}};
	}

}

