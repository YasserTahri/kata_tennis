package com.kata.tennis.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerScoreDto {

    private String codePlayer;
    private int scoreP1;
    private int scoreP2;
    private String message;
}
