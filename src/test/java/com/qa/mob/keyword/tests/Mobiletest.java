package com.qa.mob.keyword.tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.qa.mob.keyword.enginer.KeywordEngine;

public class Mobiletest 
{
	public static KeywordEngine keywordEngine;
   
	@Test
   public void SearchTest()
   {
	   keywordEngine = new KeywordEngine();
	   try {
		keywordEngine.startExecution("91mobiles");
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	
	
}
