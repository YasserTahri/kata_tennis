package com.kata.tennis.service;

import com.kata.tennis.model.GameReport;
import com.kata.tennis.model.Player;

import java.util.List;

public interface TennisGameService {
    GameReport getScoreGame(String playersWinners);
    List<String> printScoreGameReport(String playersWinners);
}
