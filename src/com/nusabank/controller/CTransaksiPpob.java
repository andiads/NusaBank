/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;
import com.nusabank.model.ModelTransaksiPPOB;
import com.nusabank.model.DAO.TransaksiPpobDAO;
import com.nusabank.model.DAO.InterfaceTrxPpobDAO;
import com.nusabank.model.table.TableModelTransaksiPPOB;

import com.nusabank.model.ModelRekening;
import com.nusabank.model.DAO.RekeningDAO;
import com.nusabank.model.DAO.InterfaceRekeningDAO;

import com.nusabank.model.ModelNasabah;
import com.nusabank.model.DAO.InterfaceNasabahDAO;
import com.nusabank.model.DAO.NasabahDAO;


import com.nusabank.view.viewNasabah.ViewTrxPPOB;
import java.sql.Date;
import java.sql.SQLException;
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
 * @author User
 */
public class CTransaksiPpob {
    private final ViewTrxPPOB vTrxPpob;
    
    private List<ModelTransaksiPPOB> listTrxPpob;
    private List<ModelNasabah> listNasabah;
    private List<ModelRekening> listRekening;

    private final InterfaceTrxPpobDAO interfaceTrxPpob;
    private final InterfaceRekeningDAO interfaceRek;
    private final NasabahDAO interfaceNasabah;
    
    private String idNasabah;
    private int idRekening;
    private int currentSaldo;
    private String noRekening;
    
    public CTransaksiPpob(JFrame frame, String idNasabah) {
        this.vTrxPpob = (ViewTrxPPOB) frame;
        
        interfaceTrxPpob = new TransaksiPpobDAO();
        interfaceRek = new RekeningDAO();
        interfaceNasabah = new NasabahDAO();
        
        this.idRekening = interfaceNasabah.getIdRekening(idNasabah);
        this.noRekening = interfaceRek.getNoRek(idRekening);
        this.currentSaldo = interfaceRek.getSaldo(idRekening);
        
        vTrxPpob.getLbNoRekening().setText(noRekening);
        listTrxPpob = interfaceTrxPpob.search("id_rekening", String.valueOf(idRekening));
    }
    
    
    public void insert() {

        ModelTransaksiPPOB trxPpob = new ModelTransaksiPPOB();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date tglPembuatan = new java.util.Date();
        int adminFee = 1000;
        
        trxPpob.setJenisTransaksi((vTrxPpob.getCmbJenisTransaksi().getSelectedItem().toString()));
        trxPpob.setNominal(Integer.parseInt(vTrxPpob.getTfNominal().getText()));
        trxPpob.setTglTransaksi(dateFormat.format(tglPembuatan));
        trxPpob.setNoTarget(Integer.parseInt(vTrxPpob.getTfNoTarget().getText()));
        trxPpob.setKetTransaksi(vTrxPpob.getTfKeterangan().getText());
        trxPpob.setIdRekening(idRekening);
        
        int totalCutSaldo = trxPpob.getNominal() + adminFee;
        
        if (currentSaldo < totalCutSaldo){
            JOptionPane.showMessageDialog(vTrxPpob, "Your current balance isn't sufficent to do a transaction !");
        } else {
            interfaceTrxPpob.insert(trxPpob);
            interfaceRek.trimSaldo(this.idRekening, totalCutSaldo);  
            JOptionPane.showMessageDialog(vTrxPpob, "Transaction Success!"
                    + "\nNo.ID.Trx: "+interfaceTrxPpob.getLastId()
                    + "\nCategory: "+ trxPpob.getJenisTransaksi()
                    + "\nNo.HP/Token: "+ trxPpob.getNoTarget()
                    + "\nCurrent balance: Rp."+ currentSaldo
                    + "\nAmount: Rp."+trxPpob.getNominal()
                    + "\nAdmin Fee: Rp."+adminFee
                    + "\n==================================="
                    + "\nBalance left: Rp."+ (currentSaldo - totalCutSaldo)
            );
        }
        
        
    }
    public void reset() {
        vTrxPpob.getCmbJenisTransaksi().setSelectedItem(0);
        vTrxPpob.getTfNominal().setText("");
        vTrxPpob.getTfNoTarget().setText("");
        vTrxPpob.getTfKeterangan().setText("");
          
    }
    public void bindingTable(){
        listTrxPpob = interfaceTrxPpob.search("id_rekening", String.valueOf(idRekening));
        vTrxPpob.getTableTrxPPOB().setModel(new TableModelTransaksiPPOB(listTrxPpob));
    }

}
