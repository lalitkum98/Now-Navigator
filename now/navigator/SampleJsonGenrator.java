package com.glide.cs.now.navigator;

import com.glide.cs.qlue.util.JsonUtil;

public class SampleJsonGenrator {

	/*

	MG - MG  WP2
	     |    |
	WP5 - WP4 - WP3
	|     |
	CB1  WP6 - CB2

	 */
	public String getMapJsonOld() {
		Location MG = new Location("MAIN GATE", LocationType.main_gate, null, new Location("WP1", LocationType.walkable_path, null, null, null, null, new Coordinate(0, 1)), null, new Location("WP5", LocationType.walkable_path, null, null, null, null, new Coordinate(1, 0)), new Coordinate(0, 0));
		Location WP1 = MG.getRightNeighbour();
		Location WP5 = MG.getDownNeighbour();
		WP1.setLeftNeighbour(MG);
		WP1.setRightNeighbour(new Location("WP2", LocationType.walkable_path, null, null, null, null, new Coordinate(0, 2)));
		WP1.setDownNeighbour(new Location("WP4", LocationType.walkable_path, null, null, null, null, new Coordinate(1, 1)));
		WP5.setTopNeighbour(MG);
		WP5.setRightNeighbour(WP1.getDownNeighbour());
		WP5.setDownNeighbour(new Location("CB0001", LocationType.cubicle, null, null, null, null, new Coordinate(2, 0)));
		Location WP2 = WP1.getRightNeighbour();
		Location WP4 = WP1.getDownNeighbour();
		WP2.setLeftNeighbour(WP1);
		WP2.setDownNeighbour(new Location("WP3", LocationType.walkable_path, null, null, null, null, new Coordinate(1, 2)));
		WP4.setTopNeighbour(WP1);
		WP4.setLeftNeighbour(WP5);
		WP4.setRightNeighbour(WP2.getDownNeighbour());
		WP4.setDownNeighbour(new Location("WP6", LocationType.walkable_path, null, null, null, null, new Coordinate(2, 1)));
		Location WP3 = WP2.getDownNeighbour();
		Location CB1 = WP5.getDownNeighbour();
		WP3.setLeftNeighbour(WP4);
		WP3.setDownNeighbour(new Location("CB0002", LocationType.cubicle, null, null, null, null, new Coordinate(2, 2)));
		CB1.setTopNeighbour(WP5);
		CB1.setRightNeighbour(WP4.getDownNeighbour());
		Location WP6 = WP4.getDownNeighbour();
		Location CB2 = WP3.getDownNeighbour();
		WP6.setLeftNeighbour(CB1);
		WP6.setTopNeighbour(WP4);
		WP6.setRightNeighbour(CB2);
		CB2.setTopNeighbour(WP3);
		CB2.setLeftNeighbour(WP6);

		String json = JsonUtil.toJsonString(MG);
		System.out.println(json);
		return json;
	}

	public String getMapJson() {
		Location MG = new Location("MAIN GATE", LocationType.main_gate, null, new Location("MAIN GATE", LocationType.main_gate, null, null, null, null, new Coordinate(0, 1)), null, null, new Coordinate(0, 0));
		Location MG1 = MG.getRightNeighbour();
		Location WP5 = new Location("WP5", LocationType.walkable_path, null, null, null, null, new Coordinate(1, 0));
		MG1.setLeftNeighbour(MG);
		MG1.setRightNeighbour(null);
		MG1.setDownNeighbour(new Location("WP4", LocationType.walkable_path, null, null, null, null, new Coordinate(1, 1)));
		WP5.setTopNeighbour(MG);
		WP5.setRightNeighbour(MG1.getDownNeighbour());
		WP5.setDownNeighbour(new Location("CB0001", LocationType.cubicle, null, null, null, null, new Coordinate(2, 0)));
		Location WP2 = new Location("WP2", LocationType.walkable_path, null, null, null, null, new Coordinate(0, 2));
		Location WP4 = MG1.getDownNeighbour();
		WP2.setLeftNeighbour(MG1);
		WP2.setDownNeighbour(new Location("WP3", LocationType.walkable_path, null, null, null, null, new Coordinate(1, 2)));
		WP4.setTopNeighbour(MG1);
		WP4.setLeftNeighbour(WP5);
		WP4.setRightNeighbour(WP2.getDownNeighbour());
		WP4.setDownNeighbour(new Location("WP6", LocationType.walkable_path, null, null, null, null, new Coordinate(2, 1)));
		Location WP3 = WP2.getDownNeighbour();
		Location CB1 = WP5.getDownNeighbour();
		WP3.setLeftNeighbour(WP4);
		WP3.setDownNeighbour(new Location("CB0002", LocationType.cubicle, null, null, null, null, new Coordinate(2, 2)));
		CB1.setTopNeighbour(WP5);
		CB1.setRightNeighbour(null);
		Location WP6 = WP4.getDownNeighbour();
		Location CB2 = WP3.getDownNeighbour();
		WP6.setLeftNeighbour(CB1);
		WP6.setTopNeighbour(WP4);
		WP6.setRightNeighbour(CB2);
		CB2.setTopNeighbour(null);
		CB2.setLeftNeighbour(WP6);

		String json = JsonUtil.toJsonString(MG);
		System.out.println(json);
		return json;
	}

	public String getJsonFinal() {
		Location MG1 = new Location("Main Entrance", LocationType.main_gate, null, null, null, null, new Coordinate(0, 1));
		Location MG2 = new Location("Main Entrance", LocationType.main_gate, null, null, null, null, new Coordinate(1, 0));
		Location MG = new Location(
				"Main Entrance",
				LocationType.main_gate,
				null,
				MG1,
				null,
				MG2,
				new Coordinate(0, 0)
		);
		MG1.setLeftNeighbour(MG);
		Location MG3 = new Location("Main Entrance", LocationType.main_gate, null, null, null, null, new Coordinate(1, 1));
		MG1.setDownNeighbour(MG3);
		MG2.setTopNeighbour(MG);
		MG2.setRightNeighbour(MG3);
		Location OS1 = new Location("O1", LocationType.walkable_path, null, null, null, null, new Coordinate(0, 2));
		Location OS7 = new Location("O7", LocationType.walkable_path, null, null, null, null, new Coordinate(1, 2));
		OS1.setDownNeighbour(OS7);
		Location OS2 = new Location("O2", LocationType.walkable_path, null, null, null, null, new Coordinate(0, 3));
		OS1.setRightNeighbour(OS2);
		MG3.setTopNeighbour(MG1);
		MG3.setLeftNeighbour(MG2);
		MG3.setRightNeighbour(OS7);
		Location OS3 = new Location("O3", LocationType.walkable_path, null, null, null, null, new Coordinate(0, 4));
		Location OS4 = new Location("O4", LocationType.walkable_path, null, null, null, null, new Coordinate(0, 5));
		Location OS5 = new Location("O5", LocationType.walkable_path, null, null, null, null, new Coordinate(0, 6));
		Location OS6 = new Location("O6", LocationType.walkable_path, null, null, null, null, new Coordinate(0, 7));
		Location OS8 = new Location("O8", LocationType.walkable_path, null, null, null, null, new Coordinate(2, 2));
		Location WS1 = new Location("WS1", LocationType.cubicle, null, null, null, null, new Coordinate(1, 3));
		Location WS2 = new Location("WS2", LocationType.cubicle, null, null, null, null, new Coordinate(1, 4));
		Location WS3 = new Location("WS3", LocationType.cubicle, null, null, null, null, new Coordinate(1, 5));
		Location WS4 = new Location("WS4", LocationType.cubicle, null, null, null, null, new Coordinate(1, 6));
		Location WS5 = new Location("WS5", LocationType.cubicle, null, null, null, null, new Coordinate(1, 7));
		Location WS6 = new Location("WS6", LocationType.cubicle, null, null, null, null, new Coordinate(2, 7));
		Location WS7 = new Location("WS7", LocationType.cubicle, null, null, null, null, new Coordinate(2, 6));
		Location WS8 = new Location("WS8", LocationType.cubicle, null, null, null, null, new Coordinate(2, 5));
		Location WS9 = new Location("WS9", LocationType.cubicle, null, null, null, null, new Coordinate(2, 4));
		Location WS10 = new Location("WS10", LocationType.cubicle, null, null, null, null, new Coordinate(2, 3));
		OS2.setLeftNeighbour(OS1);
		OS2.setRightNeighbour(OS3);
		OS2.setDownNeighbour(WS1);
		OS3.setLeftNeighbour(OS2);
		OS3.setRightNeighbour(OS4);
		OS3.setDownNeighbour(WS2);
		OS4.setLeftNeighbour(OS3);
		OS4.setRightNeighbour(OS5);
		OS4.setDownNeighbour(WS3);
		OS5.setLeftNeighbour(OS3);
		OS5.setRightNeighbour(OS6);
		OS5.setDownNeighbour(WS4);
		OS6.setLeftNeighbour(OS5);
		OS6.setDownNeighbour(WS5);
		OS7.setLeftNeighbour(MG3);
		OS7.setRightNeighbour(WS1);
		OS7.setDownNeighbour(OS8);
		OS7.setTopNeighbour(OS1);
		WS1.setLeftNeighbour(OS7);
		WS1.setTopNeighbour(OS2);
		WS2.setTopNeighbour(OS3);
		WS3.setTopNeighbour(OS4);
		WS4.setTopNeighbour(OS5);
		WS5.setTopNeighbour(OS6);
		Location OS9 = new Location("O9", LocationType.walkable_path, null, null, null, null, new Coordinate(2, 0));
		Location OS10 = new Location("O10", LocationType.walkable_path, null, null, null, null, new Coordinate(2, 1));
		Location OS11 = new Location("O11", LocationType.walkable_path, null, null, null, null, new Coordinate(3, 2));
		Location OS12 = new Location("O12", LocationType.walkable_path, null, null, null, null, new Coordinate(3, 3));
		Location OS13 = new Location("O13", LocationType.walkable_path, null, null, null, null, new Coordinate(3, 4));
		Location OS14 = new Location("O14", LocationType.walkable_path, null, null, null, null, new Coordinate(3, 5));
		Location OS15 = new Location("O15", LocationType.walkable_path, null, null, null, null, new Coordinate(3, 6));
		Location OS16 = new Location("O16", LocationType.walkable_path, null, null, null, null, new Coordinate(3, 7));
		OS8.setLeftNeighbour(OS3);
		OS8.setRightNeighbour(OS6);
		OS8.setDownNeighbour(OS11);
		OS8.setRightNeighbour(WS10);
		WS10.setDownNeighbour(OS12);
		WS9.setDownNeighbour(OS13);
		WS8.setDownNeighbour(OS14);
		WS7.setDownNeighbour(OS15);
		WS6.setDownNeighbour(OS16);
		Location WS11 = new Location("WS11", LocationType.cubicle, null, null, null, null, new Coordinate(3, 0));
		Location WS12 = new Location("WS12", LocationType.cubicle, null, null, null, null, new Coordinate(3, 1));
		Location WS13 = new Location("WS13", LocationType.cubicle, null, null, null, null, new Coordinate(4, 1));
		Location WS14 = new Location("WS14", LocationType.cubicle, null, null, null, null, new Coordinate(4, 0));
		OS10.setRightNeighbour(OS9);
		OS10.setDownNeighbour(WS11);
		OS9.setLeftNeighbour(OS10);
		OS9.setRightNeighbour(OS8);
		OS9.setDownNeighbour(WS12);
		WS11.setTopNeighbour(OS10);
		WS12.setTopNeighbour(OS9);
		WS12.setRightNeighbour(OS11);
		Location OS17 = new Location("O17", LocationType.walkable_path, null, null, null, null, new Coordinate(4, 2));
		Location OS18 = new Location("O18", LocationType.walkable_path, null, null, null, null, new Coordinate(5, 2));
		Location OS19 = new Location("O19", LocationType.walkable_path, null, null, null, null, new Coordinate(5, 1));
		Location OS20 = new Location("O20", LocationType.walkable_path, null, null, null, null, new Coordinate(5, 0));
		WS13.setDownNeighbour(OS19);
		WS13.setRightNeighbour(OS17);
		WS14.setDownNeighbour(OS20);
		OS20.setRightNeighbour(OS19);
		OS20.setTopNeighbour(WS14);
		OS20.setRightNeighbour(OS19);
		OS19.setLeftNeighbour(OS20);
		OS19.setRightNeighbour(OS18);
		OS19.setTopNeighbour(WS13);
		OS11.setLeftNeighbour(WS12);
		OS11.setTopNeighbour(OS8);
		OS11.setRightNeighbour(OS12);
		OS11.setDownNeighbour(OS17);
		Location MR1 = new Location("Sheesham", LocationType.meeting_room, null, null, null, null, new Coordinate(4, 3));
		Location MR2 = new Location("Sheesham", LocationType.meeting_room, null, null, null, null, new Coordinate(4, 4));
		Location MR3 = new Location("Sheesham", LocationType.meeting_room, null, null, null, null, new Coordinate(4, 5));
		Location MR4 = new Location("Sheesham", LocationType.meeting_room, null, null, null, null, new Coordinate(5, 5));
		Location MR5 = new Location("Sheesham", LocationType.meeting_room, null, null, null, null, new Coordinate(5, 4));
		Location MR6 = new Location("Sheesham", LocationType.meeting_room, null, null, null, null, new Coordinate(5, 3));
		OS17.setTopNeighbour(OS11);
		OS17.setLeftNeighbour(WS13);
		OS17.setDownNeighbour(OS18);
		OS18.setTopNeighbour(OS17);
		OS18.setLeftNeighbour(OS19);
		OS12.setDownNeighbour(MR1);
		OS12.setLeftNeighbour(OS11);
		OS12.setTopNeighbour(WS10);
		OS12.setRightNeighbour(OS13);
		OS13.setRightNeighbour(OS14);
		OS13.setLeftNeighbour(OS12);
		OS14.setRightNeighbour(OS15);
		OS14.setLeftNeighbour(OS13);
		MR1.setTopNeighbour(OS12);
		MR1.setRightNeighbour(MR2);
		MR1.setDownNeighbour(MR6);
		MR2.setLeftNeighbour(MR1);
		MR2.setRightNeighbour(MR3);
		MR3.setLeftNeighbour(MR2);
		MR3.setDownNeighbour(MR4);
		MR4.setTopNeighbour(MR3);
		MR4.setLeftNeighbour(MR5);
		MR5.setLeftNeighbour(MR6);
		MR5.setRightNeighbour(MR4);
		OS13.setTopNeighbour(WS9);
		OS14.setTopNeighbour(WS8);
		OS15.setTopNeighbour(WS7);
		OS16.setTopNeighbour(WS6);
		MR6.setTopNeighbour(MR1);
		MR6.setRightNeighbour(MR5);
		Location MR7 = new Location("Peepal", LocationType.meeting_room, null, null, null, null, new Coordinate(4, 6));
		Location MR8 = new Location("Peepal", LocationType.meeting_room, null, null, null, null, new Coordinate(4, 7));
		Location MR9 = new Location("Peepal", LocationType.meeting_room, null, null, null, null, new Coordinate(5, 6));
		Location MR10 = new Location("Peepal", LocationType.meeting_room, null, null, null, null, new Coordinate(5, 7));
		OS15.setDownNeighbour(MR7);
		OS15.setLeftNeighbour(OS14);
		OS15.setRightNeighbour(OS16);
		OS16.setLeftNeighbour(OS15);
		MR7.setTopNeighbour(OS15);
		MR7.setRightNeighbour(MR8);
		MR8.setLeftNeighbour(MR7);
		MR8.setDownNeighbour(MR9);
		MR9.setTopNeighbour(MR8);
		MR9.setLeftNeighbour(MR10);
		MR10.setRightNeighbour(MR9);
		MR10.setTopNeighbour(MR7);

		String json = JsonUtil.toJsonString(MG);
		System.out.println(json);
		return json;
	}

	public String getSDJson() {
		SourceDestination sd = new SourceDestination("b2e902037321001028f9b17afef6a700", "3ae902037321001028f9b17afef6a700", "snow_floor_plan");
		String sdJson = JsonUtil.toJsonString(sd);
		return sdJson;
	}

public static void main(String args[]) {
		SampleJsonGenrator sg = new SampleJsonGenrator();
		sg.getMapJson();
		sg.getSDJson();
		sg.getJsonFinal();

	}
}
