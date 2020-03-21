/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.model.ModelNasabah;
import com.nusabank.model.ModelRekening;
import com.nusabank.model.DAO.InterfaceRekeningDAO;
import com.nusabank.model.DAO.InterfaceNasabahDAO;
import com.nusabank.model.DAO.RekeningDAO;
import com.nusabank.model.DAO.NasabahDAO;
import com.nusabank.view.viewNasabah.ViewAccountInfo;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class CSaldoNasabah {
    
    private final ViewAccountInfo vAccountInfo;

    private List<ModelRekening> listRekening;
    private List<ModelNasabah> listNasabah;

    private final ModelNasabah nsbLogin;
    private final ModelRekening rekLogin;
    
    private final RekeningDAO interfaceRekening;
    private final NasabahDAO interfaceNasabah;
    
    private String idNasabah;
    private int idRekening;
    private String noRek;
    private int validatePIN;
    private int saldo;
    
    public CSaldoNasabah(JFrame frame, String idNasabah) {
        this.vAccountInfo = (ViewAccountInfo) frame;
        this.idNasabah = idNasabah;
        interfaceNasabah = new NasabahDAO();
        interfaceRekening = new RekeningDAO();
        
        nsbLogin = new ModelNasabah();
        rekLogin = new ModelRekening();
       
        this.idRekening = interfaceNasabah.getIdRekening(idNasabah);
        noRek = interfaceRekening.getNoRek(idRekening);
        validatePIN = interfaceRekening.getNoPIN(idRekening);
        saldo = interfaceRekening.getSaldo(idRekening);
        
        vAccountInfo.getTfNoRek().setText(noRek);
    }
    
    public void checkSaldo() {
        int inputNoPIN = Integer.parseInt(vAccountInfo.getTfNoPIN().getText());
        if (this.validatePIN==inputNoPIN) {
            vAccountInfo.getTfSaldo().setText(String.valueOf(this.saldo));
        } else {
            JOptionPane.showMessageDialog(null, "Kode PIN salah !");
        }
    }
}
