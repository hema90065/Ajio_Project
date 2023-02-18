package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;
import pages.AjioPage;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.util.HashMap;
import java.util.List;

public class StepDefinition {

    private WebDriver driver;
    AjioPage ajioPage;
    String url;
    HashMap<String,String> data;
    Scenario scenario;
    public StepDefinition(BrowserManager browserManager){
        this.driver=browserManager.getDriver();
    }

    @Before(order = 1)
    public void before(Scenario scenario){
        this.scenario=scenario;

    }
    @Given("the user navigates to the home page")
    public void the_user_navigates_to_the_home_page() {
        url= QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
        ajioPage = new AjioPage(driver);
        //ajioPage.getAllowLocation().click();
    }

    @When("the user enter the product name")
    public void the_user_enter_the_product_name() {
        ajioPage.getSearchBar().sendKeys(data.get("SearchProduct"));
        ajioPage.getSearchBar().sendKeys(Keys.ENTER);

    }

    @Then("the product results should be displayed")
    public void the_product_results_should_be_displayed() {
        String search_info = ajioPage.getSearchInfo().getText();
        Assert.assertEquals(search_info,data.get("SearchProduct"));
    }

    @Then("search box height should be as per specification")
    public void search_box_height_should_be_as_per_specification() {
        Dimension dimension =  ajioPage.getSearchBar().getSize();
//        System.out.println(dimension.getHeight());
        Assert.assertEquals(dimension.getHeight(),34);
    }

    @Then("search box width should be as per specification")
    public void search_box_width_should_be_as_per_specification() {
        Dimension dimension =  ajioPage.getSearchBar().getSize();
//        System.out.println(dimension.getWidth());
        Assert.assertEquals(dimension.getWidth(),269);
    }

    @Then("search box layout should be as per specification")
    public void search_box_layout_should_be_as_per_specification(){
       Point point =  ajioPage.getSearchBar().getLocation();
//        System.out.println(point.getX());
//        System.out.println(point.getY());
        Assert.assertEquals(point.getX(),872);
        Assert.assertEquals(point.getY(),48);
    }

    @Then("placeholder should be properly display")
    public void placeholder_should_be_properly_display() {
      String placeholder =  ajioPage.getSearchBar().getAttribute("placeholder");
      Assert.assertEquals(placeholder,"Search AJIO");
    }

    @When("chick on search bar")
    public void chick_on_search_bar() {
        ajioPage.getSearchBar().click();
    }
    @Then("the categories dropdown should be properly attached to the search box")
    public void the_categories_dropdown_should_be_properly_attached_to_the_search_box() {
        List<WebElement> listofCategoriesDropdown = ajioPage.getListOfCategoriesDropdownAttachedToSearchBox();
        System.out.println(listofCategoriesDropdown);
        Assert.assertEquals(listofCategoriesDropdown.size(),10);
    }

    @When("the user click on search bar then suggested product list show")
    public void the_user_click_on_search_bar_then_suggested_product_list_show() {
        ajioPage.getSearchBar().click();
        List<WebElement> listofCategoriesDropdown = ajioPage.getListOfCategoriesDropdownAttachedToSearchBox();
        System.out.println(listofCategoriesDropdown);
        Assert.assertEquals(listofCategoriesDropdown.size(),10);
    }
    @Then("the user should be able to select product from suggested list")
    public void the_user_should_be_able_to_select_product_from_suggested_list() {
        List<WebElement> listofCategoriesDropdown = ajioPage.getListOfCategoriesDropdownAttachedToSearchBox();
        String selectesOption = listofCategoriesDropdown.get(8).getText();
        listofCategoriesDropdown.get(4).click();
        Assert.assertEquals(selectesOption,"Heels");
    }


    @When("the user select an option from the suggested list")
    public void the_user_select_an_option_from_the_suggested_list() {
        List<WebElement> listofCategoriesDropdown = ajioPage.getListOfCategoriesDropdownAttachedToSearchBox();
        String selectesOption = listofCategoriesDropdown.get(4).getText();
        listofCategoriesDropdown.get(4).click();
        Assert.assertEquals(selectesOption,"Kurti");
    }

    @Then("product should be displayed on search page")
    public void product_should_be_displayed_on_search_page() {
        String searchInfo = ajioPage.getSearchInfo().getText();
        Assert.assertEquals(searchInfo,"Kurti");
    }
}
