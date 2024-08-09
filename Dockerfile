FROM maven:3.9-amazoncorretto-21-al2023
ARG env
ARG tag
ARG grid
ARG token_file
COPY *.xml    .
COPY src/    ./src/
WORKDIR .
ENTRYPOINT mvn clean test -Denv=$env -Dcucumber.filter.tags=$tag -Dtoken_file=$token_file -Dgrid=$grid