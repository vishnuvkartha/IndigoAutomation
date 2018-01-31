package com.desktopWeb.testObjects;

import org.openqa.selenium.By;

import com.ctaf.accelerators.ActionEngine;

public class PageLocators extends ActionEngine{
	
	public static By learnBaicWindowclose = By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']");
	

	
	
	
       //OCC-Manual Flight Cancellation
		
		public static By Indigo_Username = By.id("txtUserName");
		public static By Indigo_Password = By.id("txtPassword");	
		public static By Indigo_Login = By.xpath("//input[@value='Login']");
		public static By Indigo_MenuOptions = By.xpath(".//*[@id='showLeft']");
		public static By Indigo_MainMenu(String menu)
	    {
	           return By.xpath("//span[contains(text(),'"+menu+"')]");
	    }
		public static By Indigo_SubMenu(String function)
	    {
	           return By.xpath("//a[contains(text(),'"+function+"')]");
	    }
		public static By Indigo_SubMenu1(String function)
	    {
	           return By.xpath("(//a[contains(text(),'"+function+"')])[last()]");
	    }
	
		public static By MFC_FromDate = By.id("TxtFromDate");
		public static By MFC_FromCalender = By.xpath("(//div[@class='xdsoft_calendar'])[last()-1]//tr[5]//td//div");
		public static By MFC_FromCalender1 = By.xpath("(//div[@class='xdsoft_calendar'])[last()-3]//tr[5]//td//div");
		public static By MFC_ToDate = By.id("TxtToDate");
		public static By MFC_ToCalender = By.xpath("(//div[@class='xdsoft_calendar'])[last()]//td//div");
		public static By MFC_ToCalender1 = By.xpath("(//div[@class='xdsoft_calendar'])[last()-2]//td//div");
		public static By MFC_Origin = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-1]");
		public static By MFC_OriginPlaces(String place)
	    {
	           return By.xpath("//li[text()='"+place+"']");
	    }
		public static By MFC_Destination = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()]");
		public static By MFC_DestinationPlaces(String place)
	    {
	           return By.xpath("(//li[text()='"+place+"'])[last()]");
	    }
		public static By MFC_FlightNo = By.xpath("//div[@class='ms-options-wrap']//button");
		public static By MFC_FlightNoSelectAll = By.xpath("//input[@type='checkbox'][@value='Select All']");
		public static By MFC_FlightNoSelectFirst = By.xpath("//div[@class='ms-options']//ul//li//label");
		public static By MFC_GenerateButton = By.id("btnGenerate");
		public static By MFC_SelectAllCheckBox = By.xpath("//input[@id='selectallFlight']");
		public static By MFC_DelayReason = By.xpath("//input[@placeholder='Delay Reason']");
		public static By MFC_DelayReasons(String reason)
	    {
	           return By.xpath("//a[text()='"+reason+"']");
	    }
		public static By MFC_AffectedStation = By.xpath("//p[text()='Affected Station']");
	
		public static By MFC_AffectedStations(String place)
	    {
	           return By.xpath("//li[contains(text(),'"+place+"')]");
	    }
	
		public static By MFC_FlightInfo = By.xpath("//table[@class='clear-on-reset']//tr[2]//td[1]");
		public static By MFC_ETD = By.xpath("//table[@class='clear-on-reset']//tr[2]//td[3]");
		public static By MFC_TailNo = By.xpath("//table[@class='clear-on-reset']//tr[2]//td[4]");
		public static By MFC_SMSIVRPopup = By.xpath("//div[@id='ActionPopup']");
		public static By MFC_SMSIcon = By.xpath("//img[@src='/UCGWebApp_QA/images/sms_icon.png']");
		public static By MFC_IVRIcon = By.xpath("//img[@src='/UCGWebApp_QA/images/ivr_icon.png']");
		public static By MFC_SendButton = By.id("SendAll_Bottom");
		public static By MFC_SMSConfirmation = By.xpath("//div[@id='informationmessage']");
		/*public static By MFC_SMSCheckbox = By.xpath("(//input[@name='SelectedFlight'])[last()-1]");
		public static By MFC_IVRCheckbox = By.xpath("(//input[@name='SelectedFlight'])[last()]");*/
		public static By MFC_SMSCheckbox = By.xpath("//a[text()='SMS']//preceding-sibling::div//input");
		public static By MFC_IVRCheckbox = By.xpath("//a[text()='IVR']//preceding-sibling::div//input");
		public static By OKButton = By.xpath("//span[@class='ui-button-text']");
		public static By OKButton2 = By.xpath("(//span[@class='ui-button-text'])[2]");
	
	
	//Aims Uploader
		
		public static By AU_FirstFlightCheckbox = By.xpath("//div[@class='table_grid mb20']//table//tbody//tr[2]//input");
	
		public static By AU_FlightInfo = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[1]");
		public static By AU_LastNotifiedETD = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[3]");
		public static By AU_PresentETD = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[4]");
		public static By AU_lastNotifiedPax = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[5]");
		public static By AU_PresentPax = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[6]");
		public static By AU_TailNo = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[7]");
		public static By AU_CreatedDTM = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[8]");
		public static By AU_SMSCheckbox = By.xpath("//a[text()='SMS']//preceding-sibling::div");
		public static By AU_IVRCheckbox = By.xpath("//a[text()='IVR']//preceding-sibling::div");
	
		public static By AU_Boarded = By.xpath("//label[text()='Boarded']");
	
		
		public static By AU_TailReason = By.xpath("//a[@href='/UCGWebApp_QA/TailReason/Index']");
		public static By AU_History = By.xpath("//a[@href='/UCGWebApp_QA/Flight_Search/OCCFlightSearch?p1=7']");
		public static By AU_TailNumber = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-1]");
		public static By AU_ReasonRemark = By.xpath("(//div[@class='selectric'])[last()-1]");
		public static By AU_AffectedStation = By.xpath("(//div[@class='selectric'])[last()]");
		public static By AU_SaveAll = By.xpath("//input[@id='SaveAll']");
		public static By AU_FlifoUpdate = By.xpath("//input[@id='chkNotifyFLIFOUpdate']");
		public static By AU_Delete = By.xpath("//input[@id='DeleteAll_Bottom']");
	
	
	
	// PAX SMS
		
	
		public static By PAX_FligntNo = By.xpath("//div[@class='ms-options-wrap']//button");
		public static By PAX_Origin = By.xpath("//div[@class='selectricWrapper selectric-form-control']");
		
		// Passenger Adhoc
		
		
		public static By PAD_FlightType = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-4]");
		public static By PAD_LegType = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-3]");		
		public static By PAD_Origin = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-2]");
		public static By PAD_Destination = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-1]");
		public static By PAD_SMSTemplate = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()]");
	
		public static By PAD_FlightTypes(String type)
	    {
	           return By.xpath("//li[text()='"+type+"']");
	    }
		public static By PAD_LegTypes(String type)
	    {
	           return By.xpath("//li[text()='"+type+"']");
	    }
	
		public static By PAD_GenerateButton = By.id("BtnGenerate");
	
	
		public static By PAD_FlightInfo = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[1]");
		public static By PAD_Pending = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[3]");
		public static By PAD_Initiated = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[4]");
		public static By PAD_Success = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[5]");
		public static By PAD_Awaited = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[6]");
		public static By PAD_Failed = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[7]");
		public static By PAD_LastNotifiedTime = By.xpath("//div[@class='table_grid mb20']//tr[2]//td[8]");
	
	
	//Crew Adhoc Message
	
	
		public static By CAM_Origin = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[4]");
		public static By CAM_Destination = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-3]");
		public static By CAM_CrewType = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-2]");
		public static By CAM_FlightStatus = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-1]");
		public static By CAM_SMSTemplate = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()]");
		public static By CAM_CrewNotificationType = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-7]");
		public static By CAM_CrewType1 = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-6]");
		public static By CAM_Base = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-5]");
	
		
		public static By CAM_StartTime = By.id("TxtStartTime");
		public static By CAM_StartTime(String type)
	    {
	           return By.xpath("//div[@class='xdsoft_time '][contains(text(),'"+type+"')]");
	    }
		public static By CAM_EndTime = By.id("TxtEndTime");
		public static By CAM_CCNo = By.id("TxtCCNos");
	
		public static By Submenu(String type)
	    {
	           return By.xpath("((//div[@class='selectricScroll'])//ul//li[text()='"+type+"'])[2]");
	    }
		public static By CAM_Base(String type)
	    {
	           return By.xpath("((//div[@class='selectricScroll'])//ul//li[text()='"+type+"'])[1]");
	    }
	
		public static By CAM_SMS = By.xpath("//label[text()='SMS']//preceding-sibling::div//input");
		public static By CAM_Send = By.xpath("//input[@id='BtnSend']");
	
		public static By DropdownItems(String type)
	    {
	           return By.xpath("(//li[text()='"+type+"'])[last()]");
	    }
		
		//Schedule Passenger Message
		public static By SPM_SchedulerName(int row,int col)
	    {
	           return  By.xpath("//div[@class='table_grid mb10']//tr["+row+"]//td["+col+"]");
	    }
		public static By SPM_SchedulerStartDate(int row,int col)
	    {
			 return  By.xpath("//div[@class='table_grid mb10']//tr["+row+"]//td["+col+"]");
	    }
		public static By SchedulerEndDate(int row,int col)
	    {
			 return  By.xpath("//div[@class='table_grid mb10']//tr["+row+"]//td["+col+"]");
	    }
		public static By SPM_SchedulerTime(int row,int col)
	    {
			 return  By.xpath("//div[@class='table_grid mb10']//tr["+row+"]//td["+col+"]");
	    }
		public static By SPM_Active(int row,int col)
	    {
			 return  By.xpath("//div[@class='table_grid mb10']//tr["+row+"]//td["+col+"]");
	    }
		public static By SPM_SchedulerName = By.xpath("//div[@class='table_grid mb10']//tr[2]//td[1]");
		public static By SPM_SchedulerStartDate = By.xpath("//div[@class='table_grid mb10']//tr[2]//td[2]");
		public static By SchedulerEndDate = By.xpath("//div[@class='table_grid mb10']//tr[2]//td[3]");
		public static By SPM_SchedulerTime = By.xpath("//div[@class='table_grid mb10']//tr[2]//td[4]");
		public static By SPM_Active = By.xpath("//div[@class='table_grid mb10']//tr[2]//td[5]");
		public static By SPM_Search = By.xpath("//input[@id='btnSearch']");
		public static By SPM_SearchArea = By.xpath("//input[@id='txtSchedularNameName']");
		public static By SPM_SchedulerNmae = By.xpath("//input[@id='txtSchedularName']");
		public static By SPM_StartTime= By.id("txtSchedularStartTime");
		public static By SPM_Update= By.id("BtnGenerate");	
		public static By DeleteButton = By.xpath("//span[text()='Delete']");
		public static By Deletelink = By.xpath("//a[text()='Delete']");
		public static By Editlink = By.xpath("//a[text()='Edit']");
		
		//Commercial-PAX Adhoc
		
		public static By CommPAX_FlightType = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[1]");
		public static By CommPAX_LegType = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[2]");
		public static By CommPAX_Origin = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[3]");
		public static By CommPAX_Destination = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[4]");
		public static By CommPAX_EmailTemplate = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[last()-2]");
		public static By CommPAX_IVRTemplate = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[6]");
		public static By CommPAX_SmsTemplate = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[7]");
		public static By CommPAX_PAdhocHeading = By.xpath("//b[text()='Broadcast']");
		public static By CommPAX_EmailIcon = By.xpath("//b[text()='Broadcast']");
		public static By CommPAX_IVR(String place)
	    {
	           return By.xpath("(//li[text()='"+place+"'])[2]");
	    }
		public static By PAX_SMSHyperlink = By.xpath("//a[@title='Click here to preview SMS message']");
		public static By PAX_EmalHyperlink = By.xpath("//a[@title='Click here to preview EMAIL']");
		public static By PAX_IVRHyperlink = By.xpath("//a[@title='Click here to preview IVR message']");
		public static By PAX_EmailIcon = By.xpath("//img[@src='/UCGWebApp_QA/images/email_icon.png']");
		public static By PAX_EmailSubject = By.xpath("//input[@id='TxtEmailSubject']");
		public static By PAX_EmailBody = By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']");
		public static By PAX_SMSBody = By.xpath("//textarea[@id='SMSOtherTemplate']");
		public static By PAX_IVRBody = By.xpath("//textarea[@id='IvrOtherTemplate']");
		public static By PAX_AhocInfoPopup = By.xpath("//div[@id='AdhocMessageinformationmessage']");
		
		
		
		//Commercial-Queue Based Changes
		public static By CommQBC_SelectAllEmail = By.xpath("//input[@id='selectallEmail']");
		public static By CommQBC_SelectAllSMS = By.xpath("//input[@id='selectallSMS']");
		public static By CommQBC_SelectAllIVR = By.xpath("//input[@id='selectallIVR']");
		public static By CommQBC_Queue = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[1]");
		public static By CommQBC_DaysOut = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[2]");
		public static By CommQBC_EmailFirstFlight = By.xpath("(//table[@id='fixTable']//td//input[@type='checkbox'])[2]");
		public static By CommQBC_SMSFirstFlight = By.xpath("(//table[@id='fixTable']//td//input[@type='checkbox'])[3]");
		public static By CommQBC_IVRFirstFlight = By.xpath("(//table[@id='fixTable']//td//input[@type='checkbox'])[4]");
		public static By CommQBC_EmailSecondFlight = By.xpath("(//table[@id='fixTable']//td//input[@type='checkbox'])[8]");
		public static By CommQBC_SMSSecondFlight = By.xpath("(//table[@id='fixTable']//td//input[@type='checkbox'])[9]");
		public static By CommQBC_IVRSecondFlight = By.xpath("(//table[@id='fixTable']//td//input[@type='checkbox'])[10]");
		public static By CommQBC_FlightType = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[3]");
		public static By CommQBC_Origin = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[4]");
		public static By CommQBC_Destination = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[5]");
		public static By CommQBC_FlightInfoTable = By.xpath("//table[@id='fixTable']//tr");
		public static By CommQBC_ResetButton = By.xpath("//input[@id='btnReset']");
		public static By CommQBC_b_Heading = By.xpath("//b[text()='Queue Based Changes']");
		public static By CommQBC_btn_SendAll = By.id("SendAllFlight");
		public static By CommQBC_btn_SendInConfirmation = By.xpath("//span[@class='ui-button-text'][text()='Send']");
		public static By CommQBC_btn_ExporttoExcel = By.className("exel_btn");
		public static By CommQBC_btn_Close = By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[4]");
		public static By CommQBC_Starttime(String type)
	    {
	           return By.xpath("(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_'][3])//div[@class='xdsoft_time '][contains(text(),'"+type+"')]");
	    }
		
		public static By CommQBC_Endtime(String type)
	    {
			 return By.xpath("(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_'][4])//div[@class='xdsoft_time '][contains(text(),'"+type+"')]");
	    }
		//Commercial-Broadcast Message
		
		public static By CommBM_SMSTemplate = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[1]");
		public static By CommBM_IVRTemplate = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[7]");
		public static By CommBM_EmailTemplate = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[2]");
		public static By CommBM_PreviewButton = By.xpath("//input[@id='BtnPreview']");
		public static By CommBM_BroadcastHeading = By.xpath("//b[text()='Broadcast']");
		public static By CommBM_UploadExcel = By.xpath("//input[@id='txtUploadFile']");
		public static By CommBM_DownloadFile = By.xpath("//a[@id='GenerateFile']");
		public static By CommBM_SMSIcon = By.xpath("//img[@src='..\\Images\\smsIcon.png']");
		public static By CommBM_EmailIcon = By.xpath("//img[@src='..\\Images\\mailIcon.png']");
		public static By CommBM_EmailPopup = By.xpath("//div[@id='messageplaceholder']");
		public static By CommBM_chk_SelectSMS = By.xpath("//input[@id='selectall_SMS']");
		public static By CommBM_chk_SelectEmail = By.xpath("//input[@id='selectall_EMAIL']");
		
        //Commercial- Queue Approval
		public static By CommQA_b_Heading = By.xpath("//b[text()='Queue Approval']");
		public static By CommQA_drd_Queue = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[1]");
		public static By CommQA_btn_Approve = By.xpath("//a[@id='ApproveAll']");
		public static By CommQA_str_SubQueue = By.xpath("//strong[text()='Sub Queue:']");
		public static By CommQA_str_TotalPNR = By.xpath("//strong[text()='Total PNR:']");
		public static By CommQA_btn_Search = By.xpath("//input[@id='SubmitCommand']");
		public static By CommQA_btn_ExportToExcel = By.xpath("//input[@id='ExportToExcel']");
		public static By CommQA__hyp_SMSHyperlink = By.xpath("//a[text()='SMS'][@title='click to view PNR details']");
		public static By CommQA_hyp_PAX_EmalHyperlink = By.xpath("//a[text()='EMAIL'][@title='click to view PNR details']");
		public static By CommQA_hyp_PAX_IVRHyperlink = By.xpath("//a[text()='IVR'][@title='click to view PNR details']");
		public static By CommQA_btn_TemplateCancelButton = By.xpath("//input[@id='btnCloseDialogBoxSendMessage']");
		public static By CommQA_btn_TemplateExportExcelButton = By.xpath("//input[@id='buttonExportToExcel']");
		public static By CommQA_btn_processedQueue = By.id("radio1");
		public static By CommQA_btn_unprocessedQueue = By.id("radio2");
		public static By CommQA_chk_SelectAll = By.id("selectallQueue");
		public static By CommQA_chk_SelectAFlight = By.xpath("(//div[@class='Checkbox']//input)[4]");
		public static By CommQA_chk_SelectAFlight1 = By.xpath("(//div[@class='Checkbox']//input)[2]");
		public static By CommQA_chk_SelectAFlightName = By.xpath("//a[@class='l_link']");
		
		
		
		public static By CommQA_opt_QueueOptions(String options)
	    {
	           return By.xpath("//li[text()='"+options+"']");
	    }
		
		//MIS
		
		//Flight Search
		
		public static By MIS_FS_b_Heading = By.xpath("//b[text()='Flight Search']");
		public static By MIS_FS_drd_Origin = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[1]");
		public static By MIS_FS_drd_Destination = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[2]");
		public static By MIS_FS_drd_CommType = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[3]");
		public static By MIS_FS_drd_Status = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[4]");
		public static By MIS_FS_drd_Application = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[5]");
		public static By MIS_FS_btn_Search = By.id("btnSearch");
		public static By MIS_FS_btn_Reset = By.id("btnReset");
		public static By MIS_FS_btn_ExportToExcel = By.name("SubmitCommand");
		public static By MIS_FS_td_SearchResultSentBy = By.xpath("//table[@class='clear-on-reset']//tr[2]//td[9]");
        
		//Generic search
		public static By MIS_GS_b_Heading = By.xpath("//b[text()='Generic Search']");
		public static By MIS_GS_drd_Department = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[2]");
		public static By MIS_GS_drd_Queue = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[4]");
		public static By MIS_GS_drd_CommType = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[1]");
		public static By MIS_GS_drd_Status = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[6]");
		public static By MIS_GS_drd_Application = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[3]");
		public static By MIS_GS_drd_DaysOut = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[5]");
		public static By MIS_GS_btn_Search = By.id("btnSearch");
		public static By MIS_GS_btn_Reset = By.id("btnReset");
		public static By MIS_GS_btn_ExportToExcel = By.name("SubmitCommand");
		
		//Customer search
				public static By MIS_CS_b_Heading = By.xpath("//b[text()='Customer Search']");
				public static By MIS_CS_date_FlightDate = By.id("TxtFlightDate");
				public static By MIS_CS_date_Calender = By.xpath("(//div[@class='xdsoft_calendar'])//td//div");
				public static By MIS_CS_txt_FlightNo = By.id("txtFlightNumber");
				public static By MIS_CS_txt_PNRNo = By.id("txtPnr");
				public static By MIS_CS_txt_MobNo = By.id("txtCellNo");
				public static By MIS_CS_txt_Email = By.id("txtEmailId");
				public static By MIS_CS_txt_SentBy = By.id("txtSentBy");
				public static By MIS_CS_drd_CommType = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[1]");
				public static By MIS_CS_drd_Application = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[2]");
				public static By MIS_CS_btn_Search = By.id("btnSearch");
				public static By MIS_CS_btn_Reset = By.id("btnReset");
				public static By MIS_CS_btn_ExportToExcel = By.name("SubmitCommand");
				public static By MIS_CS_td_PNRCol = By.xpath("//table[@id='fixTable']//tr[1]//td[3]");
				public static By MIS_CS_td_MobCol = By.xpath("//table[@id='fixTable']//tr[1]//td[2]");
				
				//Customer search OCC
				public static By MIS_CSOCC_b_Heading = By.xpath("//b[text()='Customer Search']");
				public static By MIS_CSOCC_date_FlightDate = By.id("TxtFlightDate");
				public static By MIS_CSOCC_date_Calender = By.xpath("(//div[@class='xdsoft_calendar'])//td//div");
				public static By MIS_CSOCC_txt_FlightNo = By.id("txtFlightNumber");
				public static By MIS_CSOCC_txt_PNRNo = By.id("txtPnr");
				public static By MIS_CSOCC_txt_MobNo = By.id("txtCellNo");
				public static By MIS_CSOCC_txt_Email = By.id("txtEmailId");
				public static By MIS_CSOCC_txt_SentBy = By.id("txtSentBy");
				public static By MIS_CSOCC_drd_CommType = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[1]");
				public static By MIS_CSOCC_drd_Application = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[2]");
				public static By MIS_CSOCC_drd_UserGroup = By.xpath("(//div[@class='selectricWrapper selectric-form-control'])[3]");
				public static By MIS_CSOCC_btn_Search = By.id("btnSearch");
				public static By MIS_CSOCC_btn_Reset = By.id("btnReset");
				public static By MIS_CSOCC_btn_ExportToExcel = By.name("SubmitCommand");
				public static By MIS_CSOCC_td_PNRCol = By.xpath("//table[@id='fixTable']//tr[1]//td[3]");
				public static By MIS_CSOCC_td_MobCol = By.xpath("//table[@id='fixTable']//tr[1]//td[2]");
		
}
