package com.idotd.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Effect {

    public Effect(MagicReply magic, int dmg, int chance, String text) {
		super();
		this.magic = magic;
		this.dmg = dmg;
		this.chance = chance;
		this.text = text;
	}

	private MagicReply magic;
    private int dmg;
    private int chance;
    private String text;
    //private Condition[] conditions;

    public int getBaseDamage() {
        return dmg;
    }

    public void setBaseDamage(int newDmg) {
        dmg = newDmg;
    }

    public int getBaseChance() {
        return chance;
    }

    public void setBaseChance(int newChance) {
        chance = newChance;
    }
    

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MagicReply getMagic() {
		return magic;
	}

	public void setMagic(MagicReply magic) {
		this.magic = magic;
	}
}
