/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;
import com.nusabank.model.DAO.AdminDAO;
import com.nusabank.model.DAO.Function;
import com.nusabank.model.DAO.InterfaceAdminDAO;
import com.nusabank.model.DAO.InterfaceNasabahDAO;
import com.nusabank.model.ModelNasabah;
import com.nusabank.model.DAO.NasabahDAO;
import com.nusabank.model.ModelAdmin;
import com.nusabank.model.table.TableModelNasabah;
import com.nusabank.view.viewAdmin.ViewManageNasabah;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class CManageNasabah {
   private Function func;
    private ViewManageNasabah vManageNasabah;
    
    private List<ModelNasabah> listNasabah;
    private InterfaceNasabahDAO interfaceNasabah;
    
    public CManageNasabah(ViewManageNasabah vManageNasabah) {
        this.vManageNasabah =  (ViewManageNasabah) vManageNasabah;
        interfaceNasabah = new NasabahDAO();
        func = new Function();
        listNasabah = interfaceNasabah.getAll();
        
    }

    
    public void bindingTable(){
        listNasabah = interfaceNasabah.getAll();
        vManageNasabah.getTableNasabah().setModel(new TableModelNasabah(listNasabah));
    }
    
    public void getDataField(){
         int row = vManageNasabah.getTableNasabah().getSelectedRow();
        
        if (row != -1){
            try {
            java.util.Date tglLahir = new SimpleDateFormat("yyyy-MM-dd").parse(listNasabah.get(row).getTglLahir());
            vManageNasabah.getTfIDNasabah().setText(String.valueOf(listNasabah.get(row).getId()));
            vManageNasabah.getTfName().setText(listNasabah.get(row).getNama());
            vManageNasabah.getTfNik().setText(String.valueOf(listNasabah.get(row).getNik()));
            vManageNasabah.getDcTglLahir().setDate(tglLahir);
            vManageNasabah.getTaAdress().setText(listNasabah.get(row).getAlamatRumah());
            vManageNasabah.getTfPhoto().setText(listNasabah.get(row).getPhoto());
            vManageNasabah.getCmbGender().setSelectedItem(listNasabah.get(row).getJenisKelamin());
            vManageNasabah.getTfPekerjaan().setText(listNasabah.get(row).getPekerjaan());
            vManageNasabah.getTfAdressWork().setText(listNasabah.get(row).getAlamatKantor());
            vManageNasabah.getTfIncome().setText(String.valueOf(listNasabah.get(row).getPendapatan()));
            vManageNasabah.getTfNoHP().setText(listNasabah.get(row).getNoHp());
            vManageNasabah.getCmbStatus().setSelectedItem(listNasabah.get(row).getStatus());
            vManageNasabah.getTfMotherName().setText(listNasabah.get(row).getNamaIbu());
            vManageNasabah.getUsername().setText(listNasabah.get(row).getUsername());
            vManageNasabah.getTfPassword().setText(listNasabah.get(row).getPassword());
            vManageNasabah.getLbDateMake().setText(listNasabah.get(row).getTglPembuatan());
            vManageNasabah.getTfIDRekening().setText(String.valueOf(listNasabah.get(row).getIdRekening()));
            } catch(ParseException e){
                e.printStackTrace();
            }
        }
    }
    
    public void update(){
        ModelAdmin admin = new ModelAdmin();
        ModelNasabah nasabah = new ModelNasabah();
        
        nasabah.setId(Integer.parseInt(vManageNasabah.getTfIDNasabah().getText()));
        nasabah.setNama(vManageNasabah.getTfName().getText());
        nasabah.setNik(Integer.parseInt(vManageNasabah.getTfNik().getText()));
        nasabah.setTglLahir(new java.sql.Date(vManageNasabah.getDcTglLahir().getDate().getTime()).toString());
        nasabah.setAlamatRumah(vManageNasabah.getTaAdress().getText());
        nasabah.setPhoto(vManageNasabah.getTfPhoto().getText());
        nasabah.setJenisKelamin(vManageNasabah.getCmbGender().getSelectedItem().toString());
        nasabah.setPekerjaan(vManageNasabah.getTfPekerjaan().getText());
        nasabah.setAlamatKantor(vManageNasabah.getTfAdressWork().getText());
        nasabah.setPendapatan(Integer.parseInt(vManageNasabah.getTfIncome().getText()));
        nasabah.setNoHp(vManageNasabah.getTfNoHP().getText());
        nasabah.setStatus(vManageNasabah.getCmbStatus().getSelectedItem().toString());
        nasabah.setNamaIbu(vManageNasabah.getTfMotherName().getText());
        nasabah.setUsername(vManageNasabah.getUsername().getText());
        nasabah.setPassword(vManageNasabah.getTfPassword().getText());
        nasabah.setIdRekening(Integer.parseInt(vManageNasabah.getTfIDRekening().getText()));
               
        interfaceNasabah.update(nasabah);
        JOptionPane.showMessageDialog(vManageNasabah, "update success Broo !");
    }
    
    public void delete(){
    if (vManageNasabah.getTfIDNasabah().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(vManageNasabah, "No data deleted....? ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int row = Integer.parseInt(vManageNasabah.getTfIDNasabah().getText());
        
        interfaceNasabah.delete(row);
        JOptionPane.showMessageDialog(null, "Succesfully deleted !");
    }
}
