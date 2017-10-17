package com.idotd.entities;

import com.idotd.entities.interfaces.Condition;
import java.util.ArrayList;
import java.util.List;

public class Effect {
    
    private int id;
	private int damage;
    private int chance;
    private String text;
    private List<Condition> conditions;
    

    public Effect(int id, int chance, int damage, String text) {
    	this(id, chance, damage, text, new ArrayList<>());
	}
    
    public Effect(int id, int damage, int chance, String text, List<Condition> conditions) {
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

    public int getDamage() {
        return damage;
    }

    public int getChance() {
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
}
