package moviescom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Andrei on 4/3/2017.
 */
public class MoviePage extends BasePage {

    public WebElement movieName;
    private By movieNameSelector = By.cssSelector("div#completeInfo h1");

    public MoviePage(WebDriver driver) {
        super(driver);
        movieName = driver.findElement(movieNameSelector);
    }

    public String getMovieNameText() {
        return movieName.getText();
    }
}
