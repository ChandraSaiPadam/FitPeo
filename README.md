Steps to Setup and run the test script


1. Prerequisites

Before you begin, ensure the following are installed on your system:
	•	Java Development Kit (JDK): Version 8 or higher.
	•	Apache Maven: For dependency management.
	•	Web Browser: Such as Google Chrome or Firefox.
	•	Browser Driver: Example: ChromeDriver for Chrome or GeckoDriver for Firefox.

2. Setting Up the Script

Step 1: Download the Script

	•	Clone the repository or copy the script files to your system.

Step 2: Install Dependencies

	•	Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
	•	If using Maven, ensure the pom.xml file includes all required dependencies for Selenium:

<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.x.x</version>
</dependency>

And for TestNG:

<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
    <scope>test</scope>
</dependency>


	•	Run the Maven command to download the dependencies:

mvn clean install

3. Running the Script

Step 1: Configure WebDriver

	•	Ensure the browser driver (e.g., chromedriver.exe) is:
	•	Downloaded and compatible with the browser version.
	•	Located in a folder included in your system’s PATH or explicitly set in the script.

Step 2: Execute the Script

•               In your IDE, locate the main class with the public static void main method.
•               Run the script:
•               If using the command line:  mvn test
•	             Or, directly execute it from the IDE.



