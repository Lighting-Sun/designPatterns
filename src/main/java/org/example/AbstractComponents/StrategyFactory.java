package org.example.AbstractComponents;

import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactory {

    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");

    public StrategyFactory(WebDriver driver) {
        this.driver = driver;
    }

    // This class is being used to create objects
    public SearchFlightAvailability createStrategy(String strategyType){
        if(strategyType.equalsIgnoreCase("multiTrip")){
            return new MultiTrip(driver, sectionElement);
        }
        if(strategyType.equalsIgnoreCase("roundTrip")){
            return new RoundTrip(driver, sectionElement);
        }
        return null;
    }
}
