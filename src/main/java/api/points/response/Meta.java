package api.points.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Meta{

	@JsonProperty("per_page")
	private int perPage;

	@JsonProperty("count")
	private int count;

	@JsonProperty("href")
	private String href;

	@JsonProperty("page")
	private int page;

	@JsonProperty("total_pages")
	private int totalPages;
}