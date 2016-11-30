/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idotd.parser;

import com.idotd.entities.Magic;
import com.idotd.interfaces.Parser;

public class MagicParser implements Parser {
    private Magic magic;
    
    public MagicParser(Magic magic){
        this.magic = magic;
    }
    
    @Override
    public void run() {
        String[] components = magic.getProc().split(";");
        for( int i = 0; i < components.length; ++i){
            
        }
    }
}
