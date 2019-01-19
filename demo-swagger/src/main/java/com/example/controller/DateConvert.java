package com.example.controller;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateConvert implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        try {
            return DateFormat.getDateInstance().parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
