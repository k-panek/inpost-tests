package api.points.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address{

	@JsonProperty("line2")
	public String line2;

	@JsonProperty("line1")
	public String line1;
}