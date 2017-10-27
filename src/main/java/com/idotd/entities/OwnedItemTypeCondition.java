package com.idotd.entities;

import com.idotd.entities.interfaces.Condition;
import java.util.regex.Matcher;

public class OwnedItemTypeCondition implements Condition{
    private float damage = 0;
    private int maxItems = -1;
    private String name = "unknown";

    public float getDamage() {
        return damage;
    }
    public int getMaxItems() {
        return maxItems;
    }
    public String getName() {
        return name;
    }
    @Override
    public void addMatches(Matcher matcher) {
        damage = 1;
        maxItems = 9;
        name = "a";
    }
}
