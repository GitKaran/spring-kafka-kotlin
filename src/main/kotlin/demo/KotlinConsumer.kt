package demo

import org.springframework.stereotype.Component
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener

@Component
class KotlinConsumer {
    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["simple-message-topic"], groupId = "simple-kotlin-consumer", autoStartup = "\${custom-configs.auto-start:true}")
    fun processMessage(message: String) {
        logger.info("got message: {}", message)
    }

}