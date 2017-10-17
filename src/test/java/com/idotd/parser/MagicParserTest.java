package com.idotd.parser;

import com.idotd.entities.Effect;
import com.idotd.entities.MagicRequest;
import org.junit.Test;
import static org.junit.Assert.*;

public class MagicParserTest {
    @Test
    public void testParse() {
        System.out.println("parse");
        MagicParser instance = new MagicParser(new MagicRequest(17, "Each attack by any raid memBer has a 7.5% chance to deal 900.8% damage."));
        Effect result = instance.parse();
        System.out.print(result);
        assertEquals(17, result.getId());
        assertEquals(7.5, result.getChance());
        assertEquals(900.8, result.getDamage());
        assertTrue(result.getConditions().isEmpty());
    }
    
}
