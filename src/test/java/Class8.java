import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Andrei on 4/3/2017.
 */
public class Class8 {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Andrei\\IdeaProjects\\Libraries\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        String baseUrl = "http://imdb.com/";
        driver.get(baseUrl);
    }

    @After
    public void cleanup() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void newWindowTest() {
        driver.findElement(By.cssSelector("span.follow-twitter")).click();
        String handle = driver.getWindowHandle();
        for (String newHandle : driver.getWindowHandles()) {
            if (!newHandle.equals(handle)) {
                driver.switchTo().window(newHandle);
            }
        }
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(handle);
        driver.findElement(By.cssSelector("span.signin-facebook-text")).click();
    }

}
