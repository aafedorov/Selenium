package actions;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Andrei on 4/12/2017.
 */
public class ChangeSize {

    WebDriver driver;
    //WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Andrei\\IdeaProjects\\Libraries\\chromedriver.exe");
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 30);
        String baseUrl = "http://jqueryui.com/resizable/";
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void cleanup() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void changeSizeTest() {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);
        WebElement corner = driver.findElement(By.cssSelector("div.ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"));
        WebElement rectangle = driver.findElement(By.cssSelector("div.ui-widget-content.ui-resizable"));
        Actions builder = new Actions(driver);
        Action mouseToCornerAndMove = builder
                .moveToElement(corner)
                .clickAndHold()
                .moveByOffset(-100, -100)
                .release()
                .build();
        Dimension sizeBefore = rectangle.getSize();
        mouseToCornerAndMove.perform();
        Dimension sizeAfter = rectangle.getSize();

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        executor.executeAsyncScript("window.alert('Hello World');");


        Assert.assertFalse(sizeBefore.equals(sizeAfter));
    }


}
