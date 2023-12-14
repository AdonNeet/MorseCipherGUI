package com.AdonNeet.MorseCipherGUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MorseCodeApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConverterFrame converterFrame = new ConverterFrame();

                JFrame frame = new JFrame("Morse Code Converter");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(converterFrame.getPanel(), BorderLayout.CENTER);

                frame.setSize(400, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}