package com.powernet.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @KafkaListener(topics = "xklnbp3u-demo", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String consumerRecords) {
        System.out.println("Received a message: " + consumerRecords);
        /*Iterator<ConsumerRecord<String, String>> consumerRecordIterator = consumerRecords.iterator();

        while (consumerRecordIterator.hasNext()) {
            ConsumerRecord<String, String> consumerRecord = consumerRecordIterator.next();

            System.out.println("Partition: " + consumerRecord.partition()
                    + "\nOffset: " + consumerRecord.offset()
                    + "\nKey: " + consumerRecord.key()
                    + "\nValue: " + consumerRecord.value());
        }*/
    }
}