package com.city.map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

	private final Log log = LogFactory.getLog(getClass());

	@Autowired
	CityService cityService;

	/*
	 * @param origin city1
	 * 
	 * @param destination city2
	 * 
	 * @return "yes" for connected "no" if not connected
	 */
    @RequestMapping(value = "/connected", method = RequestMethod.GET)
	public String checkConnected(@RequestParam(name = "origin") String origin,
			@RequestParam(name = "destination") String destination) {
		log.info("Ciy Controller Strated here");
		boolean isConnected = cityService.isConneced(origin, destination);
		if (isConnected) {
			return "yes";
		} else {
			return "no";
		}
	}
}
