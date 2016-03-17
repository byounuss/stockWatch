This project is based on below projects
* [Cucumber-JVM-Parallel](https://github.com/tristanmccarthy/Cucumber-JVM-Parallel)
* [java-parallel](https://github.com/cucumber/cucumber-jvm/tree/java-parallel-example/examples/java-parallel)

It allows you to run Cucumber features (tests/scenarios) in multiple browsers simultaneously using Selenium (WebDriver) and TestNG.


## Running features in IDE
Tested in eclipse
To run all stories from IDE only in Firefox, simply right click on one of the files:
* cucumber.examples.java.testNG.runners.RunCukesTestInChrome


And chose "Run ..."
(Yes, choosing RunCukesTestInChrome will also run tests in FF,Android and iOS!)

## Running features from CLI
Run tests using local browsers:

    mvn clean install

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

Due to the release here in my company I was not concentrated much on the performance, it is taking lot of time to run the for loop 
     while implementing Decscending order logic.
     

