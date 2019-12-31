package com.glide.cs.now.navigator;

import java.util.List;

public class LocationMatrix {
	private List<Locations> listOfLocations;

	public LocationMatrix() {
	}

	public LocationMatrix(List<Locations> listOfLocations) {
		this.listOfLocations = listOfLocations;
	}

	public List<Locations> getListOfLocations() {
		return listOfLocations;
	}

	public void setListOfLocations(List<Locations> listOfLocations) {
		this.listOfLocations = listOfLocations;
	}
}
