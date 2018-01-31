package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_026_VerifyTailReasonAimsUploader1 extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_026_VerifyTailReasonAimsUploader1(String Username,String Password,String Mainmenu,String Submenu,String tailno,String reason,String AffectedStation,String testdescription) throws Throwable {
		try{					
			TestEngine.testDescription.put(HtmlReportSupport.tc_name, testdescription);
			
			Indigo_Login(Username,Password);
			ClickMenuOptions();
			ClickMainMenu(Mainmenu);
			ClickSubMenu(Submenu);
			AU_ClickTailReason();
			AU_SelectTailNo(tailno);
			AU_ClickSearch();
			AU_SelectTailReason(reason);
			AU_ClickSave();
			
			VerifyConfirmation();
			Reporter.SuccessReport("TC_026", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_026,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_026", "Username"),
	    			xls.getCellValue("TC_026", "Password"),
	    			xls.getCellValue("TC_026", "MainMenu"),
	    			xls.getCellValue("TC_026", "SubMenu"),
	    			xls.getCellValue("TC_026", "Tailno"),	    		
	    			xls.getCellValue("TC_026", "Reason"),
	    			xls.getCellValue("TC_026", "AffectedStation"),
	    			
	    		
	    			
	    			"To verify Tail Reason in Aims Uploader"
	    		}};
	}

}

