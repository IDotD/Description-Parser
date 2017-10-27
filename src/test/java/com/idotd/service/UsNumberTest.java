package com.idotd.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class UsNumberTest {

    /**
     * Test of asFloat method, of class UsNumber.
     */
    @Test
    public void testAsFloat() throws Exception {
        assertEquals(11, UsNumber.asFloat("11"), 0.01);
        assertEquals(11.7, UsNumber.asFloat("11.7"), 0.01);
        assertEquals(1189, UsNumber.asFloat("1,189"), 0.01);
        assertEquals(1189.03, UsNumber.asFloat("1,189.03"), 0.01);
    }
}
