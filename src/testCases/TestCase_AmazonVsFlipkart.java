package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import objectRepository.Amazon_IPhone;
import objectRepository.Flipkart_IPhone;

public class TestCase_AmazonVsFlipkart {
	@Test
	public void PriceAnalysis() throws AWTException {
		System.setProperty("webdriver.chrome.driver",
				"D://Testing Softwares//ChromeDriver//chromedriver_win32//chromedriver.exe");
		WebDriver driver = buildDriver();
		driver.get("http://www.amazon.in");
		Amazon_IPhone amazon = getAmazonPhoneDetails(driver);
		Set<String> S = driver.getWindowHandles();
		Iterator<String> it = S.iterator();
		String ParentId = it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		String amzprc = amazon.iPhone_Amazon_Price().getText().substring(2).replaceAll("[-+^:,]", "");
		double iPhoneAmazonPrice = Double.parseDouble(amzprc);
		System.out.println("iPhone XR (64GB) - Yellow Price in Amazon is : " + iPhoneAmazonPrice);
		driver.close();
		driver.switchTo().window(ParentId);
		driver.navigate().to("http://www.flipkart.com");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Flipkart_IPhone flipkart = getFlipkartPhoneDetails(driver);
		Set<String> S1 = driver.getWindowHandles();
		Iterator<String> it1 = S1.iterator();
		String ParentId1 = it1.next();
		String ChildId1 = it1.next();
		driver.switchTo().window(ChildId1);
		String flpprc = flipkart.iPhone_FlipKart_Price().getText().substring(1).replaceAll("[-+^:,]", "");
		double iPhoneFlipKartPrice = Double.parseDouble(flpprc);
		System.out.println("iPhone XR (64GB) - Yellow Price in FlipKart is : " + iPhoneFlipKartPrice);
		System.out.print("The lesser value for the iPhone XR is : ");
		if (iPhoneAmazonPrice < iPhoneFlipKartPrice)
			System.out.println(iPhoneAmazonPrice);
		else
			System.out.println(iPhoneFlipKartPrice);
	}

	private Flipkart_IPhone getFlipkartPhoneDetails(WebDriver driver) {
		Flipkart_IPhone flipkart = new Flipkart_IPhone(driver);
		flipkart.FlipKartSearch().sendKeys("iPhone XR (64GB) - Yellow");
		flipkart.FlipKartSubmit().click();
		flipkart.iPhone_FlipKart().click();
		return flipkart;
	}

	private Amazon_IPhone getAmazonPhoneDetails(WebDriver driver) {
		Amazon_IPhone amazon = new Amazon_IPhone(driver);
		amazon.AmazonSearch().sendKeys("iPhone XR (64GB) - Yellow");
		amazon.AmazonSubmit().click();
		amazon.iPhone_Amazon().click();
		return amazon;
	}

	private WebDriver buildDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return driver;
	}
}
