/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idotd.entities;

public class MagicReply {

	private Effect[] effects;
    private String name;
    private String proc;

	public MagicReply(Effect[] effects, String name, String proc) {
		super();
		this.effects = effects;
		this.name = name;
		this.proc = proc;
	}
	
	public Effect[] getEffects() {
		return effects;
	}
	public void setEffects(Effect[] effects) {

		this.effects = effects;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {

		this.name = name;
	}
		
	
	public String getProc() {
		return proc;
	}
	
	public void setProc(String proc) {
		this.proc = proc;
	}
}
