/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class ModelRekening {
    private int idRekening;
    private String noRekening;
    private int saldo;
    private String jenisRekening;
    private int noPin;

    public int getIdRekening() {
        return idRekening;
    }

    public void setIdRekening(int idRekening) {
        this.idRekening = idRekening;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getJenisRekening() {
        return jenisRekening;
    }

    public void setJenisRekening(String jenisRekening) {
        this.jenisRekening = jenisRekening;
    }

    public int getNoPin() {
        return noPin;
    }

    public void setNoPin(int noPin) {
        this.noPin = noPin;
    }
    
}
