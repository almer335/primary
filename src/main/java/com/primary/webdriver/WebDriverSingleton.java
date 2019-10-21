package com.primary.webdriver;


public class WebDriverSingleton {

    private static ThreadLocal<ExtendedWebDriver> instance = null;

    private WebDriverSingleton(){}

    public static ThreadLocal<ExtendedWebDriver> getInstance(){
        if (instance == null){
            instance = new ThreadLocal<ExtendedWebDriver>();
        }
        return instance;
    }

}
