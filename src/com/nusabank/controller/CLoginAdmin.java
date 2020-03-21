/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.view.viewAdmin.ViewMenuAdmin;
import com.nusabank.model.database.DBConnection;
import com.nusabank.model.ModelAdmin;
import com.nusabank.model.DAO.InterfaceAdminDAO;
import com.nusabank.model.DAO.AdminDAO;
import com.nusabank.view.viewLogin.ViewLoginAdmin;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class CLoginAdmin {

    private final ViewLoginAdmin vLoginAdmin;
    
    private ModelAdmin admin;


    public CLoginAdmin(ViewLoginAdmin vLoginAdmin) {
        this.vLoginAdmin = vLoginAdmin;
    }
    
    public void doLogin(String username, String password){
        try{
            String sql = "SELECT*FROM admin where username_admin=? AND password_admin=?";
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                    try {
                    admin = new ModelAdmin();
                    admin.setId(rs.getInt("id_admin"));
                    admin.setNama(rs.getString("nama_admin"));
                    admin.setUsername(rs.getString("username_admin"));
                    admin.setJenisKelamin(rs.getString("jenis_kelamin"));
                    admin.setNoHp(rs.getString("no_hp"));
                    admin.setPhoto(rs.getString("photo"));
                    admin.setTglLahir(rs.getString("tgl_lahir"));
                    admin.setNIK(rs.getString("nik"));
                    admin.setEmail(rs.getString("email"));
                    admin.setAlamat(rs.getString("alamat"));
                    
                    String photoAdmin = admin.getPhoto();
                    if ((photoAdmin.equals(null) || photoAdmin.equals("")) 
                          && (admin.getJenisKelamin().equals("Male"))){
                        photoAdmin = "res/admin_photos/adminM_NusaBank_default.png";
                    } else if ((photoAdmin.equals(null) || photoAdmin.equals(""))
                          && (admin.getJenisKelamin().equals("Female"))){
                        photoAdmin = "res/admin_photos/adminF_NusaBank_default.png";
                    }
                    
                    ViewMenuAdmin vMenuAdmin = new ViewMenuAdmin();
                    vMenuAdmin.getLbDobAdmin().setText(admin.getTglLahir());
                    vMenuAdmin.getLbGenderAdmin().setText(admin.getJenisKelamin());
                    vMenuAdmin.getLbHeadNamaAdm().setText(admin.getNama());
                    vMenuAdmin.getLbIdAdmin().setText(String.valueOf(admin.getId()));
                    vMenuAdmin.getLbNamaAdmin().setText(admin.getNama());
                    vMenuAdmin.getLbNikAdmin().setText(admin.getNIK());
                    vMenuAdmin.getLbNoHpAdmin().setText(admin.getNoHp());
                    vMenuAdmin.getLbUsernameAdmin().setText(admin.getUsername());
                    vMenuAdmin.getLbEmail().setText(admin.getEmail());
                    
                    BufferedImage iconAvatar = ImageIO.read(this.getClass().getResourceAsStream("../"+photoAdmin));
                    vMenuAdmin.getLbAvatarAdmin().setIcon(new ImageIcon(iconAvatar.getScaledInstance(128, 128, Image.SCALE_DEFAULT)));
                    
                    BufferedImage iconLogo = ImageIO.read(getClass().getResource("../res/logo/nb.jpeg"));
                    vMenuAdmin.getLbLogoPT().setIcon(new ImageIcon(iconLogo.getScaledInstance(240, 100, Image.SCALE_SMOOTH)));
                    
                    JOptionPane.showMessageDialog(null, "Login Sukses!");
                    
                    vMenuAdmin.setVisible(true);
                    } catch(IOException ioe) {
                        ioe.printStackTrace();
                    }
               
            } else {
                JOptionPane.showMessageDialog(null, "Login Gagal!"+username+" "+password);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
    }
}
