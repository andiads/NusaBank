/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.ModelNasabah;
import java.util.List;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public interface InterfaceNasabahDAO  {
    public void insert(ModelNasabah nasabah);
    public void update(ModelNasabah nasabah);
    public void delete(int id);
    public List<ModelNasabah> getAll();
    public List<ModelNasabah> search(String category, String search);
    public List<ModelNasabah> getById(int id);
    
}
