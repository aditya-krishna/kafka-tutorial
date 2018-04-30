package com.powernet.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topic;

    public void sendMessage() {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, "1", "First message from spring boot");

        kafkaTemplate.send(producerRecord);
    }
}
