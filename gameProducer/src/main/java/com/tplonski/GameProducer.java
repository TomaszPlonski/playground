package com.tplonski;

import java.util.Properties;
import java.util.concurrent.*;

import com.google.gson.Gson;
import com.tplonski.model.Game;
import com.tplonski.business.GameGenerator;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
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
        String key = new Gson().toJson(game.getPlayers());
        String value = new Gson().toJson(game.getChoices());
        System.out.println(key);

        ProducerRecord<String, String> data = new ProducerRecord<>(TOPIC, key, value);
        try {
            RecordMetadata meta = producer.send(data).get();
            LOG.info("key = {}, value = {}", data.key(), data.value());
        } catch (InterruptedException | ExecutionException e) {
            producer.flush();
        }

    }
}
