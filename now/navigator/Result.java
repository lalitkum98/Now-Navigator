package com.glide.cs.now.navigator;

import java.util.ArrayList;
import java.util.List;

public class Result {
	private int weight;
	private List<WalkableNode> locations = new ArrayList<>();

	public Result(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<WalkableNode> getLocations() {
		return locations;
	}

	public void setLocations(List<WalkableNode> locations) {
		this.locations = locations;
	}
}
