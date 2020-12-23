package com.sya.rabbitMq.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqRoute extends RouteBuilder
{

    @Override
    public void configure() throws Exception
    {
        from("direct:rabbitMq").to("rabbitmq:localhost:5672/direct?queue=hello&durable=true&autoDelete=false").end();
    }
}
