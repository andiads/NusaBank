/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.nusabank.controller.CLoginNasabah;
import com.nusabank.model.database.DBConnection;
import com.nusabank.view.viewLogin.ViewLoginNasabah;
import com.nusabank.view.viewNasabah.ViewMenuNasabah;

import java.sql.PreparedStatement;

/**
 *
 * @author User
 */
public class CLoginNasabahTest {
    
    CLoginNasabah login;
    
    public CLoginNasabahTest() {
    }
    
    @Before
    public void setUp() {
        login = new CLoginNasabah(new ViewLoginNasabah());
    }
    /**
     * Test of doLogin method, of class CLoginNasabah.
     * Test whether the username and password is matches
     */
    @Test
    public void testDoLoginIsMatch() throws Exception {
       String username = "asep1";
       String password = "123456";
       assertTrue("Login Matches!",login.doLogin(username, password));
       
    }
    
    /**
     * Test of doLogin method, of class CLoginNasabah.
     * Test whether the username and password isn't matches
     */
    @Test
    public void testDoLoginIsNotMatch() throws Exception {
        String username = "asepsooo";
        String password = "123123";
        assertFalse("Login Didn't Matches!",login.doLogin(username, password));
    }
}
