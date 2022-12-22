package com.tplonski.service;

import com.tplonski.mapper.ConsumeToGameMapperImpl;
import com.tplonski.model.Game;
import com.tplonski.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ConsumeToGameMapperImpl consumeToGameMapper;

    @Override
    public void saveGameFromConsume(ConsumerRecord<String, String> records){
        Game game = consumeToGameMapper.map(records.key(),records.value());
        game.setIsFirstPlayerAWinner();
        Game savedGame = gameRepository.save(game);
        log.info("Consumed: first player = {} chose = {} ||| first player = {} chose = {}",savedGame.getFirstPlayer(),savedGame.getFirstPlayerChoice(),savedGame.getSecondPlayerChoice(),savedGame.getSecondPlayer());
    }


}
