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

WebUI.callTestCase(findTestCase('Challenge/LoginTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.focus(findTestObject('getJobsElement/Page_Education/hoverBtn'))

WebUI.click(findTestObject('getJobsElement/Page_Education/Page_Education/a_Jobs'))

WebUI.click(findTestObject('getJobsElement/Page_Positions - MissionNext.org/journeyJobsClick'))

WebUI.switchToWindowTitle('Journey Missionary Job Summary - MissionNext.org')

WebUI.click(findTestObject('Object Repository/challenge2/Page_Journey Missionary Job Summary - Missi_d1fec4/span_View Job Details by Category'))

data1 = WebUI.getText(findTestObject('evangelismObj/Page_Journey missionary-jobs-detail - MissionNext.org/td_EVANGELISM (72)'))

data2 = WebUI.getText(findTestObject('evangelismObj/Page_Journey missionary-jobs-detail - MissionNext.org/td_EVANGELISM SUPPORT (16)'))

System.out.println(data1+ " + "+data2+" = "+ 88)

WebUI.closeBrowser()

