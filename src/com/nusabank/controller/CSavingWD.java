/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.model.DAO.RekeningDAO;
import com.nusabank.model.DAO.TransaksiBankDAO;
import com.nusabank.model.ModelRekening;
import com.nusabank.view.viewNasabah.ViewTrxBank;
import com.nusabank.view.viewAdmin.ViewSavingWD;
/**
 *
 * @author User
 */
public class CSavingWD {
    private ViewSavingWD vSavingWD;
    private ModelRekening rekLogin;
    private RekeningDAO interfaceRekening;


    public CSavingWD(ViewSavingWD vSW) {
        this.vSavingWD = (ViewSavingWD) vSW;
        interfaceRekening = new RekeningDAO();
    }    
     
    
    
    public void doSaving(){
        ModelRekening rek = new ModelRekening();
        String noRek = vSavingWD.getNoRek().getText();
        int nominal = Integer.parseInt(vSavingWD.getNominal().getText());
        interfaceRekening.doSaving(noRek, nominal);
    }
    
        public void doWithdraw(){
        ModelRekening rek = new ModelRekening();
        String noRek = vSavingWD.getNoRek().getText();
        int nominal = Integer.parseInt(vSavingWD.getNominal().getText());
        interfaceRekening.doWithDraw(noRek, nominal);
    }   
}
