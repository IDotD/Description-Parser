package com.idotd.parser;

import com.idotd.entities.Effect;
import com.idotd.entities.MagicRequest;
import com.idotd.entities.OwnedItemTypeCondition;
import org.junit.Test;
import static org.junit.Assert.*;

import java.text.ParseException;

public class OwnedItemConditionTest {
    @Test
    public void testParseWithOwnedSetItemCondition() throws NumberFormatException, ParseException {
        System.out.println("testParseWithOwnedSetItemCondition");
        MagicParser instance = new MagicParser(new MagicRequest(17, "Each attack by any raid memBer has a 7.5% chance to deal 900.8% damage; Extra 35% damage for each piece of Spirit Raven set owned"));
        Effect result = instance.parse();
        System.out.println(result);
        assertEquals(17, result.getId());
        assertEquals(7.5, result.getChance(), 0.1);
        assertEquals(900.8, result.getDamage(), 0.1);
        assertFalse(result.getConditions().isEmpty());
        assertEquals(1,result.getConditions().size());

        OwnedItemTypeCondition firstResult = (OwnedItemTypeCondition) result.getConditions().get(0);
        assertEquals(35, firstResult.getDamage(), 0.1);
        assertEquals("Spirit Raven", firstResult.getNames().get(0));
    }
    @Test
    public void testParseWithMultipleOwnedSetItemCondition() throws NumberFormatException, ParseException {
        System.out.println("testParseWithMultipleOwnedSetItemCondition");
        MagicParser instance = new MagicParser(new MagicRequest(100, "Attacks by any raid member have a 15% chance to deal 75% damage; Extra 5% damage for each unique piece of Jovial Jester and Celebration set owned"));
        Effect result = instance.parse();
        System.out.println(result);
        assertEquals(100, result.getId());
        assertEquals(15, result.getChance(), 0.1);
        assertEquals(75, result.getDamage(), 0.1);
        assertFalse(result.getConditions().isEmpty());
        assertEquals(1,result.getConditions().size());

        OwnedItemTypeCondition firstResult = (OwnedItemTypeCondition) result.getConditions().get(0);
        assertEquals(5, firstResult.getDamage(), 0.1);
        assertEquals("Jovial Jester", firstResult.getNames().get(0));
        assertEquals("Celebration", firstResult.getNames().get(1));
    }
    @Test
    public void testParseWithOwnedItemCondition() throws NumberFormatException, ParseException {
        System.out.println("testParseWithOwnedItemCondition");
        MagicParser instance = new MagicParser(new MagicRequest(162, "Attacks by any raid member have a 10% chance to deal 100% damage; Extra 200% if Volatile Runes is owned"));
        Effect result = instance.parse();
        System.out.println(result);
        assertEquals(162, result.getId());
        assertEquals(10, result.getChance(), 0.1);
        assertEquals(100, result.getDamage(), 0.1);
        assertFalse(result.getConditions().isEmpty());
        assertEquals(1,result.getConditions().size());

        OwnedItemTypeCondition firstResult = (OwnedItemTypeCondition) result.getConditions().get(0);
        assertEquals(200, firstResult.getDamage(), 0.1);
        assertEquals("Volatile Runes", firstResult.getNames().get(0));
    }
}
