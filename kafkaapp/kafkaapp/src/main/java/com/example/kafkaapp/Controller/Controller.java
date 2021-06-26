package com.example.kafkaapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    private static final String TOPIC = "oldtopic";

    @GetMapping("/publish/{msg}")
    public String publish(@PathVariable("msg") final String msg)
    {
    	kafkaTemplate.send(TOPIC,msg);
    	return "successfully sent to kafka client";
    }
    
   
    
}