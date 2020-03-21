/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.table;

import com.nusabank.model.ModelTransaksiPPOB;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class TableModelTransaksiPPOB extends AbstractTableModel {
     
    private static final long serialVersionUID = 1L;
    
    List<ModelTransaksiPPOB> list;
    
    public TableModelTransaksiPPOB(List<ModelTransaksiPPOB> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getIdTransaksi();
            case 1 : return list.get(rowIndex).getJenisTransaksi();
            case 2 : return list.get(rowIndex).getNominal();
            case 3 : return list.get(rowIndex).getTglTransaksi();
            case 4 : return list.get(rowIndex).getNoTarget();
            case 5 : return list.get(rowIndex).getKetTransaksi();
                default:return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "ID";
            case 1 : return "JENIS TRANSAKSI";
            case 2 : return "NOMINAL";
            case 3 : return "TANGGAL TRANSAKSI";
            case 4 : return "NO.TARGER";
            case 5 : return "KETERANGAN TRANSAKSI";
                default:return null;
        }
    }   
}
