package com.primary.core;



import com.primary.pages.MercadolibreSiteMap;
import com.primary.webdriver.ExtendedWebDriver;
import com.primary.webdriver.WebDriverBuilder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class TestBaseFrontEnd {

    protected ExtendedWebDriver driver;
    protected MercadolibreSiteMap mercadolibreSiteMap;
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBaseFrontEnd.class);

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        driver = new ExtendedWebDriver(new WebDriverBuilder(browser).build());
        try{ driver.maximize();}catch (WebDriverException e){driver.manage().window().setSize(new Dimension(1600,900));}
        mercadolibreSiteMap = new MercadolibreSiteMap(driver);
        logInfo("Setup done.");
        logInfo("TEST-START.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logInfo("TEST-END.");
        driver.closeDriver();
        logInfo("Driver closed");
    }

    protected void logInfo(String message){ LOGGER.info(message); }
}


