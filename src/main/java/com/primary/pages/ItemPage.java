package com.primary.pages;

import com.primary.webdriver.ExtendedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemPage extends Page{

    @FindBy(className = "ui-pdp-title")
    private WebElement title;

    @FindBy(xpath = "//*[contains(@class,'ui-pdp-price--size-large')]/child::*")
    private List<WebElement> priceContainer;

    protected ItemPage(ExtendedWebDriver webDriver) {
        super(webDriver);
    }

    public String getTitle(){
        return title.getText();
    }

    public Double getSalePrice(){
        return priceContainer.size()>2 ?
                Double.valueOf(priceContainer.get(2).getText()):
                Double.valueOf((priceContainer.get(1).findElement(By.className("price-tag-fraction")).getText()));
    }
}
