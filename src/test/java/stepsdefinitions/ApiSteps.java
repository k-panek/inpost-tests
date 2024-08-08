package stepsdefinitions;

import api.points.response.ItemsItem;
import api.points.response.PointsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.Token;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.ParcelLockerData;
import org.assertj.core.api.Assertions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ApiSteps extends Base {
    RequestSpecification requestSpecification;
    PointsResponse pointsResponse;
    Response response;
    Token token = new Token();

    @Before(value = "@ApiTests")
    public void setup() {
        RestAssured.baseURI = properties.getProperty("baseUri");
        RestAssured.basePath = properties.getProperty("basePath");
        requestSpecification = RestAssured.requestSpecification = RestAssured.given()
                .headers("Authorization", token.getBearerToken(),
                        "app-referrer", "geowidget.inpost.pl")
                .contentType(ContentType.JSON);
    }

    @Given("user prepares parcel lockers search request")
    public void user_prepares_parcel_lockers_search_request() {
        requestSpecification = requestSpecification
                .params("status", "Operating,Overloaded",
                        "perPage", "100",
                        "type", "parcel_locker");
    }

    @And("user adds to the request query param city {string}")
    public void user_adds_to_the_request_query_param_city(final String city) {
        requestSpecification = requestSpecification.params(
                "city", city);
    }

    @When("user makes a call")
    public void user_makes_a_call() {
        response = requestSpecification.log().all().get();
    }

    @And("response status code is 200")
    public void response_status_code_is_200() {
        Assertions.assertThat(response.getStatusCode())
                .as("Response code is different than 200")
                .isEqualTo(200);
    }

    @Then("list of parcel lockers for {string} is returned")
    public void list_of_parcel_lockers_for_is_returned(final String city) {
        pointsResponse = response.getBody().as(PointsResponse.class);
        Assertions.assertThat(checkIfAllReturnedParcelLockersHaveCity(pointsResponse, city))
                .as("Not all returned parcel lockers have expected city")
                .isTrue();
    }

    @And("name, postal code and coordinates for returned list are saved to the file parcellockers.{string}.json")
    public void name_postal_code_and_coordinates_for_returned_list_are_saved_to_the_file_parcellockers_json(final String city) {
        List<ParcelLockerData> parcelLockerDataList = new ArrayList<>();
        pointsResponse.getItems().forEach(
                pl -> parcelLockerDataList.add(getParcelLocalData(pl))
        );
        saveJsonFile(parcelLockerDataList, String.format("parcellockers.%s.json", city));
    }

    private boolean checkIfAllReturnedParcelLockersHaveCity(final PointsResponse pointsResponse, final String city) {
        return pointsResponse.getItems().stream().allMatch(pl -> pl.getAddressDetails().getCity().equalsIgnoreCase(city));
    }

    private ParcelLockerData getParcelLocalData(final ItemsItem parcelLockerItem) {
        ParcelLockerData parcelLockerData = new ParcelLockerData();
        parcelLockerData.setName(parcelLockerItem.getName());
        parcelLockerData.setPostalCode(parcelLockerItem.getAddressDetails().getPostCode());
        parcelLockerData.setCoordinates(parcelLockerItem.getLocation());
        return parcelLockerData;
    }

    private void saveJsonFile(final Object object, final String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(object);
            System.out.println(json);
            mapper.writeValue(new File(
                    String.format("./target/json-files/%s", fileName)), json);
        } catch (Exception e) {
            System.out.println("Exception while creating json " + e.getMessage());
        }
    }
}
