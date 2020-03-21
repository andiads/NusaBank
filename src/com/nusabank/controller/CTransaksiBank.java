/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;
import com.nusabank.model.ModelTransaksiBank;
import com.nusabank.model.DAO.TransaksiBankDAO;
import com.nusabank.model.DAO.InterfaceTrxBankDAO;
import com.nusabank.model.table.TableModelTransaksiBank;

import com.nusabank.model.ModelRekening;
import com.nusabank.model.DAO.RekeningDAO;
import com.nusabank.model.DAO.InterfaceRekeningDAO;

import com.nusabank.model.ModelNasabah;
import com.nusabank.model.DAO.InterfaceNasabahDAO;
import com.nusabank.model.DAO.NasabahDAO;

import com.nusabank.view.viewNasabah.ViewTrxBank;
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
public class CTransaksiBank {
    private final ViewTrxBank vTrxBank;
    private ViewTrxBank vTB;
    
    private List<ModelTransaksiBank> listTrxBank;
    private List<ModelNasabah> listNasabah;
    private List<ModelRekening> listRekening;
    
    private final InterfaceTrxBankDAO interfaceTrxBank;
    private final InterfaceRekeningDAO interfaceRek;
    private final NasabahDAO interfaceNasabah;
    
    private String idNasabah;
    private int idRekening;
    private int currentSaldo;
    private String noRekening;
    
    
    public CTransaksiBank(ViewTrxBank vTB, String idNasabah) {
        this.vTrxBank = (ViewTrxBank) vTB;
        
        interfaceTrxBank = new TransaksiBankDAO();
        interfaceRek = new RekeningDAO();
        interfaceNasabah = new NasabahDAO();
        
        this.idRekening = interfaceNasabah.getIdRekening(idNasabah);
        this.noRekening = interfaceRek.getNoRek(idRekening);
        this.currentSaldo = interfaceRek.getSaldo(idRekening);
        
        vTrxBank.getLbNoRekening().setText(noRekening);
        listTrxBank = interfaceTrxBank.search("id_rekening", String.valueOf(this.idRekening));
        
    }
    
    public void insert() {

        ModelTransaksiBank trxBank = new ModelTransaksiBank();
        ModelRekening rek = new ModelRekening();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date tglPembuatan = new java.util.Date();
        int adminFee = 1000;
        
        
        trxBank.setJenisTransaksi((vTrxBank.getCmbJenisTransaksi().getSelectedItem().toString()));
        trxBank.setNominal(Integer.parseInt(vTrxBank.getTfNominal().getText()));
        trxBank.setTglTransaksi(dateFormat.format(tglPembuatan));
        trxBank.setKodeBank(Integer.parseInt(vTrxBank.getTfKodeBank().getText()));
        trxBank.setRekTujuan(Integer.parseInt(vTrxBank.getTfNoRekTujuan().getText()));
        trxBank.setBiayaAdmin(adminFee);
        trxBank.setKetTransaksi(vTrxBank.getTfKeterangan().getText());
        trxBank.setIdRekening(this.idRekening);
        
        int totalCutSaldo = trxBank.getNominal() + adminFee;
        
        if (currentSaldo < totalCutSaldo){
            JOptionPane.showMessageDialog(vTrxBank, "Your current balance isn't sufficent to do a transaction !");
        } else {
            interfaceTrxBank.insert(trxBank);
            interfaceRek.trimSaldo(this.idRekening, totalCutSaldo);  
            JOptionPane.showMessageDialog(vTrxBank, "Transaction Success!"
                    + "\nNo.ID.Trx: "+interfaceTrxBank.getLastId()
                    + "\nTo: "+ trxBank.getRekTujuan()
                    + "\nBank Code: "+ trxBank.getKodeBank()
                    + "\nCurrent balance: Rp."+ currentSaldo
                    + "\nAmount: Rp."+trxBank.getNominal()
                    + "\nAdmin Fee: Rp."+adminFee
                    + "\n==================================="
                    + "\nBalance left: Rp."+ (currentSaldo - totalCutSaldo)
            );
        }
       
    }
    
    public void reset() {
        vTrxBank.getCmbJenisTransaksi().setSelectedItem(0);
        vTrxBank.getTfNominal().setText("");
        vTrxBank.getTfKodeBank().setText("");
        vTrxBank.getTfNoRekTujuan().setText("");
        vTrxBank.getTfKeterangan().setText("");
          
    }
    
    public void bindingTable(){
        listTrxBank = interfaceTrxBank.search("id_rekening", String.valueOf(idRekening));
        vTrxBank.getTableTrxBank().setModel(new TableModelTransaksiBank(listTrxBank));
    }

}
