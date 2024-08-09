# inpost-tests

Requirements:
- JDK
- Maven
- ChromeDriver
- Docker

GUI tests run command:
mvn test -Denv={env} -Dcucumber.filter.tags="@GuiTests"

API tests run command:
mvn test -Denv={env} -Dcucumber.filter.tags="@ApiTests" -Dtoken_file={path}

All tests run command:
mvn test -Denv={env} -Dtoken_file={path}

Docker run command (with example env config file):
docker-compose --env-file ./configs/example-prod.env up

Variables:
- env - default "prod" - properties for preferable environment (./src/test/resources/properties/{env}.properties)
- token_file - mandatory to API tests - path to file with token that has access to endpoint /v1/points (the test token you can find here: https://geowidget.inpost.pl/examples/index.html)
- grid - mandatory to GUI tests on docker - selenium grid url
- tag - optional - cucumber tests tag

Additional info:
- Screenshot after every (GUI test) fail is saved to ./target/screenshots/{scenario.name}-{scenario.id}
- HTML report with tests results is saved to ./target/cucumber-reports/cucumber.html
- JSON files with parcel lockers list are saved to ./target/parcellockers.{city}.json