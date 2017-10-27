package com.idotd.entities;

import com.idotd.entities.interfaces.Condition;
import com.idotd.service.UsNumber;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;

public class BossTypeCondition implements Condition{
    protected List<String> types = new ArrayList<>();
    protected float damage = 0;
    protected String connector = "or";
    public List<String> getTypes() {
        return types;
    }
    public float getDamage() {
        return damage;
    }
    public String getConnector() {
        return connector;
    }
    @Override
    public void addMatches(Matcher matcher) {
        String type = matcher.group("raids");
        if(type.contains(" and ")) {
            connector = "and";
        }
        for(String t:(type.replaceAll(" (and|or) ", ",")).split(",")) {
            types.add(t.trim());
        }
        try {
            damage = UsNumber.asFloat(matcher.group("damage"));
        } catch (ParseException ex) {
            Logger.getLogger(BossTypeCondition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	@Override
	public String toString() {
		return "BossTypeCondition [types=" + types + ", damage=" + damage + ", connector=" + connector + "]";
	}
    
}