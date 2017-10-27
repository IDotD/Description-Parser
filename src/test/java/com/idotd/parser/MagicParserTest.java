package com.idotd.parser;

import com.idotd.entities.BossTypeCondition;
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
        assertEquals(7.5, result.getChance(), 0.1);
        assertEquals(900.8, result.getDamage(), 0.1);
        assertTrue(result.getConditions().isEmpty());
    }
    @Test
    public void testParseWithBossCondition() {
        System.out.println("Parse With Boss Condition");
        MagicParser instance = new MagicParser(new MagicRequest(17, "Each attack by any raid memBer has a 7.5% chance to deal 900.8% damage; Extra 1,100% damage against Giant raids"));
        Effect result = instance.parse();
        System.out.print(result);
        assertEquals(17, result.getId());
        assertEquals(7.5, result.getChance(), 0.1);
        assertEquals(900.8, result.getDamage(), 0.1);
        assertFalse(result.getConditions().isEmpty());
        assertEquals(1,result.getConditions().size());
        BossTypeCondition firstResult = (BossTypeCondition) result.getConditions().get(0);
        assertEquals(1100,firstResult.getDamage(), 0.1);
        assertTrue(!firstResult.getTypes().isEmpty());
        assertEquals("Giant",firstResult.getTypes().get(0));
    }
    @Test
    public void testParseWithMultiBossCondition() {
        System.out.println("Parse With Boss Condition");
        MagicParser instance = new MagicParser(new MagicRequest(17, "Each attack by any raid memBer has a 7.5% chance to deal 900.8% damage; Extra 1,100% damage against Giant and Dragon raids; Extra 100% damage against Aquatic raids;"));
        Effect result = instance.parse();
        System.out.println(result);
        assertEquals(17, result.getId());
        assertEquals(7.5, result.getChance(), 0.1);
        assertEquals(900.8, result.getDamage(), 0.1);
        assertFalse(result.getConditions().isEmpty());
        assertEquals(1,result.getConditions().size());
        BossTypeCondition firstResult = (BossTypeCondition) result.getConditions().get(0);
        assertEquals(1100,firstResult.getDamage(), 0.1);
        assertTrue(!firstResult.getTypes().isEmpty());
        assertEquals(2, firstResult.getTypes().size());
        assertEquals("Giant",firstResult.getTypes().get(0));
        assertEquals("Dragon",firstResult.getTypes().get(1));
        assertEquals("and",firstResult.getConnector());
        BossTypeCondition secondResult = (BossTypeCondition) result.getConditions().get(1);
        assertEquals(100,secondResult.getDamage(), 0.1);
        assertTrue(!secondResult.getTypes().isEmpty());
        assertEquals(1, secondResult.getTypes().size());
        assertEquals("Aquatic",secondResult.getTypes().get(0));
    }
    @Test
    public void testParseOnlyBossCondition() {
        System.out.println("Parse With Boss Condition");
        MagicParser instance = new MagicParser(new MagicRequest(17, "Each attack by any raid member has a 6% chance to deal 120% damage against Guild raids;"));
        Effect result = instance.parse();
        System.out.print(result);
        assertEquals(17, result.getId());
        assertEquals(6, result.getChance(), 0.1);
        assertEquals(0, result.getDamage(), 0.1);
        assertFalse(result.getConditions().isEmpty());
        assertEquals(1,result.getConditions().size());
        BossTypeCondition firstResult = (BossTypeCondition) result.getConditions().get(0);
        assertEquals(120,firstResult.getDamage(), 0.1);
        assertTrue(!firstResult.getTypes().isEmpty());
        assertEquals("Guild",firstResult.getTypes().get(0));
    }
    
}
