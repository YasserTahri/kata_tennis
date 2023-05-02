package com.kata.tennis.transverse;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final int DEFAULT_GAME= 0;
    public static final String PLAYER1_LABEL= "Player A";
    public static final String PLAYER2_LABEL= "Player B";
    public static final String CODE_PLAYER_1= "A";
    public static final String CODE_PLAYER_2= "B";
    public static final Map<Integer, Integer> GAME_SCORES = Map.of(0, 0,1,15, 2,30, 3, 40);

}
