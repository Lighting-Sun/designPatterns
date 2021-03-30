package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements SearchFlightAvailability {

    private By roundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By departureCity = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By arrivalCity = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By indArmedCheck = By.id("ctl00_mainContent_chk_IndArm");
    private By searchFlights = By.id("ctl00_mainContent_btn_FindFlights");


    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    @Override
    public void checkAvail(HashMap<String,String> reservationDetails) {
        System.out.println("I'm inside round trip");
        findElement(roundTrip).click();
        findElement(departureCity).click();
        selectOriginCity(reservationDetails.get("origin"));
        findElement(arrivalCity).click();
        selectDestinationCity(reservationDetails.get("destination"));
        findElement(indArmedCheck).click();
        findElement(searchFlights).click();
    }

    public void selectOriginCity (String originCity){
        findElement(By.xpath("//a[@value='"+originCity+"']")).click();
    }

    public void selectDestinationCity (String destinationCity){
        findElement(By.xpath("(//a[@value='"+destinationCity+"'])[2]")).click();
    }

}
