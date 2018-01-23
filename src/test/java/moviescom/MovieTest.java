package moviescom;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrei on 4/3/2017.
 */
public class MovieTest {
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
    public void movieNameTest() {
        String name = "Holmes";
        HomePage homePage = new HomePage(driver);
        homePage.searchForText(name);
        WebElement listItem = homePage.getRandomItemFromDropDownList();
        String itemName = listItem.getText();
        listItem.click();
        MoviePage moviePage = new MoviePage(driver);
        Assert.assertTrue(itemName.contains(moviePage.getMovieNameText()) || moviePage.getMovieNameText().contains(itemName));
    }
}
