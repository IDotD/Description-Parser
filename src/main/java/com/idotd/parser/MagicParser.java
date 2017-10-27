/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idotd.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.idotd.entities.BossTypeCondition;
import com.idotd.entities.interfaces.Condition;
import com.idotd.entities.Effect;
import com.idotd.entities.MagicRequest;
import com.idotd.service.UsNumber;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MagicParser {

	private final MagicRequest magic;

	public MagicParser(MagicRequest magic) {
		this.magic = magic;
	}

	private Effect createEffect(Matcher m) throws ParseException {
		Effect effect = new Effect(magic.getId(), UsNumber.asFloat(m.group("chance")),
				m.group("raids") != null ? 0f : UsNumber.asFloat(m.group("damage")), magic.getProc());
		if (m.group("raids") != null) {
			addConditionToEffect(effect, "to\\sdeal\\s(?<damage>[\\d\\.\\,]+)%\\sdamage\\sagainst\\s(?<raids>\\w+)\\sraids", BossTypeCondition.class);
		}
		return effect;
	}

	public Effect parse() throws NumberFormatException, ParseException {
		Matcher m = Pattern
				.compile("(?<chance>[\\d\\.\\,]+)%\\schance\\sto\\sdeal\\s(?<damage>[\\d\\.\\,]+)%\\sdamage(?<raids>\\sagainst\\s\\w+\\sraids)?",
						Pattern.CASE_INSENSITIVE + Pattern.MULTILINE)
				.matcher(magic.getProc());
		if (!m.find()) {
			return new Effect(magic.getId(), 0f, 0f, magic.getProc());
		}
		Effect effect = createEffect(m);
		addConditionToEffect(effect, "Extra\\s(?<damage>[\\d\\.\\,]+)%\\sdamage\\sagainst\\s(?<raids>[^\\;]*)raids",
				BossTypeCondition.class);
		return effect;
	}

	private void addConditionToEffect(Effect effect, String pattern, Class type) {
		Matcher matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE + Pattern.MULTILINE)
				.matcher(magic.getProc());
		while (matcher.find()) {
			try {
				Condition con = (Condition) type.newInstance();
				con.addMatches(matcher);
				effect.getConditions().add(con);
			} catch (InstantiationException | IllegalAccessException ex) {
				Logger.getLogger(MagicParser.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
