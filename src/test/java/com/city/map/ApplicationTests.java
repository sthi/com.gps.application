package com.city.map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	 @Test
	    public void main() {

	        String args[] = {"--datafile=test/city.txt"};
	        Application.main(args);
	        assertNotNull(Application.appCtx);

	        CityServiceImpl cityServiceImpl = Application.appCtx.getBean(CityServiceImpl.class);
	        assertNotNull(cityServiceImpl);

	        assertTrue(cityServiceImpl.size() > 0);

	        assertTrue(cityServiceImpl.isConneced("Boston", "New York"));
	    }

}
