package com.ityc.se.exceptions;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(getResult());
    }

    public static String getResult(){
        try {
            return "try";
        } catch (Exception e){

        } finally {
            return "finally";
        }
    }

}
