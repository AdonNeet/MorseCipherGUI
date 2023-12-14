package com.AdonNeet.MorseCipherGUI;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeConverter implements CodeConverter {
	private static final Map<String, String> morseCodeMap;

    static {
        morseCodeMap = new HashMap<>();
        morseCodeMap.put("A", ".-");
        morseCodeMap.put("B", "-...");
        morseCodeMap.put("C", "-.-.");
        morseCodeMap.put("D", "-..");
        morseCodeMap.put("E", ".");
        morseCodeMap.put("F", "..-.");
        morseCodeMap.put("G", "--.");
        morseCodeMap.put("H", "....");
        morseCodeMap.put("I", "..");
        morseCodeMap.put("J", ".---");
        morseCodeMap.put("K", "-.-");
        morseCodeMap.put("L", ".-..");
        morseCodeMap.put("M", "--");
        morseCodeMap.put("N", "-.");
        morseCodeMap.put("O", "---");
        morseCodeMap.put("P", ".--.");
        morseCodeMap.put("Q", "--.-");
        morseCodeMap.put("R", ".-.");
        morseCodeMap.put("S", "...");
        morseCodeMap.put("T", "-");
        morseCodeMap.put("U", "..-");
        morseCodeMap.put("V", "...-");
        morseCodeMap.put("W", ".--");
        morseCodeMap.put("X", "-..-");
        morseCodeMap.put("Y", "-.--");
        morseCodeMap.put("Z", "--..");
        morseCodeMap.put("1", ".----");
        morseCodeMap.put("2", "..---");
        morseCodeMap.put("3", "...--");
        morseCodeMap.put("4", "....-");
        morseCodeMap.put("5", ".....");
        morseCodeMap.put("6", "-....");
        morseCodeMap.put("7", "--...");
        morseCodeMap.put("8", "---..");
        morseCodeMap.put("9", "----.");
        morseCodeMap.put("0", "-----");
    }

    @Override
    public String encode(String text) {
        StringBuilder morseCodeBuilder = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                String morseChar = morseCodeMap.get(String.valueOf(c));
                if (morseChar != null) {
                    morseCodeBuilder.append(morseChar).append(" ");
                }
            } else if (Character.isWhitespace(c)) {
                morseCodeBuilder.append(" ");
            }
        }
        return morseCodeBuilder.toString().trim();
    }

    @Override
    public String decode(String morseCode) { // masih error T_T
    	StringBuilder textBuilder = new StringBuilder();
        String[] sentences = morseCode.split("\\\\ ");
        for (String sentence : sentences) {
            String[] morseWords = sentence.split("\\s+");
            for (String morseWord : morseWords) {
                String[] morseChars = morseWord.split("\\s");
                for (String morseChar : morseChars) {
                    if (morseChar.equals(".")) {
                        textBuilder.append(" ");
                    } else {
                        for (Map.Entry<String, String> entry : morseCodeMap.entrySet()) {
                            if (entry.getValue().equals(morseChar)) {
                                textBuilder.append(entry.getKey());
                                break;
                            }
                        }
                    }
                }
                textBuilder.append(" ");
            }
            textBuilder.append(". ");
        }
        return textBuilder.toString().trim();
    }
}
