package com.idotd.entities;

import java.util.ArrayList;

public class MagicReply {

    private ArrayList<Effect> effects;
    private int id;
    private String proc;

    public MagicReply(ArrayList<Effect> effects, int id, String proc) {
        super();
        this.effects = effects;
        this.id = id;
        this.proc = proc;
    }
    
    public ArrayList<Effect> getEffects() {
        return effects;
    }
    public void setEffects(ArrayList<Effect> effects) {

        this.effects = effects;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public String getProc() {
        return proc;
    }
    
    public void setProc(String proc) {
        this.proc = proc;
    }
}
