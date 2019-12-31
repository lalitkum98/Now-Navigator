package com.glide.cs.now.navigator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.glide.util.Guid;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Location {
	private String locationId;
	private String locationName;
	private LocationType locationType;
	private Location leftNeighbour;
	private Location rightNeighbour;
	private Location topNeighbour;
	private Location downNeighbour;
	private Coordinate coordinate;
	private Direction direction;

	public Location() {

	}

	public Location(String locationName, LocationType locationType) {
		this.locationId = Guid.generate(this);
		this.locationName = locationName;
		this.locationType = locationType;
	}


	public Location(String locationName, LocationType locationType, Location leftNeighbour, Location rightNeighbour, Location topNeighbour, Location downNeighbour) {
		this.locationId = Guid.generate(this);
		this.locationName = locationName;
		this.locationType = locationType;
		this.leftNeighbour = leftNeighbour;
		this.rightNeighbour = rightNeighbour;
		this.topNeighbour = topNeighbour;
		this.downNeighbour = downNeighbour;
	}

	public Location(String locationName, LocationType locationType, Location leftNeighbour, Location rightNeighbour, Location topNeighbour, Location downNeighbour, Coordinate coordinate) {
		this.locationId = Guid.generate(this);
		this.locationName = locationName;
		this.locationType = locationType;
		this.leftNeighbour = leftNeighbour;
		this.rightNeighbour = rightNeighbour;
		this.topNeighbour = topNeighbour;
		this.downNeighbour = downNeighbour;
		this.coordinate = coordinate;
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

	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}

	public Location getLeftNeighbour() {
		return leftNeighbour;
	}

	public void setLeftNeighbour(Location leftNeighbour) {
		this.leftNeighbour = leftNeighbour;
	}

	public Location getRightNeighbour() {
		return rightNeighbour;
	}

	public void setRightNeighbour(Location rightNeighbour) {
		this.rightNeighbour = rightNeighbour;
	}

	public Location getTopNeighbour() {
		return topNeighbour;
	}

	public void setTopNeighbour(Location topNeighbour) {
		this.topNeighbour = topNeighbour;
	}

	public Location getDownNeighbour() {
		return downNeighbour;
	}

	public void setDownNeighbour(Location downNeighbour) {
		this.downNeighbour = downNeighbour;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
