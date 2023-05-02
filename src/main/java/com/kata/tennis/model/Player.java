package com.kata.tennis.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    // Example name as "Player A" Or "Player B"
    private String name;
    private String code;
    private int score;
}
