package vertx.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class CoreImplementation extends AbstractVerticle
{
    @Override
    public void start() throws Exception {
        System.out.println("started...");
    }

     @Override
    public void stop() throws Exception {
         System.out.println("stopped.");
    }

    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new CoreImplementation()).onComplete(stringAsyncResult ->
        {
            if (stringAsyncResult.succeeded())
            {
                System.out.println("success : " + stringAsyncResult.result());
            }
            else
            {
                System.out.println("failed");
            }

            System.out.println(vertx.deploymentIDs());

            vertx.undeploy(stringAsyncResult.result());
        });


    }
}
