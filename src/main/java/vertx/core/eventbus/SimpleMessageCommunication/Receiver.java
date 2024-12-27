package vertx.core.eventbus.SimpleMessageCommunication;

import io.vertx.core.AbstractVerticle;

public class Receiver extends AbstractVerticle
{
    @Override
    public void start() throws Exception {
        /*vertx.eventBus().consumer("mesender.send", message -> {
            System.out.println("body : " + message.body());
        });*/

        vertx.eventBus().consumer("message.address", message -> {
            System.out.println("Received message 1: " + message.body());
        });

        vertx.eventBus().consumer("message.address", message -> {
            System.out.println("Received message 2: " + message.body());
        });

        vertx.eventBus().consumer("message.address", message -> {
            System.out.println("Received message 3: " + message.body());
        });
    }
}
