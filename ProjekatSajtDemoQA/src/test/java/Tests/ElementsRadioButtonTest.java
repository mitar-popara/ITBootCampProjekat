package Tests;

import Base.Base;
import Pages.ElementsRadioButton;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.URLs.ELEMENTS_PAGE;

public class ElementsRadioButtonTest extends Base {

    ElementsRadioButton elementsRadioButton;

    @BeforeMethod
    public void pageSetup(){
        driver.manage().window().maximize(); //maximizing opened window
        driver.navigate().to(ELEMENTS_PAGE); //page navigation to Elements TextBox
        elementsRadioButton = new ElementsRadioButton();
    }
    @AfterMethod
    public void pageCleanUp(){
        driver.manage().deleteAllCookies();
    }
    @AfterTest
    public void close(){
        driver.close();
        driver.quit();
    }


    @Test(priority = 10)
    public void yesRadioButtonTest() throws InterruptedException {
        elementsRadioButton.radioButtonSelection();
        Thread.sleep(2000);
        elementsRadioButton.clickOnYesButton();
        Assert.assertEquals(elementsRadioButton.getYesResult(), "You have selected Yes");
    }
    @Test(priority = 20)
    public void impressiveButton(){
        elementsRadioButton.radioButtonSelection();
        elementsRadioButton.clickOnImpressiveButton();
        Assert.assertEquals(elementsRadioButton.getImpressiveResult(), "You have selected Impressive");
    }
}
