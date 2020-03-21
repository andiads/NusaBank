/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.model.DAO.Function;
import com.nusabank.model.ModelAdmin;
import com.nusabank.model.DAO.AdminDAO;
import com.nusabank.model.DAO.InterfaceAdminDAO;
import com.nusabank.model.table.TableModelAdmin;
import com.nusabank.view.viewAdmin.ViewManageAdmin;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class CManageAdmin {
    
    private Function func;
    private final ViewManageAdmin vManageAdmin;
    
    private List<ModelAdmin> listAdmin;
    private final InterfaceAdminDAO interfaceAdmin;
    
    public CManageAdmin(ViewManageAdmin vManageAdmin) {
        this.vManageAdmin =  vManageAdmin;
        interfaceAdmin = new AdminDAO();
        func = new Function();
        listAdmin = interfaceAdmin.getAll();
        
    }
    
    public void reset(){
        vManageAdmin.getTfIdAdmin().setText("");
        vManageAdmin.getTfNamaAdmin().setText("");
        vManageAdmin.getTfNikAdmin().setText("");
        vManageAdmin.getTfAlamatAdmin().setText("");
        vManageAdmin.getTfNoHpAdmin().setText("");
        vManageAdmin.getTfPasswordAdmin().setText("");
        vManageAdmin.getTfUsernameAdmin().setText("");
        vManageAdmin.getTfPhotoAdminPath().setText("");
        vManageAdmin.getTfEmailAdmin().setText("");
        vManageAdmin.getCmbJenisKelamin().setSelectedIndex(0);
    }
    
    public void insert(){
        ModelAdmin admin = new ModelAdmin();
        
        admin.setNama(vManageAdmin.getTfNamaAdmin().getText());
        admin.setNIK(vManageAdmin.getTfNikAdmin().getText());
        admin.setUsername(vManageAdmin.getTfUsernameAdmin().getText());
        admin.setJenisKelamin(vManageAdmin.getCmbJenisKelamin().getSelectedItem().toString());
        admin.setPassword(String.valueOf(vManageAdmin.getTfPasswordAdmin().getPassword()));
        admin.setEmail(vManageAdmin.getTfEmailAdmin().getText());
        admin.setAlamat(vManageAdmin.getTfAlamatAdmin().getText());
        admin.setTglLahir((new java.sql.Date(vManageAdmin.getDcTglLahir().getDate().getTime()).toString()));
        admin.setNoHp(vManageAdmin.getTfNoHpAdmin().getText());
        
        String newFileName = func.uploadPhotoAdmin(vManageAdmin, admin);
        admin.setPhoto(newFileName);
        
        interfaceAdmin.insert(admin);
        JOptionPane.showMessageDialog(vManageAdmin, "New admin added !");
    }
    
    public void update(){
        ModelAdmin admin = new ModelAdmin();
        admin.setNama(vManageAdmin.getTfNamaAdmin().getText());
        admin.setNIK(vManageAdmin.getTfNikAdmin().getText());
        admin.setUsername(vManageAdmin.getTfUsernameAdmin().getText());
        admin.setJenisKelamin(vManageAdmin.getCmbJenisKelamin().getSelectedItem().toString());
        admin.setPassword(String.valueOf(vManageAdmin.getTfPasswordAdmin().getPassword()));
        admin.setEmail(vManageAdmin.getTfEmailAdmin().getText());
        admin.setAlamat(vManageAdmin.getTfAlamatAdmin().getText());
        admin.setTglLahir((new java.sql.Date(vManageAdmin.getDcTglLahir().getDate().getTime()).toString()));
        admin.setNoHp(vManageAdmin.getTfNoHpAdmin().getText());
        
        String newFileName = func.uploadPhotoAdmin(vManageAdmin, admin);
        admin.setPhoto(newFileName);
        
        interfaceAdmin.update(admin);
        JOptionPane.showMessageDialog(vManageAdmin, "update success !");
    }
    
    public void delete(){
    if (vManageAdmin.getTfIdAdmin().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(vManageAdmin, "No data deleted....? ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int row = Integer.parseInt(vManageAdmin.getTfIdAdmin().getText());
        
        interfaceAdmin.delete(row);
        JOptionPane.showMessageDialog(null, "Succesfully deleted !");
    }
    
    public void bindingTable(){
        listAdmin = interfaceAdmin.getAll();
        vManageAdmin.getTableAdmin().setModel(new TableModelAdmin(listAdmin));
    }
    
    public void getData(){

        String cat = vManageAdmin.getCmbCategory().getSelectedItem().toString();
        String keyword = null;
        
        if (cat.equals("ID")){
            keyword = vManageAdmin.getTfIdAdmin().getText();
        } else if (cat.equals("NAMA")) {
            keyword = vManageAdmin.getTfNamaAdmin().getText();
        } else if (cat.equals("NIK")) {
            keyword = vManageAdmin.getTfNikAdmin().getText();
        } else if (cat.equals("USERNAME")) {
            keyword = vManageAdmin.getTfUsernameAdmin().getText();
        } else if (cat.equals("GENDER")) {
            keyword = vManageAdmin.getCmbJenisKelamin().getSelectedItem().toString();
        } else if (cat.equals("EMAIL")) {
            keyword = vManageAdmin.getTfEmailAdmin().getText();
        } else if (cat.equals("PHONE_NO")) {
            keyword = vManageAdmin.getTfNoHpAdmin().getText();
        } else if (cat.equals("ADDRESS")) {
            keyword = vManageAdmin.getTfAlamatAdmin().getText();
        }

       interfaceAdmin.search(cat, keyword);
       bindingSearch(cat, keyword);

    }
    
    public void getDataField(){
         int row = vManageAdmin.getTableAdmin().getSelectedRow();
        
        if (row != -1){
            try {
            java.util.Date tglLahir = new SimpleDateFormat("yyyy-MM-dd").parse(listAdmin.get(row).getTglLahir());
            vManageAdmin.getTfIdAdmin().setText(String.valueOf(listAdmin.get(row).getId()));
            vManageAdmin.getTfNamaAdmin().setText(listAdmin.get(row).getNama());
            vManageAdmin.getTfNikAdmin().setText(listAdmin.get(row).getNIK());
            vManageAdmin.getTfUsernameAdmin().setText(listAdmin.get(row).getUsername());
            vManageAdmin.getTfPasswordAdmin().setText(listAdmin.get(row).getPassword());
            vManageAdmin.getDcTglLahir().setDate(tglLahir);
            vManageAdmin.getTfPhotoAdminPath().setText(listAdmin.get(row).getPhoto());
            vManageAdmin.getCmbJenisKelamin().setSelectedItem(listAdmin.get(row).getJenisKelamin());
            vManageAdmin.getTfNoHpAdmin().setText(listAdmin.get(row).getNoHp());
            vManageAdmin.getTfEmailAdmin().setText(listAdmin.get(row).getEmail());
            vManageAdmin.getTfAlamatAdmin().setText(listAdmin.get(row).getAlamat());
            } catch(ParseException e){
                e.printStackTrace();
            }
        }
    }
    
    public void bindingSearch(String cat, String keyword){
        listAdmin = interfaceAdmin.search(cat, keyword);
        vManageAdmin.getTableAdmin().setModel(new TableModelAdmin(listAdmin));
    }

}
