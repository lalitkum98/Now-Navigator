package com.glide.cs.now.navigator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalkableNode {
	private String locationId;
	private String locationName;
	private LocationType locationType;
	private Direction fDirection;
	public WalkableNode() {

	}

	public WalkableNode(String locationId, String locationName, Direction direction, LocationType locationType) {
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationType = locationType;
		fDirection = direction;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Direction getDirection() {
		return fDirection;
	}

	public void setDirection(Direction direction) {
		fDirection = direction;
	}

	public LocationType getLocationType() { return locationType; }

	public void setLocationType(LocationType locationType) { this.locationType = locationType; }
}
