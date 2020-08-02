package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ShoeStoreHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoeSearchStepDefinition {

    private ShoeStoreHomePage shoeStoreHomePage = new ShoeStoreHomePage();

    @Given("^I am on home page of shoe store$")
    public void iAmOnHomePageOfShoeStore() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "shoe-store-july.herokuapp", "I am on invalid home page");
    }

    @When("^I click Chose a brand dropdown button$")
    public void iClickOnChooseBrand(){
        shoeStoreHomePage.clickChooseBrandDropDown();
    }

    @When("^I select (.+) from the list$")
    public void iSelectJimmyChooFromTheList(String anyText){
        shoeStoreHomePage.selectJimmyChoo(anyText);
    }

    @When("^I click on Search button$")
    public void iClickOnSearchBtn(){
        shoeStoreHomePage.clickSearchBtn();
    }

    @Then("^I verify Jimmy Choo's Shoes are displayed$")
    public void iVerifyJimmyChooShoesAreDisplayed() {
        Assert.assertEquals(shoeStoreHomePage.searchResult(),"Jimmy Choo's Shoe","Invalid Search Result");
        String value = SharedSD.getDriver().findElement(By.xpath("/html/body/div[2]/h2")).getText();
        if (value.contains("Jimmy Choo's Shoe")){
            System.out.println("Result value is expected");
        }else
        {
            System.out.println("Result is not valid as expected");
        }
    }

    @When("^I click Remind me on new shoes Email Address Input Box$")
    public void iClickRemindMeEmailAddressInputBox(){
        shoeStoreHomePage.clickEmailAddressInputBox();
    }

    @When("^I enter slpm146@gmail.com as email address$")
    public void iEnterEmailAddress(String anyText){
        shoeStoreHomePage.enterEmailAddress(anyText);
    }


    @When("^I click Submit button$")
    public void iClickSubmitButton(){
        shoeStoreHomePage.clickSubmitBtn();
    }

    @Then("^I verify Thanks! email notification message is displayed$")
    public void iVerifyValidationMessage() {
        Assert.assertEquals(shoeStoreHomePage.getValidationMessage(),"Thanks","Invalid Search Result");
        String value = SharedSD.getDriver().findElement(By.xpath("//*[@id=\"flash\"]/div")).getText();
        if (value.contains("Thanks")){
            System.out.println("Result value is expected");
        }else
        {
            System.out.println("Result is not valid as expected");
        }
    }

}
