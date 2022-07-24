package com.example.restaurant;

public class user {

    private String id;
    private String ad;
    private String soyad;
    private String emailAddress;
    private String tc;
    private String telefon;


    public user() {}

    public user(String id, String ad,String soyad, String emailAddress,String tc,String telefon) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;

        this.telefon = telefon;

    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }


    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }




    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }



}