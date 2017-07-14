package com.kapman;

import javax.sound.midi.*;
import java.util.Arrays;

/**
 * Created by kapman on 14.07.17.
 */
public class Midi {
    public Midi(MidiDevice from, MidiDevice to) throws MidiUnavailableException {
        to.open();
        Receiver receiver = to.getReceiver();

        from.open();
        Transmitter transmitter = from.getTransmitter();
        transmitter.setReceiver(new Receiver() {
            @Override
            public void send(MidiMessage message, long timeStamp) {
                System.out.println(Arrays.toString(message.getMessage()));
                receiver.send(message, timeStamp);
            }

            @Override
            public void close() {

            }
        });


    }

    public static MidiDevice.Info[] getDevices() {
        return MidiSystem.getMidiDeviceInfo();
    }
}
