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
public class ModelTransaksiPPOB {
    private int idTransaksi;
    private String jenisTransaksi;
    private int nominal;
    private String tglTransaksi;
    private int noTarget;
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

    public int getNoTarget() {
        return noTarget;
    }

    public void setNoTarget(int noTarget) {
        this.noTarget = noTarget;
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
