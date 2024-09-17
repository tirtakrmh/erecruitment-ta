/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

public class ModelKaryawan {
    private long id;
    private String role;
    private String nama;
    private String email;
    private String noTelepon;
    private String departemen;
    private int userId;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private String password;

    public ModelKaryawan() {
    }

    public ModelKaryawan(long id, String role, String nama, String email, String noTelepon, String departemen, int userId, Date createdAt, Date updatedAt, Date deletedAt) {
        this.id = id;
        this.role = role;
        this.nama = nama;
        this.email = email;
        this.noTelepon = noTelepon;
        this.departemen = departemen;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public ModelKaryawan(long id, String role, String nama, String email, String noTelepon, String departemen, int userId, Date createdAt, Date updatedAt, Date deletedAt, String password) {
        this.id = id;
        this.role = role;
        this.nama = nama;
        this.email = email;
        this.noTelepon = noTelepon;
        this.departemen = departemen;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "ModelKaryawan{" + "id=" + id + ", role=" + role + ", nama=" + nama + ", email=" + email + ", noTelepon=" + noTelepon + ", departemen=" + departemen + ", userId=" + userId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", password=" + password + '}';
    }
    
    
    
}
