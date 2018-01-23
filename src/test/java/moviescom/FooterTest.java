package moviescom;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei on 4/5/2017.
 */
public class FooterTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Andrei\\IdeaProjects\\Libraries\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get(BasePage.baseURL);
    }

    @After
    public void cleanup() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void footerContactTest() {
        String text = "Contact Us";
        HomePage homePage = new HomePage(driver);
        homePage.footer.findElement(By.linkText(text)).click();
        ContactPage contactPage = new ContactPage(driver);
        String pageNameText = contactPage.getPageNameText();
        Assert.assertTrue(pageNameText.equals(text));
    }
}
