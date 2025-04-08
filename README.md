# 🚀 TestMyBank - Selenium Test Automation Framework

**TestMyBank** is a robust Selenium-based automation framework built using **Java** and **TestNG**, structured with the **Page Object Model (POM)** design. It supports **CI/CD** pipelines using **Jenkins**, integrates **Git** for version control, and generates detailed test reports, logs, and screenshots.

---

## 🧰 Tech Stack

- **Language**: Java  
- **Automation**: Selenium WebDriver  
- **Test Framework**: TestNG  
- **Design Pattern**: Page Object Model (POM)  
- **Build Tool**: Maven  
- **Reporting**: Extent Reports  
- **Logging**: Log4j  
- **Version Control**: Git  
- **CI/CD Integration**: Jenkins  
- **Execution Support**: run.bat

---

## 📁 Project Structure

TestMyBank/ ├── src/test/java/ │ ├── pageObjects/ # Page classes with locators and actions │ ├── testCases/ # TestNG test classes │ ├── utilities/ # Common utils: config, logger, waits, base class │ ├── Logs/ # Log4j output ├── Screenshots/ # Screenshots captured on test failure ├── test-output/ # Extent HTML reports ├── testng.xml # TestNG suite configuration ├── run.bat # Batch file to run tests locally ├── pom.xml # Maven dependency and build config └── README.md # This file


---

## ⚙️ Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-repo/TestMyBank.git
   cd TestMyBank

2. Install Maven Dependencies
mvn clean install

3. Check Configuration

Update config.properties with correct URL, credentials, and browser.




▶️ How to Run Tests
🧪 Option 1: Run using Maven & TestNG
bash
Copy
Edit
mvn test -DsuiteXmlFile=testng.xml
🖱️ Option 2: Run via IntelliJ
Open project in IntelliJ

Right-click on testng.xml → Run

⚙️ Option 3: Run using run.bat (Windows)
bash
Copy
Edit
./run.bat
📊 Reports, Logs & Screenshots
Feature	Path
📄 HTML Report	test-output/ExtentReport.html
🧾 Logs	Logs/app.log
🖼 Screenshots	Screenshots/ (on failure)
🔁 Jenkins Integration
Jenkins fetches the project using Git.

Triggers test run using run.bat or Maven commands.

Archives:

📄 HTML Reports

🖼 Failure Screenshots

Jenkins Freestyle Job Snippet:
groovy
Copy
Edit
git 'https://github.com/your-repo/TestMyBank.git'
bat 'run.bat'
archiveArtifacts artifacts: '**/Screenshots/*.png', fingerprint: true
publishHTML(target: [reportDir: 'test-output', reportFiles: 'ExtentReport.html', reportName: 'Test Report'])

✅ Features Implemented
 Login functionality

 New customer registration

 Delete customer functionality

 Form validation tests

 Data-driven testing (via Excel)

 Screenshot on failure

 HTML & log reporting


## 🙋‍♀️ Interviewer-Friendly Highlights

- Built from scratch using Java + Maven
- Organized POM structure
- Logs, Screenshots, Reports integrated
- Git + Jenkins support added for CI/CD
- Easily maintainable and scalable framework

---

> Designed and implemented with automation best practices. 🎯
