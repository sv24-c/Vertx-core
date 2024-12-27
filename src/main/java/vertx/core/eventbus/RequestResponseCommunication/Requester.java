package vertx.core.eventbus.RequestResponseCommunication;

import io.vertx.core.AbstractVerticle;

public class Requester extends AbstractVerticle
{

    @Override
    public void start() throws Exception {
        /*vertx.eventBus().request("m1.request", "Message !", messageAsyncResult -> {
            if (messageAsyncResult.succeeded())
            {
                System.out.println("s");
            }
            else
            {
                System.out.println("f");
            }
        });*/

        vertx.eventBus().request("request.address", "Hello Responder!", reply -> {
            if (reply.succeeded()) {
                System.out.println("Received response: " + reply.result().body());
            } else {
                System.err.println("Failed to get a response: " + reply.cause());
            }
        });
    }
}
