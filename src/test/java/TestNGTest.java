import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Andrei on 3/30/2017.
 */
public class TestNGTest {
    WebDriver driver;
    WebDriverWait wait;
    String expectedTitle = "Sakai";
    String actualTitle = "";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Andrei\\IdeaProjects\\Libraries\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        String baseUrl = "https://sakai.luc.edu/";
        driver.get(baseUrl);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("nav#mastLogin form#loginForm input#submit")));
        WebElement inputId = driver.findElement(By.cssSelector("nav#mastLogin form#loginForm input#eid"));
        WebElement inputPassword = driver.findElement(By.cssSelector("nav#mastLogin form#loginForm input#pw"));
        WebElement loginButton = driver.findElement(By.cssSelector("nav#mastLogin form#loginForm input#submit"));
        inputId.sendKeys("afedorov");
        inputPassword.sendKeys("D7mbaTUOb+2");
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputId, "afedorov"));
        loginButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#loginUser.has-avatar")));


    }

    @AfterMethod
    public void cleanup() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void loginTest() {
        WebElement username = driver.findElement(By.cssSelector("a.Mrphs-userNav__submenuitem--username"));
        Assert.assertEquals(username.getText(), "Andrei");
    }

    @Test
    public void announcementTest() {
        WebElement announcements = driver.findElement(By.linkText("Announcements"));
        announcements.click();
        WebElement localTitle = driver.findElement(By.cssSelector("div.page-header h3"));
        Assert.assertEquals(localTitle.getText(), "Announcements\n(viewing announcements from the last 365 days)");
    }
}
