package com.tirta.dao;

import com.tirta.connection.DatabaseConnection;
import com.tirta.model.ModelLamaran;
import com.tirta.model.ModelLamaranPelamar;
import com.tirta.model.ModelPelamarLamaran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class LamaranDAO {
    private final Connection con;

    // Constructor
    public LamaranDAO() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    public List<ModelLamaranPelamar> getListLamaranByPelamarID(String likePosisi, int pelamarID) throws SQLException {
        List<ModelLamaranPelamar> lamaranPelamars = new ArrayList<>();
        String sql = "SELECT \n" +
                    "    lm.id, \n" +
                    "    lw.perusahaan AS perusahaan, \n" +
                    "    lw.posisi AS posisi, \n" +
                    "    lw.kualifikasi AS kualifikasi, \n" +
                    "    lm.status AS status, \n" +
                    "    lm.created_at,\n" +
                    "    i.tanggal AS tanggal_informasi,\n" +
                    "    i.jam AS jam_informasi,\n" +
                    "    i.deskripsi AS deskripsi_informasi\n" +
                    "FROM \n" +
                    "    lamaran lm\n" +
                    "JOIN \n" +
                    "    lowongan lw ON lm.lowongan_id = lw.id\n" +
                    "JOIN \n" +
                    "    pelamar p ON lm.pelamar_id = p.id\n" +
                    "LEFT JOIN \n" +
                    "    (SELECT \n" +
                    "        lamaran_id, \n" +
                    "        tanggal, \n" +
                    "        jam, \n" +
                    "        deskripsi, \n" +
                    "        created_at \n" +
                    "     FROM \n" +
                    "        informasi \n" +
                    "     WHERE \n" +
                    "        (lamaran_id, created_at) IN (\n" +
                    "            SELECT \n" +
                    "                lamaran_id, \n" +
                    "                MAX(created_at) \n" +
                    "            FROM \n" +
                    "                informasi \n" +
                    "            GROUP BY \n" +
                    "                lamaran_id\n" +
                    "        )\n" +
                    "    ) i ON lm.id = i.lamaran_id\n" +
                    "WHERE \n" +
                    "    lw.posisi LIKE ? \n" +
                    "    AND lm.deleted_at IS NULL \n" +
                    "    AND p.id = ?\n" +
                    "ORDER BY \n" +
                    "    lm.created_at DESC";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%" + likePosisi + "%");
        stmt.setInt(2, pelamarID);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            ModelLamaranPelamar lamaranPelamar = new ModelLamaranPelamar();
            lamaranPelamar.setId(rs.getLong("id"));
            lamaranPelamar.setPerusahaan(rs.getString("perusahaan"));
            lamaranPelamar.setPosisi(rs.getString("posisi"));
            lamaranPelamar.setStatus(rs.getString("status"));
            lamaranPelamar.setCreatedAt(rs.getDate("created_at"));
            lamaranPelamar.setTanggalInformasi(rs.getDate("tanggal_informasi"));
            lamaranPelamar.setJamInformasi(rs.getString("jam_informasi"));
            lamaranPelamar.setDeskripsiInformasi(rs.getString("deskripsi_informasi"));
            lamaranPelamar.setKualifikasi(rs.getString("kualifikasi"));
            lamaranPelamars.add(lamaranPelamar);
        }

        return lamaranPelamars;
    }
    
    public ModelLamaranPelamar getLamaranByPelamarIDANDLowonganID(int pelamarID, int lowonganID) throws SQLException {
        ModelLamaranPelamar lamaranPelamar = new ModelLamaranPelamar();
        String sql = "SELECT \n" +
                    "	lm.id, \n" +
                    "	lw.perusahaan AS perusahaan, \n" +
                    "	lw.posisi AS posisi, \n" +
                    "	lw.kualifikasi as kualifikasi,\n" +
                    "	lm.status AS status, \n" +
                    "	lm.created_at,\n" +
                    "	i.tanggal AS tanggal_informasi,\n" +
                    "	i.jam AS jam_informasi,\n" +
                    "	i.deskripsi AS deskripsi_informasi\n" +
                    "FROM \n" +
                    "	lamaran lm\n" +
                    "JOIN \n" +
                    "	lowongan lw ON lm.lowongan_id = lw.id\n" +
                    "JOIN \n" +
                    "	pelamar p ON lm.pelamar_id = p.id\n" +
                    "LEFT JOIN \n" +
                    "	informasi i ON lm.id = i.lamaran_id\n" +
                    "WHERE \n" +
                    "	lm.deleted_at IS NULL \n" +
                    "	AND p.id = ? \n" +
                    "	AND lw.id = ? \n" +
                    "LIMIT 1;";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, pelamarID);
        stmt.setInt(2, lowonganID);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            lamaranPelamar.setId(rs.getLong("id"));
            lamaranPelamar.setPerusahaan(rs.getString("perusahaan"));
            lamaranPelamar.setPosisi(rs.getString("posisi"));
            lamaranPelamar.setStatus(rs.getString("status"));
            lamaranPelamar.setCreatedAt(rs.getDate("created_at"));
            lamaranPelamar.setTanggalInformasi(rs.getDate("tanggal_informasi"));
            lamaranPelamar.setJamInformasi(rs.getString("jam_informasi"));
            lamaranPelamar.setDeskripsiInformasi(rs.getString("deskripsi_informasi"));
            lamaranPelamar.setKualifikasi(rs.getString("kualifikasi"));
        }

        return lamaranPelamar;
    }


    public void insertLamaran(ModelLamaran lamaran) throws SQLException {
        String sql = "INSERT INTO lamaran (pelamar_id, lowongan_id, status) VALUES (?, ?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, lamaran.getPelamarId());
        stmt.setInt(2, lamaran.getLowonganId());
        stmt.setString(3, lamaran.getStatus());
        stmt.executeUpdate();
    }

    public void updateLamaran(ModelLamaran lamaran) throws SQLException {
        String sql = "UPDATE lamaran SET status = ? WHERE id = ? and pelamar_id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, lamaran.getStatus());
        stmt.setLong(2, lamaran.getId());
        stmt.setLong(3, lamaran.getPelamarId());
        stmt.executeUpdate();
    }

    public void deleteLamaran(long id) throws SQLException {
        String sql = "DELETE FROM lamaran WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.executeUpdate();
    }
    
    public List<ModelPelamarLamaran> getListPelamarByLowonganID(String likeStatus, int lowonganID) throws SQLException {
        List<ModelPelamarLamaran> pelamarList = new ArrayList<>();
        String sql = "SELECT lm.id AS lamaran_id, p.id AS pelamar_id, p.nama AS pelamar_nama, p.email AS pelamar_email, " +
                     "p.no_telepon AS pelamar_no_telepon, p.tentang_diri AS pelamar_tentang_diri, " +
                     "p.pengalaman AS pelamar_pengalaman, p.pendidikan AS pelamar_pendidikan, p.sertifikasi AS pelamar_sertifikasi, " +
                     "lm.status, lw.perusahaan, lw.posisi, lw.kualifikasi, lm.created_at AS tanggal_melamar " +
                     "FROM lamaran lm " +
                     "JOIN pelamar p ON lm.pelamar_id = p.id " +
                     "JOIN lowongan lw ON lm.lowongan_id = lw.id " +
                     "WHERE lm.status LIKE ? AND lw.id = ? AND lm.deleted_at IS NULL " +
                     "ORDER BY lm.created_at DESC";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, "%" + likeStatus + "%");
        statement.setInt(2, lowonganID);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            ModelPelamarLamaran pelamar = new ModelPelamarLamaran(
                rs.getLong("lamaran_id"),
                rs.getLong("pelamar_id"),
                rs.getString("pelamar_nama"),
                rs.getString("pelamar_email"),
                rs.getString("pelamar_no_telepon"),
                rs.getString("pelamar_tentang_diri"),
                rs.getString("pelamar_pengalaman"),
                rs.getString("pelamar_pendidikan"),
                rs.getString("pelamar_sertifikasi"),
                rs.getString("status"),
                rs.getString("perusahaan"),
                rs.getString("posisi"),
                rs.getString("kualifikasi"),
                rs.getDate("tanggal_melamar")
            );
            pelamarList.add(pelamar);
        }
        return pelamarList;
    }

}
