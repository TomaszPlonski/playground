package com.tplonski.service;

import com.tplonski.model.Game;
import com.tplonski.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public void saveGame(Game game){
        gameRepository.save(game);
    }

}
