package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by Andrei on 4/15/2017.
 */
public class CarsSearchResultsPage extends CarsPage {

    @FindBy(how = How.CSS, using = "div.header-secondary cars-shop-srp-active-refinements.col-dt-10 cars-sr-active-refinements span.tag")
    public List<WebElement> carTypeSelectedList;
}
