import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;



/*
 * As an xkcd user, I would like to be able to find other comics (aside from the initial comic) easily. 
 */


public class XKCDComicFinderTest {

	static WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception{
		driver.get("http://www.xkcd.com");
	}
	
	// Given that I am on the main page, when I click the “random” button,
	// I view a new comic.
	@Test
	public void testRandom() {
		WebElement comic1 = driver.findElement(By.id("comic"));
		driver.findElement(By.linkText("Random")).click();
		WebElement comic2 = driver.findElement(By.id("comic"));
		assertNotEquals(comic1, comic2);
	}
	
	// Given that I am on the main page, when I click the “<Prev” button,
	// I see a new comic.
	@Test
	public void testPrev() {
		WebElement comic1 = driver.findElement(By.id("comic"));
		driver.findElement(By.linkText("Random")).click();
		driver.findElement(By.linkText("< Prev")).click();
		WebElement comic2 = driver.findElement(By.id("comic"));
		assertNotEquals(comic1, comic2);
	}
	
	// Given that I am on the main page, when I click the “Next>” button, I see a new comic.
	@Test
	public void testNext() {
		WebElement comic1 = driver.findElement(By.id("comic"));
		driver.findElement(By.linkText("Random")).click();
		driver.findElement(By.linkText("Next >")).click();
		WebElement comic2 = driver.findElement(By.id("comic"));
		assertNotEquals(comic1, comic2);
	}
	
	// Given that I am on the main page, when I click the “RSS Feed” link,
	// I am taken to http://www.xkcd.com/rss.xml
	@Test
	public void testRSSLink() {
		String url = "http://www.xkcd.com/rss.xml"; 
		driver.findElement(By.linkText("RSS Feed")).click();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
		
	}
	
	// Given that I am on the main page, when I click the “Atom Feed” link,
	// I am taken to http://www.xkcd.com/atom.xml
	@Test
	public void testAtomLink() {
		String url = "http://www.xkcd.com/atom.xml"; 
		driver.findElement(By.linkText("Atom Feed")).click();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}
	
	// Given that I am on the main page, when I click the “Archive” link,
	// I am taken to http://www.xkcd.com/archive/.
	@Test
	public void testArchiveLink() {
		String url = "http://www.xkcd.com/archive/"; 
		driver.findElement(By.linkText("Archive")).click();
		String curr = driver.getCurrentUrl();
		assertEquals(url, curr);
	}
}

