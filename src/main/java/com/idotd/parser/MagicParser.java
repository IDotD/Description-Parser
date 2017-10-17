/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idotd.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.idotd.entities.BossTypeCondition;
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
		MagicReply magic = new MagicReply(parseEffects(), this.magic.getId(), this.magic.getProc());
		
		return magic;
	}
	
	private ArrayList<Effect> parseEffects(){
		ArrayList<Effect> list = new ArrayList<Effect>();
		
		Pattern p1 = Pattern.compile("(\\d+)%\\schance\\sto\\sdeal\\s(\\d+)%\\sdamage");
		Matcher m1 = p1.matcher(magic.getProc());
		
		if(m1.find()) {
			list.add(new Effect(magic.getId(),Integer.parseInt(m1.group(0)), Integer.parseInt(m1.group(1)), magic.getProc()));
			
			Pattern p2 = Pattern.compile("additional\\s(\\d+)%\\sdamage\\sagainst\\s(.*?)");
			Matcher m2 = p2.matcher(magic.getProc());
			while(m2.find()) {
				list.add(new Effect(magic.getId(), 100, Integer.parseInt(m2.group(0)), magic.getProc(), BossTypeConditionParsing(m2.group(1))));
			}
			
			Pattern p3 = Pattern.compile("Extra\\s(\\d+)%\\sdamage\\sagainst\\s(\\w+)\\sraids");
			Matcher m3 = p3.matcher(magic.getProc());
			while(m3.find()) {
				list.add(new Effect(magic.getId(), 100, Integer.parseInt(m3.group(0)), magic.getProc(), BossTypeConditionParsing(m2.group(1))));
			}
		}
		
		return list;
	}
	
	private BossTypeCondition[] BossTypeConditionParsing(String s) {
		return Arrays.stream(s.split(", |,| and ")).map(BossTypeCondition::new).toArray(BossTypeCondition[]::new);
	}
}
