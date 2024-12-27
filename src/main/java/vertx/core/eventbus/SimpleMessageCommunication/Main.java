package vertx.core.eventbus.SimpleMessageCommunication;

import io.vertx.core.Vertx;

public class Main
{
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new Sender());
        vertx.deployVerticle(new Receiver());
    }
}
