package com.glide.cs.now.navigator;

import java.util.List;

public class Locations {
	private List<LookUpLocation> locations;

	public Locations() {
	}

	public Locations(List<LookUpLocation> locations) {
		this.locations = locations;
	}

	public void setLocations(List<LookUpLocation> locations) {
		this.locations = locations;
	}

	public List<LookUpLocation> getLocations() {
		return this.locations;
	}
}
