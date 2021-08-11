package com.example.springbootkafkaproducerexample.resource;

import com.example.springbootkafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    public final static String TOPIC = "Kafka_Example1";
    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name")final String name){
        //kafkaTemplate.send(TOPIC,name); for string
        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

        return "Published SuccessFully";
    }

}
