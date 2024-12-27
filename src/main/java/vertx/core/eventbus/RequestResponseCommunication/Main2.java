package vertx.core.eventbus.RequestResponseCommunication;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;

public class Main2
{

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new Requester());
        vertx.deployVerticle(new Responder());

        EventBus eventBus = vertx.eventBus();

        MessageConsumer<Object> m = eventBus.consumer("");

        m.completionHandler(voidAsyncResult -> {

        });
    }
}
