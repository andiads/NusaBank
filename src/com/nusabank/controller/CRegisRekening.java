/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.model.DAO.Function;
import com.nusabank.model.DAO.InterfaceRekeningDAO;
import com.nusabank.model.DAO.RekeningDAO;
import com.nusabank.model.ModelRekening;
import com.nusabank.model.table.TableModelNasabah;
import com.nusabank.view.viewAdmin.ViewRegisNasabah;
import com.nusabank.view.viewNasabah.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class CRegisRekening {
 
    private Function func;
    
    private final ViewRegisNasabah vRegNasabah;

    private List<ModelRekening> listRekening;

    private final InterfaceRekeningDAO interfaceRekening;
    
    public CRegisRekening(JFrame frame) {
        this.vRegNasabah = (ViewRegisNasabah) frame;
        interfaceRekening = new RekeningDAO();
        func = new Function();
        listRekening = interfaceRekening.getAll();
    }
    
 
    public void getDataField() {

    }
    
    /*public void getData(int id) {
        listRekening = interfaceRekening.getById(id);
        vRegNasabah.getTxtIdRekening()
                .setText(String.valueOf(
                        listRekening.get(0)
                        .getIdRekening()
                ));
    }*/
    
    public void insert() {

        ModelRekening rekening = new ModelRekening();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date tglPembuatan = new java.util.Date();
        
        rekening.setNoPin(Integer.parseInt(String.valueOf(vRegNasabah.getTxtNoPIN().getPassword())));
        rekening.setNoRekening(vRegNasabah.getTxtNoRekening().getText());
        rekening.setSaldo(Integer.parseInt(vRegNasabah.getTxtSaldo().getText()));
        rekening.setJenisRekening(vRegNasabah.getCmbJenisRekening().getSelectedItem().toString());
        
        interfaceRekening.insert(rekening);
        vRegNasabah.getTxtIdRekening().setText(interfaceRekening.getLastId());
        
    }

    

    
}

