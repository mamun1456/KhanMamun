package pages;

import org.openqa.selenium.By;

public class ShoeStoreHomePage extends BasePage {
    private By chooseBrandDropDown = By.id("brand");
    private By jimmyChoo = By.xpath("//*[@id=\"brand\"]/option[117]");
    private By searchBtn = By.id("search_button");
    private By searchResultJimmyChooShoe = By.xpath("/html/body/div[2]/h2");
    private By emailAddress = By.id("remind_email_input");
    private By submitBtn = By.id("remind_email_submit");
    private By thanksValidationMsg = By.xpath("//*[@id=\"flash\"]/div");

    public void clickChooseBrandDropDown(){
        clickOn(chooseBrandDropDown);
    }

    public void selectJimmyChoo(String anyText){
        selectFromDropDown(jimmyChoo,anyText);
    }

    public void clickSearchBtn(){
        clickOn(searchBtn);
    }

    public String searchResult(){
        return getTextFromElement(searchResultJimmyChooShoe);
    }

    public void clickEmailAddressInputBox(){
        clickOn(emailAddress);
    }

    public void enterEmailAddress(String anyText){
        sendText(emailAddress, anyText);
    }

    public void clickSubmitBtn(){
        clickOn(submitBtn);
    }

    public String getValidationMessage(){
        return getTextFromElement(thanksValidationMsg);

    }

}
