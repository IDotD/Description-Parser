package com.idotd.parser;

import com.idotd.entities.Effect;
import com.idotd.entities.MagicRequest;
import com.idotd.entities.OwnedItemTypeCondition;
import org.junit.Test;
import static org.junit.Assert.*;

import java.text.ParseException;

public class OwnedItemConditionTest {
    @Test
    public void testParseWithBossCondition() throws NumberFormatException, ParseException {
        System.out.println("Parse With Boss Condition");
        MagicParser instance = new MagicParser(new MagicRequest(17, "Each attack by any raid memBer has a 7.5% chance to deal 900.8% damage; Extra 35% damage for each piece of Spirit Raven set owned"));
        Effect result = instance.parse();
        assertEquals(17, result.getId());
        assertEquals(7.5, result.getChance(), 0.1);
        assertEquals(900.8, result.getDamage(), 0.1);
        assertFalse(result.getConditions().isEmpty());
        assertEquals(1,result.getConditions().size());

        OwnedItemTypeCondition firstResult = (OwnedItemTypeCondition) result.getConditions().get(0);
        assertEquals(35, firstResult.getDamage(), 0.1);
        assertEquals(9, firstResult.getMaxItems());
        assertEquals("Spirit Raven", firstResult.getName());
    }
}
