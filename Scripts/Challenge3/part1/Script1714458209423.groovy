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
import org.openqa.selenium.By



for (int row = 1; row <= findTestData('challenge3_csvFile').getRowNumbers(); row++) {
	WebUI.openBrowser('')
    WebUI.navigateToUrl('https://journey.missionnext.org/journey-home/login-here/?_ga=2.129357512.577224682.1714944352-1362560386.1712898014')
	
    WebUI.maximizeWindow()
	
	def element = findTestObject('closingIcon/Page_Login - Journey/i__eicon-close')
	
    if(WebUI.waitForElementVisible( element, 3)) {
	WebUI.click(findTestObject('closingIcon/Page_Login - Journey/i__eicon-close'))
    }
    
    String data = TestDataFactory.findTestData('Data Files/Challenge3_csvFile')

    //WebUI.setText(findTestObject('loginpageElements/Page_Login - Journey/input_Username_log'), username)
    WebUI.setText(findTestObject('loginpageElements/Page_Login - Journey/input_Username_log'), findTestData('challenge3_csvFile').getValue(
            1, row))

    //WebUI.setEncryptedText(findTestObject('loginpageElements/Page_Login - Journey/input_Password_pwd'), password)
    WebUI.setText(findTestObject('loginpageElements/Page_Login - Journey/input_Password_pwd'), findTestData('challenge3_csvFile').getValue(
            2, row) //WebUI.click(findTestObject('loginpageElements/Page_Login - Journey/button_Log In'))
        )
    
		
		
		WebUI.delay(3)
		WebUI.closeBrowser()
}


