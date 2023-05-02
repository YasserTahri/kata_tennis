package com.kata.tennis.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TennisGameValidator {

    public static boolean validateParameters(String params){
        boolean isValid = false;
        final String pattern= "[ab]*";
        if(params != null && !params.isBlank()){
            if(params.toLowerCase().matches(pattern)){
                isValid = true;
            }
        }else{
            throw new IllegalArgumentException("Sorry, problems related to parameters !");
        }
        return isValid;
    }
}
