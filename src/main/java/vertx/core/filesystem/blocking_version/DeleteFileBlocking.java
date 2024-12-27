package vertx.core.filesystem.blocking_version;

import io.vertx.core.Vertx;
import io.vertx.core.file.FileSystem;

public class DeleteFileBlocking
{
    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        FileSystem fileSystem = vertx.fileSystem();

        String deleteFileData = fileSystem.deleteBlocking("/home/smit/project/Vertx Webapp/src/main/java/vertx/core/filesystem/blocking_version/output.txt").toString();

        System.out.println("this file is deleted successfully : " + deleteFileData);
    }
}
