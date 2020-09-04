package com.city.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CityServiceImpl implements CityService {
	private final Log log = LogFactory.getLog(getClass());

	private HashMap<String, LinkedList<String>> connectedCityMap;

	public CityServiceImpl() {
		connectedCityMap = new HashMap<>();
	}

	@Override
	public boolean isConneced(String origin, String destination) {
		// Make sure origin and destination not null
		if (origin == null) {
			log.error("origin is null");
			return false;
		}

		origin = origin.trim();
		if (origin.length() == 0) {
			log.error("origin is empty");
			return false;
		}

		if (destination == null) {
			log.error("destination is null");
			return false;
		}

		destination = destination.trim();
		if (destination.length() == 0) {
			log.error("destination is empty");
			return false;
		}

		if (destination.equals(origin)) {
			return true;
		}

		if (!connectedCityMap.containsKey(origin) || !connectedCityMap.containsKey(destination)) {
			return false;
		}

		// set of nodes visited
		HashSet<String> visited = new HashSet<>();

		// BFS queue
		LinkedList<String> queue = new LinkedList<>();

		// BFS starts from origin node
		visited.add(origin);
		queue.add(origin);

		// BFS loop
		while (queue.size() != 0) {

			// pop out the first node from queue
			String node = queue.pop();

			// get adjacency nodes list
			LinkedList<String> connectedCityList = connectedCityMap.get(node);

			// loop through the list
			//
			ListIterator<String> iterator = connectedCityList.listIterator();
			while (iterator.hasNext()) {

				String nextNode = iterator.next();

				// check if reaches the destination
				if (nextNode.equals(destination)) {
					return true;
				}

				// not visited before, save it for late process
				if (!visited.contains(nextNode)) {
					visited.add(nextNode);
					queue.add(nextNode);
				}
			}
		}

		return false;

	}

	@Override
	public boolean addPath(String origin, String destination) {
		if (origin == null) {
			log.error("origin is null");
			return false;
		}

		origin = origin.trim();
		if (origin.length() == 0) {
			log.error("origin is empty");
			return false;
		}

		if (destination == null) {
			log.error("destination is null");
			return false;
		}

		destination = destination.trim();
		if (destination.length() == 0) {
			log.error("destination is empty");
			return false;
		}

		if (destination.equals(origin)) {
			log.error("destination is the same as origin");
			return false;
		}

		connectOriginToDestination(origin, destination);
		connectOriginToDestination(destination, origin);

		return true;

	}

	/*
	 * Get Size
	 * 
	 * @return size of nodes
	 */
	public int size() {
		return connectedCityMap.size();
	}

	private void connectOriginToDestination(String origin, String destination) {
		LinkedList<String> connectedCityList = connectedCityMap.get(origin);

		// created a linked list for the city if it is null
		if (connectedCityList == null) {

			connectedCityList = new LinkedList<String>();
			connectedCityMap.put(origin, connectedCityList);

		} else {

			// do nothing if already existed
			if (connectedCityList.contains(destination)) {
				return;
			}
		}

		connectedCityList.add(destination);
	}
}
