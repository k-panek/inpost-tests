package api.points.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentType{

	@JsonProperty("0")
	private String jsonMember0;

	@JsonProperty("2")
	private String jsonMember2;
}