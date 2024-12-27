package vertx.core.filesystem;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.OpenOptions;

public class AsyncFileFlushData
{
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        OpenOptions options = new OpenOptions().setWrite(true).setCreate(true);

        vertx.fileSystem().open("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile2.txt", options, asyncFileAsyncResult -> {

            if (asyncFileAsyncResult.succeeded())
            {
                AsyncFile file = asyncFileAsyncResult.result();

                file.write(Buffer.buffer("Hello Vert.x!".getBytes()))
                        .onSuccess(v -> {
                            file.flush().onComplete(flushResult -> {
                                if (flushResult.succeeded())
                                {
                                    System.out.println("data flush successfully");
                                }
                                else
                                {
                                    System.out.println("flush failed : " + flushResult.cause());
                                }

                                file.close();
                            });
                        });
            }
        });
    }
}
