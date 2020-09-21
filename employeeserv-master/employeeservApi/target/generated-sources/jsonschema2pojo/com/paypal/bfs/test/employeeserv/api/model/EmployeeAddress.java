package com.paypal.bfs.test.employeeserv.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "line1",
    "line2",
    "city",
    "state",
    "country",
    "zip_code"
})
public class EmployeeAddress {

	@JsonProperty("line1")
	@JsonPropertyDescription("line1")
	private String line1;

	@JsonProperty("line2")
	@JsonPropertyDescription("line2")
	private String line2;

	@JsonProperty("city")
	@JsonPropertyDescription("city")
	private String city;

	@JsonProperty("state")
	@JsonPropertyDescription("state")
	private String state;

	@JsonProperty("country")
	@JsonPropertyDescription("country")
	private String country;

	@JsonProperty("zip_code")
	@JsonPropertyDescription("zip_code")
	private String zip_code;

	@JsonProperty("line1")
	public String getLine1() {
		return line1;
	}

	@JsonProperty("line1")
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	@JsonProperty("line2")
	public String getLine2() {
		return line2;
	}

	@JsonProperty("line2")
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("zip_code")
	public String getZip_code() {
		return zip_code;
	}

	@JsonProperty("zip_code")
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
}
