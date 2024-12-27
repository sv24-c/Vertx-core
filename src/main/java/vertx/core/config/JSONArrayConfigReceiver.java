package vertx.core.config;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonArray;

public class JSONArrayConfigReceiver extends AbstractVerticle
{

    @Override
    public void start() throws Exception {

        vertx.eventBus().consumer("message.send", message -> {
            JsonArray receivedData = (JsonArray) message.body();
            System.out.println("Received data: " + receivedData.encodePrettily());
        });
    }
}
