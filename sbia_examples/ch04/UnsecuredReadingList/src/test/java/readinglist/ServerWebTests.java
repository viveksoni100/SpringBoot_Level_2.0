package readinglist;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ReadingListApplication.class)
public class ServerWebTests {
  
  private static FirefoxDriver browser;
  
  @Value("${local.server.port}")
  private int port;

  @BeforeClass
  public static void openBrowser() {
    System.setProperty("webdriver.gecko.driver", "/home/viveksoni100/dev_frameworks/geckodriver-v0.29.1-linux64/geckodriver");
    browser = new FirefoxDriver();
    browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void addBookToEmptyList() {
    String baseUrl = "http://localhost:" + port;
    browser.get(baseUrl);

    String currentUrl = browser.getCurrentUrl();
    assertEquals(baseUrl +"/readingList", currentUrl);

    assertEquals("You have no books in your book list", 
                 browser.findElementByTagName("div").getText());

    browser.findElementByName("title").sendKeys("Ramayan");
    browser.findElementByName("author").sendKeys("Valmiki");
    browser.findElementByName("isbn").sendKeys("12345");
    browser.findElementByName("description").sendKeys("Hello Brother");
    browser.findElementByTagName("form").submit();
    
    WebElement dl = 
        browser.findElementByCssSelector("dt.bookHeadline");
    assertEquals("Ramayan by Valmiki (ISBN: 12345)",
                 dl.getText());
    WebElement dt = 
        browser.findElementByCssSelector("dd.bookDescription");
    assertEquals("Hello Brother", dt.getText());
  }
  
  @AfterClass
  public static void closeBrowser() {
    browser.quit();
  }

}
