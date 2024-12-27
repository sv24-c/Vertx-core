package vertx.core.eventbus.RequestResponseCommunication;

import io.vertx.core.AbstractVerticle;

public class Responder extends AbstractVerticle
{
    @Override
    public void start() throws Exception {

        vertx.eventBus().consumer("request.address", message -> {
            if (message.isSend())
            {
                System.out.println("Request Sent : success");
                message.reply("message sent from my side");
            }
        });
    }
}




