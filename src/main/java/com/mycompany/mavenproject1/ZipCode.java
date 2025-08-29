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
    
    //table for each digit 
    private static final String[] DIGIT_TO_CODE = {
        "11000", //0
        "00011", //1
        "00101", //2
        "00110", //3
        "01001", //4
        "01010", //5
        "01100", //6
        "10001", //7
        "10010", //8
        "10100"  //9
        
    };
    
    //Constructor taking barCode String and uses parseBarCoded method to initialize zip
    public ZipCode (String barCode) {
        this.Zip = parseBarCode(barCode);
    }
    
    //Constructor from Integer
    public ZipCode(int zip) {
        
        //checks for 6 digit or more
        if(zip < 0 || zip > 999999) {
            System.out.println("Error : must tbe 5 digits");
            this.Zip = 0;
        } else {
            this.Zip = zip;
        }
    }
    
    /**
     * parse a barCode from String to integer
     * @param barCode takes barCode as String
     * @return 
     */
    public int parseBarCode (String barCode) {
        
        if (barCode.length() != 27) {
            System.out.println("ERROR");
            return 0;
        }
        
        if (barCode.charAt(0) != '1' || barCode.charAt(barCode.length() - 1) != '1') {
            System.out.println("ERROR : BARCODE MUST START AND END WITH 1");
            return 0;
        }
        
        String core = barCode.substring(1, barCode.length() - 1);
        
        if (core.length() != 25) {
            System.out.println("ERROR");
            return 0;
        }
        
        //final result as String
        String zipDigits = "";
        int [] weights = {7, 4, 2, 1,0};
        
        for (int i = 0; i < 25;  i += 5) {
            String group = core.substring(i, i + 5);
            
            //in the group must contain 2 ones or else not acceptable
            int ones = 0;
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                if (group.charAt(j) == '1') {
                    sum += weights[j];
                    ones++;
                } else if (group.charAt(j) != '0') {
                    System.out.println("ERROR");
                    return 0;
                }
            }
            
            // if there is not 2 ones then error
            if (ones != 2) {
                System.out.println("ERROR");
                return 0;
            }
            
            //for if sum is equal to 11 (special rule)
            int digit = (sum == 11) ? 0 :sum;
            
            if (digit < 0 || digit > 9) {
                System.out.println("ERROR");
                return 0;
            }
            
            zipDigits += digit;
        }
        //change the String into numbers
        return Integer.parseInt(zipDigits);
    }
    
    /**
     * encodes the stored integer ZIP code
     * @return barCode as a String of 27 digits
     */
    public String GetBarCode(){
        
        //if zip is invalid then it returns error
        if (Zip < 0 || Zip > 999999) {
            return "ERROR";
        }
        
        String ZipString = String.format("%05d", Zip);
        
        //must start with 1
        String result = "1";
        
        
        for (int i = 0; i < ZipString.length(); i++) {
            int digit = ZipString.charAt(i) - '0';
            result += DIGIT_TO_CODE[digit];
        }
       
        //must end with 1
        result += "1";
        
        return result;
    }
}
