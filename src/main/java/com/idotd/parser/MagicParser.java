/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idotd.parser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.idotd.entities.Effect;
import com.idotd.entities.MagicReply;
import com.idotd.interfaces.Parser;
import com.idotd.entities.MagicRequest;

public class MagicParser implements Parser {

    private MagicRequest magic;

    public MagicParser(MagicRequest magic) {
        this.magic = magic;
    }

    @Override
    public void run() {
    }

	public MagicRequest getMagic() {
		return magic;
	}

	public void setMagic(MagicRequest magic) {
		this.magic = magic;
	}
	
	private MagicReply parseMagic() {
		MagicReply magic = new MagicReply(parseEffects(this.magic, this.magic.getProc().split(";")), this.magic.getId(), this.magic.getProc());
		
		return magic;
	}
	
	private ArrayList<Effect> parseEffects(MagicRequest magic, String[] array){
		ArrayList<Effect> list = new ArrayList<Effect>();
		Matcher m;
		
		for(String item : array) {	
			Pattern p = Pattern.compile(item);
			if((m=p.matcher("\\bAttacks by any raid member have a (\\d+)% chance to deal extra (\\d+)% damage([\\s\\S]+)")).matches()){
				
			}else if((m=p.matcher("Extra (\\d+)% damage against ([\\s\\S]+) raids")).matches()){
				list.add(new Effect(magic.getId(), Integer.parseInt(m.group(0)), Integer.parseInt(m.group(1)), item));
			}
		}
		
		return list;
	}
}
