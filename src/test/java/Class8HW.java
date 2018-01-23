import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Andrei on 4/3/2017.
 */
public class Class8HW {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Andrei\\IdeaProjects\\Libraries\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        String baseUrl = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_alert";
        driver.get(baseUrl);
    }

    @After
    public void cleanup() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void alertTest() {
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.tagName("button")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertTrue(alertText.equals("I am an alert box!"));


    }
}
