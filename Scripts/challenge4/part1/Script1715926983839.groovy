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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

// login process
WebUI.callTestCase(findTestCase('Challenge/LoginTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.focus(findTestObject('getJobsElement/Page_Education/hoverBtn'))

WebUI.click(findTestObject('getJobsElement/Page_Education/Page_Education/a_Jobs'))

WebUI.click(findTestObject('getJobsElement/Page_Positions - MissionNext.org/journeyJobsClick'))

WebUI.switchToWindowTitle('Journey Missionary Job Summary - MissionNext.org')

WebUI.click(findTestObject('getJobsElement/Page_Journey Missionary Job Summary - MissionNext.org/JobCategory'))

WebUI.delay(2)

	// list of jobs category
	List<String> jobCategories = ['EVANGELISM', 'EDUCATION', 'COMMUNICATIONS']
	
	WebDriver driver = DriverFactory.getWebDriver()
	int totalJobCount = 0
	
	for (String category : jobCategories) {
		WebUI.click(findTestObject('CATEGORIES_JOBS/Page_Journey missionary-jobs-detail - MissionNext.org/a_' + category))
	
		// Wait 
		WebUI.delay(2)
	
		// find the elemenet containing "Job ID"
		List<WebElement> jobIDElements = driver.findElements(By.xpath('//*[contains(text(),\'Job ID\')]'))
	
		// Get the count
		int jobIDCount = jobIDElements.size()
		
		// sum up the job number
		totalJobCount += jobIDCount;
		
		
		// Print
		System.out.println((('Total jobs for category ' + category) + ': ') + jobIDCount)
	
		// Go back
		WebUI.back()
	}
	
	// print total number of jobs in each category
	System.out.println('Total jobs for each category is: ' + totalJobCount);
	WebUI.closeBrowser()
	

	 
