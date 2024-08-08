package api.points.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Location{

	@JsonProperty("latitude")
	private double latitude;

	@JsonProperty("longitude")
	private double longitude;
}