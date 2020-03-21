/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;
import com.nusabank.view.viewAdmin.ViewMenuAdmin;
import com.nusabank.view.viewAdmin.ViewRegisNasabah;
import com.nusabank.view.viewNasabah.ViewMenuNasabah;
import com.nusabank.view.viewNasabah.ViewTrxBank;
import com.nusabank.view.viewNasabah.ViewTrxPPOB;
import com.nusabank.view.viewNasabah.ViewAccountInfo;
import com.nusabank.view.viewAdmin.ViewSavingWD;

/**
 *
 * @author User
 */
public class CButton {
    private ViewMenuAdmin vMenuAdmin;
    private ViewRegisNasabah vRegisNasabah;
    private ViewMenuNasabah vMenuNasabah;
    private ViewTrxBank vTrxBank;
    private ViewTrxPPOB vTrxPpob;
    private ViewAccountInfo vAccountInfo;

    public CButton(ViewMenuAdmin vMenuAdmin) {
        this.vMenuAdmin = vMenuAdmin;
    }
    public CButton(ViewRegisNasabah vRegisNasabah) {
        this.vRegisNasabah = vRegisNasabah;
    }
    public CButton(ViewMenuNasabah vMenuNasabah){
        this.vMenuNasabah = vMenuNasabah;
    }
        public CButton(ViewTrxBank vTrxBank){
        this.vTrxBank = vTrxBank;
    }
        public CButton(ViewTrxPPOB vTrxPpob){
        this.vTrxPpob = vTrxPpob;
    }
            public CButton(ViewAccountInfo vAccountInfo){
        this.vAccountInfo = vAccountInfo;
    }
    
    public void goRegis(){
        ViewRegisNasabah vRegAdmin = new ViewRegisNasabah();
                    vRegAdmin.setVisible(true);
    }
    
    public void goSavingWD(){
        ViewSavingWD vSavingWD = new ViewSavingWD();
        vSavingWD.setVisible(true);
    }
    
    public void goBackMenuAdmin(){
        ViewMenuAdmin vBackMenuAdmin = new ViewMenuAdmin();
        vBackMenuAdmin.setVisible(true);
    }
    
    public void goTrxBank(){
        ViewTrxBank viTrxBank = new ViewTrxBank();
        viTrxBank.setVisible(true);
    }
    public void goTrxPpob(){
        ViewTrxPPOB viTrxPpob = new ViewTrxPPOB();
        viTrxPpob.setVisible(true);
    }
    public void goAccountInfo(){
        ViewAccountInfo viAccountInfo = new ViewAccountInfo();
        viAccountInfo.setVisible(true);
    }
    public void goBackMenuNasabah(){
        ViewMenuNasabah vBackMenuNasabah = new ViewMenuNasabah();
        vBackMenuNasabah.setVisible(true);
    }

}
