package com.glide.cs.now.navigator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceDestination {
	private String sourceLocation;
	private String destinationLocation;
	private String map;

	public  SourceDestination(){
	}

	public SourceDestination(String sourceLocation, String destinationLocation, String map) {
		this.sourceLocation = sourceLocation;
		this.destinationLocation = destinationLocation;
	}

	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}
}
