package com.sub.gen.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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

        byte[] data = content.getBytes("UTF-8");
        byte[] chunkData = null;
        int len = data.length;
        ByteBuffer buf = ByteBuffer.allocate(DATA_CHUNK);
        int start = 0;
        while (len >= DATA_CHUNK) {

            buf.clear(); // clear for re-write
            chunkData = new byte[DATA_CHUNK];
            System.arraycopy(data, start, chunkData, 0, DATA_CHUNK);
            buf.put(chunkData);
            buf.flip(); // switches a Buffer from writing mode to reading mode
            fileChannel.write(buf);
            fileChannel.force(true);

            len -= DATA_CHUNK;
            start += DATA_CHUNK;
        }

        if (len > 0) {
            buf = ByteBuffer.allocateDirect(len);

            chunkData = new byte[len];
            System.arraycopy(data, start, chunkData, 0, len);
            buf.put(data);

            buf.flip(); // switches a Buffer from writing mode to reading mode, position to 0, limit not changed
            fileChannel.write(buf);
            fileChannel.force(true);
        }

        fileChannel.close();
        raf.close();
    }
}
