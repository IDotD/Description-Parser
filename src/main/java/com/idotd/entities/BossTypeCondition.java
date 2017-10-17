package com.idotd.entities;

public class BossTypeCondition extends Condition{

	private String type;
	
	public BossTypeCondition(String type) {
		super();
		this.type = type;
	}
	
	public String getType() { return type; }
}