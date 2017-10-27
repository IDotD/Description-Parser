package com.idotd.parser;


import com.idotd.entities.Effect;
import com.idotd.entities.MagicRequest;
import org.junit.Test;
import static org.junit.Assert.*;

import java.text.ParseException;

public class EffectTest {
    @Test
    public void testParse() throws NumberFormatException, ParseException {
        System.out.println("parse");
        MagicParser instance = new MagicParser(new MagicRequest(17, "Each attack by any raid memBer has a 7.5% chance to deal 900.8% damage."));
        Effect result = instance.parse();
        assertEquals(17, result.getId());
        assertEquals(7.5, result.getChance(), 0.1);
        assertEquals(900.8, result.getDamage(), 0.1);
        assertTrue(result.getConditions().isEmpty());
    }
}
