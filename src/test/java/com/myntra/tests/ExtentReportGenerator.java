package com.myntra.tests;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {

	protected static final Logger logger;
	
	static {
        Configurator.initialize(null, "src/test/resources/log_config.xml");
        logger = LogManager.getLogger(ExtentReportGenerator.class);
    }
		
	protected static ExtentReports extentReportsObj = new ExtentReports();
	protected static ExtentSparkReporter extentSparkReporterObj;
	protected static ExtentTest testObj;	

	
	public void createExtentReport() {
		logger.info("extent reporting started");		
		File extentSparkReporterFileObj = new File("./extentReports.html");
		extentSparkReporterObj = new ExtentSparkReporter(extentSparkReporterFileObj);
		extentReportsObj.attachReporter(extentSparkReporterObj);
	}
	
	public void flushExtentReport() {
		logger.info("extent reporting ended");
		extentReportsObj.flush();
	}
}
