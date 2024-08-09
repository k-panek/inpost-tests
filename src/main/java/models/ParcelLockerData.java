package models;

import api.points.response.Location;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ParcelLockerData {

    @JsonProperty("name")
    private String name;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("coordinates")
    private Location coordinates;
}
