package vertx.core.httpserver;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.RequestOptions;

public class HttpServerTest
{
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        HttpServer httpServer = vertx.createHttpServer();

        httpServer.requestHandler(httpServerRequest ->
        {
            System.out.println("Http request is arrived from " + httpServerRequest.remoteAddress());

            System.out.println("URI : " + httpServerRequest.uri());

            System.out.println("Version : " + httpServerRequest.version());

            System.out.println("Method : " + httpServerRequest.method());

            System.out.println("Path : " + httpServerRequest.path());

            System.out.println("Query : " + httpServerRequest.query());

            System.out.println("Headers : " + httpServerRequest.headers());

            System.out.println("Authority : " + httpServerRequest.authority());

            System.out.println("Parameters : " + httpServerRequest.params());

            httpServerRequest.handler(buffer -> {
                System.out.println("buffer data : " + buffer);
            });

            httpServerRequest.response().end("Your request has been processed");

        }).listen(8080,"0.0.0.0").onComplete(httpServer1 ->
                {
                    if (httpServer1.succeeded()) {
                        System.out.println("started listening");
                    }
                    else {
                        System.out.println("listening fail");
                    }
                });

        HttpClient httpClient = vertx.createHttpClient();

        httpClient.request(new RequestOptions().setHost("0.0.0.0").setPort(8080));
    }

}