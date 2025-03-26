package steps;

import BaseTest.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        BaseTest.initializeDriver();
    }

    @After
    public void tearDown() {
        BaseTest.quitDriver();
    }
}
