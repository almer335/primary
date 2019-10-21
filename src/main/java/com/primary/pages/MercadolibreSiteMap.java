package com.primary.pages;

import com.primary.utils.PropertiesDefault;
import com.primary.webdriver.ExtendedWebDriver;

public class MercadolibreSiteMap {

    private final ExtendedWebDriver extendedWebDriver;

    private final String siteUrl = new PropertiesDefault().getProperties().getProperty("site.endpoint");

    public MercadolibreSiteMap(ExtendedWebDriver extendedWebDriver){
        this.extendedWebDriver = extendedWebDriver;
    }

    public HomePage homePage(){
        extendedWebDriver.get(siteUrl);
        return new HomePage(this.extendedWebDriver);
    }
}
