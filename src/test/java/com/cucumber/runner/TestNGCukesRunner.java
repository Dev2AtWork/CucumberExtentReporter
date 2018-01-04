package com.cucumber.runner;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

@CucumberOptions(
        //features = {"src/test/resources/features/MyFeature.feature"},
        features = {"src/test/resources/features/"},
        glue = {"com.cucumber.stepdefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
)
public class TestNGCukesRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public  static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setExtentXServerUrl("http://localhost:1337");
        extentProperties.setProjectName("MyTestProject");
//        extentProperties.setReportPath("output/myreport.html");
//        extentProperties.setReportPath("output/Run_<Current Time Stamp>/report.html");
    }

    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Ubuntu");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
