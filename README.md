# SeleniumFrameworkDesign

A Selenium WebDriver automation project testing the Rahul Shetty Academy Client e-commerce application (`https://rahulshettyacademy.com/client/`), focusing on the login, product selection, cart, and checkout flow.

## Tech Stack
- **Language:** Java 11
- **Browser Automation:** Selenium WebDriver (4.38.0)
- **Build Tool:** Maven
- **Test Framework:** TestNG (7.11.0)
- **CI/CD:** GitHub Actions workflow triggered on push/PR
- **Reporting:** Surefire Default Reports

## Features Demonstrated
- **Page Object Model (POM):** UI interactions are abstracted into page classes.
- **End-to-End Flow:** Automates the complete shopping journey from login to order confirmation.
- **Synchronization:** Uses explicit waits (`WebDriverWait`) for reliable element interaction.
- **TestNG Integration:** Robust test structure with proper assertions and setup/teardown methods.
- **CI/CD Pipeline:** Automated execution via GitHub Actions on every commit to `main`.

## Folder Structure
```text
├── src/main/java/afnanaacademy/AbstractComponents/ # Common utilities and wrappers
├── src/main/java/afnanacademy/pageobjects/         # Page Object classes
├── src/test/java/afnanacademy/                     # Automation execution scripts (main methods) and Java exercises
├── pom.xml                                         # Maven dependencies and Java version config
└── .gitignore                                      # Ignored IDE and build files
```

## Running the Tests
To compile and execute the complete test suite via Maven and TestNG:
```bash
mvn clean test
```

## Test Class Summary
- **UI Automation Tests:** 1 (`SubmitOrderTest.java` - End-to-End Shopping Flow)
