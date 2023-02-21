package pages;

import lombok.Getter;
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




    @FindBy(xpath = "//input[@autocomplete=\"off\"]")
    @Getter
    private WebElement searchBar;

    @FindBy(xpath = "//button[@class=\"_1Pr1m wQxKC _2fXFm _2zWIL\"]")
    @Getter
    private WebElement allowLocation;

    @FindBy(xpath = "//div[@class=\"header2\"]")
    @Getter
    private WebElement searchInfo;

    @FindBy(xpath = "//ul[@class=\"rilrtl-list \"]//li")
    @Getter
    private List<WebElement>  listOfCategoriesDropdownAttachedToSearchBox;



}
