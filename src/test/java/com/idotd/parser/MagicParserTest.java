/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idotd.parser;

import com.idotd.entities.Effect;
import org.junit.Test;
import static org.junit.Assert.*;

public class MagicParserTest {
    
    public MagicParserTest() {
    }

    /**
     * Test of parse method, of class MagicParser.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        MagicParser instance = null;
        Effect expResult = null;
        Effect result = instance.parse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
