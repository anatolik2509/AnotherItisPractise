package ru.itis.antonov.nio;

import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public interface IOChannel extends ScatteringByteChannel, GatheringByteChannel {
}
