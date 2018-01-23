package moviescom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Andrei on 4/5/2017.
 */
public class ContactPage extends BasePage {

    public WebElement pageName;
    private By pageNameSelector = By.cssSelector("div#content.contactUs h1");

    public ContactPage(WebDriver driver) {
        super(driver);
        pageName = driver.findElement(pageNameSelector);
    }

    public String getPageNameText() {
        return pageName.getText();
    }
}
