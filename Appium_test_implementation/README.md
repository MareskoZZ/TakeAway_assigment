## Test assignment for TakeAway

## Preparation to environment
0. install java11
1. install and setup Android studio
2. install and setup Appium server, and setup all Global variable (ANDROID_HOME, JAVA_HOME)
3. check that all installed (appium-doctor - command tool for help)
4. install maven and setup Global variable MAVEN_HOME M2_HOME
or 
0. install java11
1. install AppiumStudio 
2. install maven

## How to run
0. run appium server

first way:
1. run command in project folder
`mvn clean -Dsuite="testngCustom.xml" -Dudid="{YourUDID}" -Dport="{YourAppiumPort}" test`

second way:
1. open testng.xml and fill in next row 

        <parameter name="udid" value="{YourUDID}" />
        <parameter name="port" value="{YourAppiumPort}" />
        
2. run command  `mvn clean -Dsuite="testng.xml"  test`   

third way:
1. just use development studio

## Description
I try show flexible framework which can be easily improved and increased

## Contains
- testNG - because it is much more flexible that Junit
- PageFactory and POM - because it is one of the best solution for big test project 
- surefire - as a base report (i didn't integrate Allure or Extent reports, coz different company choose different reports tools)
- Java 11- as a base language
- Maven  