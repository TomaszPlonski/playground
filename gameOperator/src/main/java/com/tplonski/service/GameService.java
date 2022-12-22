package com.tplonski.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface GameService {

    public void saveGameFromConsume(ConsumerRecord<String, String> records);
}
