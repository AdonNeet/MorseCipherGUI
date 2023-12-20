package com.AdonNeet.MorseCipherGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

class ConverterFrame implements ActionListener{
	private JLabel inLabel, outLabel;
    private JTextArea inputTextArea, outputTextArea;
    private MorseCodeConverter codeConverter = new MorseCodeConverter();
    private JButton encodeButton, decodeButton;
    private JPanel panel, panel11, panel12, panel13;
    private GridBagConstraints gbc;
    private JScrollPane inputArea, outputArea;

    public ConverterFrame() {	// it's still suck tho, but yeah, let make it more better
    	UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 20));
        UIManager.put("Button.font", new Font("Helvetica", Font.PLAIN, 20));
        UIManager.put("TextArea.font", new Font("Helvetica", Font.PLAIN, 16));
    	
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(3, 1));
        
        panel11 = new JPanel(new BorderLayout());
        panel12 = new JPanel(new GridBagLayout());
        panel13 = new JPanel(new BorderLayout());
        
        inLabel = new JLabel("  Input");
        inputTextArea = new JTextArea();
        inputTextArea.setSize(new Dimension(370, 150));
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);
        inputArea = new JScrollPane(inputTextArea);

        outLabel = new JLabel("  Output");
        outputTextArea = new JTextArea();
        outputTextArea.setSize(new Dimension(370, 150));
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setEditable(false);
        outputArea = new JScrollPane(outputTextArea);

        
        encodeButton = new JButton("Encode");
        encodeButton.setSize(new Dimension(150, 100));
        decodeButton = new JButton("Decode");
        decodeButton.setSize(new Dimension(150, 100));

        encodeButton.addActionListener(this);
        decodeButton.addActionListener(this);
        
        panel11.add(inLabel, BorderLayout.WEST);
        panel11.add(inputArea, BorderLayout.EAST);
       
        panel12.add(new JLabel("              "));
        panel12.add(encodeButton, gbc);
        panel12.add(new JLabel("              "));
        panel12.add(decodeButton, gbc);
        
        panel13.add(outLabel, BorderLayout.WEST);
        panel13.add(outputArea, BorderLayout.EAST);
        
        panel.add(panel11, BorderLayout.CENTER);
        panel.add(panel12, BorderLayout.CENTER);
        panel.add(panel13, BorderLayout.CENTER);
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

    public JPanel getPanel() {
        return panel;
    }
}