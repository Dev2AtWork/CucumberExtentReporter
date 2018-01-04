package com.cucumber.stepdefinitions;

import com.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert.*;

import java.io.IOException;

public class MyTestStepDefs {

    @Before
    public void beforeScenario(Scenario scenario) {
        if (scenario.getName().equals("My First Test Scenario")) {
            Reporter.assignAuthor("AbhiN");
        }
    }

    @Given("I have existing feature") public void I_have_existing_feature()
        throws IOException {
        Reporter.addStepLog("I have existing feature");
        Reporter.addScenarioLog("This is scenario log");
    }

    @When("I write a new feature") public void I_write_a_new_feature()
            throws IOException {
            Reporter.addStepLog("I am writing a new feature");
            Reporter.addScenarioLog("This is scenario log");
        }
    
    @Then("I should see that feature") public void I_should_see_that_feature() {
    	Reporter.addStepLog("I see that feature!");
    	//Assert.assertTrue(false);
    }

}
