package com.tirta.model;

import java.util.Date;

public class ModelPelamarLamaran {
    private long lamaranId; // tambahkan lamaranId di sini
    private long pelamarId;
    private String pelamarNama;
    private String pelamarEmail;
    private String pelamarNoTelepon;
    private String pelamarTentangDiri;
    private String pelamarPengalaman;
    private String pelamarPendidikan;
    private String pelamarSertifikasi;
    private String status;
    private String perusahaan;
    private String posisi;
    private String kualifikasi;
    private Date tanggalMelamar;

    public ModelPelamarLamaran() {}

    public ModelPelamarLamaran(long lamaranId, long pelamarId, String pelamarNama, String pelamarEmail, String pelamarNoTelepon, String pelamarTentangDiri, String pelamarPengalaman, String pelamarPendidikan, String pelamarSertifikasi, String status, String perusahaan, String posisi, String kualifikasi, Date tanggalMelamar) {
        this.lamaranId = lamaranId;
        this.pelamarId = pelamarId;
        this.pelamarNama = pelamarNama;
        this.pelamarEmail = pelamarEmail;
        this.pelamarNoTelepon = pelamarNoTelepon;
        this.pelamarTentangDiri = pelamarTentangDiri;
        this.pelamarPengalaman = pelamarPengalaman;
        this.pelamarPendidikan = pelamarPendidikan;
        this.pelamarSertifikasi = pelamarSertifikasi;
        this.status = status;
        this.perusahaan = perusahaan;
        this.posisi = posisi;
        this.kualifikasi = kualifikasi;
        this.tanggalMelamar = tanggalMelamar;
    }

    // Getters and Setters
    public long getLamaranId() {
        return lamaranId;
    }

    public void setLamaranId(long lamaranId) {
        this.lamaranId = lamaranId;
    }

    public long getPelamarId() {
        return pelamarId;
    }

    public void setPelamarId(long pelamarId) {
        this.pelamarId = pelamarId;
    }

    public String getPelamarNama() {
        return pelamarNama;
    }

    public void setPelamarNama(String pelamarNama) {
        this.pelamarNama = pelamarNama;
    }

    public String getPelamarEmail() {
        return pelamarEmail;
    }

    public void setPelamarEmail(String pelamarEmail) {
        this.pelamarEmail = pelamarEmail;
    }

    public String getPelamarNoTelepon() {
        return pelamarNoTelepon;
    }

    public void setPelamarNoTelepon(String pelamarNoTelepon) {
        this.pelamarNoTelepon = pelamarNoTelepon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getKualifikasi() {
        return kualifikasi;
    }

    public void setKualifikasi(String kualifikasi) {
        this.kualifikasi = kualifikasi;
    }

    public Date getTanggalMelamar() {
        return tanggalMelamar;
    }

    public void setTanggalMelamar(Date tanggalMelamar) {
        this.tanggalMelamar = tanggalMelamar;
    }

    public String getPelamarTentangDiri() {
        return pelamarTentangDiri;
    }

    public void setPelamarTentangDiri(String pelamarTentangDiri) {
        this.pelamarTentangDiri = pelamarTentangDiri;
    }

    public String getPelamarPengalaman() {
        return pelamarPengalaman;
    }

    public void setPelamarPengalaman(String pelamarPengalaman) {
        this.pelamarPengalaman = pelamarPengalaman;
    }

    public String getPelamarPendidikan() {
        return pelamarPendidikan;
    }

    public void setPelamarPendidikan(String pelamarPendidikan) {
        this.pelamarPendidikan = pelamarPendidikan;
    }

    public String getPelamarSertifikasi() {
        return pelamarSertifikasi;
    }

    public void setPelamarSertifikasi(String pelamarSertifikasi) {
        this.pelamarSertifikasi = pelamarSertifikasi;
    }
}
