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
import java.sql.PreparedStatement
import java.sql.SQLException
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory




String url = "jdbc:postgresql://localhost:5432/postgres"
String user = "postgres"
String password = "Nicolas3"

// Load CSV data 
TestData csvData = findTestData('Challenge3_csvFile') 



Connection connection = null
try {
	connection = DriverManager.getConnection(url, user, password)
	println("Connected to the database successfully.")
} catch (SQLException e) {
	println(e.getMessage())
}


if (connection == null) {
	println("Connection fails")
	return
}

// Inserting data into the database
String query = "INSERT INTO public.theusers (column1, column2, column3) VALUES (?, ?, ?)"
PreparedStatement pstmt = connection.prepareStatement(query)



// Loop through CSV data
for (def rowIndex = 1; rowIndex <= csvData.getRowNumbers(); rowIndex++) {
    String column1 = csvData.getValue(1, rowIndex)
    String column2 = csvData.getValue(2, rowIndex)
    String column3 = csvData.getValue(3, rowIndex)

    pstmt.setString(1, column1)
     pstmt.setString(2, column2)
     pstmt.setString(3, column3)
    
}

pstmt.executeBatch()
println("Data has been inserted successfully.")

// Closing 
pstmt.close()
connection.close()