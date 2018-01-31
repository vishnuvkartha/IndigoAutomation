package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_017_VerifyCrewAdhocMessageBySelectingCrewNotificationTypeAsGeneralBroadcast extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_017(String Username,String Password,String Mainmenu,String Submenu,
			String NotificationType,String From,String To,String Origin,
			String Destination,String Starttime,String Endtime,String Crewtype,String base,String FlightStatus,	
			String SMSTemplate,String CCNo,String communication,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			CAM_SelectCrewNotificationType(NotificationType);
			CAM_SelectCrewType(Crewtype,NotificationType);
			CAM_SelectBase(base);
			PAD_SMSTemplate(SMSTemplate);
			CAM_AddCCNo(CCNo);
			PAD_ClickGenerate();
			SelectSMS();
			CAM_ClickSend();
			
			VerifyConfirmation();
			Reporter.SuccessReport("TC_017", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_017,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_017", "Username"),
	    			xls.getCellValue("TC_017", "Password"),
	    			xls.getCellValue("TC_017", "MainMenu"),
	    			xls.getCellValue("TC_017", "SubMenu"),
	    			xls.getCellValue("TC_017", "NotificationType"),
	    			xls.getCellValue("TC_017", "From"),
	    			xls.getCellValue("TC_017", "To"),
	    			xls.getCellValue("TC_017", "Origin"),
	    			xls.getCellValue("TC_017", "Destination"),
	    			xls.getCellValue("TC_017", "Starttime"),
	    			xls.getCellValue("TC_017", "Endtime"),
	    			xls.getCellValue("TC_017", "CrewType"),
	    			xls.getCellValue("TC_017", "Base"),
	    			xls.getCellValue("TC_017", "FlightStatus"),
	    			xls.getCellValue("TC_017", "SMSTemplate"),
	    			xls.getCellValue("TC_017", "CCNo"),
	    			xls.getCellValue("TC_017", "Communication"),
	    			
	    		
	    			
	    			"To verify Crew Adhoc Message by selecting Crew Notification type as General Broadcast"
	    		}};
	}

}

