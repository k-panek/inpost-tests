package api.points.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PointsResponse {

    @JsonProperty("per_page")
    private int perPage;

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("count")
    private int count;

    @JsonProperty("href")
    private String href;

    @JsonProperty("page")
    private int page;

    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("items")
    private List<ItemsItem> items;
}