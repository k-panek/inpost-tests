package stepsdefinitions;

import api.BaseClient;
import api.points.response.ItemsItem;
import api.points.response.PointsResponse;
import helpers.SaveFile;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.ParcelLockerData;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class ApiSteps extends Base {
    RequestSpecification requestSpecification;
    Response response;
    PointsResponse pointsResponse;

    @Before(value = "@ApiTests")
    public void setup() {
        BaseClient baseClient = new BaseClient();
        requestSpecification = baseClient.getBaseReqSpecification(properties).build();
    }

    @Given("user prepares parcel lockers search request")
    public void user_prepares_parcel_lockers_search_request() {
        requestSpecification = RestAssured.given()
                .spec(requestSpecification)
                .header("app-referrer", "geowidget.inpost.pl")
                .params("status", "Operating,Overloaded",
                        "perPage", "100",
                        "type", "parcel_locker");
    }

    @And("user adds to the request query param {string} with value {string}")
    public void user_adds_to_the_request_query_param_city(final String param, final String city) {
        requestSpecification = requestSpecification.params(param, city);
    }

    @When("user makes a call")
    public void user_makes_a_call() {
        response = requestSpecification.log().all().get();
    }

    @And("response status code is {int}")
    public void response_status_code_is_200(final int code) {
        Assertions.assertThat(response.getStatusCode())
                .as(String.format("Response code is different than %d", code))
                .isEqualTo(code);
    }

    @Then("list of parcel lockers for {string} is returned")
    public void list_of_parcel_lockers_for_is_returned(final String city) {
        pointsResponse = response.getBody().as(PointsResponse.class);
        Assertions.assertThat(checkIfAllReturnedParcelLockersHaveCity(pointsResponse, city))
                .as("Not all returned parcel lockers have expected city")
                .isTrue();
    }

    @And("name, postal code and coordinates for returned list are saved to the file {string}")
    public void name_postal_code_and_coordinates_for_returned_list_are_saved_to_the_file(final String fileName) {
        List<ParcelLockerData> parcelLockerDataList = new ArrayList<>();
        pointsResponse.getItems().forEach(
                pl -> parcelLockerDataList.add(getParcelLocalData(pl))
        );
        final String path = String.format("./target/%s", fileName);
        new SaveFile(parcelLockerDataList, path).saveFile();
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
}
