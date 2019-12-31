package com.glide.cs.now.navigator;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalkablePath {
	private List<WalkableNode> path;

	public WalkablePath(List<WalkableNode> path) {
		this.path = path;
	}

	public List<WalkableNode> getPath() {
		return path;
	}

	public void setPath(List<WalkableNode> path) {
		this.path = path;
	}
}
