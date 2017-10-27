package com.idotd.entities;

import com.idotd.entities.interfaces.Condition;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class BossTypeCondition implements Condition{
	protected List<String> types;
    protected float  damage;
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
        String type = matcher.group(2);
        System.out.println(type);
        if(type.contains(" and ")) {
            connector = "and";
        }
        if(types==null) {types = new ArrayList<String>(); }
        for(String t:(type.replaceAll(" (and|or) ", ",")).split(",")) {
            types.add(t.trim());
        }
        damage = Float.parseFloat(matcher.group(1));
    }
}