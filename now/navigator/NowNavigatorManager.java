package com.glide.cs.now.navigator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.glide.cs.ChatbotLogger;
import com.glide.cs.qlue.QlueApp;
import com.glide.cs.qlue.util.JsonUtil;
import com.glide.util.StringUtil;

public class NowNavigatorManager {
	static final ChatbotLogger LOGGER = new ChatbotLogger(NowNavigatorManager.class.getSimpleName());
	private final FloorLayoutDao fMapDao;
	private final String WALKABLE_PATH = LocationType.walkable_path.name();
	private final String FLOOR_LAYOUT = "8e8632d7732100108564b17afef6a7f3";

	public NowNavigatorManager() {
		fMapDao = QlueApp.getComponent().dao().getMapDao();
	}

	protected Object processRequest(String payload) {
		SourceDestination sourceDestination = null;
		if (StringUtil.notNil(payload))
			sourceDestination = JsonUtil.fromJsonString(payload, SourceDestination.class, true);

		Location map = null;
		if (sourceDestination != null)
			map = getLocation(FLOOR_LAYOUT);

		WalkablePath walkablePath = null;
		if (map != null) {
			Location source = getSource(map, sourceDestination.getSourceLocation(), new ArrayList<>());
			Location destination = getSource(map,sourceDestination.getDestinationLocation(), new ArrayList<>());
			walkablePath = getPath(source, destination.getLocationId());
		}
		if (walkablePath != null) {
			try {
				return JsonUtil.toJsonString(walkablePath);
			} catch (Exception ex) {
				LOGGER.error("Unable to parse the walkable path", ex);
			}
		}

		return null;
	}

	protected Object processLookUp() {
		Location startLocation = getLocation(FLOOR_LAYOUT);
		List<LookUpLocation> lns = new ArrayList<>();
		Set<String> visited = new HashSet<String>();
		LinkedList<Location> queue = new LinkedList<Location>();

		visited.add(startLocation.getLocationId());
		queue.add(startLocation);

		Location temp, tempNext;
		while (queue.size() != 0) {
			temp = queue.poll();
			System.out.println(temp.getLocationType());
			if (temp.getLocationType()!=LocationType.walkable_path && !findLocationExists(lns, temp.getLocationName())) {
				LookUpLocation obj = new LookUpLocation();
				obj.setLocationId(temp.getLocationId());
				obj.setLocationName(temp.getLocationName());

				lns.add(obj);
			}

			tempNext = temp.getTopNeighbour();
			if (tempNext != null)
				if (!visited.contains(tempNext.getLocationId())) {
					visited.add(tempNext.getLocationId());
					queue.add(tempNext);
				}

			tempNext = temp.getDownNeighbour();
			if (tempNext != null)
				if (!visited.contains(tempNext.getLocationId())) {
					visited.add(tempNext.getLocationId());
					queue.add(tempNext);
				}

			tempNext = temp.getLeftNeighbour();
			if (tempNext != null)
				if (!visited.contains(tempNext.getLocationId())) {
					visited.add(tempNext.getLocationId());
					queue.add(tempNext);
				}

			tempNext = temp.getRightNeighbour();
			if (tempNext != null)
				if (!visited.contains(tempNext.getLocationId())) {
					visited.add(tempNext.getLocationId());
					queue.add(tempNext);
				}
		}
		Locations ln = new Locations();
		ln.setLocations(lns);
		return ln;
	}

	protected Location getSource(Location startLocation, String source, List<Location> visited) {
		if (startLocation == null)
			return null;

		if (!visited.contains(startLocation))
			visited.add(startLocation);
		else
			return null;

		String locationName = startLocation.getLocationName();
		if (StringUtil.notNil(locationName) && locationName.equalsIgnoreCase(source)) {
			Location left = startLocation.getLeftNeighbour();
			Location right = startLocation.getRightNeighbour();
			Location top = startLocation.getTopNeighbour();
			Location down = startLocation.getDownNeighbour();
			if ((left != null && LocationType.walkable_path.name().equalsIgnoreCase(left.getLocationType().name()))
					|| (right != null && LocationType.walkable_path.name().equalsIgnoreCase(right.getLocationType().name()))
					|| (top != null && LocationType.walkable_path.name().equalsIgnoreCase(top.getLocationType().name()))
					|| (down != null && LocationType.walkable_path.name().equalsIgnoreCase(down.getLocationType().name()))) {
				return startLocation;
			}
		}

		Location foundSource = getSource(startLocation.getLeftNeighbour(), source, visited);
		if (foundSource != null)
			return foundSource;
		foundSource = getSource(startLocation.getRightNeighbour(), source, visited);
		if (foundSource != null)
			return foundSource;
		foundSource = getSource(startLocation.getTopNeighbour(), source, visited);
		if (foundSource != null)
			return foundSource;
		foundSource = getSource(startLocation.getDownNeighbour(), source, visited);

		return foundSource;
	}

	protected WalkablePath getPath(Location source, String destination) {
		Result result = path(source, source, destination, new ArrayList<>());
		List<WalkableNode> path = result.getLocations();
		Collections.reverse(path);
		path.get(0).setDirection(Direction.start);
		return new WalkablePath(new ArrayList<>(path));
	}

	protected Result path(Location source, Location mainSource, String destination, List<Location> visited) {
		if (source == null)
			return new Result(0);

		String locationId = source.getLocationId();
		if (StringUtil.notNil(locationId) && locationId.equalsIgnoreCase(destination)) {
			Result result = new Result(1);
			source.setDirection(Direction.end);
			result.getLocations().add(transformToWalkableNode(source));
			return result;
		}

		if (!visited.contains(source))
			visited.add(source);
		else
			return new Result(0);

		if (source != mainSource) {
			LocationType locationType = source.getLocationType();
			if (locationType != null && !WALKABLE_PATH.equalsIgnoreCase(locationType.name())) {
				visited.remove(source);
				return new Result(0);
			}
		}
		Result result = null;
		Result leftResult = path(source.getLeftNeighbour(), mainSource, destination, visited);
		int leftWeight = leftResult.getWeight();
		if (leftWeight > 0) {
			leftResult.setWeight(leftWeight + 1);
			source.setDirection(Direction.left);
			leftResult.getLocations().add(transformToWalkableNode(source));
			result = leftResult;
		}


		Result rightResult = path(source.getRightNeighbour(), mainSource, destination, visited);
		int rightWeight = rightResult.getWeight();
		if (rightWeight > 0) {
			rightResult.setWeight(rightWeight + 1);
			source.setDirection(Direction.right);
			rightResult.getLocations().add(transformToWalkableNode(source));
			if (result == null || result.getWeight() >= rightWeight)
				result = rightResult;
		}


		Result topResult = path(source.getTopNeighbour(), mainSource, destination, visited);
		int topWeight = topResult.getWeight();
		if (topWeight > 0) {
			topResult.setWeight(topWeight + 1);
			source.setDirection(Direction.top);
			topResult.getLocations().add(transformToWalkableNode(source));
			if (result == null || result.getWeight() >= topWeight)
				result = topResult;
		}


		Result downResult = path(source.getDownNeighbour(), mainSource, destination, visited);
		int downWeight = downResult.getWeight();
		if (downWeight > 0) {
			downResult.setWeight(downWeight + 1);
			source.setDirection(Direction.top);
			downResult.getLocations().add(transformToWalkableNode(source));
			if (result == null || result.getWeight() >= downWeight)
				result = downResult;
		}


		visited.remove(source);
		if (result == null)
			return new Result(0);

		return result;
	}

	protected WalkableNode transformToWalkableNode(Location node) {
		return new WalkableNode(node.getLocationId(), node.getLocationName(), node.getDirection(), node.getLocationType());
	}

	protected Location getLocation(String floorLayoutId) {
		String map = fMapDao.getFloorLayout(floorLayoutId);
		Location location = null;
		if (StringUtil.notNil(map))
			location = JsonUtil.fromJsonString(map, Location.class, true);

		return location;
	}


	protected Object getFloorLayout() {
		Location startLocation = getLocation(FLOOR_LAYOUT);
		return new LocationMatrix(transformMapToMatrix(startLocation, new ArrayList<>()));
	}

	protected List<Locations> transformMapToMatrix(Location startLocation, List<Locations> xAxisLocations) {
		if (startLocation == null)
			return xAxisLocations;

		Locations yAxisLocations = new Locations(getYAxisLocations(startLocation, new ArrayList<>()));
		xAxisLocations.add(yAxisLocations);
		transformMapToMatrix(startLocation.getDownNeighbour(), xAxisLocations);

		return xAxisLocations;
	}

	protected List<LookUpLocation> getYAxisLocations(Location startLocation, List<LookUpLocation> yAxisLocations) {
		if (startLocation == null)
			return yAxisLocations;

		yAxisLocations.add(new LookUpLocation(startLocation.getLocationId(), startLocation.getLocationName()));
		getYAxisLocations(startLocation.getRightNeighbour(), yAxisLocations);

		return yAxisLocations;

	}

	protected boolean findLocationExists(List<LookUpLocation> locations, String locationName) {
		for(LookUpLocation location : locations){
			if (location.getLocationName().equalsIgnoreCase(locationName))
				return true;
		}
		return false;
	}

	protected Object getFloorMatrix() {
		FloorLayout floor = new FloorLayout();
		floor.setFloor();
		return floor;
	}
}
