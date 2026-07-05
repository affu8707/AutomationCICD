# SeleniumFrameworkDesign

A Selenium WebDriver automation project testing the Rahul Shetty Academy Client e-commerce application (`https://rahulshettyacademy.com/client/`), focusing on the login, product selection, cart, and checkout flow.

## Tech Stack
- **Language:** Java 1.8
- **Browser Automation:** Selenium WebDriver (4.38.0)
- **Build Tool:** Maven
- **Assertions:** JUnit 3.8.1 (TestNG 7.11.0 is included in `pom.xml`, but no `@Test` methods are currently implemented).
- **Reporting:** No external reporting (e.g., ExtentReports, Allure) is configured.

## Features Demonstrated
- **Page Object Model (POM):** UI interactions are abstracted into page classes (e.g., `LandingPage`, `ProductCatalogue`, `cartPage`, `CheckOutPage`, `confirmationPage`).
- **End-to-End Flow:** Automates the complete shopping journey from login to order confirmation.
- **Synchronization:** Uses explicit waits (`WebDriverWait`) for reliable element interaction.
- **Java Basics:** Includes solutions to several common Java interview questions.

## Folder Structure
```text
├── src/main/java/afnanaacademy/AbstractComponents/ # Common utilities and wrappers
├── src/main/java/afnanacademy/pageobjects/         # Page Object classes
├── src/test/java/afnanacademy/                     # Automation execution scripts (main methods) and Java exercises
├── pom.xml                                         # Maven dependencies and Java version config
└── .gitignore                                      # Ignored IDE and build files
```

## Running the Tests
Currently, the tests are implemented as standard Java applications containing a `public static void main` method rather than TestNG/JUnit `@Test` methods. 

To compile and execute the Maven lifecycle:
```bash
mvn clean test
```
*(Note: Because there are no `@Test` annotations, `mvn test` will report 0 tests run.)*

To execute the main end-to-end automation script from the command line:
```bash
mvn exec:java -Dexec.mainClass="afnanacademy.StandAloneTest" -Dexec.classpathScope=test
```
*(Alternatively, you can run `StandAloneTest.java` directly from your IDE.)*

## Test Class / Method Count
- **Test Executables (`main` methods):** 3 (`StandAloneTest.java`, `StandAloneTestNew.java`, `WindowAuthenticationPopup.java`)
- **Empty Test Classes:** 1 (`SubmitOrderTest.java`)
- **Java Interview Exercises:** 8 classes
