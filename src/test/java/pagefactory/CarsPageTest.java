package pagefactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrei on 4/13/2017.
 */
public class CarsPageTest {
    public static WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Andrei\\IdeaProjects\\Libraries\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(CarsPage.baseURL);

        wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.tab-contents")));
        wait.until(ExpectedConditions.javaScriptThrowsNoExceptions("window.stop()"));
//        JavascriptExecutor js = (JavascriptExecutor) CarsPageTest.driver;
//        js.executeScript("window.stop()");

    }

    @After
    public void cleanup() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
//    public void chooseCarTypeTest() throws InterruptedException {
    public void chooseCarTypeTest() {
        CarsPage page = PageFactory.initElements(driver, CarsPage.class);

        WebElement carTypeListItem = page.getRandomItemFromDropDownList(page.carTypeList);
        System.out.println(carTypeListItem.getText());

        WebElement carPriceListItem = page.getRandomItemFromDropDownList(page.carPriceList);
        System.out.println(carPriceListItem.getText());

        WebElement carMakeListItem = page.getRandomItemFromDropDownList(page.carMakeList);
        System.out.println(carMakeListItem.getText());

        WebElement carModelListItem = page.getRandomItemFromDropDownList(page.carModelList);
        System.out.println(carModelListItem.getText());

        WebElement radiusListItem = page.getRandomItemFromDropDownList(page.radiusList);
        System.out.println(radiusListItem.getText());

        page.insertZip();

        page.clickVisibleSearchButton();

        CarsSearchResultsPage page1 = PageFactory.initElements(driver, CarsSearchResultsPage.class);
        wait.until(ExpectedConditions.visibilityOf(page1.carTypeSelectedList.get(0)));

        System.out.println("First filter = " + page1.carTypeSelectedList.get(0).getText());
        System.out.println("Second filter = " + page1.carTypeSelectedList.get(1).getText());
        System.out.println("Third filter = " + page1.carTypeSelectedList.get(2).getText());
        System.out.println("Fourth filter = " + page1.carTypeSelectedList.get(3).getText());
        Assert.assertTrue(true);
    }

}
