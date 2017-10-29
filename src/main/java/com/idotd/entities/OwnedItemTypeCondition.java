package com.idotd.entities;

import com.idotd.entities.interfaces.Condition;
import com.idotd.service.UsNumber;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;

public class OwnedItemTypeCondition implements Condition{
    private float damage = 0;
    private int max = -1;
    protected String connector = "or";
    protected List<String> names = new ArrayList<>();
    
    public float getDamage() {
        return damage;
    }
    public int getMax() {
    	return max;
    }
    public String getConnector() {
    	return connector;
    }
    public List<String> getNames() {
        return names;
    }
    @Override
    public void addMatches(Matcher matcher) {        
    	String name = matcher.group("items");
    	max = matcher.group("unique") == null ? 1 : 9;
    	if(name.contains(" and ")) {
    		connector = "and";
    	}
    	for(String n:(name.replaceAll(" (and|or) ", ",")).split(",")) {
    		names.add(n);
    	}
    	try {
    		damage = UsNumber.asFloat(matcher.group("damage"));
    	} catch (ParseException ex) {
    		Logger.getLogger(BossTypeCondition.class.getName()).log(Level.SEVERE, null, ex);
    	}
    }
	@Override
	public String toString() {
		return "OwnedItemTypeCondition [damage=" + damage + ", connector=" + connector + ", names=" + names + "]";
	}
}
