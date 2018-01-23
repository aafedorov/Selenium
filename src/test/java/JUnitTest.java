import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Andrei on 3/30/2017.
 */
public class JUnitTest {
    WebDriver driver;
    WebDriverWait wait;
    String expectedTitle = "Sakai";
    String actualTitle = "";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Andrei\\IdeaProjects\\Libraries\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        String baseUrl = "https://sakai.luc.edu/";
        driver.get(baseUrl);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#mastLogin form#loginForm input#submit")));
        WebElement inputId = driver.findElement(By.cssSelector("div#mastLogin form#loginForm input#eid"));
        WebElement inputPassword = driver.findElement(By.cssSelector("div#mastLogin form#loginForm input#pw"));
        WebElement loginButton = driver.findElement(By.cssSelector("div#mastLogin form#loginForm input#submit"));
        inputId.sendKeys("afedorov");
        inputPassword.sendKeys("D7mbaTUOb+1");
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputId, "afedorov"));
        loginButton.click();
    }

    @After
    public void cleanup() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void loginTest() {
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void announcementTest() {
        WebElement announcements = driver.findElement(By.linkText("Announcements"));
        announcements.click();
        WebElement localTitle = driver.findElement(By.className("title"));
        Assert.assertTrue(localTitle.getText().equals("My Workspace: Announcements"));
    }
}
