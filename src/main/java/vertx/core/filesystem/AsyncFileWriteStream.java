package vertx.core.filesystem;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.OpenOptions;

public class AsyncFileWriteStream
{
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        vertx.fileSystem().open("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile2.txt", new OpenOptions())
                .onComplete(asyncFile -> {
                    if (asyncFile.succeeded())
                    {
                        System.out.println("asyncFile open success");

                        AsyncFile file = asyncFile.result();

                        Buffer buffer = Buffer.buffer("write to buffer\r");

                        for (int index = 0; index < 5; index++) {

                            file.write(buffer, (long) buffer.length() * index).onComplete(asyncResult -> {

                                if (asyncResult.succeeded())
                                {
                                    System.out.println("asyncFile write successful");
                                }
                                else
                                {
                                    System.out.println("asyncFile write fail " + asyncResult.cause());
                                }
                            });
                        }
                    }
                    else
                    {
                        System.out.println("asyncFile open fail : " + asyncFile.cause());
                    }
                });
    }
}
