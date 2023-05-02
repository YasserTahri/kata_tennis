package com.kata.tennis.enums;

public enum GameStatus {
    WIN_GAME("wins the game"), DEUCE("Deuce"), ADV("Advantage");
    private final String gameStatusMessage;
    GameStatus(String gameStatusMessage) {
        this.gameStatusMessage = gameStatusMessage;
    }
}
