package com.qa.mob.keyword.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base 
{
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(String browserName)
	{
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\PERENNIAL-QA\\Desktop\\Gaurav\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\PERENNIAL-QA\\Desktop\\Gaurav\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.internetexplorer.driver", "C:\\Users\\PERENNIAL-QA\\Desktop\\Gaurav\\Drivers\\iedriver.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
		
	}
	
	
	public Properties init_prop()
	{
		prop = new Properties();
		try 
		{
			FileInputStream ip = new FileInputStream("C:\\Users\\PERENNIAL-QA\\Desktop\\Gaurav\\Eclipse Workspace\\KeywordDrive91Mobiles\\src\\main\\java\\com\\qa"
					+ "\\mob\\keyword\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}

	
}
