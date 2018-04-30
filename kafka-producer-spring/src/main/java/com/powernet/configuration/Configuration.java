package com.powernet.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;

@SpringBootConfiguration
public class Configuration {
    /*@Value("${kafka.bootstrap.servers}")
    private String bootstrapServers;

    @Value("${kafka.username}")
    private String username;

    @Value("${kafka.password}")
    private String password;

    public Map<String, Object> producerConfigs() {
        String jaasTemplate = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";";
        String jaasCfg = String.format(jaasTemplate, username, password);

        Map<String, Object> properties = new HashMap<>();

        properties.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        properties.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ACKS_CONFIG, "1");
        properties.put(RETRIES_CONFIG, "3");
        properties.put("security.protocol", "SASL_SSL");
        properties.put("sasl.mechanism", "SCRAM-SHA-256");
        properties.put("sasl.jaas.config", jaasCfg);

        return properties;
    }

    public ProducerFactory<Integer, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate kafkaTemplate() {
        return new KafkaTemplate(producerFactory());
    }*/
}
