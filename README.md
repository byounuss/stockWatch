

This project is based on below projects
* [Cucumber-JVM-Parallel](https://github.com/tristanmccarthy/Cucumber-JVM-Parallel)
* [java-parallel](https://github.com/cucumber/cucumber-jvm/tree/java-parallel-example/examples/java-parallel)

It allows you to run Cucumber features (tests/scenarios) in multiple browsers simultaneously using Selenium (WebDriver) and TestNG.

Requirements :
Java : 1.7
Maven and set the path for M2_HOME and $M2_HOME in PATH so that can able to mvn from command prompt

## Running features from CLI
Run tests using local browsers:

    mvn clean install
    
## Running features in IDE
Tested in eclipse
To run all stories from IDE only in Firefox, simply right click on one of the files:
* cucumber.examples.java.testNG.runners.RunCukesTestInChrome


And chose "Run ..."
(Yes, choosing RunCukesTestInChrome will also run tests in FF,Android and iOS!)



To run all stories simultaneously in all browsers (Chrome,Firefox,Android and iOS) right click on one of the files:
* src/test/resources/TestNGRunTests.xml

And chose "Run as TestNG Suite..."



## Viewing the results
All Cucumber reports [html, json, xml, js] are in: target/cucumber-report

##Information 
Path of different file related to this project :

* src/test/resources/features/ndsotckwatch.feature 
* src/test/java/KB.stockWatch.java.testNG.runners
* src/test/java/KB.stockWatch.java.testNG
* src/test/java/KB.stockWatch.java.testNG.pageObjects
* src/test/java/KB.stockWatch.java.testNG.stepDefinition
* src/test/java/KB.stockWatch.java.testNG.keywords
* KB/stockWatch/src/test/resources/TestNGRunTests.xml 
