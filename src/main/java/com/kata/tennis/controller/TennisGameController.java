package com.kata.tennis.controller;


import com.kata.tennis.service.TennisGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tennis-game")
@RequiredArgsConstructor
public class TennisGameController {

    private final TennisGameService tennisGameService;


    @GetMapping("/score/{winnersParam}")
    public ResponseEntity<List<String>> getScoreGame(@PathVariable final String winnersParam){
        return ResponseEntity.ok(tennisGameService.printScoreGameReport(winnersParam));
    }

}
