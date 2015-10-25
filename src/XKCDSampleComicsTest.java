import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/*As an xkcd user, I would like to easily navigate to some of the more
* popular comics from the xkcd main page so that I can show non-users what
* they are missing out on and convince them to become a user.
*/

public class XKCDSampleComicsTest {

	static WebDriver driver = new FirefoxDriver();
	Actions builder = new Actions(driver);

	@Before
	public void setUp() throws Exception{
		driver.get("http://www.xkcd.com");
	}

	//Given I am on the main page, when I click on the first sample comic from the left
	//in the bottom box, I am taken to http://xkcd.com/150/ 
	@Test
	public void testSampleComic1() {
		String url = "http://xkcd.com/150/";
		builder.moveToElement(driver.findElement(By.id("comicmap")), 50, 50).click().build().perform();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}

	//Given I am on the main page, when I click on the second sample comic from the left
	//in the bottom box, I am taken to http://xkcd.com/730/
	@Test
	public void testSampleComic2() {
		String url = "http://xkcd.com/730/";
		builder.moveToElement(driver.findElement(By.id("comicmap")), 154, 50).click().build().perform();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}

	//Given I am on the main page, when I click on the third sample comic from the left
	//in the bottom box, I am taken to http://xkcd.com/162/ 
	@Test
	public void testSampleComic3() {
		String url = "http://xkcd.com/162/";
		builder.moveToElement(driver.findElement(By.id("comicmap")), 258, 50).click().build().perform();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}

	//Given I am on the main page, when I click on the second sample comic from the right
	//in the bottom box, I am taken to http://xkcd.com/688/ 
	@Test
	public void testSampleComic4() {
		String url = "http://xkcd.com/688/";
		builder.moveToElement(driver.findElement(By.id("comicmap")), 362, 50).click().build().perform();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}

	//Given I am on the main page, when I click on the first sample comic from the right
	//in the bottom box, I am taken to http://xkcd.com/556/ 
	@Test
	public void testSampleComic5() {
		String url = "http://xkcd.com/556/";
		builder.moveToElement(driver.findElement(By.id("comicmap")), 470, 50).click().build().perform();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}
}