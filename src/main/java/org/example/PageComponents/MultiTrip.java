package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightAvailability;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvailability {

    private By multiCityRadio = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By informationMultiCity = By.id("MultiCityModelAlert");

    private By originCity1 = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By destinationCity1 = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By originCity2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By searchFlights = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String,String> reservationDetails) {
        makeMultiTripReady(s -> selectOriginCity(reservationDetails.get("origin")));

        selectDestinationCity(reservationDetails.get("destination"));
        selectOriginCity2(reservationDetails.get("origin2"));
        findElement(searchFlights).click();
    }

    public void selectOriginCity (String originCity){
        findElement(originCity1).click();
        findElement(By.xpath("//a[@value='"+originCity+"']")).click();
    }

    public void selectOriginCity2 (String originCityTwo){
        findElement(originCity2).click();
        findElement(By.xpath("(//a[@value='"+originCityTwo+"'])[3]")).click();
    }

    public void selectDestinationCity (String destinationCity){
        findElement(destinationCity1).click();
        findElement(By.xpath("(//a[@value='"+destinationCity+"'])[2]")).click();
    }

    public void makeMultiTripReady(Consumer<MultiTrip> consumer){
        System.out.println("I'm inside multi trip");
        findElement(multiCityRadio).click();
        findElement(informationMultiCity).click();
        waitForElementToDisappear(informationMultiCity);
//        This is to accept an execute any method on this class
        consumer.accept(this);
    }

}
