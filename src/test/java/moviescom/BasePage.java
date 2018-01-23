package moviescom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 4/3/2017.
 */
public abstract class BasePage {
    public static final String baseURL = "http://movies.com";
    WebElement searchBox;
    List<WebElement> dropDownList;
    WebElement searchButton;
    WebElement footer;
    private By searchBoxSelector = By.cssSelector("div.searchBox input.inputString");
    private By searchButtonSelector = By.cssSelector("div.searchBox input.search");
    private By dropDownItemSelector = By.cssSelector("p#searchresults a");
    private By footerSelector = By.cssSelector("div#footerContent");

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        searchBox = driver.findElement(searchBoxSelector);
        searchButton = driver.findElement(searchButtonSelector);
        footer = driver.findElement(footerSelector);
    }

    public void searchForText(String textToSearch) {
        searchBox.sendKeys(textToSearch);
        wait.until(ExpectedConditions.presenceOfElementLocated(dropDownItemSelector));
    }

    public WebElement getRandomItemFromDropDownList() {
        createDropDownList();
        int itemNumber = (int) (Math.random() * dropDownList.size());
        return dropDownList.get(itemNumber);
    }

    private void createDropDownList() {
        dropDownList = driver.findElements(dropDownItemSelector);
        ArrayList<WebElement> toRemove = new ArrayList<WebElement>();

        for (WebElement item : dropDownList) {
            try {
                item.findElement(By.tagName("img"));
            } catch (Exception e) {
                toRemove.add(item);
            }
        }

        dropDownList.removeAll(toRemove);
    }

}
