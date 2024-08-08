package api.points.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OperatingHoursExtended{

	@JsonProperty("customer")
	private Customer customer;
}