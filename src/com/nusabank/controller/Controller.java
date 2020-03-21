/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

/**
 *
 * @author ANDI DWI SAPUTRO
 */
public abstract class Controller {
    public Controller() {
        
    }
    
    public abstract void reset();
    
    public abstract void insert();
    
    public abstract void update();
    
    public abstract void delete();
    
    public abstract void bindingTable();
    
    public abstract void getDataField();
    
    public abstract void searchData();
    
    public abstract void bindingSearch();
    
    
}
