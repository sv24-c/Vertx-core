package vertx.core.filesystem;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.OpenOptions;

public class AsyncFileReadStreamWriteStream
{
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        OpenOptions options = new OpenOptions().setRead(true).setWrite(true).setCreate(true);

        vertx.fileSystem().open("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile2.txt",options,asyncFileAsyncResult -> {

            if (asyncFileAsyncResult.succeeded())
            {
                AsyncFile file = asyncFileAsyncResult.result();

                file.write(Buffer.buffer("Hello this is writeStream data".getBytes())).onSuccess(result ->
                    System.out.println("data written in writeStream successfully"));

                file.handler(buffer -> {
                    System.out.println("data in readStream : " + buffer.toString());
                });

                file.endHandler(v -> System.out.println("readStream end"));
                file.close();
            }
        });
    }
}
