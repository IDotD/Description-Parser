/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idotd.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.idotd.entities.BossTypeCondition;
import com.idotd.entities.interfaces.Condition;
import com.idotd.entities.Effect;
import com.idotd.entities.MagicRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MagicParser {

    private final MagicRequest magic;

    public MagicParser(MagicRequest magic) {
        this.magic = magic;
    }

    public Effect parse(){
        Matcher m1 = Pattern.compile(
                "(\\d+)%\\schance\\sto\\sdeal\\s(\\d+)%\\sdamage",
                Pattern.CASE_INSENSITIVE+Pattern.MULTILINE
        ).matcher(magic.getProc());
        if(!m1.find()) {
            return new Effect(magic.getId(),0,0,magic.getProc());
        }
        Effect effect = new Effect(magic.getId(),Integer.parseInt(m1.group(0)), Integer.parseInt(m1.group(1)), magic.getProc());

        addConditionToEffect(effect, "additional\\s(\\d+)%\\sdamage\\sagainst\\s(.*?)", BossTypeCondition.class);
        addConditionToEffect(effect, "Extra\\s(\\d+)%\\sdamage\\sagainst\\s(\\w+)\\sraids", BossTypeCondition.class);

        return effect;
    }
    private void addConditionToEffect(Effect effect, String pattern, Class type) {
        Matcher matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE+Pattern.MULTILINE).matcher(magic.getProc());
        while(matcher.find()) {
            try {
                Condition con = (Condition) type.newInstance();
                con.addMatches(matcher);
                effect.getConditions().add(con);
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(MagicParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
