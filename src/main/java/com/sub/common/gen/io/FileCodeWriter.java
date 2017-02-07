package com.sub.common.gen.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * Created by yy111026 on 2017/2/7.
 */
public class FileCodeWriter implements ICodeWriter {

    public static final int LEN = 1024*1024;

    public static final int DATA_CHUNK = 1024*1024;

    @Override
    public boolean write(String code) {
        return false;
    }

    public static void writeWithFileChannel(String rootPath, String fileName, String content) throws IOException {
        String fullPath = rootPath + "/" + fileName;
        File file = new File(fullPath);
        if (file.exists()) {
            file.delete();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = raf.getChannel();

        byte[] data = content.getBytes("utf-8");
        int len = data.length;
        ByteBuffer buf = ByteBuffer.allocate(DATA_CHUNK);
        int start = 0;
        while (len >= DATA_CHUNK) {

            buf.clear(); // clear for re-write
            byte[] newData = new byte[DATA_CHUNK];
            System.arraycopy(data, start, newData, 0, DATA_CHUNK);

            data = null;

            buf.flip(); // switches a Buffer from writing mode to reading mode
            fileChannel.write(buf);
            fileChannel.force(true);

            len -= DATA_CHUNK;
            start += len;
        }

        if (len > 0) {
            System.out.println("write rest data chunk: " + len + "B");
            buf = ByteBuffer.allocateDirect((int) len);
            data = new byte[(int) len];
            for (int i = 0; i < len; i++) {
                buf.put(data[i]);
            }

            buf.flip(); // switches a Buffer from writing mode to reading mode, position to 0, limit not changed
            fileChannel.write(buf);
            fileChannel.force(true);
            data = null;
        }

        fileChannel.close();
        raf.close();
    }
}
