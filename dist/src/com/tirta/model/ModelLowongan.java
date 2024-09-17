/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tirta.model;

/**
 *
 * @author Tirta Karimah
 */
import java.util.Date;

public class ModelLowongan {
    private long id;
    private String posisi;
    private String perusahaan;
    private String kualifikasi;
    private String status;
    private Date tanggalBuka;
    private Date tanggalTutup;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    // Constructors, getters, and setters
    public ModelLowongan() {
    }

    public ModelLowongan(long id, String posisi, String perusahaan, String kualifikasi, String status, Date tanggalBuka, Date tanggalTutup, Date createdAt, Date updatedAt, Date deletedAt) {
        this.id = id;
        this.posisi = posisi;
        this.perusahaan = perusahaan;
        this.kualifikasi = kualifikasi;
        this.status = status;
        this.tanggalBuka = tanggalBuka;
        this.tanggalTutup = tanggalTutup;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }

    public String getKualifikasi() {
        return kualifikasi;
    }

    public void setKualifikasi(String kualifikasi) {
        this.kualifikasi = kualifikasi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTanggalBuka() {
        return tanggalBuka;
    }

    public void setTanggalBuka(Date tanggalBuka) {
        this.tanggalBuka = tanggalBuka;
    }

    public Date getTanggalTutup() {
        return tanggalTutup;
    }

    public void setTanggalTutup(Date tanggalTutup) {
        this.tanggalTutup = tanggalTutup;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
