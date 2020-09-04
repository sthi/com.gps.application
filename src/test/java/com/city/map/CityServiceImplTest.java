package com.city.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CityServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addConnection() {
		CityServiceImpl cityServiceImpl = new CityServiceImpl();
		assertTrue(cityServiceImpl.addPath("a", "b"));

		assertEquals(2, cityServiceImpl.size());

		assertFalse(cityServiceImpl.addPath(null, "c"));
		assertFalse(cityServiceImpl.addPath("", "c"));
		assertFalse(cityServiceImpl.addPath("c", null));
		assertFalse(cityServiceImpl.addPath("c", ""));
		assertFalse(cityServiceImpl.addPath("e", "e"));

		assertEquals(2, cityServiceImpl.size());
	}

	@Test
	public void isConnected1() {

		CityServiceImpl cityServiceImpl = new CityServiceImpl();

		cityServiceImpl.addPath("a", "b");
		cityServiceImpl.addPath("b", "c");

		assertFalse(cityServiceImpl.isConneced(null, "c"));
		assertFalse(cityServiceImpl.isConneced("", "c"));
		assertFalse(cityServiceImpl.isConneced("d", null));
		assertFalse(cityServiceImpl.isConneced("d", ""));

		assertEquals(3, cityServiceImpl.size());
	}

	@Test
	public void isConnected2() {

		CityServiceImpl cityServiceImpl = new CityServiceImpl();

		cityServiceImpl.addPath("a", "b");
		cityServiceImpl.addPath("b", "c");

		assertEquals(true, cityServiceImpl.isConneced("a", "c"));
		assertEquals(false, cityServiceImpl.isConneced("a", "e"));

		assertEquals(true, cityServiceImpl.isConneced("e", "e"));

	}

	@Test
	public void size() {

		CityServiceImpl cityServiceImpl = new CityServiceImpl();

		assertEquals(0, cityServiceImpl.size());

		cityServiceImpl.addPath("a", "b");
		cityServiceImpl.addPath("b", "c");

		assertEquals(3, cityServiceImpl.size());
	}

}
