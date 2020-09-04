package com.city.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.File;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class ReadCitiesFromFileTest {

	  @Test
	    public void read0() {
	        assertNotNull(new ReadCitiesFromFile());
	    }

	    @Test
	    public void read1() {

	    	CityServiceImpl cityServiceImpl = new CityServiceImpl();
	        assertEquals(0, cityServiceImpl.size());
	        assertTrue(ReadCitiesFromFile.readCitesFormFile(cityServiceImpl, new File("test/city.txt")));
	        assertEquals(6, cityServiceImpl.size());

	        assertEquals(true, cityServiceImpl.isConneced("Boston", "Newark"));
	        assertEquals(true, cityServiceImpl.isConneced("Boston", "Philadelphia"));
	        assertEquals(false, cityServiceImpl.isConneced("Philadelphia", "Albany"));
	    }

	    @Test
	    public void read2() {

	    	CityServiceImpl cityServiceImpl = new CityServiceImpl();
	        assertEquals(0, cityServiceImpl.size());
	        assertFalse(ReadCitiesFromFile.readCitesFormFile(cityServiceImpl, new File("./test/data.txt")));
	        assertEquals(6, cityServiceImpl.size());

	        assertEquals(true, cityServiceImpl.isConneced("a", "e"));
	        assertEquals(false, cityServiceImpl.isConneced("a", "c"));
	    }

	    @Test
	    public void read3() {

	    	CityServiceImpl cityServiceImpl = new CityServiceImpl();

	        assertFalse(ReadCitiesFromFile.readCitesFormFile(cityServiceImpl, new File("not-existed.txt")));
	        assertFalse(ReadCitiesFromFile.readCitesFormFile(cityServiceImpl, new File("./test/empty.txt")));

	    }

	    @Test
	    public void read4() {

	    	CityServiceImpl cityServiceImpl = mock(CityServiceImpl.class, Mockito.RETURNS_DEEP_STUBS);

	        assertNotNull(cityServiceImpl);

	        BDDMockito.when(cityServiceImpl.addPath(Mockito.anyString(),Mockito.anyString())).thenReturn(false);

	        assertFalse(ReadCitiesFromFile.readCitesFormFile(cityServiceImpl, new File("test/city.txt")));

	    }

}
