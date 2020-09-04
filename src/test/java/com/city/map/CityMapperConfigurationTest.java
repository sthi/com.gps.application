package com.city.map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperConfigurationTest {

	@Autowired
	CityServiceImpl cityServiceImpl;

	@Test
	public void adjacencyListGraph() {
		assertNotNull(cityServiceImpl);
		assertTrue(cityServiceImpl.size() > 0);
	}
}
