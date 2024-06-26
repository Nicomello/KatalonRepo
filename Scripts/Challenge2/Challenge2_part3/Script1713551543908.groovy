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
import org.openqa.selenium.WebDriver as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.chrome.ChromeDriver


WebUI.callTestCase(findTestCase('Challenge/LoginTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.focus(findTestObject('getJobsElement/Page_Education/hoverBtn'))

WebUI.click(findTestObject('getJobsElement/Page_Education/Page_Education/a_Jobs'))

WebUI.click(findTestObject('getJobsElement/Page_Positions - MissionNext.org/journeyJobsClick'))

WebUI.switchToWindowTitle('Journey Missionary Job Summary - MissionNext.org')

WebUI.click(findTestObject('getJobsElement/Page_Journey Missionary Job Summary - MissionNext.org/JobCategory'))

WebDriver driver = DriverFactory.getWebDriver()
String ExpectedValue = "EVANGELISM";

WebElement Table = driver.findElement(By.xpath("//table/tbody"))

List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
int rows_count = rows_table.size()
int jobCount = 0
String jobName ="";
Loop:
for (int row = 0; row < rows_count ; row++) {

	List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))
	int columns_count = Columns_row.size()

	for (int column = 0; column < columns_count; column++) {

		String celltext = Columns_row.get(column).getText()
		jobName = ""
		
		if (celltext.contains(ExpectedValue)) {
			
			int position = celltext.indexOf('EVANGELISM')
			
//			char word = celltext.charAt(position)
			while(position != celltext.indexOf('(')) {
				jobName += celltext.charAt(position);
				position++;
				
			}
			
			int pos = celltext.indexOf('(')
			
			String jobNum = celltext.substring(pos+1, celltext.length() - 1)
			System.out.println("Jobs for *** "+jobName+"*** has "+jobNum+" jobs available.")
			jobCount += Integer.parseInt(jobNum)
			
		}
	}
}

System.out.println("The total number of jobs available for both categories of Evangelism is: "+ jobCount)

WebUI.closeBrowser()

