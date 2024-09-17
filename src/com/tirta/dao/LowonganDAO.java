/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tirta.dao;

/**
 *
 * @author Tirta Karimah
 */
import com.tirta.connection.DatabaseConnection;
import com.tirta.model.ModelLowongan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LowonganDAO {
    private final Connection con;

    // Constructor
    public LowonganDAO() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    // Method to get list of vacancies based on LIKE query and sorted by created_at
    public List<ModelLowongan> getListLowonganByPosisi(String likeQuery) throws SQLException {
        List<ModelLowongan> lowonganList = new ArrayList<>();
        String sql = "SELECT * FROM lowongan\n" +
                    "WHERE posisi LIKE ?\n" +
                    "AND deleted_at IS NULL\n" +
                    "AND tanggal_buka <= CURDATE()\n" +
                    "AND tanggal_tutup >= CURDATE()\n" +
                    "and status = 'OPEN'\n" +
                    "ORDER BY created_at asc;";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + likeQuery + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ModelLowongan lowongan = new ModelLowongan();
                lowongan.setId(rs.getLong("id"));
                lowongan.setPosisi(rs.getString("posisi"));
                lowongan.setPerusahaan(rs.getString("perusahaan"));
                lowongan.setKualifikasi(rs.getString("kualifikasi"));
                lowongan.setStatus(rs.getString("status"));
                lowongan.setTanggalBuka(rs.getDate("tanggal_buka"));
                lowongan.setTanggalTutup(rs.getDate("tanggal_tutup"));
                lowongan.setCreatedAt(rs.getDate("created_at"));
                lowongan.setUpdatedAt(rs.getDate("updated_at"));
                lowongan.setDeletedAt(rs.getDate("deleted_at"));

                lowonganList.add(lowongan);
            }
        }

        return lowonganList;
    }
    
    public List<ModelLowongan> getAllListLowonganByPosisi(String likeQuery) throws SQLException {
        List<ModelLowongan> lowonganList = new ArrayList<>();
        String sql = "SELECT * FROM lowongan\n" +
                    "WHERE posisi LIKE ?\n" +
                    "ORDER BY created_at asc;";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + likeQuery + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ModelLowongan lowongan = new ModelLowongan();
                lowongan.setId(rs.getLong("id"));
                lowongan.setPosisi(rs.getString("posisi"));
                lowongan.setPerusahaan(rs.getString("perusahaan"));
                lowongan.setKualifikasi(rs.getString("kualifikasi"));
                lowongan.setStatus(rs.getString("status"));
                lowongan.setTanggalBuka(rs.getDate("tanggal_buka"));
                lowongan.setTanggalTutup(rs.getDate("tanggal_tutup"));
                lowongan.setCreatedAt(rs.getDate("created_at"));
                lowongan.setUpdatedAt(rs.getDate("updated_at"));
                lowongan.setDeletedAt(rs.getDate("deleted_at"));

                lowonganList.add(lowongan);
            }
        }

        return lowonganList;
    }
    
    public boolean insertLowongan(ModelLowongan lowongan) throws SQLException, IllegalArgumentException {
        boolean rowInserted = false;
        
        // Validation checks
        if (lowongan.getPosisi() == null || lowongan.getPosisi().isEmpty()) {
            throw new IllegalArgumentException("Posisi tidak boleh kosong");
        }
        if (lowongan.getPerusahaan() == null || lowongan.getPerusahaan().isEmpty()) {
            throw new IllegalArgumentException("Perusahaan tidak boleh kosong");
        }
        if (lowongan.getKualifikasi() == null || lowongan.getKualifikasi().isEmpty()) {
            throw new IllegalArgumentException("Kualifikasi tidak boleh kosong");
        }
        if (lowongan.getStatus() == null || lowongan.getStatus().isEmpty()) {
            throw new IllegalArgumentException("Status tidak boleh kosong");
        }
        if (lowongan.getTanggalBuka() == null || lowongan.getTanggalTutup() == null) {
            throw new IllegalArgumentException("Tanggal buka dan tanggal tutup tidak boleh kosong");
        }
        
        String sql = "INSERT INTO lowongan (posisi, perusahaan, kualifikasi, status, tanggal_buka, tanggal_tutup) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, lowongan.getPosisi());
        statement.setString(2, lowongan.getPerusahaan());
        statement.setString(3, lowongan.getKualifikasi());
        statement.setString(4, lowongan.getStatus());
        statement.setDate(5, new java.sql.Date(lowongan.getTanggalBuka().getTime()));
        statement.setDate(6, new java.sql.Date(lowongan.getTanggalTutup().getTime()));

        rowInserted = statement.executeUpdate() > 0;

        return rowInserted;
    }
    
    public boolean updateLowongan(ModelLowongan lowongan) throws SQLException, IllegalArgumentException {
        boolean rowUpdated = false;

        // Validation checks
        if (lowongan.getPosisi() == null || lowongan.getPosisi().isEmpty()) {
            throw new IllegalArgumentException("Posisi tidak boleh kosong");
        }
        if (lowongan.getPerusahaan() == null || lowongan.getPerusahaan().isEmpty()) {
            throw new IllegalArgumentException("Perusahaan tidak boleh kosong");
        }
        if (lowongan.getKualifikasi() == null || lowongan.getKualifikasi().isEmpty()) {
            throw new IllegalArgumentException("Kualifikasi tidak boleh kosong");
        }
        if (lowongan.getStatus() == null || lowongan.getStatus().isEmpty()) {
            throw new IllegalArgumentException("Status tidak boleh kosong");
        }
        if (lowongan.getTanggalBuka() == null || lowongan.getTanggalTutup() == null) {
            throw new IllegalArgumentException("Tanggal buka dan tanggal tutup tidak boleh kosong");
        }

        Connection connection = con;
        PreparedStatement statement = connection.prepareStatement("UPDATE lowongan SET posisi = ?, perusahaan = ?, kualifikasi = ?, status = ?, tanggal_buka = ?, tanggal_tutup = ? WHERE id = ?");
        statement.setString(1, lowongan.getPosisi());
        statement.setString(2, lowongan.getPerusahaan());
        statement.setString(3, lowongan.getKualifikasi());
        statement.setString(4, lowongan.getStatus());
        statement.setDate(5, new java.sql.Date(lowongan.getTanggalBuka().getTime()));
        statement.setDate(6, new java.sql.Date(lowongan.getTanggalTutup().getTime()));
        statement.setLong(7, lowongan.getId());

        rowUpdated = statement.executeUpdate() > 0;

        return rowUpdated;
    }

    public ModelLowongan getByLowonganID(int lowonganID) throws SQLException {
        ModelLowongan lowongan = null;
        String sql = "SELECT * FROM lowongan WHERE id = ? AND deleted_at IS NULL LIMIT 1";
        
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, lowonganID);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            lowongan = new ModelLowongan();
            lowongan.setId(rs.getLong("id"));
            lowongan.setPosisi(rs.getString("posisi"));
            lowongan.setPerusahaan(rs.getString("perusahaan"));
            lowongan.setKualifikasi(rs.getString("kualifikasi"));
            lowongan.setStatus(rs.getString("status"));
            lowongan.setTanggalBuka(rs.getDate("tanggal_buka"));
            lowongan.setTanggalTutup(rs.getDate("tanggal_tutup"));
            lowongan.setCreatedAt(rs.getDate("created_at"));
            lowongan.setUpdatedAt(rs.getDate("updated_at"));
            lowongan.setDeletedAt(rs.getDate("deleted_at"));
        }

        return lowongan;
    }
}

