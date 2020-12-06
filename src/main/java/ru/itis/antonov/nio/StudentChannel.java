package ru.itis.antonov.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.Date;

public class StudentChannel{

    private StudentSerialisator serialisator;

    public StudentChannel(){
        serialisator = new StudentSerialisator();
    }

    public void writeStudent(Student student, GatheringByteChannel channel) throws IOException {
        StudentSerialisator serialisator = new StudentSerialisator();
        channel.write(serialisator.serialize(student));
    }

    public Student readStudent(ScatteringByteChannel channel) throws IOException {
        ByteBuffer in = ByteBuffer.allocate(4);
        channel.read(in);
        in.flip();
        int length = in.getInt();
        System.out.println(length);
        in = ByteBuffer.allocate(length);
        in.putInt(length);
        channel.read(in);
        in.flip();
        return serialisator.deserialize(in);
    }

}
