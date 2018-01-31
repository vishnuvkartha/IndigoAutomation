package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_029_PAXSMSDateValidation extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_029_PAXSMSDateValidation(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,
			String Destination,	String reason,String station,String communication,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			ClickGenerate();
			VerifyConfirmation();
			ClickOKButton();
			SelectFromDate(From);
			ClickGenerate();
			VerifyConfirmation();
			ClickOKButton();
			SelectToDate(To);
			ClickGenerate();	
			
			Reporter.SuccessReport("TC_029", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_029,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_029", "Username"),
	    			xls.getCellValue("TC_029", "Password"),
	    			xls.getCellValue("TC_029", "MainMenu"),
	    			xls.getCellValue("TC_029", "SubMenu"),
	    			xls.getCellValue("TC_029", "From"),
	    			xls.getCellValue("TC_029", "To"),
	    			xls.getCellValue("TC_029", "Origin"),
	    			xls.getCellValue("TC_029", "Destination"),
	    			xls.getCellValue("TC_029", "Reason"),
	    			xls.getCellValue("TC_029", "AffectedStation"),
	    			xls.getCellValue("TC_029", "Communication"),
	    		
	    			
	    			"To verify PAX SMS/IVR Manual by selecting IVR Option"
	    		}};
	}

}

