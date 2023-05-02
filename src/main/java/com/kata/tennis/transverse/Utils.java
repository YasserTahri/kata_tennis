package com.kata.tennis.transverse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {


    public static List<String> splitParameters(String players){
        return Arrays.asList(players.split(""));
    }
}
