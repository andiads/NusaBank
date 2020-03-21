/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.model.DAO;

import com.nusabank.model.ModelRekening;
import java.util.List;
/**
 *
 * @author ANDI DWI SAPUTRO
 */
public interface InterfaceRekeningDAO {
    public void insert(ModelRekening rekening);
    public void update(ModelRekening rekening);
    public void delete(int id);
    public List<ModelRekening> getAll();
    public List<ModelRekening> search(String category, String search);
    public List<ModelRekening> getById(int id);
    public String getLastId();
    public int getNoPIN(int idRek);
    public String getNoRek(int idRek);
    public int getSaldo(int idRek);
    public void trimSaldo(int id, int nominal);
    public void doSaving(String id, int nominal);
    public void doWithDraw(String id, int nominal);
    public void doChangePin(ModelRekening rekening);
    
}
