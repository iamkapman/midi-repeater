package com.kapman;

//import javax.sound.midi.*;
import java.util.Arrays;

/**
 * Created by kapman on 25.06.17.
 */
public class Main {

    public Main() {
        System.out.println(Arrays.toString(Midi.getDevices()));
        Settings settFrame = new Settings(Midi.getDevices());

//        MidiDevice device = MidiSystem.getMidiDevice(informations[2]);
//        device.open();
//
//        Receiver receiver = device.getReceiver();
//        receiver.send(new ShortMessage(ShortMessage.NOTE_ON, 1, 1, 1), 500);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
