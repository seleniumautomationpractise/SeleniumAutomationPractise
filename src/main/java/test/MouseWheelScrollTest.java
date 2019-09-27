package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseWheelScrollTest 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{


		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.co.uk/maps");
		WebElement elm = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#scene > div.widget-scene > canvas")));
		// Mouse wheel UP or Zoom In 
		wheel_element(elm, -500, 0, 0);
		System.out.println("Mouse wheel UP or Zoom In through Wheel achieved !!!");
		// Mouse wheel DOWN or Zoom Out 
		wheel_element(elm, 120, 0, 0);
		System.out.println("Mouse wheel DOWN or Zoom Out through Wheel achieved !!!");
		System.out.println("Mouse Scroll through Wheel achieved !!!");
	}

	public static void wheel_element(WebElement element, int deltaY, int offsetX, int offsetY)
	{
		try{
			String script = "var element = arguments[0];"
					+"var deltaY = arguments[1];"
					+"var box = element.getBoundingClientRect();"
					+"var clientX = box.left + (arguments[2] || box.width / 2);"
					+"var clientY = box.top + (arguments[3] || box.height / 2);"
					+"var target = element.ownerDocument.elementFromPoint(clientX, clientY);"
					+"for (var e = target; e; e = e.parentElement) {"
					+"if (e === element) {"
					+"target.dispatchEvent(new MouseEvent('mouseover', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY}));"
					+"target.dispatchEvent(new MouseEvent('mousemove', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY}));"
					+"target.dispatchEvent(new WheelEvent('wheel',     {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY, deltaY: deltaY}));"
					+"return;"
					+"}"
					+"}";  

			WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", element);
			((JavascriptExecutor) driver).executeScript(script, parent, deltaY, offsetX, offsetY);
		}catch(WebDriverException e)
		{
			System.out.println("Exception caught in Catch block");
		}
	}

}