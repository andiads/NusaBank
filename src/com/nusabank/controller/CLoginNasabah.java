/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import com.nusabank.view.viewNasabah.ViewMenuNasabah;
import com.nusabank.model.database.DBConnection;
import com.nusabank.view.viewLogin.ViewLoginNasabah;
import com.nusabank.model.ModelNasabah;
import com.nusabank.model.DAO.InterfaceNasabahDAO;
import com.nusabank.model.DAO.NasabahDAO;
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
public class CLoginNasabah {

    private final ViewLoginNasabah vLoginNasabah;
    private ModelNasabah nasabah;
    private List<ModelNasabah> listNasabah;
    private String jenisRekening;


    public CLoginNasabah(ViewLoginNasabah vLoginNasabah) {
        this.vLoginNasabah = vLoginNasabah;
    }

    public boolean doLogin(String username, String password) throws IOException {
        boolean results = false;
        try {
            String sql = "SELECT*FROM nasabah where username_nasabah=? AND password_nasabah=?";
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                try {
                    nasabah = new ModelNasabah();
                    nasabah.setId(rs.getInt("id_nasabah"));
                    nasabah.setUsername(rs.getString("username_nasabah"));
                    nasabah.setNama(rs.getString("nama"));
                    nasabah.setNik(rs.getString("nik"));
                    nasabah.setTglLahir(rs.getString("tgl_lahir"));
                    nasabah.setJenisKelamin(rs.getString("jenis_kelamin"));
                    nasabah.setIdRekening(rs.getInt("id_rekening"));
                    nasabah.setPhoto(rs.getString("photo"));

                    PreparedStatement stmtJenisRek = DBConnection.getConnection()
                            .prepareStatement("select jenis_rekening from rekening where id_rekening='"
                                    + nasabah.getIdRekening() + "'");
                    ResultSet resultJenisRek = stmtJenisRek.executeQuery();

                    if (resultJenisRek.next()) {
                        this.jenisRekening = resultJenisRek.getString("jenis_rekening");
                    }

                    JOptionPane.showMessageDialog(null, "Login Sukses!");
                    System.out.println(nasabah.getPhoto());
                    ViewMenuNasabah vMenuNasabah = new ViewMenuNasabah();
                    vMenuNasabah.getLabelUsername().setText(nasabah.getUsername());
                    vMenuNasabah.getLabelNamaWelcome().setText(nasabah.getNama());
                    vMenuNasabah.getLabelNIK().setText(String.valueOf(nasabah.getNik()));
                    vMenuNasabah.getLabelGender().setText(nasabah.getJenisKelamin());
                    vMenuNasabah.getLabelDOB().setText(nasabah.getTglLahir().toString());
                    vMenuNasabah.getLbJenisRek().setText(this.jenisRekening);
                    vMenuNasabah.getLabelIdNasabah().setText(String.valueOf(nasabah.getId()));
                    
                    BufferedImage iconAvatar = ImageIO.read(this.getClass().getResourceAsStream("../"+nasabah.getPhoto()));
                    vMenuNasabah.getLabelAvatar().setIcon(new ImageIcon(iconAvatar.getScaledInstance(128, 128, Image.SCALE_DEFAULT)));
                    
                    BufferedImage iconLogo = ImageIO.read(getClass().getResource("../res/logo/nb.jpeg"));
                    vMenuNasabah.getLogoPT().setIcon(new ImageIcon(iconLogo.getScaledInstance(240, 100, Image.SCALE_SMOOTH)));
                    vMenuNasabah.setVisible(true);
                    
                    results = true;
                } catch (IOException ioe) {
                    System.err.println(ioe);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Login Gagal!" + username + " " + password);
                results = false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        
        return results;
    }

}
