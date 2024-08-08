# inpost-tests

GUI tests run command:
mvn test -Denv={env} -Dcucumber.filter.tags="@GuiTests"

API tests run command:
mvn test -Denv={env} -Dcucumber.filter.tags="@ApiTests" -Dtoken={token}

All tests run command:
mvn test -Denv={env} -Dtoken={token}

Variables:
- env - properties for preferable environment
- token - token with access to endpoint /v1/points (test token is possible to get from: https://geowidget.inpost.pl/examples/index.html)
- grid - selenium grid url

Screenshot after every (GUI test) fail is saved to ./target/screenshots/{scenario.name}-{scenario.id}
HTML report with tests results is saved to ./target/cucumber-reports/cucumber.html
JSON files with parcel lockers list are saved to ./target/parcellockers.{city}.json