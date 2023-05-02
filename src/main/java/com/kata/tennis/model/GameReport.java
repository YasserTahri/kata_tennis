package com.kata.tennis.model;

import com.kata.tennis.dto.PlayerScoreDto;
import com.kata.tennis.enums.GameStatus;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameReport {

 private List<PlayerScoreDto> playersScore = new ArrayList<>();
 private GameStatus gameStatus;
 private String codePlayerWins;
}
