package com.city.map;

import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

public class CityErrorHandler implements ErrorController {

	private final Log log = LogFactory.getLog(getClass());
	private static final String PATH = "/error";

	 /**
     * Based on the requirement: "If there are no connection between 2 cities it should result in a ’no’ response"
     *
     * EXPECTATIONS:
     *  1) not all exceptions are caused by unexpected input
     *  2) response code needs to be more specific
     *  3) error message needs to be more specific
     *
     * @param response  current HttpServletResponse object
     * @return          "no"
     */
	@GetMapping(value = PATH)
	public String handleError(HttpServletResponse response) {
		response.setStatus(400);
		log.error("Error occured while reading");
		return "no";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}
