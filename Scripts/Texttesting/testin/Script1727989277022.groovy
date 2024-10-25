import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import com.kms.katalon.core.testobject.ConditionType



String url
String dropdownXPath = '//*[@id="nf-field-21"]' 
String optionXPath = '//*[@id="nf-field-21"]/option[2]' 
String expectedElementXPath = '//*[@id="nf-field-23-wrap"]' 
String case1x = '//*[@id="nf-label-field-23-0"]'
String case2x = '//*[@id="nf-label-field-23-1"]'
String case3x = '//*[@id="nf-label-field-23-2"]'

if (GlobalVariable.Domain == 'missionnext') {
	url = 'https://missionnext.org/contact-us/' 
} else if (GlobalVariable.Domain == 'explorenext') {
	url = 'https://explorenext.org/contact-us/' 
}


WebUI.openBrowser(url)


TestObject dropdown = new TestObject('dropdown')
dropdown.addProperty('xpath', ConditionType.EQUALS, dropdownXPath)

TestObject option = new TestObject('option')
option.addProperty('xpath', ConditionType.EQUALS, optionXPath)

TestObject expectedElement = new TestObject('expectedElement')
expectedElement.addProperty('xpath', ConditionType.EQUALS, expectedElementXPath)

TestObject case1 = new TestObject('case1')
case1.addProperty('xpath', ConditionType.EQUALS, case1x)

TestObject case2 = new TestObject('case2')
case2.addProperty('xpath', ConditionType.EQUALS, case2x)

TestObject case3 = new TestObject('case3')
case3.addProperty('xpath', ConditionType.EQUALS, case3x)

try {
	WebUI.click(dropdown)
} catch (Exception e) {
	WebUI.comment("Error: Unable to click the dropdown." + e.getMessage())
	WebUI.closeBrowser()
	throw(e)
}

WebUI.waitForElementVisible(option, 10)

try {
	WebUI.click(option)
} catch (Exception e) {
	WebUI.comment("Error: Unable to click the dropdown option.  " + e.getMessage())
	WebUI.closeBrowser()
	throw(e)
}
WebUI.delay(10)


WebUI.click(case1)
WebUI.delay(2)
WebUI.click(case2)
WebUI.delay(2)
WebUI.click(case3)


try {
	//WebUI.waitForElementVisible(expectedElement, 10)
	WebUI.verifyElementVisible(expectedElement)
} catch (Exception e) {
	WebUI.comment("Error: the 3 options are not appearing in the page. " + e.getMessage())
	WebUI.closeBrowser()
	throw(e)
}
if(WebUI.verifyElementVisible(expectedElement)) {
System.out.println("Element is visible")
}
WebUI.closeBrowser()
