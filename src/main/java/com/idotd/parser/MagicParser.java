/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idotd.parser;

import com.idotd.entities.Magic;
import com.idotd.entities.Effect;
import com.idotd.interfaces.Parser;

public class MagicParser implements Parser {

    private Magic magic;

    public MagicParser(Magic newMagic) {
        this.magic = newMagic;
    }

    private int FilterChance(String text) {
        int chance = 0;
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; ++i) {
            if (words[i].endsWith("%")) {
                chance = Integer.parseInt(words[i].substring(0, words[i].length() - 2));
            }
        }
        return chance;
    }
    private int FilterDamage(String text) {
        int dmg = 0;
        String[] words = text.split(" ");
        for (int i = words.length - 1; i >= 0; --i) {
            if (words[i].endsWith("%")) {
                dmg = Integer.parseInt(words[i].substring(0, words[i].length() - 2));
            }
        }
        return dmg;
    }

    @Override
    public void run() {
        String[] components = this.magic.getProc().split(";");
        Effect[] effects = new Effect[components.length];
        for (int i = 0; i < components.length; ++i) {
            int dmg = 0;
            int chance = 0;
            // basic proc
            if (components[i].startsWith("Attacks by")) {
                effects[i] = new Effect(magic,FilterChance(components[i]),FilterDamage(components[i]),components[i]);
            }
        }
    }
}
