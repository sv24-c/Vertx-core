package vertx.core.filesystem.blocking_version;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;

public class WrittingFileBlocking
{
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        FileSystem fileSystem = vertx.fileSystem();

        boolean isFileExists = fileSystem.existsBlocking("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/blocking_version");

        if (isFileExists)
        {
            fileSystem.writeFileBlocking("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/blocking_version/output.txt", Buffer.buffer("Hello this is blocking write operation"));

            System.out.println("blocking write operation on file is done");
        }
    }
}
