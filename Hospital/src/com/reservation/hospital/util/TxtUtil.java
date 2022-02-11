/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reservation.hospital.util;

/**
 *
 * @author 정도윤(Doyun Jung)
 */
public class TxtUtil {

    public static String personSecName(String name){
        
        String strTmp = "";
        
        for ( int i = 0; i < name.length(); i++ ){
            
            if ( i == 0 ){
                strTmp = name.substring(0, i + 1);
            }
            else{
                strTmp = strTmp + "*";
            }
            
        }
        
        return strTmp;
    }
    
    public static String shortDate(String strDate){
        
        return strDate.substring(0, 10);
        
    }
    
    public static String shortLastPhoneNumber(String strNumber){
        
        String strTmp = "";
        
        for ( int i = strNumber.length(); i > strNumber.length() - 4; i-- ){
            strTmp = strTmp + strNumber.substring(i - 1, i);
        }
        
        return strTmp;
        
    }
    
    public static String getDeptCode(String strValue){
        
        String strTmp = "";
        
        strTmp = strValue.substring(0, strValue.indexOf("/", 0) );
        
        return strTmp;
        
    }
            
    
}
