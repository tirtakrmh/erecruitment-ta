/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tirta.model;

import java.util.Date;

public class ModelLamaranPelamar {
    private long id;
    private String perusahaan;
    private String posisi;
    private String status;
    private Date createdAt;
    private Date tanggalInformasi;
    private String jamInformasi;
    private String deskripsiInformasi;
    private String kualifikasi;

    public ModelLamaranPelamar() {
    }

    public ModelLamaranPelamar(long id, String perusahaan, String posisi, String status, Date createdAt, Date tanggalInformasi, String jamInformasi, String deskripsiInformasi, String kualifikasi) {
        this.id = id;
        this.perusahaan = perusahaan;
        this.posisi = posisi;
        this.status = status;
        this.createdAt = createdAt;
        this.tanggalInformasi = tanggalInformasi;
        this.jamInformasi = jamInformasi;
        this.deskripsiInformasi = deskripsiInformasi;
        this.kualifikasi = kualifikasi;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getTanggalInformasi() {
        return tanggalInformasi;
    }

    public void setTanggalInformasi(Date tanggalInformasi) {
        this.tanggalInformasi = tanggalInformasi;
    }

    public String getJamInformasi() {
        return jamInformasi;
    }

    public void setJamInformasi(String jamInformasi) {
        this.jamInformasi = jamInformasi;
    }

    public String getDeskripsiInformasi() {
        return deskripsiInformasi;
    }

    public void setDeskripsiInformasi(String deskripsiInformasi) {
        this.deskripsiInformasi = deskripsiInformasi;
    }

    public String getKualifikasi() {
        return kualifikasi;
    }

    public void setKualifikasi(String kualifikasi) {
        this.kualifikasi = kualifikasi;
    }

    @Override
    public String toString() {
        return "ModelLamaranPelamar{" + "id=" + id + ", perusahaan=" + perusahaan + ", posisi=" + posisi + ", status=" + status + ", createdAt=" + createdAt + ", tanggalInformasi=" + tanggalInformasi + ", jamInformasi=" + jamInformasi + ", deskripsiInformasi=" + deskripsiInformasi + ", kualifikasi=" + kualifikasi + '}';
    }

    
}
