/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.table;

import com.nusabank.model.ModelRekening;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public class TableModelRekening extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    
    List<ModelRekening> list;
    
    public TableModelRekening(List<ModelRekening> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : return list.get(rowIndex).getIdRekening();
            case 1 : return list.get(rowIndex).getNoRekening();
            case 2 : return list.get(rowIndex).getSaldo();
            case 3 : return list.get(rowIndex).getJenisRekening();
            case 4 : return list.get(rowIndex).getSaldo();
                default:return null;    
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "ID";
            case 1 : return "NO.REKENING";
            case 2 : return "SALDO";
            case 3 : return "JENIS REKENING";
            case 4 : return "NO.PIN";
                default:return null;
        }
    }
}
