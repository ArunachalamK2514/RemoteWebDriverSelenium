package akitochalam.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteChrome {
	
	@Test
	public void InitiateChrome() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
//		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		// Use this to start the hub -> java -jar selenium-server-4.5.0.jar hub
		// Use this to start the node -> java -jar selenium-server-4.5.0.jar node --detect-drivers true
		
		WebDriver rDriver = new RemoteWebDriver(new URL("http://192.168.1.34:4444"), capabilities);
		rDriver.manage().window().maximize();
		
		rDriver.get("https://www.google.com/");
		rDriver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(2000);
		rDriver.findElement(By.cssSelector("input[value='Google Search']")).click();
		System.out.println(rDriver.getTitle());
		rDriver.close();
		
	}

}
