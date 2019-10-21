package com.primary.pages;


import com.primary.webdriver.ExtendedWebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {

    private static final int TIMEOUT_FOR_DOCUMENT_READY = 40;
    protected ExtendedWebDriver webDriver;

    protected Page(ExtendedWebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waitUntilDocumentReadyStateIsComplete();
    }

    protected void waitUntilDocumentReadyStateIsComplete() {
        webDriver.waitUntil(TIMEOUT_FOR_DOCUMENT_READY, wd -> webDriver.executeScript("return document.readyState").equals("complete"));
    }

    public String url(){
        return webDriver.getCurrentUrl();
    }

}
