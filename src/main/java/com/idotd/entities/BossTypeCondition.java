package com.idotd.entities;

import com.idotd.entities.interfaces.Condition;
import java.util.List;
import java.util.regex.Matcher;

public class BossTypeCondition implements Condition{
	protected List<String> types;
    protected Integer damage;
    protected String connector = "or";
	public List<String> getTypes() {
        return types;
    }
    public Integer getDamage() {
        return damage;
    }
    @Override
    public void addMatches(Matcher matcher) {
        String type = matcher.group(2);
        if(type.contains(" and ")) {
            connector = "and";
        }
        for(String t:type.replaceAll(" and ", ",").split(",")) {
            types.add(t.trim());
        }
        damage = Integer.parseInt(matcher.group(1));
    }
}