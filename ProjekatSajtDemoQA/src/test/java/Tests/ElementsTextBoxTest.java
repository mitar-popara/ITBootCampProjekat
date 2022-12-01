package Tests;

import Base.Base;
import Pages.ElementsTextBox;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.Strings.*;
import static Helpers.URLs.ELEMENTS_PAGE;


public class ElementsTextBoxTest extends Base {
    ElementsTextBox elementsTextBox;

    @BeforeMethod
    public void pageSetup(){
        driver.manage().window().maximize(); //maximizing opened window
        driver.navigate().to(ELEMENTS_PAGE); //page navigation to Elements TextBox
        elementsTextBox = new ElementsTextBox();
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



    //tests
    @Test(priority = 10)
    public void textBoxSelection(){
        elementsTextBox.textBoxSelection();
        Assert.assertEquals(elementsTextBox.headerMessage(), "Text Box");
    }

    @Test(priority = 20)
    public void formFillIn(){
        elementsTextBox.textBoxSelection();
        elementsTextBox.userNameInput(ELEMENTS_USER_NAME);
        elementsTextBox.emailInput(ELEMENTS_EMAIL);;
        elementsTextBox.currentAddressInput(ELEMENTS_CURRENT_ADDRESS);
        elementsTextBox.permanentAddressInput(ELEMENTS_PERMANENT_ADDRESS);
        elementsTextBox.submitButtonClick();

        //asserts
        Assert.assertEquals(elementsTextBox.nameOutput(), "Name:"+ELEMENTS_USER_NAME);
        Assert.assertEquals(elementsTextBox.emailOutput(), "Email:"+ELEMENTS_EMAIL);
        Assert.assertEquals(elementsTextBox.curentAddressOutput(), "Current Address :"+ELEMENTS_CURRENT_ADDRESS);
        Assert.assertEquals(elementsTextBox.permanentAddressOutput(), "Permananet Address :"+ELEMENTS_PERMANENT_ADDRESS);
    }
}
