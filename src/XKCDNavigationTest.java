import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/*As an xkcd user, I would like to be able to travel to the xkcd store,
* blog, and other related sites from the xkcd main page so that I can keep up
* with Randall’s other projects, related to xkcd or otherwise.
 */

public class XKCDNavigationTest {

	static WebDriver driver = new FirefoxDriver();

	@Before
	public void setUp() throws Exception{
		driver.get("http://www.xkcd.com");
	}

	//Given I am on the main page, when I click on the "What If?" link,
	//I am taken to http://what-if.xkcd.com/ 
	@Test
	public void testWhatIf() {
		String url = "http://what-if.xkcd.com/"; 
		driver.findElement(By.linkText("What If?")).click();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}

	//Given I am on the main page, when I click on the "Blag" link,
	//I am taken to http://blog.xkcd.com/ 
	@Test
	public void testBlag() {
		String url = "http://blog.xkcd.com/"; 
		driver.findElement(By.linkText("Blag")).click();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}

	//Given I am on the main page, when I click on the "Store" link,
	//I am taken to http://store.xkcd.com/
	@Test
	public void testStore() {
		String url = "http://store.xkcd.com/"; 
		driver.findElement(By.linkText("Store")).click();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}

	//Given I am on the main page, when I click on the "About" link,
	//I am taken to http://xkcd.com/about/ 
	@Test
	public void testAbout() {
		String url = "http://www.xkcd.com/about/"; 
		driver.findElement(By.linkText("About")).click();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}

	//Given I am on the main page, when I click on the "More Details" link,
	//I am taken to http://xkcd.com/license.html 
	@Test
	public void testMoreDetails() {
		String url = "http://www.xkcd.com/license.html"; 
		driver.findElement(By.linkText("More details")).click();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}

}