package org.example.PageObjects;

import org.example.AbstractComponents.SearchFlightAvailability;
import org.example.AbstractComponents.StrategyFactory;
import org.example.PageComponents.FooterNavigation;
import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

//    To make the function delegation, there should be an Abstract Component
public class TravelHomePage {

    WebDriver driver;

    By sectionElement = By.id("traveller-home");
    By navigationBar = By.id("buttons");
    SearchFlightAvailability searchFlightAvailability;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(String URL){
        driver.get(URL);
    }

    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver, navigationBar);
    }

    public FooterNavigation getFooterNavigation(){
        return new FooterNavigation(driver,sectionElement);
    }

//    Creation of the strategy! -> using the interface both classes can use this method
    public void setBookingStrategy (String strategyType){
        StrategyFactory strategyFactory = new StrategyFactory(driver);
        searchFlightAvailability = strategyFactory.createStrategy(strategyType);
    }

    public void checkAvailability(HashMap <String,String> reservationDetails) {
        searchFlightAvailability.checkAvail(reservationDetails);
    }

}
