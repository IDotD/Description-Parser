/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idotd.parser;

import com.idotd.entities.MagicRequest;
import com.idotd.entities.Effect;
import com.idotd.interfaces.Parser;

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
}
