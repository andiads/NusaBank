/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.helper.Function;
import com.nusabank.helper.Validation;
import com.nusabank.model.ModelAdmin;
import com.nusabank.model.DAO.AdminDAO;
import com.nusabank.model.DAO.InterfaceAdminDAO;
import com.nusabank.model.table.TableModelAdmin;
import com.nusabank.view.viewAdmin.ViewManageAdmin;

import java.lang.reflect.*;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class CManageAdmin {

    private Function func;
    private Validation validator;

    private final ViewManageAdmin vManageAdmin;

    private boolean isAllValid;
    private boolean isInsert = true;
    private Boolean[] isEachFieldsValid;

    private int minPasswordLength = 6;
    private int maxPasswordLength = 12;

    private List<ModelAdmin> listAdmin;
    private final InterfaceAdminDAO interfaceAdmin;

    private Border errorBorder = BorderFactory.createLineBorder(Color.red, 1);
    private Color errorColor = new Color(225, 102, 102);

    public CManageAdmin(ViewManageAdmin vManageAdmin) {
        this.vManageAdmin = (ViewManageAdmin) vManageAdmin;
        interfaceAdmin = new AdminDAO();
        func = new Function();
        listAdmin = interfaceAdmin.getAll();
    }

    public void reset() {
        vManageAdmin.getTxtIdAdmin().setText("");
        vManageAdmin.getTxtNamaAdmin().setText("");
        vManageAdmin.getTxtNikAdmin().setText("");
        vManageAdmin.getTxtAlamatAdmin().setText("");
        vManageAdmin.getTxtNoHpAdmin().setText("");
        vManageAdmin.getTxtPasswordAdmin().setText("");
        vManageAdmin.getTxtUsernameAdmin().setText("");
        vManageAdmin.getTxtPhotoAdminPath().setText("");
        vManageAdmin.getTxtEmailAdmin().setText("");
        vManageAdmin.getCmbJenisKelamin().setSelectedIndex(0);
        vManageAdmin.getTxtAreaValidation().setText("");
        // reset the border
        //BorderFactory.createEmptyBorder()
        vManageAdmin.getTxtNamaAdmin().setBackground(Color.WHITE);
        vManageAdmin.getTxtNikAdmin().setBackground(Color.WHITE);
        vManageAdmin.getTxtUsernameAdmin().setBackground(Color.WHITE);
        vManageAdmin.getTxtEmailAdmin().setBackground(Color.WHITE);
        vManageAdmin.getTxtPasswordAdmin().setBackground(Color.WHITE);
        vManageAdmin.getTxtNoHpAdmin().setBackground(Color.WHITE);
        vManageAdmin.getDcTglLahir().setBackground(Color.WHITE);
        vManageAdmin.getTxtAlamatAdmin().setBackground(Color.WHITE);
        vManageAdmin.getCmbJenisKelamin().setBackground(Color.WHITE);

    }

    public void validateForm(boolean isInsert) {
        validator = Validation.buildPasswordRule(false, false, true, 6, 12);
        ModelAdmin admin = new ModelAdmin();

        isEachFieldsValid = new Boolean[9];

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tglLahir = sdf.format(this.vManageAdmin.getDcTglLahir().getDate());

        admin.setNama(vManageAdmin.getTxtNamaAdmin().getText());
        admin.setNIK(vManageAdmin.getTxtNikAdmin().getText());
        admin.setUsername(vManageAdmin.getTxtUsernameAdmin().getText());
        admin.setJenisKelamin(vManageAdmin.getCmbJenisKelamin().getSelectedItem().toString());
        admin.setPassword(String.valueOf(vManageAdmin.getTxtPasswordAdmin().getPassword()));
        admin.setEmail(vManageAdmin.getTxtEmailAdmin().getText());
        admin.setAlamat(vManageAdmin.getTxtAlamatAdmin().getText());
        admin.setTglLahir(tglLahir);
        admin.setNoHp(vManageAdmin.getTxtNoHpAdmin().getText());

        StringBuilder messageBuilder = new StringBuilder();
        java.util.Date todayDate = new java.util.Date();

        if ((admin.getNama().isEmpty())
                && (admin.getNIK().isEmpty())
                && (admin.getUsername().isEmpty())
                && (admin.getPassword().isEmpty())
                && (admin.getEmail().isEmpty())
                && (admin.getJenisKelamin().isEmpty()
                || admin.getJenisKelamin().equals("- Choose -"))
                && (admin.getNoHp().isEmpty())
                && (admin.getTglLahir().isEmpty()
                || (vManageAdmin.getDcTglLahir().getDate().compareTo(todayDate) < 0))
                && (admin.getAlamat().isEmpty())) {

            JOptionPane.showMessageDialog(vManageAdmin,
                    "Please don't leave fields blank!",
                    "Warning",
                    JOptionPane.ERROR_MESSAGE
            );

            isAllValid = false;

        } else if (isAllValid == false) {

            if (!validator.isValidName(admin.getNama())) {

                messageBuilder.append("\n > Incorrect Name input, "
                        + "please use alphanumeric characters and avoid symbols!");

                vManageAdmin.getTxtNamaAdmin().setBackground(errorColor);
                isEachFieldsValid[0] = false;

            } else {

                isEachFieldsValid[0] = true;

            }

            if (!validator.isValidNIK(admin.getNIK())) {

                messageBuilder.append("\n > Incorrect NIK input, "
                        + "only numeric input accepted !");

                vManageAdmin.getTxtNikAdmin().setBackground(errorColor);
                isEachFieldsValid[1] = false;

            } else {

                isEachFieldsValid[1] = true;

            }

            if (!validator.isValidUsername(admin.getUsername())) {

                messageBuilder.append("\n > Incorrect Username input, "
                        + "please use alphanumeric characters and avoid symbols!");

                vManageAdmin.getTxtUsernameAdmin().setBackground(errorColor);
                isEachFieldsValid[2] = false;

            } else {

                isEachFieldsValid[2] = true;

            }

            if (!validator.isValidEmail(admin.getEmail())) {

                messageBuilder.append("\n > Incorrect Email input, "
                        + "the format should be like name@mailhost.com !");

                vManageAdmin.getTxtEmailAdmin().setBackground(errorColor);
                isEachFieldsValid[3] = false;
            
            } else {
            
                isEachFieldsValid[3] = true;
            
            }

            if (!validator.isValidPassword(admin.getPassword().toString())) {

                messageBuilder.append("\n > Incorrect Password input !"
                        + "\n\t->Password should be alphanumeric"
                        + "\n\t->Password should have at least 1 number"
                        + "\n\t->Password should have minimum "
                        + minPasswordLength + " characters"
                        + "\n\t->and maximum of " + maxPasswordLength + " characters"
                        + "\n\t->No Capital letters"
                        + "\n\t->and doesn't include whitespaces "
                        + "\n\tor special characters !");

                vManageAdmin.getTxtPasswordAdmin().setBackground(errorColor);
                isEachFieldsValid[4] = false;
            
            } else {
            
                isEachFieldsValid[4] = true;
            
            }

            if (!validator.isValidPhoneNumber(admin.getNoHp())) {

                messageBuilder.append("\n Incorrect Phone Number input !"
                        + "\n\t-> The phone number format should be like this:"
                        + "\n\t-> +62 82123456789"
                        + "\n\t-> Contains numerical digit only"
                        + "\n\t-> With maximum length: 14 digits");

                vManageAdmin.getTxtNoHpAdmin().setBackground(errorColor);
                isEachFieldsValid[5] = false;
            
            } else {
            
                isEachFieldsValid[5] = true;
            
            }

            if (!validator.isValidDate(admin.getTglLahir())) {

                messageBuilder.append("\n Incorrect Date Format input !"
                        + "\n\t-> Date of birth format should be like this: "
                        + "\n\t-> e.g: 1970-01-31"
                        + "format: yyyy-mm-dd.");

                vManageAdmin.getDcTglLahir().setBackground(errorColor);
                isEachFieldsValid[6] = false;
            
            } else {
            
                isEachFieldsValid[6] = true;
            
            }

            if (admin.getAlamat().isEmpty()) {

                messageBuilder.append("\n Address field can't be blank!");

                vManageAdmin.getTxtAlamatAdmin().setBackground(errorColor);
                isEachFieldsValid[7] = false;
            
            } else {
            
                isEachFieldsValid[7] = true;
            
            }

            if (admin.getJenisKelamin().isEmpty()
                    || admin.getJenisKelamin().equals("- Choose -")) {

                messageBuilder.append("\n Please select your gender !");

                vManageAdmin.getCmbJenisKelamin().setBackground(errorColor);
                isEachFieldsValid[8] = false;
            
            } else {
            
                isEachFieldsValid[8] = true;
            
            }

            vManageAdmin.getTxtAreaValidation().setText(messageBuilder.toString());

            if (isEachFieldsValid[0] == true
                    && isEachFieldsValid[1] == true
                    && isEachFieldsValid[2] == true
                    && isEachFieldsValid[3] == true
                    && isEachFieldsValid[4] == true
                    && isEachFieldsValid[5] == true
                    && isEachFieldsValid[6] == true
                    && isEachFieldsValid[7] == true
                    && isEachFieldsValid[8] == true) {
            
                isAllValid = true;
            
            } else {
            
                isAllValid = false;
            
            }

        }
        
        if (isAllValid == true) {
            
            if (isInsert) {
                this.insert();
                this.reset();
            } else {
                this.update();
                this.reset();
            }
            
        } else {
            
            JOptionPane.showMessageDialog(vManageAdmin, "There's something wrong");
        
        }

    }

    public void insert() {
        ModelAdmin admin = new ModelAdmin();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tglLahir = sdf.format(vManageAdmin.getDcTglLahir().getDate());

        admin.setNama(vManageAdmin.getTxtNamaAdmin().getText());
        admin.setNIK(vManageAdmin.getTxtNikAdmin().getText());
        admin.setUsername(vManageAdmin.getTxtUsernameAdmin().getText());
        admin.setJenisKelamin(vManageAdmin.getCmbJenisKelamin().getSelectedItem().toString());
        admin.setPassword(String.valueOf(vManageAdmin.getTxtPasswordAdmin().getPassword()));
        admin.setEmail(vManageAdmin.getTxtEmailAdmin().getText());
        admin.setAlamat(vManageAdmin.getTxtAlamatAdmin().getText());
        admin.setTglLahir(tglLahir);
        admin.setNoHp(vManageAdmin.getTxtNoHpAdmin().getText());

        String newFileName = func.uploadPhotoAdmin(vManageAdmin, admin);
        admin.setPhoto(newFileName);

        interfaceAdmin.insert(admin);
        JOptionPane.showMessageDialog(vManageAdmin, "New admin added !");
    }

    public void update() {
        ModelAdmin admin = new ModelAdmin();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tglLahir = sdf.format(vManageAdmin.getDcTglLahir().getDate());

        admin.setId(Integer.parseInt(vManageAdmin.getTxtIdAdmin().getText()));
        admin.setNama(vManageAdmin.getTxtNamaAdmin().getText());
        admin.setNIK(vManageAdmin.getTxtNikAdmin().getText());
        admin.setUsername(vManageAdmin.getTxtUsernameAdmin().getText());
        admin.setJenisKelamin(vManageAdmin.getCmbJenisKelamin().getSelectedItem().toString());
        admin.setPassword(String.valueOf(vManageAdmin.getTxtPasswordAdmin().getPassword()));
        admin.setEmail(vManageAdmin.getTxtEmailAdmin().getText());
        admin.setAlamat(vManageAdmin.getTxtAlamatAdmin().getText());
        admin.setTglLahir(tglLahir);
        admin.setNoHp(vManageAdmin.getTxtNoHpAdmin().getText());

        String newFileName = func.uploadPhotoAdmin(vManageAdmin, admin);
        admin.setPhoto(newFileName);

        interfaceAdmin.update(admin);
        JOptionPane.showMessageDialog(vManageAdmin, "update success !");
    }

    public void delete() {
        if (vManageAdmin.getTxtIdAdmin().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(vManageAdmin, "No data deleted....? ", null, JOptionPane.ERROR_MESSAGE);
            return;
        }

        int row = Integer.parseInt(vManageAdmin.getTxtIdAdmin().getText());

        interfaceAdmin.delete(row);
        JOptionPane.showMessageDialog(null, "Succesfully deleted !");
    }

    public void bindingTable() {
        listAdmin = interfaceAdmin.getAll();
        vManageAdmin.getTableAdmin().setModel(new TableModelAdmin(listAdmin));
    }

    public void getData() {

        String cat = vManageAdmin.getCmbCategory().getSelectedItem().toString();
        String keyword = vManageAdmin.getTxtSearch().getText();
        String tableField = null;

        if (cat.equals("ID")) {
            tableField = "id_admin";
        } else if (cat.equals("NAME")) {
            tableField = "nama_admin";
        } else if (cat.equals("NIK")) {
            tableField = "nik";
        } else if (cat.equals("USERNAME")) {
            tableField = "username_admin";
        } else if (cat.equals("GENDER")) {
            tableField = "jenis_kelamin";
        } else if (cat.equals("EMAIL")) {
            tableField = "email";
        } else if (cat.equals("PHONE_NO")) {
            tableField = "no_hp";
        } else if (cat.equals("ADDRESS")) {
            tableField = "alamat";
        }

        interfaceAdmin.search(tableField, keyword);
        bindingSearch(tableField, keyword);

    }

    public void getDataField() {
        int row = vManageAdmin.getTableAdmin().getSelectedRow();

        if (row != -1) {
            try {
                java.util.Date tglLahir = new SimpleDateFormat("yyyy-MM-dd").parse(listAdmin.get(row).getTglLahir());
                vManageAdmin.getTxtIdAdmin().setText(String.valueOf(listAdmin.get(row).getId()));
                vManageAdmin.getTxtNamaAdmin().setText(listAdmin.get(row).getNama());
                vManageAdmin.getTxtNikAdmin().setText(listAdmin.get(row).getNIK());
                vManageAdmin.getTxtUsernameAdmin().setText(listAdmin.get(row).getUsername());
                vManageAdmin.getTxtPasswordAdmin().setText(listAdmin.get(row).getPassword());
                vManageAdmin.getDcTglLahir().setDate(tglLahir);
                vManageAdmin.getTxtPhotoAdminPath().setText(listAdmin.get(row).getPhoto());
                vManageAdmin.getCmbJenisKelamin().setSelectedItem(listAdmin.get(row).getJenisKelamin());
                vManageAdmin.getTxtNoHpAdmin().setText(listAdmin.get(row).getNoHp());
                vManageAdmin.getTxtEmailAdmin().setText(listAdmin.get(row).getEmail());
                vManageAdmin.getTxtAlamatAdmin().setText(listAdmin.get(row).getAlamat());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void bindingSearch(String cat, String keyword) {
        listAdmin = interfaceAdmin.search(cat, keyword);
        vManageAdmin.getTableAdmin().setModel(new TableModelAdmin(listAdmin));
    }

}
