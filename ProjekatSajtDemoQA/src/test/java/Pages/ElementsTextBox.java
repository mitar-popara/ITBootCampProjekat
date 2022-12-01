package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import static Helpers.Strings.ELEMENTS_CURRENT_ADDRESS;
import static Helpers.Strings.ELEMENTS_PERMANENT_ADDRESS;

public class ElementsTextBox extends Base {
    public ElementsTextBox() {
        PageFactory.initElements(driver, this);
    }

    //for input fields
    @FindBy(id = "item-0")
    public WebElement textBoxButton; // navigation to text box from elements page
    @FindBy(id = "userName")
    public WebElement userNameField;
    @FindBy(id = "userEmail")
    public WebElement email;
    @FindBy(id = "currentAddress")
    public WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    public WebElement permanentAddress;
    @FindBy(id = "submit")
    public WebElement submitButton;

    //for asserts
    @FindBy(css = ".main-header")
    public WebElement header;
    @FindBy(id = "name")
    public WebElement nameOutput;
    @FindBy(id = "email")
    public WebElement emailOutput;
    @FindBy(css = ".mb-1")
    public List<WebElement> addressListOutput;


    //methods
    public void textBoxSelection() {
        textBoxButton.click();
    }

    public void userNameInput(String userName) {
        userNameField.clear();
        userNameField.sendKeys(userName);
    }

    public void emailInput(String userEmail) {
        email.clear();
        email.sendKeys(userEmail);
    }

    public void currentAddressInput(String userCurrentAddress) {
        currentAddress.clear();
        currentAddress.sendKeys(userCurrentAddress);
    }

    public void permanentAddressInput(String userPermanentAddress) {
        permanentAddress.clear();
        permanentAddress.sendKeys(userPermanentAddress);
    }

    public void submitButtonClick() {
        submitButton.click();
    }



    //methods for asserts
    public String headerMessage() {
        return header.getText();
    }

    public String nameOutput() {
        return nameOutput.getText();
    }

    public String emailOutput() {
        return emailOutput.getText();
    }

    public String  curentAddressOutput() {
        String curretnAddressOut = "";
        for (int i = 0; i < addressListOutput.size(); i++) {
            if (addressListOutput.get(i).getText().equals("Current Address :"+ELEMENTS_CURRENT_ADDRESS)) {
                curretnAddressOut = addressListOutput.get(i).getText();
                break;
            }
        }
        return curretnAddressOut;
    }
    public String permanentAddressOutput() {

        String permanentAddressOut = "";
        for (int i = 0; i < addressListOutput.size(); i++) {
            if (addressListOutput.get(i).getText().equals("Permananet Address :"+ELEMENTS_PERMANENT_ADDRESS)) {
                permanentAddressOut = addressListOutput.get(i).getText();
                break;
            }
        }
        return permanentAddressOut;
    }
}
