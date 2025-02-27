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
import utils.*;

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
        }

    @When("the user enter the product name")
    public void the_user_enter_the_product_name() {
        ajioPage.getSearchBar().sendKeys(data.get("SearchProduct"));
        ajioPage.getSearchBar().sendKeys(Keys.ENTER);

    }

    @When("the user click on search box")
    public void theUserClickOnSearchBox() {
        ClickUtil.click(driver,ajioPage.getSearchBar());

    }

    @Then("search box should be clickable")
    public void searchBoxShouldBeClickable() {
        WaitUtil.waitTillVisible(driver, ajioPage.getSearchBar());
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


    @Then("placeholder should be properly display")
    public void placeholder_should_be_properly_display() {
      String placeholder =  ajioPage.getSearchBar().getAttribute("placeholder");
      Assert.assertEquals(placeholder,"Search AJIO");
    }

    @When("the user enter the product {string}")
    public void theUserEnterTheProduct(String arg0) {
        ajioPage.getSearchBar().sendKeys(arg0);
        ajioPage.getSearchBar().sendKeys(Keys.ENTER);
    }


    @Then("the product {string} should be displayed")
    public void theProductShouldBeDisplayed(String arg0) {
        HashMap<String,String> searchData=new HashMap<>();
        searchData.put("Shoes","Shoes");
        searchData.put("Jackets","Jackets And Shrugs");
        searchData.put("Jeans","Jeans");

        String searchInfo = ajioPage.getSearchInfo().getText();
        Assert.assertEquals(searchInfo,searchData.get(arg0));

    }


}
