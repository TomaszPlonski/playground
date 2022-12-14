package com.tplonski.kafka;

import com.tplonski.mapper.ConsumeToGameMapperImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class GameConsumer {

    private final ConsumeToGameMapperImpl consumeToGameMapper;

    @KafkaListener(topics = "game",
            groupId = "first")

    // Method
    public void consume(ConsumerRecord<String, String> records) {

        log.info("I am working");

        log.info(consumeToGameMapper.map(records.key(),records.value()).getFirstPlayerChoice().toString());

    }


}

