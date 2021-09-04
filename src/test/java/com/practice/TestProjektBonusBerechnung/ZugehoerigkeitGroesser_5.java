package com.practice.TestProjektBonusBerechnung;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZugehoerigkeitGroesser_5 {
	
	@Test
	public void TestMethod() throws InterruptedException {
		
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();		
 
 		String baseUrl = "http://www.localhost:9090/MyDynaamicWebApp-0.0.1-SNAPSHOT/";
        String Name = "Stéphane";
        String Zugoerigkeit = "6";
        String Gehalt = "100000";
        String SollErgebnis = "Hi Stéphane dein Bonus beträgt 15000.0 Euro";
        
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
                
        // find the search edit box on the google page
        WebElement txtName = driver.findElement(By.id("vorname"));
        WebElement txtZugehoerigkeit = driver.findElement(By.id("Jahr"));
        WebElement txtGehalt = driver.findElement(By.id("Gehalt"));
        WebElement btnBonusBerechnen = driver.findElement(By.id("Bonusberechnen"));

        txtName.sendKeys(Name);
        Thread.sleep(1500);
        txtZugehoerigkeit.sendKeys(Zugoerigkeit);
        Thread.sleep(1500);
        txtGehalt.sendKeys(Gehalt);
        Thread.sleep(2000);
	    btnBonusBerechnen.click();
	  	  
	    List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + SollErgebnis + "')]"));
	    Assert.assertTrue(list.size() > 0);
    	System.out.println("Test Passed. Execution completed ");
        Thread.sleep(5000);
		
        //close Fire fox
        driver.close();
		}

}
