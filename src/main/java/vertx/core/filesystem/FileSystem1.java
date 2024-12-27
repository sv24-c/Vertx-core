package vertx.core.filesystem;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;

public class FileSystem1
{
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        FileSystem fileSystem = vertx.fileSystem();

        fileSystem.readFile("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile.txt").onComplete(asyncOperation -> {
            if (asyncOperation.succeeded())
            {
                System.out.println("file read success");
                System.out.println(asyncOperation.result());
            }
            else
            {
                System.out.println("Error in file read");
            }
        });


        fileSystem.copy("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile.txt","/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile2.txt").onComplete(asyncOpration -> {
           if (asyncOpration.succeeded())
           {
               System.out.println("file copied successfully");
               System.out.println(asyncOpration.result());
           }
           else
           {
               System.out.println("Error in copy file " + asyncOpration.cause());
           }
        });


        fileSystem.writeFile("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile2.txt", Buffer.buffer("testfile2 content")).onComplete(asyncOpration -> {
            if (asyncOpration.succeeded())
            {
                System.out.println("file write successfully");
                System.out.println(asyncOpration.result());
            }
            else
            {
                System.out.println("Error in write file " + asyncOpration.cause());
            }
        });


        fileSystem.exists("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile2.txt", booleanAsyncResult -> {
            if (booleanAsyncResult.succeeded())
            {
                System.out.println("File Exist");
            }
            else
            {
                fileSystem.copy("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile.txt","/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile2.txt").onComplete(asyncOpration -> {
                    if (asyncOpration.succeeded())
                    {
                        System.out.println("file copied successfully");
                        System.out.println(asyncOpration.result());
                    }
                    else
                    {
                        System.out.println("Error in copy file " + asyncOpration.cause());
                    }
                });
            }
        });
    }
}
