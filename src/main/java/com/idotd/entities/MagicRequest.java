package com.idotd.entities;

public class MagicRequest {

	public MagicRequest(int id, String proc) {
		super();
		this.setId(id);
		this.setProc(proc);
	}

	public String getProc() {
		return proc;
	}

	public void setProc(String proc) {
		this.proc = proc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;

	private String proc;
	
}