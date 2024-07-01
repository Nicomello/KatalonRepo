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

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
import java.sql.ResultSet

// Database credentials
String url = "jdbc:postgresql://localhost:5432/postgres"
String user = "postgres"
String password = "Nicolas3"

Connection connection = null
Statement statement = null
ResultSet resultSet = null

try {
	Class.forName("org.postgresql.Driver")

	// make the connection
	connection = DriverManager.getConnection(url, user, password)
	statement = connection.createStatement()

	resultSet = statement.executeQuery('SELECT * from public."theusers"')
	
	int count = 0;
	while (resultSet.next()) {
		if(resultSet.getString("Username"))
			count++;
	}
	
	println("number of rows: "+count);
	
	
	
	
} catch (ClassNotFoundException e) {
	e.printStackTrace()
} catch (SQLException e) {
	e.printStackTrace()
} finally {
	// Close the result set, statement, and connection
	try {
		if (resultSet != null) {
			resultSet.close()
		}
		if (statement != null) {
			statement.close()
		}
		if (connection != null) {
			connection.close()
		}
	} catch (SQLException e) {
		e.printStackTrace()
	}
}
