package com.example.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.quartz.DisallowConcurrentExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.apache.kafka.common.requests.FetchMetadata.log;


@Component
@DisallowConcurrentExecution
public class MessageConsumer {
    @Autowired
    KafkaConsumer<String ,String > kafkaConsumer;


    int message =0;

    @Scheduled(fixedRate = 1) // Run every 1 seconds

    public void execute() {
        kafkaConsumer.subscribe(Collections.singletonList("my-topic"));
        ConsumerRecords<String, String> messages = kafkaConsumer.poll(Duration.ofMillis(10000));
        message += messages.count();

        log.info(  "message count :" +messages.count()+", total messages = " +String.valueOf(message));
    }

}
