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

public class ModelLamaran {
    private long id;
    private int pelamarId;
    private int lowonganId;
    private String status;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public ModelLamaran() {
    }

    public ModelLamaran(long id, int pelamarId, int lowonganId, String status, Date createdAt, Date updatedAt, Date deletedAt) {
        this.id = id;
        this.pelamarId = pelamarId;
        this.lowonganId = lowonganId;
        this.status = status;
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

    public int getPelamarId() {
        return pelamarId;
    }

    public void setPelamarId(int pelamarId) {
        this.pelamarId = pelamarId;
    }

    public int getLowonganId() {
        return lowonganId;
    }

    public void setLowonganId(int lowonganId) {
        this.lowonganId = lowonganId;
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



