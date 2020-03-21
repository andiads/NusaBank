/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model;

import java.sql.Date;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class ModelTransaksiBank {
    private int idTransaksi;
    private String jenisTransaksi;
    private int nominal;
    private String tglTransaksi;
    private int kodeBank;
    private int rekTujuan;
    private int biayaAdmin;
    private String ketTransaksi;
    private int idRekening;
    
    

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public int getKodeBank() {
        return kodeBank;
    }

    public void setKodeBank(int kodeBank) {
        this.kodeBank = kodeBank;
    }

    public int getRekTujuan() {
        return rekTujuan;
    }

    public void setRekTujuan(int rekTujuan) {
        this.rekTujuan = rekTujuan;
    }

    public int getBiayaAdmin() {
        return biayaAdmin;
    }

    public void setBiayaAdmin(int biayaAdmin) {
        this.biayaAdmin = biayaAdmin;
    }

    public String getKetTransaksi() {
        return ketTransaksi;
    }

    public void setKetTransaksi(String ketTransaksi) {
        this.ketTransaksi = ketTransaksi;
    }

    public int getIdRekening() {
        return idRekening;
    }

    public void setIdRekening(int idRekening) {
        this.idRekening = idRekening;
    }
    
}
