/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tirta.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Tirta Karimah
 */
public class DateUtils {
    
    public static String getFormattedCurrentDate() {
        // Membuat objek Date untuk mendapatkan tanggal saat ini
        Date currentDate = new Date();
        
        // Membuat objek SimpleDateFormat dengan pola format yang diinginkan dan lokal Indonesia
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy", new Locale("id"));
        
        // Mengembalikan tanggal yang diformat sebagai String
        return "Jakarta, " + dateFormat.format(currentDate);
    }
}
