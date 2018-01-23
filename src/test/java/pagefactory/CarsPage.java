package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Andrei on 4/12/2017.
 */
public class CarsPage {
    public static final String baseURL = "http://www.cars.com";

    @FindBy(how = How.CSS, using = "div.cui-input-group div.sw-input-group-stock select.dropdown")
    public List<WebElement> carTypeList;
    @FindBy(how = How.CSS, using = "div.cui-input-group div.sw-input-group-price select.dropdown")
    public List<WebElement> carPriceList;
    @FindBy(how = How.CSS, using = "div.cui-input-group div.sw-input-group-make select.dropdown")
    public List<WebElement> carMakeList;
    @FindBy(how = How.CSS, using = "div.cui-input-group div.sw-input-group-model select.dropdown")
    public List<WebElement> carModelList;
    @FindBy(how = How.CSS, using = "div.cui-input-group div.sw-input-group-radius select.dropdown")
    public List<WebElement> radiusList;
    @FindBy(how = How.CSS, using = "div.cui-input-group div.sw-input-group-zip div.input input")
    private List<WebElement> zipList;
    @FindBy(how = How.CSS, using = "div.sw-input-group-submit input")
    public List<WebElement> searchButtons;

    private WebElement getVisibleElement(List<WebElement> list) {

        WebElement visibleElement = null;
        for (WebElement element : list) {
            if (element.isDisplayed()) {
                visibleElement = element;
                break;
            }
        }
        return visibleElement;
    }

    public WebElement getRandomItemFromDropDownList(List<WebElement> list) {
        Select select = new Select(getVisibleElement(list));
        int itemNumber = (int) (Math.random() * select.getOptions().size());
        select.selectByIndex(itemNumber);
        return select.getOptions().get(itemNumber);
    }

    public void insertZip() {
        WebElement element = getVisibleElement(zipList);
        element.sendKeys("60616");
    }

    public void clickVisibleSearchButton() {
        WebElement element = getVisibleElement(searchButtons);
        element.click();
    }


}
