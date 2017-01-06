package com.idotd.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Effect {

    private Magic magic;
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

    public Effect(Magic magic, int dmg, int chance, String text) {
        this.magic = magic;
        this.dmg = dmg;
        this.chance = chance;
        this.text = text;
    }

    public String ToString() {
        return "This effect belongs to " + magic.getName() + " and has a chance of" + chance + "to deal" + dmg + " damage";
    }
}
