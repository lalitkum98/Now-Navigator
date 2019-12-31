package com.glide.cs.now.navigator;

public class Node {
	private String locationId;
	private String locationName;
	private LocationType fLocationType;

	public Node() {

	}

	public Node(String locationId, String locationName, LocationType locationType) {
		this.locationId = locationId;
		this.locationName = locationName;
		fLocationType = locationType;
	}

	public void setLocationId(String locationId) { this.locationId = locationId; }

	public String getLocationId() { return locationId; }

	public void setLocationName(String locationName) { this.locationName = locationName; }

	public String getLocationName() { return locationName; }

	public void setLocationType(LocationType locationType) { fLocationType = locationType; }

	public LocationType getLocationType() { return fLocationType; }
}
