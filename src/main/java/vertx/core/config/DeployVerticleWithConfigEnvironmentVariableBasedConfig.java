package vertx.core.config;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class DeployVerticleWithConfigEnvironmentVariableBasedConfig extends AbstractVerticle
{
    @Override
    public void start() throws Exception {

        JsonObject config = config();

        System.out.println(config);
    }

    public static void main(String[] args)
    {
        Vertx vertx = Vertx.vertx();

        JsonObject config = new JsonObject();

        config.put("DB_URL_",System.getenv("DB_URL"));

        config.put("DB_USER", System.getenv("DB_USER"));

        vertx.deployVerticle(new DeployVerticleWithConfigEnvironmentVariableBasedConfig(), new DeploymentOptions().setConfig(config));
    }
}
