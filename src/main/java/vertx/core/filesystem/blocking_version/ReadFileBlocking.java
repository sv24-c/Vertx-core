package vertx.core.filesystem.blocking_version;

import io.vertx.core.Vertx;
import io.vertx.core.file.FileSystem;

public class ReadFileBlocking
{
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        FileSystem fileSystem = vertx.fileSystem();

        String readFileData = fileSystem.readFileBlocking("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/testfile.txt").toString();

        System.out.println(readFileData);
    }
}
