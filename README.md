# Note App COCUS Appium Challenge

This repo contains the automation test for Note App COCUS Appium challenge with Appium, Java as programming language as well as TestNG as framework with extent as the reporter.


## Pre-requisites
In order to run this, you should have
* macOS High Sierra or Mojave or Windows
* Java 11 or above
* NodeJS and npm
* Appium Server
* Android Studio with Emulator

### Tools & Technologies :

* Java
* Appium
* TestNG
* Maven
* Extent
* IntelliJ


## Steps to Run
* Ensure to configure avd in the desired capabilities in TestBase Class
* Have Appium Server running
* Have emulator running
* Clone the git repo
* Cd into the cloned repo
* After cd into to the cloned repo, run:
```bash
mvn clean
```
* To Run test use:
```bash
mvn compile test
```
## To See Extent Test Report

* On the root folder you will see the first test-report.html

## Bug

* Bug_title: The app crashes on click on add picture
* Bug_description: When a user clicks on add picture the application force close

###### Steps to reproduce bug
1. Launch application
2. Click on + button
3. Click on the button at the right top corner
4. Click on Add picture



