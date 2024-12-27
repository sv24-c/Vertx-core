package vertx.core.filesystem;

import io.vertx.core.Vertx;
import io.vertx.core.file.OpenOptions;

public class AsyncFileOpenOptions
{
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        OpenOptions options = new OpenOptions();

        options.setRead(true);
        options.setCreate(true);
        options.setWrite(true);


        vertx.fileSystem().open("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile.txt", options, asyncFileAsyncResult -> {
           if (asyncFileAsyncResult.succeeded())
           {
               System.out.println("asyncfile openoptions applied success");
               System.out.println(asyncFileAsyncResult.result());
           }
           else
           {
               System.out.println("asyncfile openoptions applied fail : " + asyncFileAsyncResult.cause());
           }
        });
    }
}
