import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/*As an xkcd user, I would like to see a comic, the web page title, 
 * and other identifying information on the main page so that I am sure
 * I am on the correct site and that I can enjoy its features. 
 */


public class XKCDTitleTest {

	static WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception{
		driver.get("http://www.xkcd.com");
	}
	
	// Given that I am on the main page, when I view the title,
	// I see that the word “xkcd” appears.
	@Test
	public void testTitle() {
		String title = driver.getTitle();
		assertTrue(title.contains("xkcd"));
	}
	
	// Given that I am on the main page, when I view the sub title,
	// I see the words “A webcomic of romance, sarcasm,
	// math, and language” appear.
	@Test
	public void testSubtitle() {
		WebElement e = driver.findElement(By.id("slogan"));
		String subtitle = e.getText(); 
		assertTrue(subtitle.contains("A webcomic of romance,\nsarcasm, math, and language."));
	}
	
	// Given that I am on the main page, when I view the page, I see a comic.
	@Test
	public void testMainComic() {
		try{
			driver.findElement(By.id("comic"));
		} catch (NoSuchElementException el_err){
			fail();
		}
	}
	
	// Given that I am on the main page, when I view the page,
	//I see a permanent link to the presented comic.
	@Test
	public void testMainComicLink() {
		String text = "Permanent link to this comic:"; 
		WebElement e = driver.findElement(By.id("middleContainer"));
		assertTrue(e.getText().contains(text));
		
	}
	
	// Given that I am on the main page, when I view the page,
	//I see a warning about potential strong language.
	@Test
	public void testMainLanguage() {
		String text = "this comic occasionally contains strong language"; 
		WebElement e = driver.findElement(By.id("bottom"));
		assertTrue(e.getText().contains(text));
	}
}
