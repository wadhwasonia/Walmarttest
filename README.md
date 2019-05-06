# Walmart

This is a test exercise consisting of 3 automated tests to be executed as smoke tests for walmart.ca

Details of 3 tests:
1. Verify search on walmart.ca is working.
2. Verify user is able to shop products under Mother's day category
3. Verify user is able to schedule pickup for grocery

## Dependencies

1. An IDE - Eclipse or IntelliJ
2. Change the path for chrome driver in walmart_test.java 
(System.setProperty("webdriver.chrome.driver", "desired path")


## Testng
1. Run your tests  through walmart.xml(/src/main/resources/walmart.xml)
2. Parameterization is done through testng file.
3. To ignore a test, set enabled parameter to false  alongside test
e.g.  @Test(enabled = false)
4. To run tests in a particular sequence, set priority alongside test
e.g. @Test(priority=1)
