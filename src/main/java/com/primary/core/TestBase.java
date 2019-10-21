package com.primary.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@ContextConfiguration(classes = SpringConfiguration.class)
public class TestBase  extends AbstractTestNGSpringContextTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    protected void logStartTest(){
        logInfo("TEST-START.");
    }

    @AfterMethod(alwaysRun = true)
    protected void logEndTest(){
        logInfo("TEST-END.");
    }

    protected void logInfo(String message){ LOGGER.info(message); }
}
