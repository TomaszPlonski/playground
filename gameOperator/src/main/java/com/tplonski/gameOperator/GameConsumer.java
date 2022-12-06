package com.tplonski.gameOperator;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.logging.LogManager;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

@Slf4j
public class GameConsumer {


//    private static final Logger LOG = LoggerFactory.getLogger(GameConsumer.class);

    private static final String BOOTSTRAP_SERVERS = ":9092";
    private static final String CONSUMER_GROUP = "first";
    private static final String OFFSET_RESET = "earliest";
//	private static final String OFFSET_RESET = "latest"; // default


    @SuppressWarnings("boxing")
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, CONSUMER_GROUP);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OFFSET_RESET);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1000);


        try (KafkaConsumer<String, Integer> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(Collections.singleton(args[0]));
            while (true) {

                ConsumerRecords<String, Integer> records = consumer.poll(Duration.ofSeconds(2));

                for (ConsumerRecord<String, Integer> data : records) {
                    log.info("key = {}, value = {} => partition = {}, offset= {}", data.key(), data.value(), data.partition(), data.offset());
                }
            }
        } catch (Exception e) {
            log.error("Something goes wrong: {}", e.getMessage(), e);
        }
    }
}

