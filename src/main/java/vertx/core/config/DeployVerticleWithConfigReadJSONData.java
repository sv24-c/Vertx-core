package vertx.core.config;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeployVerticleWithConfigReadJSONData extends AbstractVerticle
{

    @Override
    public void start() throws Exception {

        JsonObject config = config();

        System.out.println(config);
    }


    public static void main(String[] args) throws IOException
    {
        Vertx vertx = Vertx.vertx();

        String stringFileData = new String(Files.readAllBytes(Paths.get("/home/smit/project/Vertx Webapp/src/main/webapp/json/package.json")));

        JsonObject config = new JsonObject(stringFileData);

        vertx.deployVerticle(new DeployVerticleWithConfigReadJSONData(), new DeploymentOptions().setConfig(config));
    }
}
