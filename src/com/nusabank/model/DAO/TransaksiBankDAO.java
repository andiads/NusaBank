/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.database.DBConnection;
import com.nusabank.model.ModelTransaksiBank;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class TransaksiBankDAO implements InterfaceTrxBankDAO {
    
    private List<ModelTransaksiBank> listTrxBank;
    
    @Override
    public void insert(ModelTransaksiBank mtb) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement("INSERT INTO transaksi_bank "
                    + "(jenis_transaksi, nominal, tgl_transaksi, kode_bank, rek_tujuan,"
                    + "biaya_admin, ket_transaksi, id_rekening)"
                    + "VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, mtb.getJenisTransaksi());
            statement.setInt(2, mtb.getNominal());
            statement.setString(3, mtb.getTglTransaksi());
            statement.setInt(4, mtb.getKodeBank());
            statement.setInt(5, mtb.getRekTujuan());
            statement.setInt(6, mtb.getBiayaAdmin());
            statement.setString(7, mtb.getKetTransaksi());
            statement.setInt(8, mtb.getIdRekening());
            statement.executeUpdate();
            statement.close();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
            Logger.getLogger(TransaksiBankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(ModelTransaksiBank mtb) {
    try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""
                    + "UPDATE transaksi_bank SET "
                    + "jenis_transaksi=?, nominal=?, tgl_transaksi=?,"
                    + "kode_bank=?, rek_tujuan=?, biaya_admin=?,"
                    + "ket_transaksi=?"
                    + "  WHERE id_transaksi=? AND id_rekening=?");
            
            statement.setString(1, mtb.getJenisTransaksi());
            statement.setInt(2, mtb.getNominal());
            statement.setString(3, mtb.getTglTransaksi());
            statement.setInt(4, mtb.getKodeBank());
            statement.setInt(5, mtb.getRekTujuan());
            statement.setInt(6, mtb.getBiayaAdmin());
            statement.setString(7, mtb.getKetTransaksi());
            statement.setInt(8, mtb.getIdTransaksi());
            statement.setInt(9, mtb.getIdRekening());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiBankDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""
                    + "DELETE FROM transaksi_bank WHERE id_transaksi=?");
            
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiBankDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public List<ModelTransaksiBank> getAll() {
    listTrxBank = new ArrayList<ModelTransaksiBank>();
        
        try {
            
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM transaksi_bank");
            
            while (result.next()) { 
                ModelTransaksiBank mtb = new ModelTransaksiBank();
                mtb.setIdTransaksi(result.getInt("id_transaksi"));
                mtb.setJenisTransaksi(result.getString("jenis_transaksi"));
                mtb.setNominal(result.getInt("nominal"));
                mtb.setTglTransaksi(result.getString("tgl_transaksi"));
                mtb.setKodeBank(result.getInt("kode_bank"));
                mtb.setRekTujuan(result.getInt("rek_tujuan"));
                mtb.setBiayaAdmin(result.getInt("biaya_admin"));
                mtb.setKetTransaksi(result.getString("ket_transaksi"));
                mtb.setIdRekening(result.getInt("id_rekening"));
                listTrxBank.add(mtb);
            }
            
            
            statement.close();
            result.close();
            return listTrxBank;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiBankDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }

    @Override
    public List<ModelTransaksiBank> search(String category, String search) {
        listTrxBank = new ArrayList<ModelTransaksiBank>();
        
        try {
            String query = "SELECT * FROM transaksi_bank WHERE "+category+" LIKE '%"+search+"%'";
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) { 
                ModelTransaksiBank mtb = new ModelTransaksiBank();
                mtb.setIdTransaksi(result.getInt("id_transaksi"));
                mtb.setJenisTransaksi(result.getString("jenis_transaksi"));
                mtb.setNominal(result.getInt("nominal"));
                mtb.setTglTransaksi(result.getString("tgl_transaksi"));
                mtb.setKodeBank(result.getInt("kode_bank"));
                mtb.setRekTujuan(result.getInt("rek_tujuan"));
                mtb.setBiayaAdmin(result.getInt("biaya_admin"));
                mtb.setKetTransaksi(result.getString("ket_transaksi"));
                mtb.setIdRekening(result.getInt("id_rekening"));
                listTrxBank.add(mtb);
            }
            
            
            statement.close();
            result.close();
            return listTrxBank;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiBankDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ModelTransaksiBank> getById(int id) {
    listTrxBank = new ArrayList<ModelTransaksiBank>();
        
        try {
            String query = "SELECT * FROM transaksi_bank WHERE id_transaksi='"+id+"'";
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) { 
                ModelTransaksiBank mtb = new ModelTransaksiBank();
                mtb.setIdTransaksi(result.getInt("id_transaksi"));
                mtb.setJenisTransaksi(result.getString("jenis_transaksi"));
                mtb.setNominal(result.getInt("nominal"));
                mtb.setTglTransaksi(result.getString("tgl_transaksi"));
                mtb.setKodeBank(result.getInt("kode_bank"));
                mtb.setRekTujuan(result.getInt("rek_tujuan"));
                mtb.setBiayaAdmin(result.getInt("biaya_admin"));
                mtb.setKetTransaksi(result.getString("ket_transaksi"));
                mtb.setIdRekening(result.getInt("id_rekening"));
                listTrxBank.add(mtb);
            }
            
            
            statement.close();
            result.close();
            return listTrxBank;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiBankDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public String getLastId() {
        String lastId = "0";
        String qLastId = "SELECT MAX(id_transaksi) AS last_id FROM transaksi_bank";
        
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(qLastId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                lastId = rs.getString("last_id");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RekeningDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastId;
    }
}
