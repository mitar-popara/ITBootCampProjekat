package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Base {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".card.mt-4.top-card")
    public List<WebElement> cards;
    @FindBy(css = ".pattern-backgound.playgound-header")
    public WebElement header;



    //-------------------------------------



    //Selection of  elements on Home Page
    public void elementsSelection() {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals("Elements")) {
                cards.get(i).click();
                break;
            }
        }
    }
    public void formsSelection(){
        for (int i = 0; i < cards.size(); i++){
            if(cards.get(i).getText().equals("Forms")){
                cards.get(i).click();
                break;
            }
        }
    }
    public void alertsFrameAndWindowsSelection(){
        for (int i = 0; i < cards.size(); i++){
            if(cards.get(i).getText().equals("Alerts, Frame & Windows")){
                cards.get(i).click();
                break;
            }
        }
    }
    public void widgetsSelection(){
        for (int i = 0; i < cards.size(); i++){
            if(cards.get(i).getText().equals("Widgets")){
                cards.get(i).click();
                break;
            }
        }
    }
    public void interactionsSelection(){
        for (int i = 0; i < cards.size(); i++){
            if(cards.get(i).getText().equals("Interactions")){
                cards.get(i).click();
                break;
            }
        }
    }
    public void bookStoreApplicationsSelection(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,260)", "");   //scroll to bookstore card
        for (int i = 0; i < cards.size(); i++){
            if(cards.get(i).getText().equals("Book Store Application")){
                cards.get(i).click();
                break;
            }
        }
    }

    //-----------
    //methods for asserts
    public String headerMessage(){
        return header.getText();
    }
}
