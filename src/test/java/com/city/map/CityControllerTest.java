package com.city.map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityControllerTest {

    @Autowired
    CityController controller;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isConnected1() {
        String result = controller.checkConnected("a", "b");
        assertEquals("no", result);
    }

    @Test
    public void isConnected2() {
        String result = controller.checkConnected("", "b");
        assertEquals("no", result);
    }

    @Test
    public void isConnected3() {
        String result = controller.checkConnected("", "");
        assertEquals("no", result);
    }

    @Test
    public void isConnected4() {
        String result = controller.checkConnected(null, null);
        assertEquals("no", result);
    }

    @Test
    public void isConnected5() {
        String result = controller.checkConnected("Boston", "Newark");
        assertEquals("yes", result);
    }

    @Test
    public void isConnected6() {
        String result = controller.checkConnected("Boston", "Philadelphia");
        assertEquals("yes", result);
    }

    @Test
    public void isConnected7() {
        String result = controller.checkConnected("Philadelphia", "Albany");
        assertEquals("no", result);
    }
}