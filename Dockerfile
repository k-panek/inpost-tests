FROM maven:3.9-amazoncorretto-21-al2023
ARG env
ARG tag
ARG token
ARG grid
COPY *.xml    .
COPY src/    ./src/
WORKDIR .
ENTRYPOINT mvn clean test -Denv=$env -Dcucumber.filter.tags=$tag -Dtoken=$token -Dgrid=$grid