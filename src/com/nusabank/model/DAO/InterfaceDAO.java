/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import java.util.List;
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public interface InterfaceDAO {
    /*public abstract boolean insert();
    public abstract boolean update();
    public abstract boolean delete();
    public abstract List<Object> getAll();
    public abstract List<Object> search();
    public abstract Object getById();
*/
    public abstract void insert();
    public abstract void update();
    public abstract void delete();
    public abstract List getAll();
    public abstract List search(String category, String search);
    public abstract Object getById(String id);
}
