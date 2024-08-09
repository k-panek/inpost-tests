package api.points.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Customer{

	@JsonProperty("sunday")
	private List<Object> sunday;

	@JsonProperty("saturday")
	private List<SaturdayItem> saturday;

	@JsonProperty("tuesday")
	private List<TuesdayItem> tuesday;

	@JsonProperty("wednesday")
	private List<WednesdayItem> wednesday;

	@JsonProperty("thursday")
	private List<ThursdayItem> thursday;

	@JsonProperty("friday")
	private List<FridayItem> friday;

	@JsonProperty("monday")
	private List<MondayItem> monday;
}