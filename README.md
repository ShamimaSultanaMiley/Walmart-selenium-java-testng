# Selenium Automation Framework for Walmart Product Analysis

## Overview

This project is an automated testing framework developed using Java and TestNG for analyzing Walmart product details. The framework utilizes Selenium for web automation and is designed to navigate through multiple pages of search results on Walmart's website.

## Project Structure

The project is structured into two main packages:

1. **BasePackage**: Contains the base class (`BaseClass`) responsible for setting up the WebDriver, loading locator properties, and providing reusable methods for interacting with web elements.

   - `BaseClass`: Initializes WebDriver, sets up Chrome options to exclude automation control, and defines common methods for navigation, sending keys, clicking, and retrieving text.

2. **TaskList**: Contains test classes, such as `TestTotalResult`, which extends the `BaseClass`. Test classes implement specific test scenarios using TestNG annotations.

   - `TestTotalResult`: Implements a test scenario for analyzing Walmart product search results. It calculates and prints the total number of search results across multiple pages.

## Prerequisites

Before running the tests, ensure the following:

- **Web Driver**: ChromeDriver is placed in the specified location.

- **Locator Properties**: Update the `locators.properties` file with the correct locators for the elements on the Walmart website.

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/walmart-automation-framework.git
   ```

2. Open the project in your preferred Java IDE.

3. Configure the `locators.properties` file in the specified folder.

4. Run the test classes using TestNG.

## Test Scenario

### 1. Total Search Result For Every Page

This test scenario navigates to the Walmart website, performs a search (e.g., "camera"), and iterates through each page of search results. It calculates and prints the total number of search results across all pages. An assertion is included to ensure that the total result is greater than 500.

## Notes

- Make sure to adapt the XPath expressions in `locators.properties` based on the structure of the Walmart website, as changes to the website may affect the reliability of the automation scripts.

- Additional test scenarios and functionalities can be added by extending the framework.
