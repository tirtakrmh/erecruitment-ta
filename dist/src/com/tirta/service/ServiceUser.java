package com.tirta.service;

import com.tirta.connection.DatabaseConnection;
import com.tirta.model.ModelLogin;
import com.tirta.model.ModelUser;
import com.tirta.model.ModelUserLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceUser {

    private final Connection con;

    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    public ModelUserLogin login(ModelLogin login) throws SQLException {
        ModelUserLogin data = null;
        PreparedStatement p = con.prepareStatement(
                "SELECT * FROM user WHERE email=? AND password=? LIMIT 1"
        );
        p.setString(1, login.getEmail());
        p.setString(2, login.getPassword());
        ResultSet r = p.executeQuery();

        if (r.next()) {
            int userID = r.getInt("id");
            String email = r.getString("email");

            // Check if the user is a pelamar
            PreparedStatement pPelamar = con.prepareStatement(
                    "SELECT * FROM pelamar WHERE user_id=? LIMIT 1"
            );
            pPelamar.setInt(1, userID);
            ResultSet rPelamar = pPelamar.executeQuery();

            if (rPelamar.next()) {
                String role = "pelamar";
                String nama = rPelamar.getString("nama");
                data = new ModelUserLogin(userID, email, nama, role);
                // Set other pelamar specific data if needed
            } else {
                // Check if the user is a karyawan
                PreparedStatement pKaryawan = con.prepareStatement(
                        "SELECT * FROM karyawan WHERE user_id=? LIMIT 1"
                );
                pKaryawan.setInt(1, userID);
                ResultSet rKaryawan = pKaryawan.executeQuery();

                if (rKaryawan.next()) {
                    String role = rKaryawan.getString("role");
                    String nama = rKaryawan.getString("nama");
                    data = new ModelUserLogin(userID, email, nama, role);
                }
                rKaryawan.close();
                pKaryawan.close();
            }
            rPelamar.close();
            pPelamar.close();
        }
        r.close();
        p.close();
        return data;
    }

    public void insertUser(ModelUser user) throws SQLException {
        // Mulai transaksi
        System.out.println("MASUK KE INSERT!!");
        con.setAutoCommit(false);

        try {
            // Insert ke tabel user
            PreparedStatement p = con.prepareStatement(
                "INSERT INTO `user` (Email, `Password`) VALUES (?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );
            p.setString(1, user.getEmail());
            p.setString(2, user.getPassword());
            p.execute();

            // Ambil user_id yang baru saja dimasukkan
            ResultSet r = p.getGeneratedKeys();
            if (r.next()) {  // Menggunakan next() untuk memastikan ada baris yang dihasilkan
                int userID = r.getInt(1);
                user.setUserID(userID);
            }

            r.close();
            p.close();

            // Konversi tglLahir dari String ke java.sql.Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date utilDate = null;
            try {
                utilDate = sdf.parse(user.getTglLahir());
            } catch (ParseException ex) {
                Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  // Membuat objek java.sql.Date dari java.util.Date

            // Insert ke tabel pelamar
            p = con.prepareStatement(
                "INSERT INTO `pelamar` (nama, email, no_telepon, tanggal_lahir, user_id, alamat) VALUES (?, ?, ?, ?, ?, ?)"
            );
            p.setString(1, user.getUserName());
            p.setString(2, user.getEmail());
            p.setString(3, user.getNoTelp());
            p.setDate(4, sqlDate);  // Menggunakan objek java.sql.Date secara langsung
            p.setInt(5, user.getUserID());
            p.setString(6, user.getAlamat());
            p.execute();

            p.close();

            // Commit transaksi
            con.commit();
            System.out.println("OK!");
        } catch (SQLException e) {
            // Rollback transaksi jika terjadi kesalahan
            System.out.println("Error"+e.getMessage());
            con.rollback();
            throw e;
        } finally {
            // Kembalikan autocommit ke true
            con.setAutoCommit(true);
        }
    }



    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  //  Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = con.prepareStatement("select UserID from `user` where VerifyCode=? limit 1");
        p.setString(1, code);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

//    public boolean checkDuplicateUser(String email) throws SQLException {
//        boolean duplicate = false;
//        PreparedStatement p = con.prepareStatement("select * from `user` where email=? limit 1");
//        p.setString(1, email);
//        ResultSet r = p.executeQuery();
//        if (r.first()) {
//            duplicate = true;
//        }
//        r.close();
//        p.close();
//        return duplicate;
//    }

    public boolean checkDuplicateEmail(String email) throws SQLException {
        boolean duplicate = false;
        System.out.println("!!!!!!!!!!!!!!!!!!!!!MASUK");
        PreparedStatement p = con.prepareStatement("select email from `user` where email=? limit 1");
        p.setString(1, email);
        ResultSet r = p.executeQuery();
        if (r.next()) {  // Use next() instead of first() to move the cursor to the first row.
            duplicate = true;
            System.out.println("MASUKKK " + r.getString("email"));
        }
        r.close();
        p.close();
        return duplicate;
    }


    public void doneVerify(int userID) throws SQLException {
        PreparedStatement p = con.prepareStatement("update `user` set VerifyCode='', `Status`='Verified' where UserID=? limit 1");
        p.setInt(1, userID);
        p.execute();
        p.close();
    }

    public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
        boolean verify = false;
        PreparedStatement p = con.prepareStatement("select UserID from `user` where UserID=? and VerifyCode=? limit 1");
        p.setInt(1, userID);
        p.setString(2, code);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            verify = true;
        }
        r.close();
        p.close();
        return verify;
    }
}
