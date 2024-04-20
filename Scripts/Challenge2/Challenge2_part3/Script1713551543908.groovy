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
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver as Keys
import com.kms.katalon.core.webui.driver.DriverFactory






WebUI.callTestCase(findTestCase('Challenge/LoginTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.focus(findTestObject('getJobsElement/Page_Education/hoverBtn'))

WebUI.click(findTestObject('getJobsElement/Page_Education/Page_Education/a_Jobs'))

WebUI.click(findTestObject('getJobsElement/Page_Positions - MissionNext.org/journeyJobsClick'))

WebUI.switchToWindowTitle('Journey Missionary Job Summary - MissionNext.org')

def evangelismCategories = WebUI.findWebElements(By.xpath("//div[contains(@class, 'elementor-widget-container') and contains(text(), 'EVANGELISM')]"))
def totalOpenings = 0


evangelismCategories.each { category ->

 def categoryName = category.text

 def openingsElement = category.findElement(By.xpath("./following-sibling::div[@class='elementor-widget-container']"))
 def openingsCount = openingsElement.text.toInteger()

println("Category: $categoryName and Job Openings: $openingsCount")

totalOpenings += openingsCount
}

println("Total Job Openings Related to Evangelism: $totalOpenings")
WebUI.closeBrowser()

