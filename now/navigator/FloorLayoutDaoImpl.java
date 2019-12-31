package com.glide.cs.now.navigator;

import com.glide.script.GlideRecord;

public class FloorLayoutDaoImpl implements FloorLayoutDao {
	private final String SYS_CS_NOW_NAVIGATOR_FLOOR_LAYOUT = "sys_cs_now_navigator_floor_layout";
	private final String LAYOUT = "layout";
	private final String SYS_ID = "sys_id";

	@Override
	public String getFloorLayout(String floorLayoutId) {
		GlideRecord mapGraph = new GlideRecord(SYS_CS_NOW_NAVIGATOR_FLOOR_LAYOUT);
		mapGraph.addQuery(SYS_ID, floorLayoutId);
		mapGraph.query();
		if (mapGraph.next())
			return mapGraph.getValue(LAYOUT);

		return null;
	}
}
