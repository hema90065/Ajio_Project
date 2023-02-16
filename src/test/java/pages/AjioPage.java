package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AjioPage {
    private WebDriver driver;

    public AjioPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public WebElement getSearchBar() {
        return searchBar;
    }

    @FindBy(xpath = "//input[@autocomplete=\"off\"]")
    private WebElement searchBar;



    public WebElement getAllowLocation() {
        return allowLocation;
    }

    @FindBy(xpath = "//button[@class=\"_1Pr1m wQxKC _2fXFm _2zWIL\"]")
    private WebElement allowLocation;

    public WebElement getSearchInfo() {
        return searchInfo;
    }

    @FindBy(xpath = "//div[@class=\"header2\"]")
    private WebElement searchInfo;


    public List<WebElement> getListOfCategoriesDropdownAttachedToSearchBox() {
        return listOfCategoriesDropdownAttachedToSearchBox;
    }

    @FindBy(xpath = "//ul[@class=\"rilrtl-list \"]//li")
    private List<WebElement>  listOfCategoriesDropdownAttachedToSearchBox;



}
