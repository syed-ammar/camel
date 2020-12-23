package com.sya.rabbitMq.camel;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

public class MessageSender
{

    @Autowired
    private RabbitTemplate template;

    @Produce(value = "direct:rabbitMq") /* This value should be same as parameter passed to from() in the route*/
    private ProducerTemplate producerTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World!"+ new Random().ints();
        producerTemplate.sendBody(producerTemplate.getDefaultEndpoint(),message);
        //this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
