package com.qa.mob.keyword.enginer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.mob.keyword.base.Base;

public class KeywordEngine {
	
	Base base;

	public WebDriver driver;
	public Properties prop;
	
	public static Workbook book;
	public static Sheet sheet;
	
	public final String SCENARIO_SHEET_PATH = "C:\\Users\\PERENNIAL-QA\\Desktop\\Gaurav\\Eclipse Workspace\\KeywordDrive91Mobiles\\src\\main\\java\\com\\qa\\mob\\keyword"
			+ "\\scenarios\\Keyword_91mobiles_scenario.xlsx";
	
	public void startExecution(String sheetName) throws InvalidFormatException
	{
		WebElement element;
		List<WebElement> elements;
		String locatorName = null;
		String locatorValue = null;
		FileInputStream file = null;
		try 
		{
			file = new FileInputStream(SCENARIO_SHEET_PATH);
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			book = WorkbookFactory.create(file);
		} 
		catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int k=0;
		sheet = book.getSheet(sheetName);
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			try
			{
			String locator = sheet.getRow(i+1).getCell(k+1).toString().trim();  //id
			String locvalue = sheet.getRow(i+1).getCell(k+2).toString().trim(); //autoSuggestBox
	
			
			String action = sheet.getRow(i+1).getCell(k+3).toString().trim();
			String value = sheet.getRow(i+1).getCell(k+4).toString().trim();
			
		 	switch(action)
			{
			 
			case "open browser":
				base = new Base();
				prop = base.init_prop();
				if(value.isEmpty() || value.equals("NA"))
				{
					driver = base.init_driver(prop.getProperty("browser"));
				}
				else
				{
					driver = base.init_driver(value);
				}
				break;
				
			case "enter url" :
				if(value.isEmpty() || value.equals("NA"))
				{
					driver.get(prop.getProperty("url"));
				}
				else
				{
					driver.get(value);
				}
				break;
				
			case "quit" :
				driver.quit();
				break;
				
				default:
					break;
			}
			
			switch (locator) 
			{
			 case "id":
				 element = driver.findElement(By.id(locvalue));
				if(action.equalsIgnoreCase("sendkeys"))
				{
					element.clear();
					element.sendKeys(value);
				}
				else if(action.equalsIgnoreCase("click"))
				{
					element.click();
				}
				locator=null;
				break;
				
			 case "xpath":
				 element = driver.findElement(By.xpath(locvalue));
				 if(action.equalsIgnoreCase("verify"))
				 {
					 String cattext = element.getText();
				     if(cattext.equals("apple mobile"))
				    	 System.out.println("title matched");
				 }
				 else if(action.equalsIgnoreCase("print mobile name"))
				 {
					 elements = driver.findElements(By.xpath(locvalue));
					 for(WebElement e : elements)
					 {
						 String st = e.getText();
						 System.out.println(st);
					 }
				 }
				   break;

			  default:
				break;
			}
		}
			catch(Exception e)
			{
				
			}
			
		}
	}

}
