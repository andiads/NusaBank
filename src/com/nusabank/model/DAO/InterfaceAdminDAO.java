/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.ModelAdmin;
import java.util.List;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public interface InterfaceAdminDAO {
    public void insert(ModelAdmin admin);
    public void update(ModelAdmin admin);
    public void delete(int id);
    public List<ModelAdmin> getAll();
    public List<ModelAdmin> search(String category, String search);
    public List<ModelAdmin> getById(int id);
}
