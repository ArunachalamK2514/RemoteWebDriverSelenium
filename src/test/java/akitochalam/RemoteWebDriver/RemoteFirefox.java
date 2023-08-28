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

public class RemoteFirefox {
	
	@Test
	public void InitiateFirefox() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setBrowserName("firefox");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		
		// Use this to start the hub -> java -jar selenium-server-4.5.0.jar hub
		// Use this to start the node -> java -jar selenium-server-4.5.0.jar node --detect-drivers true
		
		WebDriver rDriver = new RemoteWebDriver(new URL("http://192.168.1.34:4444"), capabilities);
		rDriver.manage().window().maximize();
		
		rDriver.get("https://www.selenium.dev/");
		System.out.println(rDriver.getTitle());
		rDriver.close();
		
	}

}
