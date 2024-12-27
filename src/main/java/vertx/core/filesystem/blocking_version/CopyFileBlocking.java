package vertx.core.filesystem.blocking_version;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;

public class CopyFileBlocking
{
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        FileSystem fileSystem = vertx.fileSystem();

        boolean isFileExists = fileSystem.existsBlocking("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/blocking_version/output.txt");

        if (!isFileExists)
        {
            System.out.println("file is not exists so creating file first");

            fileSystem.writeFileBlocking("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/blocking_version/output.txt", Buffer.buffer("Hello this is blocking write operation"));
        }

        fileSystem.copyBlocking("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/blocking_version/output.txt", "/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/blocking_version/output_copied.txt");

        System.out.println("copy blocking is done");
    }
}
