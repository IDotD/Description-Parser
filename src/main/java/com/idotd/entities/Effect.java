package com.idotd.entities;

import com.idotd.entities.interfaces.Condition;
import java.util.ArrayList;
import java.util.List;

public class Effect {
    
    private int id;
    private float damage;
    private float chance;
    private String text;
    private List<Condition> conditions;
    

    public Effect(int id, float chance, float damage, String text) {
        this(id, chance, damage, text, new ArrayList<>());
    }
    
    public Effect(int id, float chance, float damage, String text, List<Condition> conditions) {
        super();
        this.id = id;
        this.chance = chance;
        this.damage = damage;
        this.text = text;
        this.conditions = conditions;
    }
    public int getId() {
        return id;
    }

    public float getDamage() {
        return damage;
    }

    public float getChance() {
        return chance;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    @Override
    public String toString() {
        return "Effect [id=" + id + ",\n\tdamage=" + damage + ",\n\tchance=" + chance + ",\n\ttext=" + text + ",\n\tconditions="
                + conditions + "]";
    }
    
    
}
