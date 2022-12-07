package com.tplonski.gameOperator.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GameConsumerTest {

    @KafkaListener(topics = "string-test",
            groupId = "first")

    // Method
    public void consume(ConsumerRecord<String, String> records) {

        log.info("!!!! value = {}", records.value());
        log.info("key = {}, value = {} => partition = {}, offset= {}", records.key(), records.value(), records.partition(), records.offset());
    }


}

