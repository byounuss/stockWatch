package KB.stockWatch.java.testNG.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import KB.stockWatch.java.testNG.keywords.*;
import KB.stockWatch.java.testNG.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static KB.stockWatch.java.testNG.DriverManager.SWObj;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * Contains step definitions for two feature files: first.feature &
 * second.feature
 * 
 * @author Shaik
 */
public class StockWatch {

	static Logger log;
	static Random rnd = new Random();
	static final String eMail = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	WebDriver driver = DriverManager.getDriver();
	private Keywords keyWords;
	private WebDriverWait wait;

	static {
		log = Logger.getLogger(StockWatch.class);
	}

	static int incrCount = 0;
	static int decrCount = 0;
	static int unChangeCount = 0;

	public StockWatch() {
		keyWords = new Keywords(this.driver);
		wait = new WebDriverWait(this.driver, 30);
	}

	@Given("^I am on \"([^\"]*)\"$")
	public void guest_is_on_home_page(String url) throws Throwable {
		try {
			keyWords = new Keywords(this.driver);
			keyWords.go(url, SWObj.nifty_50);
			keyWords.waitTillPageLoad();
			log.info("Page loaded succefully");
		} catch (Exception e) {
			log.info("Some problem in loading page ");
		}
	}

	@Given("^Verify the Stocklsit page loaded properly$")
	public void stockListPageLoad() throws Throwable {
		try {
			keyWords.waitTillPageLoad();
			keyWords.waitTillElementPresent(SWObj.nifty_50);
			log.info("Page loaded succefully");
		} catch (Exception e) {
			log.info("element ");
		}
	}

	@Given("^Verify Open Chng and %Chng columns are present$")
	public void CheckingElements() throws Throwable {
		try {
			Keywords.isElementPresent(SWObj.col_chng);
			Keywords.isElementPresent(SWObj.col_open);
			Keywords.isElementPresent(SWObj.col_Perchng);
			log.info("All the columns are displayed properly");
		} catch (Exception e) {
			log.info("Issue in loading some of the columns");
		}
	}

	@Given("^Verify %Chng calculated curreclty$")
	public void verifyPerntChange() throws Throwable {
		try {
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			String pattern = ((DecimalFormat) nf).toPattern();
			String newPattern = pattern.replace("\u00A4", "").trim();
			float open_val = Float.parseFloat(keyWords.getText(SWObj.open_val).replace(",", ""));
			float change = Float.parseFloat(keyWords.getText(SWObj.chng_val).replace(",", ""));
			float changeinPerc = Float.parseFloat(keyWords.getText(SWObj.PerChng_val).replace(",", ""));
			NumberFormat newFormat = new DecimalFormat(newPattern);

			// Calculated from change and open value
			float changeinPerc1 = change * 100 / open_val;

			Keywords.isElementPresent(SWObj.col_chng);
			Keywords.isElementPresent(SWObj.col_open);
			Keywords.isElementPresent(SWObj.col_Perchng);

			// Below assert will check the Actual value
			Assert.assertEquals(Float.parseFloat(newFormat.format(changeinPerc)),
					Float.parseFloat(newFormat.format(changeinPerc1)), 0.0f);
			log.info("% Change is printed properly");
		} catch (Exception e) {
			log.info("% Change is printed value is not matching");
		}
	}
/*
 * In the below Method 
 * 
 */
	@And("^Verify Make sure that %Chng displayed in descending order$")
	public void isPerntChangeInDescOrder() throws Throwable {
		try {
			float current=0;
			float next = 0;
			String xPathString = "//*[@id='dataTable']/tbody//td[9]";
			int j = 0;
			for (int i = 2; i <= keyWords.getSize(SWObj.PerChange_col) - 1; i++) {
				j = i+1;
				current=Float.parseFloat(keyWords.getText(By.xpath("(" + xPathString + ")" + "[" + i + "]")));
				next=Float.parseFloat(keyWords.getText(By.xpath("(" + xPathString + ")" + "[" + j + "]")));
				if (current > 0) {
					++incrCount;
				} else if (current < 0) {
					++decrCount;
				} else {
					++unChangeCount;
				}
				System.out.println(i - 1 + " current " + current + " next " + next);
				Assert.assertTrue(current >= next);
			}
			if (decrCount != 0 && next!= 0 )
				decrCount++;
			else if (unChangeCount != 0 && next == 0)
				unChangeCount++;
			else
				incrCount++;
			log.info("% Change is displaying in descending order " + incrCount + " " + decrCount + " " + unChangeCount);
			Thread.sleep(20000);
		} catch (Exception e) {
			log.info("% Change is not displayingin descending order ");
		}
	}

	@And("^Verify that advances, declines and Unchanged count match exaclty and total count should be 50$")
	public void countMatch() throws Throwable {
		try {
			int advances = Integer.parseInt(keyWords.getText(SWObj.adVances).split("-")[1].replace(" ", ""));
			int declines = Integer.parseInt(keyWords.getText(SWObj.deClines).split("-")[1].replace(" ", ""));
			int unchnaged = Integer.parseInt(keyWords.getText(SWObj.unChanged).split("-")[1].replace(" ", ""));
			Assert.assertTrue(incrCount==advances);
			Assert.assertTrue(decrCount==declines);
			Assert.assertTrue(unChangeCount==unchnaged);
			Assert.assertTrue(incrCount+decrCount+unChangeCount==50);
			log.info("Count Matches and total is ");
		} catch (Exception e) {
			log.info("Count doestNot match ");
		}
	}
}
