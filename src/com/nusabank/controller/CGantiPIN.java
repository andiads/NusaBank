/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;
import com.nusabank.view.viewNasabah.ViewGantiPin;
import com.nusabank.model.ModelRekening;
import com.nusabank.model.DAO.RekeningDAO;
import com.nusabank.model.DAO.InterfaceRekeningDAO;
import com.nusabank.model.ModelTransaksiBank;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author User
 */
public class CGantiPIN {
    private ViewGantiPin cGantiPin;
    
    private InterfaceRekeningDAO interfaceRekeningDAO;
    
    public CGantiPIN(ViewGantiPin vma) {
        this.cGantiPin =  vma;
        interfaceRekeningDAO = new RekeningDAO();
    }
    public void doChangePin() {

        ModelRekening rek = new ModelRekening();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date tglPembuatan = new java.util.Date();
        int adminFee = 1000;
        
        rek.setNoPin(Integer.parseInt(cGantiPin.getNewPin().getText()));
        rek.setNoRekening(cGantiPin.getNoRek().getText());
        rek.setIdRekening(Integer.parseInt(cGantiPin.getOldPin().getText()));
        interfaceRekeningDAO.doChangePin(rek);
        
       
    }
}
