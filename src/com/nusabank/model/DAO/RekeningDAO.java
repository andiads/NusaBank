/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.database.DBConnection;
import com.nusabank.model.ModelRekening;
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
public class RekeningDAO implements InterfaceRekeningDAO {
    
    List<ModelRekening> listRekening;
    
    @Override
    public void insert(ModelRekening rekening) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement("INSERT INTO rekening "
                    + "(no_rekening, saldo, jenis_rekening, no_pin)"
                    + "VALUES (?, ?, ?, ?)");
            statement.setString(1, rekening.getNoRekening());
            statement.setInt(2, rekening.getSaldo());
            statement.setString(3, rekening.getJenisRekening());
            statement.setInt(4, rekening.getNoPin());
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
            Logger.getLogger(RekeningDAO.class.getName()).log(Level.SEVERE, null, ex);
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ModelRekening rekening) {
    try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""
                    + "UPDATE rekening SET "
                    + "saldo=?, jenis_rekening=?, no_pin=?"
                    + "  WHERE id_rekening=? AND no_rekening=?");
            
            statement.setInt(1, rekening.getSaldo());
            statement.setString(2, rekening.getJenisRekening());
            statement.setInt(3, rekening.getNoPin());
            statement.setInt(4, rekening.getIdRekening());
            statement.setString(5, rekening.getNoRekening());
            
          
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(RekeningDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
    try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""
                    + "DELETE FROM rekening WHERE id_rekening=?");
            
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(RekeningDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public List<ModelRekening> getAll() {
        listRekening = new ArrayList<ModelRekening>();
        
        try {
            
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM rekening");
            
            while (result.next()) { 
                ModelRekening rekening = new ModelRekening();
                rekening.setIdRekening(result.getInt("id_rekening"));
                rekening.setNoRekening(result.getString("no_rekening"));
                rekening.setSaldo(result.getInt("saldo"));
                rekening.setJenisRekening(result.getString("jenis_rekening"));
                rekening.setNoPin(result.getInt("no_pin"));
                
                listRekening.add(rekening);
            }
            
            
            statement.close();
            result.close();
            return listRekening;
        } catch (SQLException ex) {
            Logger.getLogger(RekeningDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ModelRekening> search(String category, String search) {
        listRekening = new ArrayList<ModelRekening>();
        
        try {
            String query = "SELECT * FROM rekening WHERE "+category+" LIKE '%"+search+"%'";
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) { 
                ModelRekening rekening = new ModelRekening();
                rekening.setIdRekening(result.getInt("id_rekening"));
                rekening.setNoRekening(result.getString("no_rekening"));
                rekening.setSaldo(result.getInt("saldo"));
                rekening.setJenisRekening(result.getString("jenis_rekening"));
                rekening.setNoPin(result.getInt("no_pin"));
                
                listRekening.add(rekening);
            }
            
            
            statement.close();
            result.close();
            return listRekening;
        } catch (SQLException ex) {
            Logger.getLogger(RekeningDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ModelRekening> getById(int id) {
        
        try {
            String query = "SELECT * FROM rekening WHERE id_rekening='"+id+"'";
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while (result.next()) { 
                ModelRekening rekening = new ModelRekening();
                rekening.setIdRekening(result.getInt("id_rekening"));
                rekening.setNoRekening(result.getString("no_rekening"));
                rekening.setSaldo(result.getInt("saldo"));
                rekening.setJenisRekening(result.getString("jenis_rekening"));
                rekening.setNoPin(result.getInt("no_pin"));
                
                listRekening.add(rekening);
            }
            
            
            statement.close();
            result.close();
            return listRekening;
        } catch (SQLException ex) {
            Logger.getLogger(RekeningDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getLastId() {
        String lastId = "0";
        String qLastId = "SELECT MAX(id_rekening) AS last_id FROM rekening";
        
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

    @Override
    public int getNoPIN(int idRek) {
        ModelRekening rekening = new ModelRekening();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT * FROM rekening WHERE id_rekening="+idRek);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                rekening.setNoPin(rs.getInt("no_pin"));
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rekening.getNoPin();
    }
    
    @Override
    public String getNoRek(int idRek) {
        ModelRekening rekening = new ModelRekening();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT * FROM rekening WHERE id_rekening="+idRek);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                rekening.setNoRekening(rs.getString("no_rekening"));
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rekening.getNoRekening();
    }
    
    @Override
    public int getSaldo(int idRek) {
        ModelRekening rekening = new ModelRekening();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT * FROM rekening WHERE id_rekening="+idRek);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                rekening.setSaldo(rs.getInt("saldo"));
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rekening.getSaldo();
    }
    
    @Override
    public void trimSaldo(int id, int nominal) {
        ModelRekening rekening = new ModelRekening();
        rekening.setIdRekening(id);
        int currentSaldo;
        int updateSaldo;
        try {
            String qSel = "SELECT  * FROM rekening WHERE id_rekening = "+id;
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(qSel);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                rekening.setIdRekening(rs.getInt("id_rekening"));
                rekening.setNoRekening(rs.getString("no_rekening"));
                rekening.setSaldo(rs.getInt("saldo"));
            }
            
            currentSaldo = rekening.getSaldo();
            updateSaldo = currentSaldo - nominal;
            rekening.setSaldo(updateSaldo);
            
            String q = "UPDATE rekening SET saldo=? WHERE id_rekening=?";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(q);
            ps.setInt(1,rekening.getSaldo());
            ps.setInt(2, rekening.getIdRekening());
            ps.executeUpdate();
            ps.close();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void doSaving(String id, int nominal) {
        ModelRekening rekening = new ModelRekening();
        rekening.setNoRekening(id);
        int currentSaldo;
        int updateSaldo;
        try {
            String qSel = "SELECT  * FROM rekening WHERE no_rekening = "+id;
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(qSel);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                rekening.setSaldo(rs.getInt("saldo"));
                rekening.setNoRekening(rs.getString("no_rekening"));
            }
            
            currentSaldo = rekening.getSaldo();
            updateSaldo = currentSaldo + nominal;
            rekening.setSaldo(updateSaldo);
            
            String q = "UPDATE rekening SET saldo=? WHERE no_rekening=?";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(q);
            ps.setInt(1, rekening.getSaldo());
            ps.setString(2,rekening.getNoRekening());
            ps.executeUpdate();
            ps.close();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void doWithDraw(String id, int nominal) {
        ModelRekening rekening = new ModelRekening();
        rekening.setNoRekening(id);
        int currentSaldo;
        int updateSaldo;
        try {
            String qSel = "SELECT  * FROM rekening WHERE no_rekening = "+id;
            PreparedStatement pst = DBConnection.getConnection().prepareStatement(qSel);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                rekening.setSaldo(rs.getInt("saldo"));
                rekening.setNoRekening(rs.getString("no_rekening"));
            }
            
            currentSaldo = rekening.getSaldo();
            updateSaldo = currentSaldo - nominal;
            rekening.setSaldo(updateSaldo);
            
            String q = "UPDATE rekening SET saldo=? WHERE no_rekening=?";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(q);
            ps.setInt(1, rekening.getSaldo());
            ps.setString(2,rekening.getNoRekening());
            ps.executeUpdate();
            ps.close();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void doChangePin(ModelRekening rekening) {
    try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""
                    + "UPDATE rekening SET "
                    + "no_pin=?"
                    + "  WHERE no_rekening=? AND no_pin=?");
            
            statement.setInt(1, rekening.getNoPin());
            statement.setString(2, rekening.getNoRekening());
            statement.setInt(3, rekening.getIdRekening());;
            
          
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(RekeningDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
