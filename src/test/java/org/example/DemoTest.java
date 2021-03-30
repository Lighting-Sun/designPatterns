package org.example;

import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.RoundTrip;
import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest{

    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setUp(){
        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails){

        travelHomePage.goTo("https://rahulshettyacademy.com/dropdownsPractise");
        travelHomePage.getFooterNavigation().selectFlight();
        travelHomePage.getFooterNavigation().getLinksCount();
        travelHomePage.getNavigationBar().selectFlight();
        travelHomePage.getNavigationBar().getLinksCount();

        //Strategy part of the pattern -> both methods use the interface
        travelHomePage.setBookingStrategy("multiTrip");
        travelHomePage.checkAvailability(reservationDetails);
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String,String>> list = getJsonData(System.getProperty("user.dir") +
                "\\src\\main\\java\\org\\example\\DataLoads\\reservationDetails.json");

        return new Object[][] {
                {list.get(0)},{list.get(1)}
        };
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
