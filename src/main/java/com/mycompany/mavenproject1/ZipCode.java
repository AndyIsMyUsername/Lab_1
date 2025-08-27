/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author luoan
 */
public class ZipCode {
    public int Zip;
    private boolean valid;
    
    private static final String[] DIGIT_TO_CODE = {
        "11000",
        
    };
    
    public ZipCode(int zip) {
        if(zip < 0 || zip > 99999) {
            System.out.println("Error : mus tbe 5 digits");
            valid = false;
            this.zip = 0;
        }
        this.Zip = zip;
        valid = true;
    }
    
    public ZipCode(String barCode) {
        this.Zip = 0;
        valid = false;
        
        if (barCode.length() != 27) {
            System.out.println("ERROR");
            return;
        }
        
        if (barCode.charAt(0) != '1' || barCode.charAt(barCode.length() - 1) != '1') {
            System.out.println("ERROR : BARCODE MUST START AND END WITH 1");
            return;
        }
        
        String core = barCode.substring(1, barCode.length() - 1);
        
        if (core.length() != 25) {
            System.out.println("ERROR");
            return;
        }
        
        String zipDigits = "";
        int [] weights = {7, 4, 2, 1,0);
        
        for (int i = 0; i < 25;  i +=5) {
            String group
        }
    }
        
    }
}
