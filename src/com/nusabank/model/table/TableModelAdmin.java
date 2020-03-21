/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.table;

import com.nusabank.model.ModelAdmin;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class TableModelAdmin extends AbstractTableModel{
    
    private static final long serialVersionUID = 1L;
    
    List<ModelAdmin> list;
    
    public TableModelAdmin(List<ModelAdmin> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getNama();
            case 2 : return list.get(rowIndex).getNIK();
            case 3 : return list.get(rowIndex).getUsername();
            case 4 : return list.get(rowIndex).getPassword();
            case 5 : return list.get(rowIndex).getTglLahir();
            case 6 : return list.get(rowIndex).getPhoto();
            case 7 : return list.get(rowIndex).getJenisKelamin();
            case 8 : return list.get(rowIndex).getNoHp();
            case 9 : return list.get(rowIndex).getEmail();
            case 10 : return list.get(rowIndex).getAlamat();
                default:return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "ID";
            case 1 : return "NAMA";
            case 2 : return "NIK";
            case 3 : return "USERNAME";
            case 4 : return "PASSWORD";
            case 5 : return "TGL LAHIR";
            case 6 : return "PHOTO";
            case 7 : return "JENIS KELAMIN";
            case 8 : return "NO HP";
            case 9 : return "EMAIL";
            case 10 : return "ALAMAT";
                default:return null;
        }
    }
}
