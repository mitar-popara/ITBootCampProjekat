package Tests;

import Base.Base;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.URLs.HOME_PAGE;

public class HomePageTest extends Base {
    HomePage homePage;


    @BeforeMethod
    public void pageSetup(){
        driver.manage().window().maximize(); //maximizing opened window
        driver.navigate().to(HOME_PAGE);     //page navigation to Home Page
        homePage = new HomePage();
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


    // Tests  Home Page
    @Test(priority = 10)
    public void elementsPageOpen(){
        homePage.elementsSelection();
        Assert.assertTrue(homePage.headerMessage().equals("Elements"));
    }

    @Test(priority = 20)
    public void formsPageOpen(){
        homePage.formsSelection();
        Assert.assertTrue(homePage.headerMessage().equals("Forms"));
    }

    @Test(priority = 30)
    public void alertsFrameAndWindowsPageOpen(){
        homePage.alertsFrameAndWindowsSelection();
        Assert.assertTrue(homePage.headerMessage().equals("Alerts, Frame & Windows"));
    }

    @Test(priority = 40)
    public void widgetsPageOpen(){
        homePage.widgetsSelection();
        Assert.assertTrue(homePage.headerMessage().equals("Widgets"));
    }

    @Test(priority = 50)
    public void interactionPageOpen(){
        homePage.interactionsSelection();
        Assert.assertTrue(homePage.headerMessage().equals("Interactions"));
    }

    @Test(priority = 60)
    public void bookStoreApplicationPageOpen(){
        homePage.bookStoreApplicationsSelection();
        Assert.assertTrue(homePage.headerMessage().equals("Book Store"));
    }


}
