package vertx.core.buffer;

import io.vertx.core.buffer.Buffer;

import java.io.File;

public class BufferTest
{
    public static void main(String[] args) {

        Buffer buffer = Buffer.buffer();

        buffer.setUnsignedByte(12, (byte) 200);

        byte bytes = (byte) buffer.getUnsignedByte(12);

        System.out.println(bytes);

        System.out.println(buffer.getUnsignedByte(12));

        System.out.println(System.getProperty("user.dir"));

        File file = new File(System.getProperty("user.dir"));

        System.out.println(file.getParent());
    }
}
