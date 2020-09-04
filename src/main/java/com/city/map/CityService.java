package com.city.map;

public interface CityService {
	boolean isConneced(String origin, String destination);
	boolean addPath(String origin, String destination);
}
