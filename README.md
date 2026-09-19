# Crio QA Automation - Google Forms Assignment

## 📌 Project Overview

This project is a Selenium WebDriver automation assignment completed as part of the Crio QA/SDET program.

The automation validates and submits a Google Form using Selenium WebDriver with Java and TestNG.

## 🛠️ Technology Stack

- Java 11
- Selenium WebDriver 4.21.0
- TestNG
- Gradle 7.5.1
- Google Chrome
- Git / GitHub
- Windows 11

## 🧪 Automated Test Scenario

The automated test performs the following actions:

1. Opens the Google Form.
2. Enters `Crio Learner` in the name field.
3. Enters the required QA Engineer statement with the current Unix epoch timestamp.
4. Selects `3 - 5` years of automation testing experience.
5. Selects:
   - Java
   - Selenium
   - TestNG
6. Selects `Mr` from the address dropdown.
7. Calculates and enters the date from 7 days ago dynamically.
8. Enters the time `07:30`.
9. Submits the form.
10. Validates the successful submission message:
    `Thanks for your response, Automation Wizard!`

## 🏗️ Framework Design

The project uses reusable wrapper methods for Selenium actions.

### Wrappers implemented

- `navigateTo()`
- `enterText()`
- `clickElement()`
- `selectFromDropdown()`
- `enterDate()`
- `isElementDisplayed()`
- `getText()`
- `waitForElement()`

This keeps the test case readable and promotes reusable Selenium operations.

## ▶️ Running the Test

Clone the repository:

```bash
git clone https://github.com/gitkousik/kousik79-ME_QA_XGOOGLE_FORM.git
