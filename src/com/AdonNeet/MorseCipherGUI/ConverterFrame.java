package com.AdonNeet.MorseCipherGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class ConverterFrame implements ActionListener, CodeConverter {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private MorseCodeConverter codeConverter = new MorseCodeConverter();
    private JButton encodeButton;
    private JButton decodeButton;
    private JPanel panel;

    public ConverterFrame() {	// it's still suck tho
        // codeConverter = this;
        panel = new JPanel();

        inputTextArea = new JTextArea();
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);

        outputTextArea = new JTextArea();
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setEditable(false);

        encodeButton = new JButton("Encode");
        decodeButton = new JButton("Decode");

        encodeButton.addActionListener(this);
        decodeButton.addActionListener(this);

        panel.add(inputTextArea);
        panel.add(encodeButton);
        panel.add(decodeButton);
        panel.add(outputTextArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputText = inputTextArea.getText();
        if (e.getSource() == encodeButton) {
            String convertedCode = codeConverter.encode(inputText);
            outputTextArea.setText(convertedCode);
        } else if (e.getSource() == decodeButton) {
            String decodedText = codeConverter.decode(inputText);
            outputTextArea.setText(decodedText);
        }
    }

    @Override
    public String encode(String text) {
        // Implementation for encoding
        return "Encoded: " + text;
    }

    @Override
    public String decode(String code) {
        // Implementation for decoding
        return "Decoded: " + code;
    }

    public JPanel getPanel() {
        return panel;
    }
}