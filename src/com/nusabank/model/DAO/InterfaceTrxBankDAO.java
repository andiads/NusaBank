/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.ModelTransaksiBank;
import java.util.List;
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public interface InterfaceTrxBankDAO {
    public void insert(ModelTransaksiBank mtb);
    public void update(ModelTransaksiBank mtb);
    public void delete(int id);
    public List<ModelTransaksiBank> getAll();
    public List<ModelTransaksiBank> search(String category, String search);
    public List<ModelTransaksiBank> getById(int id);
    public String getLastId();
}
