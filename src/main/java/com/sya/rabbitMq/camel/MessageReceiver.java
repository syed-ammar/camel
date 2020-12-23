package com.sya.rabbitMq.camel;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello", containerFactory = "prefetchRabbitListenerContainerFactory")
public class MessageReceiver
{
    @RabbitHandler
    public void receive(byte[] message) {
        System.out.println(" [x] Received '" + message + "'");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
