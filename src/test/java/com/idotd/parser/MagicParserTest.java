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
        assertEquals(7.5, result.getChance());
        assertEquals(900.8, result.getDamage());
        assertTrue(result.getConditions().isEmpty());
    }
    @Test
    public void testParseWithBossCondition() {
        System.out.println("Parse With Boss Condition");
        MagicParser instance = new MagicParser(new MagicRequest(17, "Each attack by any raid memBer has a 7.5% chance to deal 900.8% damage; Extra 1,100% damage against Giant raids"));
        Effect result = instance.parse();
        System.out.print(result);
        assertEquals(17, result.getId());
        assertEquals(7.5, result.getChance());
        assertEquals(900.8, result.getDamage());
        assertFalse(result.getConditions().isEmpty());
        assertEquals(1,result.getConditions().size());
        BossTypeCondition firstResult = (BossTypeCondition) result.getConditions().get(0);
        assertEquals(1100,firstResult.getDamage());
        assertTrue(!firstResult.getTypes().isEmpty());
        assertEquals("Giant",firstResult.getTypes().get(0));
    }
    
}
