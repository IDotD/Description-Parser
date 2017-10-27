package com.idotd.entities;

public class MagicRequest {
    
    private final int id;
    private final String proc;

    public MagicRequest(int id, String proc) {
        this.id = id;
        this.proc = proc;
    }

    public String getProc() {
        return proc;
    }

    public int getId() {
        return id;
    }
}