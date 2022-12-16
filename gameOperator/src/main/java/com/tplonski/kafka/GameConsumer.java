package com.tplonski.kafka;

import com.tplonski.mapper.ConsumeToGameMapperImpl;
import com.tplonski.service.GameServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class GameConsumer {

    private final GameServiceImpl gameService;

    @KafkaListener(topics = "game",
            groupId = "first")

    // Method
    public void consume(ConsumerRecord<String, String> records) {

    gameService.saveGameFromConsume(records);

    }


}

