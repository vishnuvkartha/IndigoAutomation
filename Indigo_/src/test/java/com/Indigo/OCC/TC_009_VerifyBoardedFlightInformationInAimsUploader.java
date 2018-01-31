package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_009_VerifyBoardedFlightInformationInAimsUploader extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_009(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,
			String Destination,	String reason,String station,String communication,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			AU_ClickBoarded();
			AU_SelectFirstFlight();
			AU_GetFlightDetails();
			
			Reporter.SuccessReport("TC_009", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_009,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_009", "Username"),
	    			xls.getCellValue("TC_009", "Password"),
	    			xls.getCellValue("TC_009", "MainMenu"),
	    			xls.getCellValue("TC_009", "SubMenu"),
	    			xls.getCellValue("TC_009", "From"),
	    			xls.getCellValue("TC_009", "To"),
	    			xls.getCellValue("TC_009", "Origin"),
	    			xls.getCellValue("TC_009", "Destination"),
	    			xls.getCellValue("TC_009", "Reason"),
	    			xls.getCellValue("TC_009", "AffectedStation"),
	    			xls.getCellValue("TC_009", "Communication"),
	    		
	    			
	    			"To verify boarded flight Information in Aims Uploader"
	    		}};
	}

}

