/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.table;

import com.nusabank.model.ModelNasabah;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class TableModelNasabah extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    
    List<ModelNasabah> list;
    
    public TableModelNasabah(List<ModelNasabah> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 17;
}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getNama();
            case 2 : return list.get(rowIndex).getNik();
            case 3 : return list.get(rowIndex).getTglLahir();
            case 4 : return list.get(rowIndex).getAlamatRumah();
            case 5 : return list.get(rowIndex).getPhoto();
            case 6 : return list.get(rowIndex).getJenisKelamin();
            case 7 : return list.get(rowIndex).getPekerjaan();
            case 8 : return list.get(rowIndex).getAlamatKantor();
            case 9 : return list.get(rowIndex).getPendapatan();
            case 10 : return list.get(rowIndex).getNoHp();
            case 11 : return list.get(rowIndex).getStatus();
            case 12 : return list.get(rowIndex).getNamaIbu();
            case 13 : return list.get(rowIndex).getUsername();
            case 14 : return list.get(rowIndex).getPassword();
            case 15 : return list.get(rowIndex).getTglPembuatan();
            case 16 : return list.get(rowIndex).getIdRekening();
                default:return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "ID";
            case 1 : return "NAMA";
            case 2 : return "NIK";
            case 3 : return "TANGGAL LAHIR";
            case 4 : return "ALAMAT RUMAH";
            case 5 : return "PHOTO";
            case 6 : return "JENIS KELAMIN";
            case 7 : return "PEKERJAAN";
            case 8 : return "ALAMAT KANTOR";
            case 9 : return "PENDAPATAN";
            case 10 : return "NO HP";
            case 11 : return "STATUS";
            case 12 : return "NAMA IBU";
            case 13 : return "USERNAME";
            case 14 : return "PASSWORD";
            case 15 : return "TANGGAL PEMBUATAN";
            case 16 : return "ID REKENING";
                default:return null;
        }
    }
}
