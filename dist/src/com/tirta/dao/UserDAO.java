/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tirta.dao;

import com.tirta.connection.DatabaseConnection;
import com.tirta.model.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tirta Karimah
 */
public class UserDAO {
    
    private final Connection con;

    // Constructor
    public UserDAO() {
        con = DatabaseConnection.getInstance().getConnection();
    }
    
    // SQL query to update the user's password
    private static final String UPDATE_PASSWORD_SQL = "UPDATE user SET password = ? WHERE id = ?";
    // SQL query to get user by email
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = ?";

    
    // Method to change the user's password
    public boolean changePassword(int userID, String newPassword) throws SQLException {
         if (!isPasswordValid(newPassword)) {
            throw new IllegalArgumentException("Password harus 8 karakter, dan 1 angka");
        }
        boolean rowUpdated = false;
        PreparedStatement preparedStatement = con.prepareStatement(UPDATE_PASSWORD_SQL);
        preparedStatement.setString(1, newPassword);
        preparedStatement.setInt(2, userID);

        rowUpdated = preparedStatement.executeUpdate() > 0;
        return rowUpdated;
    }

    // Method to get a user by email
    public ModelUser getUserByID(int userID) throws SQLException {
        ModelUser user = new ModelUser();
        PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER_BY_ID);
        preparedStatement.setInt(1, userID);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String email = rs.getString("email");
            String password = rs.getString("password");

            user.setUserID(userID);
            user.setPassword(password);
            user.setEmail(email);
        }

        return user;
    }
    
    private boolean isPasswordValid(String password) {
        // Example criteria: at least 8 characters, contains at least one digit, one letter, and one special character
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasLetter = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLetter(c)) {
                hasLetter = true;
            }
        }

        return hasDigit && hasLetter;
    }
}
