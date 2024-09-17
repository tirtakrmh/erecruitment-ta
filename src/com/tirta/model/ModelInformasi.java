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

public class ModelInformasi {
    private long id;
    private int lamaranId;
    private Date tanggal;
    private Date jam;
    private String deskripsi;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    // Default constructor
    public ModelInformasi() {
    }

    // Parameterized constructor
    public ModelInformasi(long id, int lamaranId, Date tanggal, Date jam, String deskripsi, Date createdAt, Date updatedAt, Date deletedAt) {
        this.id = id;
        this.lamaranId = lamaranId;
        this.tanggal = tanggal;
        this.jam = jam;
        this.deskripsi = deskripsi;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLamaranId() {
        return lamaranId;
    }

    public void setLamaranId(int lamaranId) {
        this.lamaranId = lamaranId;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Date getJam() {
        return jam;
    }

    public void setJam(Date jam) {
        this.jam = jam;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
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
