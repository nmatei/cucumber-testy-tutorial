Cucumber Testy Tutorial
=======================

Integration Tests with [Testy](https://github.com/sdl/Testy) and [Cucumber](https://cucumber.io/)

Running the Tests:
------------------

    mvn clean test -DfailIfNoTests=false
	
For Running specific Test add system parameter "test":
	 
	 mvn clean test -DfailIfNoTests=false -Dtest=ExamplesTest
	 mvn clean test -DfailIfNoTests=false -Dtest=LoginTest
	 mvn clean test -DfailIfNoTests=false -Dtest=AccountTest

