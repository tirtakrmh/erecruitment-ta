/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tirta.dao;

import com.tirta.connection.DatabaseConnection;
import com.tirta.model.ModelInformasi;
import com.tirta.model.ModelKaryawan;
import com.tirta.model.ModelPelamarLamaran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tirta Karimah
 */
public class InformasiDAO {
    private final Connection con;

    public InformasiDAO() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    public boolean insertInformasi(List<ModelPelamarLamaran> listLamaran, ModelInformasi informasi) throws SQLException {
        String sql = "INSERT INTO informasi (lamaran_id, tanggal, jam, deskripsi) " +
                     "VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        for (ModelPelamarLamaran lamaran : listLamaran) {
            stmt.setInt(1, (int)lamaran.getLamaranId());
            stmt.setDate(2, new java.sql.Date(informasi.getTanggal().getTime()));
            stmt.setTime(3, new java.sql.Time(informasi.getJam().getTime()));
            stmt.setString(4, informasi.getDeskripsi());
            stmt.addBatch();
        }
        int[] rowsInserted = stmt.executeBatch();
        return rowsInserted.length == listLamaran.size();
        
    }

}
