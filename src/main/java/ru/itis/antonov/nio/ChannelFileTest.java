package ru.itis.antonov.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Date;

public class ChannelFileTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        StudentChannel channel = new StudentChannel();
        channel.writeStudent(new Student("Ivan", Student.MALE, new Date(100000000)), inChannel);
        inChannel.close();
    }
}
