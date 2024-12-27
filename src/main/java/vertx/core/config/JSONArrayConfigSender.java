package vertx.core.config;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;

public class JSONArrayConfigSender extends AbstractVerticle
{
    @Override
    public void start() throws Exception {

        JsonArray data = new JsonArray();

        data.add("jasonarray").add(123).add(true);

        vertx.setTimer(2000, id -> {
            vertx.eventBus().send("message.send", data);
            System.out.println("Sent data: " + data.encodePrettily());
        });

        System.out.println("data sent");
        //vertx.eventBus().consumer("message.1.send", message -> System.out.println(message.body()));
    }

    @Override
    public void stop() throws Exception {

    }

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new JSONArrayConfigSender());

        vertx.deployVerticle(new JSONArrayConfigReceiver());

        //vertx.deployVerticle(JSONArrayConfig.class, new DeploymentOptions().setConfig(JsonObject.mapFrom(config)));
    }
}


