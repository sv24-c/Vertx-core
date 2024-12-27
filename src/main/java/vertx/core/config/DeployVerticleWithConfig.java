package vertx.core.config;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class DeployVerticleWithConfig extends AbstractVerticle
{
    @Override
    public void start() throws Exception
    {
        try
        {
            System.out.println("diploy verticle starting...");

            JsonObject config = config();

            System.out.println(config.getString("host", "localhost"));

            System.out.println(config.getString("id","3"));
        }
        catch (Exception e)
        {
            throw new Exception(e);
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        JsonObject config = new JsonObject();

        config.put("host", "172.16.12.1").put("id","1");

        vertx.deployVerticle(new DeployVerticleWithConfig(), new DeploymentOptions().setConfig(config));
    }
}
