package com.kapman;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kapman on 10.07.17.
 */
public class Settings extends JFrame {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JPanel rootPanel;
    private JButton startButton;

    public Settings(MidiDevice.Info[] list) {
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        comboBox1.removeAllItems();
        for (int i = 0; i < list.length; i++) {
            String type = list[i].getClass().getSimpleName();
            if (type.equals("MidiInDeviceInfo")) {
                comboBox1.addItem(new ComboItem(i, list[i].getName()));
            } else if (type.equals("MidiOutDeviceInfo")) {
                comboBox2.addItem(new ComboItem(i, list[i].getName()));
            }
        }

        pack();
        setVisible(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Midi(
                            MidiSystem.getMidiDevice(list[((ComboItem)comboBox1.getSelectedItem()).getKey()]),
                            MidiSystem.getMidiDevice(list[((ComboItem)comboBox2.getSelectedItem()).getKey()])
                    );
                } catch (MidiUnavailableException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
