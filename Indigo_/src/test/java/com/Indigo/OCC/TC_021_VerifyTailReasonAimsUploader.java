package com.Indigo.OCC;





import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;
import com.desktopWeb.workflows.HelperClass;

public class TC_021_VerifyTailReasonAimsUploader extends HelperClass {
	
	ExcelReader xls = new ExcelReader(configProps.getProperty("TestData"),"Web_Home");
	
	@Test(dataProvider = "testData")
	public void TC_021(String Username,String Password,String Mainmenu,String Submenu,String tailno,String reason,String AffectedStation,String testdescription) throws Throwable {
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
			ClickOKButton();
			AU_SelectAffectedStation(AffectedStation);
			AU_ClickSave();
			VerifyConfirmation();
			Reporter.SuccessReport("TC_021", "Passed");
		}catch(Exception e){
			Reporter.failureReport("TC_021,Exception message is "+e.getStackTrace().toString()+e.getMessage(), "Failed");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] createdata1() {
	    return new Object[][] { 
	    		{
	    			xls.getCellValue("TC_021", "Username"),
	    			xls.getCellValue("TC_021", "Password"),
	    			xls.getCellValue("TC_021", "MainMenu"),
	    			xls.getCellValue("TC_021", "SubMenu"),
	    			xls.getCellValue("TC_021", "Tailno"),
	    		
	    			xls.getCellValue("TC_021", "Reason"),
	    			xls.getCellValue("TC_021", "AffectedStation"),
	    			
	    		
	    			
	    			"To verify Tail Reason in Aims Uploader"
	    		}};
	}

}

