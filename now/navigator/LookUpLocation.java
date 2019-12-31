package com.glide.cs.now.navigator;

public class LookUpLocation {
	private String locationId;
	private String locationName;

	public LookUpLocation() {
	}

	public LookUpLocation(String locationId, String locationName) {
		this.locationId = locationId;
		this.locationName = locationName;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationId() {
		return this.locationId;
	}

	public String getLocationName() {
		return this.locationName;
	}
}
