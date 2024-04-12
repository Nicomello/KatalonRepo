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

WebUI.openBrowser('https://education.missionnext.org/education-home/login-here/?_ga=2.165430015.1920693411.1712898015-1362560386.1712898014')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/challenge2/Page_Login - Education/i_Safari by Apple_eicon-close'))

WebUI.sendKeys(findTestObject('LoginElements/Page_Login - Education/userName'), 'nicolasf77')

WebUI.sendKeys(findTestObject('LoginElements/Page_Login - Education/password'), 'chicodens10')

WebUI.click(findTestObject('LoginElements/Page_Login - Education/submitBtn'))

WebUI.verifyElementPresent(findTestObject('LoginElements/Page_Education/div_Partners_background'), 10)

WebUI.focus(findTestObject('getJobsElement/Page_Education/hoverBtn'))

WebUI.click(findTestObject('getJobsElement/Page_Education/Page_Education/a_Jobs'))

WebUI.click(findTestObject('getJobsElement/Page_Positions - MissionNext.org/journeyJobsClick'))

WebUI.switchToWindowTitle('Journey Missionary Job Summary - MissionNext.org')

WebUI.click(findTestObject('Object Repository/challenge2/Page_Journey Missionary Job Summary - Missi_d1fec4/span_View Job Details by Category'))

print('number of jobs for: ' + WebUI.getText(findTestObject('getJobsElement/Page_Journey missionary-jobs-detail - MissionNext.org/EvangelismTxt')))

WebUI.closeBrowser()

