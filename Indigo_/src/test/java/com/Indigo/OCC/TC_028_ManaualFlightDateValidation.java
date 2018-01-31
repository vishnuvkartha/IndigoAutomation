package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_028_ManaualFlightDateValidation extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_028_ManaualFlightDateValidation(String Username,String Password,String Mainmenu,String Submenu,String From,String To,String Origin,
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
			Reporter.SuccessReport("TC_028", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_028,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_028", "Username"),
	    			xls.getCellValue("TC_028", "Password"),
	    			xls.getCellValue("TC_028", "MainMenu"),
	    			xls.getCellValue("TC_028", "SubMenu"),
	    			xls.getCellValue("TC_028", "From"),
	    			xls.getCellValue("TC_028", "To"),
	    			xls.getCellValue("TC_028", "Origin"),
	    			xls.getCellValue("TC_028", "Destination"),
	    			xls.getCellValue("TC_028", "Reason"),
	    			xls.getCellValue("TC_028", "AffectedStation"),
	    			xls.getCellValue("TC_028", "Communication"),
	    		
	    			
	    			"To verify the Manual Flight Cancellation Date Validation"
	    		}};
	}

}

