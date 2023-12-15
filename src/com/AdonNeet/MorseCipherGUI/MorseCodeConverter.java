package com.AdonNeet.MorseCipherGUI;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeConverter implements CodeConverter {
	private static final Map<String, String> morseCodeMap;

    static {
        morseCodeMap = new HashMap<>(); // international morse code
        morseCodeMap.put("A", ".-");	// each word separated by a backslash
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
        
        boolean midDot = false; // untuk mengecek jika di tengah ada titik
        for (char c : text.toUpperCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                String morseChar = morseCodeMap.get(String.valueOf(c));
                if (morseChar != null) {
                    morseCodeBuilder.append(morseChar).append(" ");
                }
            } else if (Character.isWhitespace(c)) {
            	if(midDot == true) {
            		morseCodeBuilder.append(" ");
            		midDot = false;
            	} else {
            		morseCodeBuilder.append("\\ ");
            	}
            } else if(c == '.') {
            	morseCodeBuilder.append("\\\\");
            	midDot = true;
            }
        }
        return morseCodeBuilder.toString().trim();
    }

    @Override
    public String decode(String morseCode) { 
    	StringBuilder textBuilder = new StringBuilder();
        String[] morseChars = morseCode.split(" ");  // pemisah antar char

        for(String morseChar : morseChars) {
        	if(morseChar.equals("\\")) {	// mendeteksi pergantian kata
        		textBuilder.append(" ");
        	} else if(morseChar.equals("\\\\")) {	// mendeteksi tanda titik, pergantian kalimat
        		textBuilder.append(". ");
        	} else {
        		for(Map.Entry<String, String> entry : morseCodeMap.entrySet()) {
        			if(entry.getValue().equals(morseChar)) {
        				textBuilder.append(entry.getKey());
        				break;
        			}
        		}
        	}
        }
        return textBuilder.toString().trim();
    }
}
