/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.database.DBConnection;
import com.nusabank.model.ModelTransaksiPPOB;
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
public class TransaksiPpobDAO implements InterfaceTrxPpobDAO {

    private List<ModelTransaksiPPOB> listTrxPPOB;
    
    @Override
    public void insert(ModelTransaksiPPOB mTrxPPOB) {
     try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement("INSERT INTO transaksi_ppob "
                    + "(jenis_transaksi, nominal, tgl_transaksi, no_target,"
                    + "ket_transaksi, id_rekening)"
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)");
            statement.setString(1, mTrxPPOB.getJenisTransaksi());
            statement.setInt(2, mTrxPPOB.getNominal());
            statement.setString(3, mTrxPPOB.getTglTransaksi());
            statement.setInt(4, mTrxPPOB.getNoTarget());
            statement.setString(5, mTrxPPOB.getKetTransaksi());
            statement.executeUpdate();
            statement.close();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
            Logger.getLogger(TransaksiPpobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ModelTransaksiPPOB mTrxPPOB) {
    try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""
                    + "UPDATE transaksi_ppob SET "
                    + "jenis_transaksi=?, nominal=?, tgl_transaksi=?,"
                    + "no_target=?, ket_transaksi=?"
                    + "  WHERE id_transaksi=?");
            
            statement.setString(1, mTrxPPOB.getJenisTransaksi());
            statement.setInt(2, mTrxPPOB.getNominal());
            statement.setString(3, mTrxPPOB.getTglTransaksi());
            statement.setInt(4, mTrxPPOB.getNoTarget());
            statement.setString(5, mTrxPPOB.getKetTransaksi());
            statement.setInt(6, mTrxPPOB.getIdTransaksi());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPpobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
    try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""
                    + "DELETE FROM transaksi_ppob WHERE id_transaksi=?");
            
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPpobDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public List<ModelTransaksiPPOB> getAll() {
    listTrxPPOB = new ArrayList<ModelTransaksiPPOB>();
        
        try {
            
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM transaksi_ppob");
            
            while (result.next()) { 
                ModelTransaksiPPOB mTrxPPOb = new ModelTransaksiPPOB();
                mTrxPPOb.setIdTransaksi(result.getInt("id_transaksi"));
                mTrxPPOb.setJenisTransaksi(result.getString("jenis_transaksi"));
                mTrxPPOb.setNominal(result.getInt("nominal"));
                mTrxPPOb.setTglTransaksi(result.getString("tgl_transaksi"));
                mTrxPPOb.setNoTarget(result.getInt("no_target"));
                mTrxPPOb.setKetTransaksi(result.getString("ket_transaksi"));
                listTrxPPOB.add(mTrxPPOb);
            }
            
            
            statement.close();
            result.close();
            return listTrxPPOB;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPpobDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ModelTransaksiPPOB> search(String category, String search) {
    listTrxPPOB = new ArrayList<ModelTransaksiPPOB>();
        
        try {
            String query = "SELECT * FROM transaksi_ppob WHERE "+category+" LIKE '%"+search+"%'";
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) { 
                ModelTransaksiPPOB mTrxPPOb = new ModelTransaksiPPOB();
                mTrxPPOb.setIdTransaksi(result.getInt("id_transaksi"));
                mTrxPPOb.setJenisTransaksi(result.getString("jenis_transaksi"));
                mTrxPPOb.setNominal(result.getInt("nominal"));
                mTrxPPOb.setTglTransaksi(result.getString("tgl_transaksi"));
                mTrxPPOb.setNoTarget(result.getInt("no_target"));
                mTrxPPOb.setKetTransaksi(result.getString("ket_transaksi"));
                listTrxPPOB.add(mTrxPPOb);
            }
            
            
            statement.close();
            result.close();
            return listTrxPPOB;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPpobDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ModelTransaksiPPOB> getById(int id) {
    listTrxPPOB = new ArrayList<ModelTransaksiPPOB>();
        
        try {
            String query = "SELECT * FROM transaksi_ppob WHERE id_transaksi='"+id+"'";
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) { 
                ModelTransaksiPPOB mTrxPPOb = new ModelTransaksiPPOB();
                mTrxPPOb.setIdTransaksi(result.getInt("id_transaksi"));
                mTrxPPOb.setJenisTransaksi(result.getString("jenis_transaksi"));
                mTrxPPOb.setNominal(result.getInt("nominal"));
                mTrxPPOb.setTglTransaksi(result.getString("tgl_transaksi"));
                mTrxPPOb.setNoTarget(result.getInt("no_target"));
                mTrxPPOb.setKetTransaksi(result.getString("ket_transaksi"));
                listTrxPPOB.add(mTrxPPOb);
            }
            
            
            statement.close();
            result.close();
            return listTrxPPOB;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPpobDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
