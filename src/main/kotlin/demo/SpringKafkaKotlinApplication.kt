package demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka


@SpringBootApplication
@EnableKafka
@EnableConfigurationProperties(CustomConfigs::class)
class SpringKafkaKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringKafkaKotlinApplication>(*args)
}

/** To run
 *
 * export DOCKER_HOST_IP=127.0.0.1
 *
 * (its needed because spring app is running inside localhost host
 * network and Kafka and zookeeper are running inside the "docker network".)
 *
 * docker-compose up -d
 *
 * mvn spring-boot:run
 *
 * make a request
 * curl -X POST http://localhost:8080/api/message -d "yet more fun karan" -H "Content-Type: text/plain"
 *
 *
 * **/