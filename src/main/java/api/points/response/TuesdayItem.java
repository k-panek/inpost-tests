package api.points.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TuesdayItem{

	@JsonProperty("start")
	private int start;

	@JsonProperty("end")
	private int end;
}