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
import com.tirta.model.ModelPelamar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PelamarDAO {
    private final Connection con;

    public PelamarDAO() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    private static final String SELECT_PELAMAR_BY_USER_ID = "SELECT * FROM pelamar WHERE user_id = ?";
    private static final String UPDATE_PELAMAR = "UPDATE pelamar SET nama = ?, email = ?, no_telepon = ?, alamat = ?, tanggal_lahir = ?, user_id = ?, updated_at = CURRENT_DATE(), deleted_at = ?, tentang_diri = ?, pengalaman = ?, pendidikan = ?, sertifikasi = ? WHERE user_id = ?";

    public ModelPelamar selectPelamar(int userID) throws SQLException{
        ModelPelamar pelamar = null;

        Connection connection = con;
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PELAMAR_BY_USER_ID);
        preparedStatement.setLong(1, userID);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            pelamar = new ModelPelamar();
            pelamar.setId(rs.getLong("id"));
            pelamar.setNama(rs.getString("nama"));
            pelamar.setEmail(rs.getString("email"));
            pelamar.setNoTelepon(rs.getString("no_telepon"));
            pelamar.setAlamat(rs.getString("alamat"));
            pelamar.setTanggalLahir(rs.getDate("tanggal_lahir"));
            pelamar.setUserId(rs.getInt("user_id"));
            pelamar.setCreatedAt(rs.getDate("created_at"));
            pelamar.setUpdatedAt(rs.getDate("updated_at"));
            pelamar.setDeletedAt(rs.getDate("deleted_at"));
            pelamar.setTentangDiri(rs.getString("tentang_diri"));
            pelamar.setPengalaman(rs.getString("pengalaman"));
            pelamar.setPendidikan(rs.getString("pendidikan"));
            pelamar.setSertifikasi(rs.getString("sertifikasi"));
        }
        return pelamar;
    }

    public boolean updatePelamar(ModelPelamar pelamar) throws SQLException, IllegalArgumentException {
        boolean rowUpdated = false;

        if (pelamar.getTentangDiri()== null || pelamar.getTentangDiri().isEmpty()) {
            throw new IllegalArgumentException("Tenteang diri tidak boleh kosong");
        }
        if (pelamar.getPengalaman()== null || pelamar.getPengalaman().isEmpty()) {
            throw new IllegalArgumentException("Pengalaman boleh tidak kosong");
        }
        if (pelamar.getPendidikan()== null || pelamar.getPendidikan().isEmpty()) {
            throw new IllegalArgumentException("Pendidikan Terakhir tidak boleh kosong");
        }
        if (pelamar.getSertifikasi()== null || pelamar.getPendidikan().isEmpty()) {
            throw new IllegalArgumentException("Sertifikasi tidak boleh kosong");
        }

        Connection connection = con;
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PELAMAR);
            preparedStatement.setString(1, pelamar.getNama());
            preparedStatement.setString(2, pelamar.getEmail());
            preparedStatement.setString(3, pelamar.getNoTelepon());
            preparedStatement.setString(4, pelamar.getAlamat());
            preparedStatement.setDate(5, pelamar.getTanggalLahir());
            preparedStatement.setInt(6, pelamar.getUserId());
            preparedStatement.setDate(7, pelamar.getDeletedAt());
            preparedStatement.setString(8, pelamar.getTentangDiri());
            preparedStatement.setString(9, pelamar.getPengalaman());
            preparedStatement.setString(10, pelamar.getPendidikan());
            preparedStatement.setString(11, pelamar.getSertifikasi());
            preparedStatement.setInt(12, pelamar.getUserId());

            rowUpdated = preparedStatement.executeUpdate() > 0;

        return rowUpdated;
    }
}

