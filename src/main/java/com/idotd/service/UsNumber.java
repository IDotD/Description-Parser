package com.idotd.service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class UsNumber {
    private static final NumberFormat US = NumberFormat.getInstance(Locale.US);
    public static float asFloat(String input) throws ParseException {
        return US.parse(input).floatValue();
    }
}
