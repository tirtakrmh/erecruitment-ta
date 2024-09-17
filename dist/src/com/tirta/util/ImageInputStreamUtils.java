/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tirta.util;

import java.io.InputStream;

/**
 *
 * @author Tirta Karimah
 */
public class ImageInputStreamUtils {
    
    public static InputStream getImageInputStream(String imagePath) {
        InputStream inputStream = ImageInputStreamUtils.class.getResourceAsStream(imagePath);
        if (inputStream == null) {
            throw new RuntimeException("Gambar tidak ditemukan: " + imagePath);
        }
        return inputStream;
    }
}
