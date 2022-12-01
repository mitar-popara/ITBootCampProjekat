package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsRadioButton extends Base {
    public ElementsRadioButton(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "item-2")
    public WebElement radioButton; //navigation from elements page to radio button
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/label") //xpath had to be used because no other possible way with ID,CSS...
    public WebElement yesButton;
    @FindBy(id = "impressiveRadio")
    public WebElement  impressiveButton;
    @FindBy(css = ".mt-3")
    public List<WebElement> textResult;


    //methods
    public void radioButtonSelection(){
        radioButton.click();
    }
    public void clickOnYesButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(yesButton).click().perform();
    }
    public void clickOnImpressiveButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(impressiveButton).click().perform();
    }

    //for asserts

    public String getYesResult(){
        String yesResult = "";
        for (int i = 0; i<textResult.size(); i++){
            if (textResult.get(i).getText().contains("Yes")){
                yesResult = textResult.get(i).getText();
            }
        }
        return yesResult;
    }

    public String getImpressiveResult(){
        String impressiveResult = "";
        for (int i = 0; i < textResult.size(); i++){
            if (textResult.get(i).getText().contains("Impressive")){
                impressiveResult = textResult.get(i).getText();
            }
        }
        return impressiveResult;
    }
}
