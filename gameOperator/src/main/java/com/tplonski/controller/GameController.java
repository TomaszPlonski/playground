package com.tplonski.controller;

import com.tplonski.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameRepository gameRepository;


    @GetMapping("/players")
    List<String> allPlayers(){
        return gameRepository.findAllDistinctPlayers();
    }

    @GetMapping("/player-wins/{name}")
    Long getPlayerWins(@PathVariable String name){
        return gameRepository.countByFirstPlayerAndIsFirstPlayerAWinnerTrueOrSecondPlayerAndIsFirstPlayerAWinnerFalse(name,name);
    }

}
