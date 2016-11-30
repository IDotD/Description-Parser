package com.idotd.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Effect {
        private Magic magic;
        private int baseDamage;
        private int baseChance;
        //private Condition[] conditions;
    
    public int getBaseDamage(){
        return baseDamage;
    }
    
    public void setBaseDamage(int min){
        baseDamage = min;
    }
    
    public int getBaseChance(){
        return baseChance;
    }
    
    public void setBaseChance(int min){
        baseChance = min;
    }
}
