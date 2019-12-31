package com.glide.cs.now.navigator;

import java.util.ArrayList;

public class FloorLayout {
	private ArrayList<ArrayList<Node>> floor = new ArrayList<ArrayList<Node>>();

	public void setFloor() {
		//initialize rows
		for(int i=0;i<6;i++) {
			floor.add(new ArrayList<Node>());
		}
		floor.get(0).add(new Node("a3232223c7210010da92b91703c26000", "Main Entrance", LocationType.main_gate));
		floor.get(0).add(new Node("23232223c7210010da92b91703c26000", "Main Entrance", LocationType.main_gate));
		floor.get(0).add(new Node("27232223c7210010da92b91703c26000", "O1", LocationType.walkable_path));
		floor.get(0).add(new Node("a7232223c7210010da92b91703c26000", "O2", LocationType.walkable_path));
		floor.get(0).add(new Node("e7232223c7210010da92b91703c26000", "O3", LocationType.walkable_path));
		floor.get(0).add(new Node("2b232223c7210010da92b91703c26000", "O4", LocationType.walkable_path));
		floor.get(0).add(new Node("6b232223c7210010da92b91703c26000", "O5", LocationType.walkable_path));
		floor.get(0).add(new Node("ab232223c7210010da92b91703c26000", "O6", LocationType.walkable_path));

		floor.get(1).add(new Node("63232223c7210010da92b91703c26000", "Main Entrance", LocationType.main_gate));
		floor.get(1).add(new Node("e3232223c7210010da92b91703c26000", "Main Entrance", LocationType.main_gate));
		floor.get(1).add(new Node("67232223c7210010da92b91703c26000", "O7", LocationType.walkable_path));
		floor.get(1).add(new Node("2f232223c7210010da92b91703c26000", "WS1", LocationType.cubicle));
		floor.get(1).add(new Node("6f232223c7210010da92b91703c26000", "WS2", LocationType.cubicle));
		floor.get(1).add(new Node("af232223c7210010da92b91703c26000", "WS3", LocationType.cubicle));
		floor.get(1).add(new Node("ef232223c7210010da92b91703c26000", "WS4", LocationType.cubicle));
		floor.get(1).add(new Node("23232223c7210010da92b91703c26001", "WS5", LocationType.cubicle));

		floor.get(2).add(new Node("e7232223c7210010da92b91703c26001", "O10", LocationType.walkable_path));
		floor.get(2).add(new Node("a7232223c7210010da92b91703c26001", "O9", LocationType.walkable_path));
		floor.get(2).add(new Node("eb232223c7210010da92b91703c26000", "O8", LocationType.walkable_path));
		floor.get(2).add(new Node("67232223c7210010da92b91703c26001", "WS10", LocationType.cubicle));
		floor.get(2).add(new Node("27232223c7210010da92b91703c26001", "WS9", LocationType.cubicle));
		floor.get(2).add(new Node("e3232223c7210010da92b91703c26001", "WS8", LocationType.cubicle));
		floor.get(2).add(new Node("a3232223c7210010da92b91703c26001", "WS7", LocationType.cubicle));
		floor.get(2).add(new Node("63232223c7210010da92b91703c26001", "WS6", LocationType.cubicle));

		floor.get(3).add(new Node("af232223c7210010da92b91703c26001", "WS11", LocationType.cubicle));
		floor.get(3).add(new Node("ef232223c7210010da92b91703c26001", "WS12", LocationType.cubicle));
		floor.get(3).add(new Node("2b232223c7210010da92b91703c26001", "O11", LocationType.walkable_path));
		floor.get(3).add(new Node("6b232223c7210010da92b91703c26001", "O12", LocationType.walkable_path));
		floor.get(3).add(new Node("ab232223c7210010da92b91703c26001", "O13", LocationType.walkable_path));
		floor.get(3).add(new Node("eb232223c7210010da92b91703c26001", "O14", LocationType.walkable_path));
		floor.get(3).add(new Node("2f232223c7210010da92b91703c26001", "O15", LocationType.walkable_path));
		floor.get(3).add(new Node("6f232223c7210010da92b91703c26001", "O16", LocationType.walkable_path));

		floor.get(4).add(new Node("63232223c7210010da92b91703c26002", "WS14", LocationType.cubicle));
		floor.get(4).add(new Node("23232223c7210010da92b91703c26002", "WS13", LocationType.cubicle));
		floor.get(4).add(new Node("a3232223c7210010da92b91703c26002", "O17", LocationType.walkable_path));
		floor.get(4).add(new Node("a7232223c7210010da92b91703c26002", "Sheesham", LocationType.meeting_room));
		floor.get(4).add(new Node("e7232223c7210010da92b91703c26002", "Sheesham", LocationType.meeting_room));
		floor.get(4).add(new Node("2b232223c7210010da92b91703c26002", "Sheesham", LocationType.meeting_room));
		floor.get(4).add(new Node("2f232223c7210010da92b91703c26002", "Peepal", LocationType.meeting_room));
		floor.get(4).add(new Node("6f232223c7210010da92b91703c26002", "Peepal", LocationType.meeting_room));

		floor.get(5).add(new Node("67232223c7210010da92b91703c26002", "O20", LocationType.walkable_path));
		floor.get(5).add(new Node("27232223c7210010da92b91703c26002", "O19", LocationType.walkable_path));
		floor.get(5).add(new Node("e3232223c7210010da92b91703c26002", "O18", LocationType.walkable_path));
		floor.get(5).add(new Node("eb232223c7210010da92b91703c26002", "Sheesham", LocationType.meeting_room));
		floor.get(5).add(new Node("ab232223c7210010da92b91703c26002", "Sheesham", LocationType.meeting_room));
		floor.get(5).add(new Node("6b232223c7210010da92b91703c26002", "Sheesham", LocationType.meeting_room));
		floor.get(5).add(new Node("af232223c7210010da92b91703c26002", "Peepal", LocationType.meeting_room));
		floor.get(5).add(new Node("ef232223c7210010da92b91703c26002", "Peepal", LocationType.meeting_room));
	}

	public ArrayList<ArrayList<Node>> getFloor() {
		return floor;
	}
}
