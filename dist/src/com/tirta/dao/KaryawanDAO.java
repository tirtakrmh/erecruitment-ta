/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tirta.dao;

import com.tirta.connection.DatabaseConnection;
import com.tirta.model.ModelKaryawan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tirta Karimah
 */
public class KaryawanDAO {
    private final Connection con;

    public KaryawanDAO() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    private static final String SELECT_KARYAWAN_BY_USER_ID = "SELECT * FROM karyawan WHERE user_id = ?";

    public ModelKaryawan selectKaryawan(int userID) throws SQLException{
        ModelKaryawan karyawan = null;

        Connection connection = con;
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_KARYAWAN_BY_USER_ID);
        preparedStatement.setLong(1, userID);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            karyawan = new ModelKaryawan();
            karyawan.setId(rs.getLong("id"));
            karyawan.setRole(rs.getString("role"));
            karyawan.setNama(rs.getString("nama"));
            karyawan.setEmail(rs.getString("email"));
            karyawan.setNoTelepon(rs.getString("no_telepon"));
            karyawan.setDepartemen(rs.getString("departemen"));
            karyawan.setUserId(rs.getInt("user_id"));
            karyawan.setCreatedAt(rs.getDate("created_at"));
            karyawan.setUpdatedAt(rs.getDate("updated_at"));
            karyawan.setDeletedAt(rs.getDate("deleted_at"));
        }
        return karyawan;
    }
    
    public List<ModelKaryawan> getListKaryawan(String likeDepartemen) throws SQLException {
        List<ModelKaryawan> karyawanList = new ArrayList<>();

        String sql = "SELECT id, role, nama, email, no_telepon, departemen, user_id, created_at, updated_at, deleted_at " +
                     "FROM karyawan " +
                     "WHERE departemen LIKE ? AND deleted_at IS NULL";

        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setString(1, "%" + likeDepartemen + "%");

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            ModelKaryawan karyawan = new ModelKaryawan();
            karyawan.setId(rs.getLong("id"));
            karyawan.setRole(rs.getString("role"));
            karyawan.setNama(rs.getString("nama"));
            karyawan.setEmail(rs.getString("email"));
            karyawan.setNoTelepon(rs.getString("no_telepon"));
            karyawan.setDepartemen(rs.getString("departemen"));
            karyawan.setUserId(rs.getInt("user_id"));
            karyawan.setCreatedAt(rs.getDate("created_at"));
            karyawan.setUpdatedAt(rs.getDate("updated_at"));
            karyawan.setDeletedAt(rs.getDate("deleted_at"));

            karyawanList.add(karyawan);
        }

        return karyawanList;
    }
    
   public boolean insertKaryawan(ModelKaryawan karyawan) throws SQLException {
        // Step 1: Insert into the user table
        String userSql = "INSERT INTO user (email, password) VALUES (?, ?)";
        PreparedStatement userStatement = con.prepareStatement(userSql, Statement.RETURN_GENERATED_KEYS);
        userStatement.setString(1, karyawan.getEmail());
        userStatement.setString(2, karyawan.getPassword());

        int userRowsInserted = userStatement.executeUpdate();

        // Retrieve the generated user_id
        ResultSet generatedKeys = userStatement.getGeneratedKeys();
        int userId = -1;
        if (generatedKeys.next()) {
            userId = generatedKeys.getInt(1); // Assuming the ID is the first column
        }

        // Check if the user insertion was successful and userId was retrieved
        if (userRowsInserted > 0 && userId != -1) {
            // Step 2: Insert into the karyawan table
            String karyawanSql = "INSERT INTO karyawan (nama, email, no_telepon, departemen, role, user_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement karyawanStatement = con.prepareStatement(karyawanSql);
            karyawanStatement.setString(1, karyawan.getNama());
            karyawanStatement.setString(2, karyawan.getEmail());
            karyawanStatement.setString(3, karyawan.getNoTelepon());
            karyawanStatement.setString(4, karyawan.getDepartemen());
            karyawanStatement.setString(5, karyawan.getRole());
            karyawanStatement.setInt(6, userId); // Use the retrieved user_id

            int karyawanRowsInserted = karyawanStatement.executeUpdate();
            return karyawanRowsInserted > 0;
        }

        return false;
    }

    
    public boolean updateKaryawan(ModelKaryawan karyawan) throws SQLException {
        String sql = "UPDATE karyawan SET nama = ?, email = ?, no_telepon = ?, departemen = ?, role = ? WHERE id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, karyawan.getNama());
        statement.setString(2, karyawan.getEmail());
        statement.setString(3, karyawan.getNoTelepon());
        statement.setString(4, karyawan.getDepartemen());
        statement.setString(5, karyawan.getRole());
        statement.setLong(6, karyawan.getId());

        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    }
    
    public boolean deleteKaryawan(ModelKaryawan karyawan) throws SQLException {
        String sql = "UPDATE karyawan SET deleted_at = ? WHERE id = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setTimestamp(1, new Timestamp(System.currentTimeMillis())); // Set current timestamp as deleted_at
            statement.setLong(2, karyawan.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

}
