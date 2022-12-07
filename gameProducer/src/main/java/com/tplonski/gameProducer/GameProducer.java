package com.tplonski.gameProducer;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.*;

import com.tplonski.model.Game;
import com.tplonski.model.GameGenerator;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameProducer {

    private static final Logger LOG = LoggerFactory.getLogger(GameProducer.class);

    private static final String BOOTSTRAP_SERVERS = ":9092";
    private static final String CLIENT_ID = "ex";

    private static final String TOPIC = "game-test";

    private static Producer<String, String> producer;

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, CLIENT_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        producer = new KafkaProducer<>(props);

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> send(args[0]), 0, 3, TimeUnit.SECONDS); // no blocking

    }

    @SuppressWarnings({ "boxing", "unused" })
    public static void send(String topic) {
        Game game = GameGenerator.generate();
        String key = game.getFirstPlayer() + game.getSecondPlayer();

        ProducerRecord<String, String> data = new ProducerRecord<>(TOPIC, key, "value string test------");
        try {
            RecordMetadata meta = producer.send(data).get();
            LOG.info("key = {}, value = {} => partition = {}, offset= {}", data.key(), data.value(), meta.partition(), meta.offset());
        } catch (InterruptedException | ExecutionException e) {
            producer.flush();
        }

    }
}
