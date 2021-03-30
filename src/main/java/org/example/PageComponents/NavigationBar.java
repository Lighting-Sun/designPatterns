package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {

    By flights = By.cssSelector("[title='Flights']");
    By links = By.tagName("a");

    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public void selectFlight(){
        System.out.println(findElement(flights).getAttribute("class"));
    }

    public void getLinksCount(){
        System.out.println(findElements(links).size());
    }
}
