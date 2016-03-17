package KB.stockWatch.java.testNG.keywords;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import static KB.stockWatch.java.testNG.DriverManager.SWObj;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Keywords {
	static Logger log;
	private WebDriver driver;
	private WebDriverWait wait;

	static {
		log = Logger.getLogger(Keywords.class);
	}

	public Keywords(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);
	}

	public void go(String url, By header_search) {
		log.info("Launching Home Page");
		this.driver.get(url);
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(header_search));
		log.info("Succesfully launched Home Page");
	}

	public void go_withCookie(String url, By header_search) {
		log.info("Launching Home Page");
		this.driver.get("http://www.target.com/__ssobj/static/setSSOECookie.html");
		this.driver.switchTo().alert().sendKeys("AB-802-01242016-01");
		this.driver.switchTo().alert().accept();
		this.driver.get(url);
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(header_search));
		log.info("Succesfully launched Home Page");
	}
	

	public void sendKeys(By element, String keyWords) {
		this.driver.findElement(element).clear();
		this.driver.findElement(element).sendKeys(keyWords);
	}

	public void waitTillPageLoad() {
		try {
			ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			};
			Wait<WebDriver> wait = new WebDriverWait(driver, 40);
			try {
				wait.until(expectation);
			} catch (Throwable error) {
			}
			// log.info(" Page loaded Successfully");
		} catch (Exception e) {
			log.info(" Some problem in loading Page");

		}

	}



	public static Boolean isElementPresent(Object element) {
		try {
			if (element != null)
				// if(((WebElement) element).getSize()!=0)
				return true;
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public void scrollTillElement(By element) {
		try {
			Point hoverItem = driver.findElement(element).getLocation();
			((JavascriptExecutor) driver).executeScript("return window.title;");
			Thread.sleep(1500);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + ((hoverItem.getY()) - 100) + ");");
			Thread.sleep(1500);
			log.info("Scrolled till " + element);
		} catch (Exception e) {
			log.info("Not scrolled " + element);
		}

	}

	public String getText(By element) {
		String title = null;
		try {
			waitTillElementPresent(element);
			title = this.driver.findElement(element).getText();
			return title;
		} catch (Exception e) {
			log.info("text -- not found");
		}
		return title;
	}
	
	
	public int getSize(By element) {
		int size = 0;
		try {
			waitTillElementPresent(element);
			size = this.driver.findElements(element).size();
			return size;
		} catch (Exception e) {
			log.info("text -- not found");
		}
		return size;
	}

	
	public String getAttribute(By element) {
		String attribute = null;

		try {
			attribute = this.driver.findElement(element).getAttribute("alt");
			System.out.println("attribute --" + attribute);
			return attribute;
		} catch (Exception e1) {

		}

		return attribute;
	}

	public void waitTillElementPresent(By element) throws InterruptedException {
		Thread.sleep(1000);
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}

	public void tap(By element) throws InterruptedException {
		waitTillPageLoad();
		waitTillElementPresent(element);
		this.driver.findElement(element).click();
	}

	public void tapTillTaps(By element) {
		try {
			int count = 0;
			int x = driver.findElements(element).size();

			while (x != 0 && count < 10) {
				driver.findElement(element).click();
				Thread.sleep(500);
				count++;
				x = driver.findElements(element).size();
			}
		} catch (Exception e) {
			// log.info("error");
		}
		log.info("Clicked at " + element);

	}

	public void tapAndWait(By element) throws InterruptedException {
		waitTillPageLoad();
		waitTillElementPresent(element);
		this.driver.findElement(element).click();
		Thread.sleep(3000);
	}

	public void selectFromDropdown(By element, int i) {
		Select dropdown = new Select(this.driver.findElement(element));
		dropdown.selectByIndex(i);
	}

}
