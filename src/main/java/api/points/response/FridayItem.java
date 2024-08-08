package api.points.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FridayItem{

	@JsonProperty("start")
	private int start;

	@JsonProperty("end")
	private int end;
}