package com.tplonski.kafka;

import com.google.gson.Gson;
import com.tplonski.model.Players;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GameConsumer {

    @KafkaListener(topics = "game-test",
            groupId = "first")

    // Method
    public void consume(ConsumerRecord<String, String> records) {

        Players players = new Gson().fromJson(records.key(), Players.class);
        log.info(players.getFirstPlayer());

    }


}

