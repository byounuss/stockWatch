package KB.stockWatch.java.testNG.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by jay on 10/04/14.
 */
public class StockWatchPageObjects {
	public By nifty_50 = By.xpath(".//*[@id='gettd' and contains(text(),'NIFTY 50')]");
	public By col_open=By.xpath(".//*[@id='dataTable']//th[@title='Open']");
	public By col_chng=By.xpath(".//*[@id='dataTable']//th[@title='Change']");
	public By col_Perchng=By.xpath(".//*[@id='dataTable']//th[@title='% Change']");
	
	public By open_val=By.xpath("(.//*[@id='dataTable']//td[4])[1]");
	public By chng_val=By.xpath("(.//*[@id='dataTable']//td[8])[1]");
	public By PerChng_val=By.xpath("(.//*[@id='dataTable']//td[9])[1]");
	
	public By PerChange_col=By.xpath(".//*[@id='dataTable']/tbody//td[8]");
	
	public By adVances=By.xpath("//*[@id='advDecData']/*[contains(text(),'Advance')]");
	public By deClines=By.xpath("//*[@id='advDecData']/*[contains(text(),'Declines')]");
	public By unChanged=By.xpath("//*[@id='advDecData']/*[contains(text(),'Unchanged')]");
	
	
}
