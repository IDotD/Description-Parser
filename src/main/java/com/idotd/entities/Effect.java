package com.idotd.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Effect {

    public Effect(int id, int chance, int damage, String text) {
		super();
		this.id = id;
		this.chance = chance;
		this.damage = damage;
		this.text = text;
	}
    
	private int id;
    private int damage;
    private int chance;
    private String text;
    //private Condition[] conditions;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
    

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
