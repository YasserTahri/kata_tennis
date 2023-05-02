package com.kata.tennis.service.impl;

import com.kata.tennis.dto.PlayerScoreDto;
import com.kata.tennis.enums.GameStatus;
import com.kata.tennis.model.GameReport;
import com.kata.tennis.service.TennisGameService;
import com.kata.tennis.transverse.Constants;
import com.kata.tennis.transverse.Utils;
import com.kata.tennis.validator.TennisGameValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Service
public class TennisGameImpl implements TennisGameService {

    static int scorePlayer1 = 0;
    static int scorePlayer2 = 0;

    @Override
    public GameReport getScoreGame(String playersWinners) {
        List<String> playersList = Utils.splitParameters(playersWinners);
        PlayerScoreDto playerScoreDto;
        int lastScoreP1 = 0;
        int lastScoreP2 = 0;
        List<Integer> scoreListP1 = new ArrayList<>();
        List<Integer> scoreListP2 = new ArrayList<>();
        List<PlayerScoreDto> playersScore = new ArrayList<>();
        GameReport gameReport = new GameReport();
        for (String s : playersList) {

            if (s.equalsIgnoreCase(Constants.CODE_PLAYER_1)) {
                scorePlayer1 += 1;

                if (!scoreListP2.isEmpty()) {
                    Stream<Integer> StreamScore = scoreListP2.stream();
                    lastScoreP2 = StreamScore.reduce((first, last) -> last)
                            .orElse(0);
                }

                playerScoreDto = PlayerScoreDto.builder()
                        .codePlayer(Constants.CODE_PLAYER_1)
                        .scoreP1(nextScore(scorePlayer1))
                        .scoreP2(lastScoreP2)
                        .message(buildMessage(nextScore(scorePlayer1), lastScoreP2))
                        .build();
                if (playerScoreDto.getScoreP1() != 11) {
                    scoreListP1.add(playerScoreDto.getScoreP1());
                    playersScore.add(playerScoreDto);
                }
            } else {
                if (!scoreListP1.isEmpty()) {
                    Stream<Integer> StreamScore = scoreListP1.stream();
                    lastScoreP1 = StreamScore.reduce((first, last) -> last)
                            .orElse(0);
                }
                scorePlayer2 += 1;
                playerScoreDto = PlayerScoreDto.builder()
                        .codePlayer(Constants.CODE_PLAYER_2)
                        .scoreP1(lastScoreP1)
                        .scoreP2(nextScore(scorePlayer2))
                        .message(buildMessage(lastScoreP1, nextScore(scorePlayer2)))
                        .build();
                if (playerScoreDto.getScoreP2() != 11) {
                    scoreListP2.add(playerScoreDto.getScoreP2());
                    playersScore.add(playerScoreDto);
                }
            }
            if (playerScoreDto.getScoreP1() == 40 && playerScoreDto.getScoreP2() == 40) {
                gameReport = GameReport.builder()
                        .gameStatus(GameStatus.DEUCE)
                        .playersScore(playersScore)
                        .build();
                return gameReport;
            } else {
                playerWinGame(playerScoreDto, gameReport);
            }
        } // END for loop
        gameReport.setPlayersScore(playersScore);
        return gameReport;
    }

    private void playerWinGame(PlayerScoreDto playerScoreDto, GameReport gameReport){
        if (playerScoreDto.getCodePlayer().equalsIgnoreCase(Constants.CODE_PLAYER_1)) {
            if (playerScoreDto.getScoreP1() == 40 && scorePlayer1 > 2) {
                gameReport.setGameStatus(GameStatus.WIN_GAME);
                gameReport.setCodePlayerWins(Constants.CODE_PLAYER_1);
            }
        } else {
            if (playerScoreDto.getScoreP2() == 40 && scorePlayer2 > 2) {
                gameReport.setCodePlayerWins(Constants.CODE_PLAYER_2);
                gameReport.setGameStatus(GameStatus.WIN_GAME);
            }
        }
    }
    @Override
    public List<String> printScoreGameReport(String playersWinners) {

        List<String> messagesList = new ArrayList<>();
        List<PlayerScoreDto> scoreGameList;


        if (TennisGameValidator.validateParameters(playersWinners)) {
            GameReport gameReport = getScoreGame(playersWinners);
            scoreGameList = gameReport.getPlayersScore();
            for (PlayerScoreDto player : scoreGameList) {
                messagesList.add(player.getMessage());
            }
            if (gameReport.getGameStatus() == GameStatus.DEUCE) {
                messagesList.clear();
                messagesList.add(GameStatus.DEUCE.toString());
            } else {
                if (gameReport.getGameStatus() == GameStatus.WIN_GAME) {
                    messagesList.add("Player " + gameReport.getCodePlayerWins() + " wins the game");
                }
            }

            System.out.println("------------------------- START --------------------------");
            messagesList.forEach(System.out::println);
            System.out.println("-------------------------- END -------------------------------");
        } else {
            messagesList.add("Attention, paramètre Invalid !");
        }
        return messagesList;
    }

    private String buildMessage(int scoreP1, int scoreP2) {
        return "Player A: " + scoreP1 + " / Player B: " + scoreP2;
    }

    private int nextScore(int index) {
        return switch (index) {
            case 1 -> Constants.GAME_SCORES.get(1);
            case 2 -> Constants.GAME_SCORES.get(2);
            case 3 -> Constants.GAME_SCORES.get(3);
            default -> 11;
        };
    }
}
