# appium-test-with-testng
Automation testing script using TestNG, Maven and Gradle for mobile platforms

### Commands if you want to run test with maven
```
brew install maven
mvn install
mvn clean test -Dsurefire.suiteXmlFiles=android.xml
mvn clean test -Dsurefire.suiteXmlFiles=ios.xml
mvn clean test -Dsurefire.suiteXmlFiles=android.xml,ios.xml
```

### Commands if you want to run with gradle
```
brew install gradle
gradle wrapper --gradle-version 2.13
./gradlew test -Psuite=android.xml
./gradlew test -Psuite=ios.xml
./gradlew test
```
