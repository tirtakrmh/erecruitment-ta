/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tirta.util;

/**
 *
 * @author Tirta Karimah
 */
import java.awt.FontMetrics;
import java.util.StringTokenizer;

public class TextUtils {

//    public static String formatKualifikasi(String kualifikasi, int maxWidth, FontMetrics metrics) {
//        if (kualifikasi.length() > 20) {
//            int charWidth = metrics.charWidth('A'); // Get the width of character 'A'
//            int maxCharsPerLine = maxWidth / charWidth; // Calculate maximum characters per line
//
//            StringTokenizer tokenizer = new StringTokenizer(kualifikasi, " ");
//            StringBuilder formattedKualifikasi = new StringBuilder();
//            int currentLineLength = 0;
//
//            while (tokenizer.hasMoreTokens()) {
//                String word = tokenizer.nextToken();
//                int wordLength = word.length();
//
//                if (currentLineLength + wordLength > maxCharsPerLine) {
//                    formattedKualifikasi.append("\n");
//                    currentLineLength = 0;
//                }
//
//                formattedKualifikasi.append(word).append(" ");
//                currentLineLength += wordLength + 1;
//            }
//
//            return formattedKualifikasi.toString().trim(); // Trim to remove trailing whitespace
//        } else {
//            return kualifikasi;
//        }
//    }
    
   public static String formatTextAreaString(String data, int maxWidth, FontMetrics metrics) {
        if (data == null || data.isEmpty()) {
            return ""; // Return an empty string if data is null or empty
        }

        StringBuilder formattedKualifikasi = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(data, " ");
        int currentLineLength = 0;

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            int wordWidth = metrics.stringWidth(word);

            if (currentLineLength + wordWidth > maxWidth) {
                formattedKualifikasi.append("\n");
                currentLineLength = 0;
            }

            formattedKualifikasi.append(word).append(" ");
            currentLineLength += wordWidth + metrics.charWidth(' ');
        }

        return formattedKualifikasi.toString().trim();
    }

}

