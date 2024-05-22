package com.example.demo.helpers;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class ValidacionPatron {
    public static Boolean evaluarPatron(String cadena, String expresionRegular){
        Pattern patron = Pattern.compile(expresionRegular);
        Matcher coincidencia = patron.matcher(cadena);

        if (coincidencia.matches()){
            return true;
        }else {
            return false;
        }
    }
}
