/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import java.util.List;
import com.nusabank.model.ModelTransaksiPPOB;
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public interface InterfaceTrxPpobDAO {
    public void insert(ModelTransaksiPPOB mTrxPPOB);
    public void update(ModelTransaksiPPOB mTrxPPOB);
    public void delete(int id);
    public List<ModelTransaksiPPOB> getAll();
    public List<ModelTransaksiPPOB> search(String category, String search);
    public List<ModelTransaksiPPOB> getById(int id);
    public String getLastId();
}
