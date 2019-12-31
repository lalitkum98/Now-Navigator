package com.glide.cs.now.navigator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public enum LocationType {
	meeting_room, printer, cafeteria, cubicle, washroom, main_gate, reception, walkable_path
}
