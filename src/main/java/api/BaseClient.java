package api;

import data.Token;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import java.util.Properties;

public class BaseClient {

    public RequestSpecBuilder getBaseReqSpecification(final Properties properties) {
        Token token = new Token();
        RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
        reqSpecBuilder
                .addHeader("Authorization", token.getBearerToken())
                .setBaseUri(properties.getProperty("baseUri"))
                .setBasePath(properties.getProperty("basePath"))
                .setContentType(ContentType.JSON);
        return reqSpecBuilder;
    }

}
