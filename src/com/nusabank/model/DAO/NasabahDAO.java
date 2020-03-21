/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.database.DBConnection;
import com.nusabank.model.ModelNasabah;
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
public class NasabahDAO implements InterfaceNasabahDAO {
    
    List<ModelNasabah> listNasabah;
    
    @Override
    public void insert(ModelNasabah nasabah) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement("INSERT INTO nasabah "
                    + "(nama, nik, tgl_lahir, alamat, photo, jenis_kelamin,"
                    + "pekerjaan, alamat_kantor, pendapatan, no_hp, status, nama_ibu, username_nasabah,"
                    + "password_nasabah, tgl_pembuatan, id_rekening)"
                    + "VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, nasabah.getNama());
            statement.setInt(2, nasabah.getNik());
            statement.setString(3, nasabah.getTglLahir());
            statement.setString(4, nasabah.getAlamatRumah());
            statement.setString(5, nasabah.getPhoto());
            statement.setString(6, nasabah.getJenisKelamin());
            statement.setString(7, nasabah.getPekerjaan());
            statement.setString(8, nasabah.getAlamatKantor());
            statement.setInt(9, nasabah.getPendapatan());
            statement.setString(10, nasabah.getNoHp());
            statement.setString(11, nasabah.getStatus());
            statement.setString(12, nasabah.getNamaIbu());
            statement.setString(13, nasabah.getUsername());
            statement.setString(14, nasabah.getPassword());
            statement.setString(15, nasabah.getTglPembuatan());
            statement.setInt(16, nasabah.getIdRekening());
            
            statement.executeUpdate();
            statement.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
            Logger.getLogger(NasabahDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void update(ModelNasabah nasabah) {
    try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""
                    + "UPDATE nasabah SET "
                    + "id_nasabah=?, nama=?, nik=?, tgl_lahir=?,"
                    + "alamat=?, photo=?, jenis_kelamin=?,"
                    + "pekerjaan=?, alamat_kantor=?, pendapatan=?,"
                    + "no_hp=?, status=?, nama_ibu=?,"
                    + "username_nasabah=?, password_nasabah=?,"
                    + "id_rekening=?"
                    + "  WHERE id_nasabah=?");
            
            statement.setInt(1, nasabah.getId());
            statement.setString(2, nasabah.getNama());
            statement.setInt(3, nasabah.getNik());
            statement.setString(4, nasabah.getTglLahir());
            statement.setString(5, nasabah.getAlamatRumah());
            statement.setString(6, nasabah.getPhoto());
            statement.setString(7, nasabah.getJenisKelamin());
            statement.setString(8, nasabah.getPekerjaan());
            statement.setString(9, nasabah.getAlamatKantor());
            statement.setInt(10, nasabah.getPendapatan());
            statement.setString(11, nasabah.getNoHp());
            statement.setString(12, nasabah.getStatus());
            statement.setString(13, nasabah.getNamaIbu());
            statement.setString(14, nasabah.getUsername());
            statement.setString(15, nasabah.getPassword());
            statement.setInt(16, nasabah.getIdRekening());
            statement.setInt(17, nasabah.getId());
            
          
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(NasabahDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""
                    + "DELETE FROM nasabah WHERE id_nasabah=?");
            
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(NasabahDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ModelNasabah> getAll() {
        listNasabah = new ArrayList<ModelNasabah>();
        
        try {
            
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM nasabah");
            
            while (result.next()) { 
                ModelNasabah nasabah = new ModelNasabah();
                nasabah.setId(result.getInt("id_nasabah"));
                nasabah.setNama(result.getString("nama"));
                nasabah.setNik(result.getInt("nik"));
                nasabah.setTglLahir(result.getString("tgl_lahir"));
                nasabah.setAlamatRumah(result.getString("alamat"));
                nasabah.setPhoto(result.getString("photo"));
                nasabah.setJenisKelamin(result.getString("jenis_kelamin"));
                nasabah.setPekerjaan(result.getString("pekerjaan"));
                nasabah.setAlamatKantor(result.getString("alamat_kantor"));
                nasabah.setPendapatan(result.getInt("pendapatan"));
                nasabah.setNoHp(result.getString("no_hp"));
                nasabah.setStatus(result.getString("status"));
                nasabah.setNamaIbu(result.getString("nama_ibu"));
                nasabah.setUsername(result.getString("username_nasabah"));
                nasabah.setPassword(result.getString("password_nasabah"));
                nasabah.setTglPembuatan(result.getString("tgl_pembuatan"));
                nasabah.setIdRekening(result.getInt("id_rekening"));
                
                
                listNasabah.add(nasabah);
            }
            
            
            statement.close();
            result.close();
            return listNasabah;
        } catch (SQLException ex) {
            Logger.getLogger(NasabahDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }       
    }

    @Override
    public List<ModelNasabah> search(String category, String search) {
        listNasabah = new ArrayList<ModelNasabah>();
        try {
            String query = "SELECT * FROM nasabah WHERE "+category+" LIKE '%"+search+"%'";
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                ModelNasabah nasabah = new ModelNasabah();
                nasabah.setId(result.getInt("id_nasabah"));
                nasabah.setNama(result.getString("nama"));
                nasabah.setNik(result.getInt("nik"));
                nasabah.setJenisKelamin(result.getString("jenis_kelamin"));
                nasabah.setUsername(result.getString("username_nasabah"));
                nasabah.setPassword(result.getString("password_nasabah"));
                nasabah.setIdRekening(result.getInt("id_rekening"));
                nasabah.setTglLahir(result.getString("tgl_lahir"));
                nasabah.setAlamatRumah(result.getString("alamat"));
                nasabah.setAlamatKantor(result.getString("alamat_kantor"));
                nasabah.setNoHp(result.getString("no_hp"));
                nasabah.setPekerjaan(result.getString("pekerjaan"));
                nasabah.setPendapatan(result.getInt("pendapatan"));
                nasabah.setStatus(result.getString("status"));
                nasabah.setPhoto(result.getString("photo"));
                nasabah.setNamaIbu(result.getString("nama_ibu"));
                nasabah.setTglPembuatan(result.getString("tgl_pembuatan"));
                
                listNasabah.add(nasabah);
            }
            
            statement.close();
            result.close();
            return listNasabah;
        } catch (SQLException ex) {
            Logger.getLogger(NasabahDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ModelNasabah> getById(int id) {
        listNasabah = new ArrayList<ModelNasabah>();
        try {
            String query = "SELECT * FROM nasabah WHERE id_nasabah = '"+id+"'";
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                ModelNasabah nasabah = new ModelNasabah();
                nasabah.setId(result.getInt("id_nasabah"));
                nasabah.setNama(result.getString("nama"));
                nasabah.setNik(result.getInt("nik"));
                nasabah.setJenisKelamin(result.getString("jenis_kelamin"));
                nasabah.setUsername(result.getString("username_nasabah"));
                nasabah.setPassword(result.getString("password_nasabah"));
                nasabah.setIdRekening(result.getInt("id_rekening"));
                nasabah.setTglLahir(result.getString("tgl_lahir"));
                nasabah.setAlamatRumah(result.getString("alamat"));
                nasabah.setAlamatKantor(result.getString("alamat_kantor"));
                nasabah.setNoHp(result.getString("no_hp"));
                nasabah.setPekerjaan(result.getString("pekerjaan"));
                nasabah.setPendapatan(result.getInt("pendapatan"));
                nasabah.setStatus(result.getString("status"));
                nasabah.setPhoto(result.getString("photo"));
                nasabah.setNamaIbu(result.getString("nama_ibu"));
                nasabah.setTglPembuatan(result.getString("tgl_pembuatan"));
                
                listNasabah.add(nasabah);
            }
            
            statement.close();
            result.close();
            return listNasabah;
        } catch (SQLException ex) {
            Logger.getLogger(NasabahDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    }
    
    public int getIdRekening(String id) {
        ModelNasabah nasabah = new ModelNasabah();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT * FROM nasabah WHERE id_nasabah="+id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                nasabah.setIdRekening(rs.getInt("id_rekening"));
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "error: "+e);
        }
        
        return nasabah.getIdRekening();
    }
}
