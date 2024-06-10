import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By

for (int row = 1; row <= findTestData('challenge3_csvFile').getRowNumbers(); row++) {
    WebUI.openBrowser('')

    WebUI.navigateToUrl('https://journey.missionnext.org/journey-home/login-here/?_ga=2.129357512.577224682.1714944352-1362560386.1712898014')

    WebUI.maximizeWindow()

    def element = findTestObject('closingIcon/Page_Login - Journey/i__eicon-close')

    if (WebUI.waitForElementVisible(element, 3)) {
        WebUI.click(findTestObject('closingIcon/Page_Login - Journey/i__eicon-close'))
    }
    
    String data = TestDataFactory.findTestData('Data Files/Challenge3_csvFile')

    //WebUI.setText(findTestObject('loginpageElements/Page_Login - Journey/input_Username_log'), username)
    WebUI.setText(findTestObject('loginpageElements/Page_Login - Journey/input_Username_log'), findTestData('challenge3_csvFile').getValue(
            1, row))

    //WebUI.setEncryptedText(findTestObject('loginpageElements/Page_Login - Journey/input_Password_pwd'), password)
    WebUI.setEncryptedText(findTestObject('loginpageElements/Page_Login - Journey/input_Password_pwd'), findTestData('challenge3_csvFile').getValue(
            2, row))

   WebUI.setText(findTestObject('loginpageElements/Page_Login - Journey/input_Password_pwd'), findTestData('challenge3_csvFile').getValue(
            2, row))
    WebUI.click(findTestObject('loginpageElements/Page_Login - Journey/button_Log In'))

    WebUI.delay(3)

    if (WebUI.verifyElementPresent(findTestObject('verificationLogin/Page_Journey/div_Partners_background'), 10)) {
        System.out.println(findTestData('challenge3_csvFile').getValue(1, row) + ' has successfully logged in !')

        WebUI.verifyElementPresent(findTestObject('verificationLogin/Page_Journey/div_Partners_background'), 2)
    }
    
    if (findTestData('challenge3_csvFile').getValue(3, row).equals('About')) {
        WebUI.focus(findTestObject('ObjectFocus/Page_Journey/a_About'))

        WebUI.click(findTestObject('navigationTopics/Page_Journey/a_Impact Report'))
		if (WebUI.waitForElementVisible(element, 5)) {
			WebUI.click(findTestObject('closingIcon/Page_Login - Journey/i__eicon-close'))
		}
		if (WebUI.verifyElementPresent(findTestObject('checkingelementNavigation/Page_Impact Report Archives - MissionNext.org/div_2023 ANNUAL IMPACT REPORTRead MoreBrad BensonApril 26, 20242022 ANNUAL IMPACT REPORTRead MorewebmasterJanuary 23, 20232021 ANNUAL IMPACT REPORTRead MoreApril 3, 20222020 ANNUAL IMPACT REPORTRead MoreJuly 23, 2020'), 5)) {
			System.out.println('Welcome to the About section of impact report!')
		}
		WebUI.delay(2)
		
		WebUI.closeBrowser()
			
    }
	
	else if(findTestData('challenge3_csvFile').getValue(3, row).equals('Goer')) {
        WebUI.focus(findTestObject('ObjectFocus/Page_Journey/a_Goer'))

        WebUI.click(findTestObject('navigationTopics/Page_Journey/a_Jobs'))
		if (WebUI.waitForElementVisible(element, 5)) {
			WebUI.click(findTestObject('closingIcon/Page_Login - Journey/i__eicon-close'))
		}
		if (WebUI.verifyElementPresent(findTestObject('checkingelementNavigation/Page_Positions - MissionNext.org/div_Journey PositionsFind a wide range of ministry positions in all major Job Categories through MissionNext Journey.Click Here'), 5)) {
			System.out.println('Welcome to the Goer section of Jobs !')
		}
		WebUI.delay(2)
		
		WebUI.closeBrowser()
			
    }
	
	else if(findTestData('challenge3_csvFile').getValue(3, row).equals('Sender')) {
		WebUI.focus(findTestObject('ObjectFocus/Page_Journey/a_Sender'))

		WebUI.click(findTestObject('navigationTopics/Page_Journey/a_Schools'))
		if (WebUI.waitForElementVisible(element, 5)) {
			WebUI.click(findTestObject('closingIcon/Page_Login - Journey/i__eicon-close'))
		}
		if (WebUI.verifyElementPresent(findTestObject('checkingelementNavigation/Page_Im a School - Education/h4_Connecting Gods People with Opportunities to Serve the Lord Among the Nations'), 5)) {
			System.out.println('Welcome to the Sender section of Schools !')
		}
		WebUI.delay(2)
		
		WebUI.closeBrowser()
			
	}
	 else {
        WebUI.delay(2)
		
        WebUI.closeBrowser()
    }
}

