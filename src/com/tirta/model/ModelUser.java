package com.tirta.model;

public class ModelUser {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    

    public ModelUser(int userID, String userName, String email, String password, String noTelp, String tglLahir, String alamat) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.noTelp = noTelp;
        this.tglLahir = tglLahir;
        this.alamat = alamat;
    }
    
    public ModelUser(int userID, String userName, String email, String password) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public ModelUser() {
    }

    private int userID;
    private String userName;
    private String email;
    private String password;
    private String noTelp;
    private String tglLahir;
    private String alamat;

    @Override
    public String toString() {
        return "ModelUser{" + "userID=" + userID + ", userName=" + userName + ", email=" + email + ", password=" + password + ", noTelp=" + noTelp + ", tglLahir=" + tglLahir + ", alamat=" + alamat + '}';
    }

    

    
    
    
    
}

