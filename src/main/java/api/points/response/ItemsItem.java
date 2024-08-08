package api.points.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemsItem{

	@JsonProperty("virtual")
	private String virtual;

	@JsonProperty("location_description_2")
	private Object locationDescription2;

	@JsonProperty("distance")
	private Object distance;

	@JsonProperty("functions")
	private List<String> functions;

	@JsonProperty("location_description_1")
	private String locationDescription1;

	@JsonProperty("type")
	private List<String> type;

	@JsonProperty("easy_access_zone")
	private boolean easyAccessZone;

	@JsonProperty("partner_id")
	private int partnerId;

	@JsonProperty("air_index_level")
	private Object airIndexLevel;

	@JsonProperty("address_details")
	private AddressDetails addressDetails;

	@JsonProperty("location_date")
	private Object locationDate;

	@JsonProperty("href")
	private String href;

	@JsonProperty("payment_point_descr")
	private String paymentPointDescr;

	@JsonProperty("location_247")
	private boolean location247;

	@JsonProperty("address")
	private Address address;

	@JsonProperty("agency")
	private Object agency;

	@JsonProperty("operating_hours_extended")
	private OperatingHoursExtended operatingHoursExtended;

	@JsonProperty("apm_doubled")
	private Object apmDoubled;

	@JsonProperty("image_url")
	private String imageUrl;

	@JsonProperty("recommended_low_interest_box_machines_list")
	private Object recommendedLowInterestBoxMachinesList;

	@JsonProperty("location_description")
	private String locationDescription;

	@JsonProperty("location_type")
	private Object locationType;

	@JsonProperty("is_next")
	private boolean isNext;

	@JsonProperty("payment_type")
	private PaymentType paymentType;

	@JsonProperty("payment_available")
	private boolean paymentAvailable;

	@JsonProperty("name")
	private String name;

	@JsonProperty("opening_hours")
	private String openingHours;

	@JsonProperty("physical_type_description")
	private Object physicalTypeDescription;

	@JsonProperty("location")
	private Location location;

	@JsonProperty("phone_number")
	private Object phoneNumber;

	@JsonProperty("physical_type_mapped")
	private Object physicalTypeMapped;

	@JsonProperty("status")
	private String status;
}