package com.cs.canvas.utils;

public class Utils {

    public static boolean isNumber(String s) {
        boolean isNumber = true;
        try {
           Integer n = Integer.parseInt(s.trim());
           if(n < 0){
               throw new NumberFormatException();
           }
        }catch(NumberFormatException ex){
            isNumber = false;
        }
        return isNumber;
    }
}
