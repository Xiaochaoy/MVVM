package com.example.mvvm;

public class Comunes {
    public static boolean isNumeric(double cadena){
        try {
            Double.parseDouble(String.valueOf(cadena));
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
    public static boolean isNumeric(int cadena){
        try {
            Integer.parseInt(String.valueOf(cadena));
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}

