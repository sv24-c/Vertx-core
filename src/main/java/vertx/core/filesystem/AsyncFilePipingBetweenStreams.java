package vertx.core.filesystem;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.OpenOptions;

public class AsyncFilePipingBetweenStreams
{
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        OpenOptions options = new OpenOptions().setRead(true).setWrite(true).setCreate(true);

        vertx.fileSystem().open("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile.txt", options, asyncFileAsyncResult -> {

            if (asyncFileAsyncResult.succeeded())
            {
                AsyncFile sourceFile = asyncFileAsyncResult.result();

                vertx.fileSystem().open("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile2.txt", options, destRes -> {

                    AsyncFile destFile = destRes.result();

                    sourceFile.pipeTo(destFile).onComplete(result ->
                    {
                        if (result.succeeded())
                        {
                            System.out.println("File successfully piped!");
                        }
                        else {
                            System.out.println("Pipe operation failed: " + result.cause().getMessage());
                        }
                    });

                    sourceFile.close();

                    destFile.close();

                    });
            }
        });

    }
}
