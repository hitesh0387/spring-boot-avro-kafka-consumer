package com.hnp.example.listener;

import com.hnp.example.event.ConfigChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConfigChangeListener {

    @KafkaListener(topics = "${kafka.config.change.topic}", groupId = "${kafka.config.change.group-id}")
    public void onConfigChange(Message<ConfigChangeEvent> message) {
        log.info("Received message: {}", message.getPayload());
    }
}
