package com.kata.tennis.service;

import com.kata.tennis.enums.GameStatus;
import com.kata.tennis.service.impl.TennisGameImpl;
import com.kata.tennis.validator.TennisGameValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
class TennisGameTest {
    List<String> gameMessages;
    @InjectMocks
    private TennisGameImpl tennisGameImpl;

    @BeforeEach
    void should_validate_code_players(){
        String players= "ABAABBA";
        boolean validatedParams= TennisGameValidator.validateParameters(players);
        assertTrue(validatedParams);

    }

    @Test
    void should_display_message_p1_wins_firstBall(){
        String players= "A";
        gameMessages = tennisGameImpl.printScoreGameReport(players);
        assertEquals("Player A: 15 / Player B: 0", gameMessages.get(0));
    }
    @Test
    @DisplayName("should display this message ==> Player A 15 / Player B: 15")
    void should_display_two_message_p2_wins_secondBall(){
        String players= "AB";

        gameMessages = tennisGameImpl.printScoreGameReport(players);
        assertEquals("Player A: 15 / Player B: 0", gameMessages.get(0));
        assertEquals("Player A: 15 / Player B: 15", gameMessages.get(1));

    }
    @Test
    @DisplayName("should display this message ==> Player A 30 / Player B: 15")
    void should_display_message_p1_wins_ThirdBall(){
        String players= "ABA";

        gameMessages = tennisGameImpl.printScoreGameReport(players);
        assertEquals("Player A: 15 / Player B: 0", gameMessages.get(0));
        assertEquals("Player A: 30 / Player B: 15", gameMessages.get(2));
    }
    @Test
    @DisplayName("should display this message ==> Player A 30 / Player B: 30")
    void should_display_message_p1_wins_forthBall(){
        String players= "ABAB";

        gameMessages = tennisGameImpl.printScoreGameReport(players);
        assertEquals("Player A: 15 / Player B: 0", gameMessages.get(0));
        assertEquals("Player A: 30 / Player B: 30", gameMessages.get(3));
    }
    @Test
    @DisplayName("should display this message ==> return DEUCE")
    void should_display_deuce_if_both_have40(){
        String players= "AAABBB";

        gameMessages = tennisGameImpl.printScoreGameReport(players);
        assertEquals(GameStatus.DEUCE, gameMessages.get(0));
    }

    @Test
    @DisplayName("should display this message ==> DEUCE")
    void should_display_deuce_if_both_have_40_points(){
        String players= "ABABAB";

        gameMessages = tennisGameImpl.printScoreGameReport(players);
        assertEquals(GameStatus.DEUCE.toString(), gameMessages.get(0));
    }

    @Test
    @DisplayName("should display message winner player A")
    void should_display_report_with_winner_player(){
        String players= "ABABAA";

        gameMessages = tennisGameImpl.printScoreGameReport(players);
        assertEquals("Player A wins the game", gameMessages.get(5));
    }
}
