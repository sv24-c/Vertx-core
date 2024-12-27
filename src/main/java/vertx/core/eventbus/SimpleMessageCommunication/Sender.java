package vertx.core.eventbus.SimpleMessageCommunication;

import io.vertx.core.AbstractVerticle;

import java.util.HashMap;

public class Sender extends AbstractVerticle
{
    @Override
    public void start() throws Exception {
        //vertx.eventBus().send("message.address", "message");

        HashMap<String,Object> map = new HashMap<>();
        map.put("1","one");

        vertx.setPeriodic(1000, id -> {
            vertx.eventBus().send("message.address", "Hello from SenderVerticle!");
        });

        vertx.setPeriodic(3000, id -> {
            vertx.eventBus().send("message.address", map);
        });

    }
}
