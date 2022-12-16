package com.tplonski.service;

import com.tplonski.mapper.ConsumeToGameMapperImpl;
import com.tplonski.model.Game;
import com.tplonski.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ConsumeToGameMapperImpl consumeToGameMapper;

    public void saveGameFromConsume(ConsumerRecord<String, String> records){
        Game game = consumeToGameMapper.map(records.key(),records.value());
        System.out.println(gameRepository.save(game).toString());
    }

}
