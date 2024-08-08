package api.points.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressDetails{

	@JsonProperty("province")
	private String province;

	@JsonProperty("city")
	private String city;

	@JsonProperty("flat_number")
	private Object flatNumber;

	@JsonProperty("street")
	private String street;

	@JsonProperty("post_code")
	private String postCode;

	@JsonProperty("building_number")
	private String buildingNumber;
}