package ru.itis.antonov.nio;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class StudentSerialisator {

    public static final int MAX_LENGTH = 100000;

    public ByteBuffer serialize(Student s){
        int length = s.getName().getBytes(StandardCharsets.UTF_16).length + 4 + 8 + 4;
        if(length > MAX_LENGTH){
            throw new IllegalArgumentException();
        }
        ByteBuffer buf = ByteBuffer.allocate(length);
        buf.putInt(length)
                .putInt(s.getSex())
                .putLong(s.getBirthDate().getTime())
                .put(s.getName().getBytes(StandardCharsets.UTF_16));
        buf.flip();
        return buf;
    }

    public Student deserialize(ByteBuffer b){
        int length = b.getInt() - 16;
        int sex = b.getInt();
        Date birthDate = new Date(b.getLong());
        byte[] nameBytes = new byte[length];
        b.get(nameBytes,0,  length);
        String name = new String(nameBytes, StandardCharsets.UTF_16);
        return new Student(name, sex, birthDate);
    }
}
