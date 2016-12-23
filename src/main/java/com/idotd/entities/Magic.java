/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idotd.entities;

public class Magic {

    private Effect[] effects;
    private String name;
    private String proc;

    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Effect[] getEffect() {
        return effects;
    }

    public void setEffects(Effect[] effects) {
        this.effects = effects;
    }
}
