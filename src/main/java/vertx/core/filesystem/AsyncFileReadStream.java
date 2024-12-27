package vertx.core.filesystem;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.OpenOptions;

public class AsyncFileReadStream
{
    public static void main(String[] args) {


        /*
        * file contents is as below:
        * 1write to buffer
          2write to buffer
          3write to buffer
          4write to buffer
          5write to buffer
        * */
        Vertx vertx = Vertx.vertx();

        vertx.fileSystem().open("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile2.txt", new OpenOptions())
                .onComplete(asyncFile -> {
                   if (asyncFile.succeeded())
                   {
                       System.out.println("asyncFile open success");

                       AsyncFile file = asyncFile.result();

                       Buffer buffer = Buffer.buffer();

                       for (int i = 0; i < 5; i++) {

                           file.read(buffer, i*10, i, 9)
                                   .onComplete(bufferAsyncResult -> {
                                       if (bufferAsyncResult.succeeded())
                                       {
                                           //System.out.println("asyncFile read success");
                                           System.out.println(bufferAsyncResult.result());
                                       }
                                       else
                                       {
                                           System.out.println("asyncFile read fail : " + bufferAsyncResult.cause());
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
