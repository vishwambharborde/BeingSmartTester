package being_tester.being_smart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	static final String url="https://www.zoopla.co.uk";
	public WebDriver driver;
	BaseTest() {
		System.setProperty("log4j.configurationFile", "src/main/resources/log4j2.xml");
	}
	@BeforeClass
	public void baseSetUp() {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
//		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get(url);
	}
	@AfterClass
	public void baseTearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
