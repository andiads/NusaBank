/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.helper;

import com.nusabank.model.ModelAdmin;
import com.nusabank.model.ModelNasabah;
import com.nusabank.view.viewAdmin.ViewManageAdmin;
import com.nusabank.view.viewAdmin.ViewManageNasabah;
import com.nusabank.view.viewAdmin.ViewMenuAdmin;
import com.nusabank.view.viewAdmin.ViewRegisNasabah;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class FunctionTest {
    
    ViewManageNasabah vmn;
    ViewManageAdmin vma;
    ViewRegisNasabah vrn;
    ViewMenuAdmin vMenuAdm;
    
    ModelNasabah mn;
    ModelAdmin ma;
    
    public FunctionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        vmn = new ViewManageNasabah();
        vma = new ViewManageAdmin();
        vMenuAdm = new ViewMenuAdmin();
 
        mn = new ModelNasabah();
        ma = new ModelAdmin();
        
        mn.setUsername("dummy_nasabah");
        ma.setUsername("dummy_admin");
       
        vmn.setFileName("test.png");
        vma.setFileName("test.png");      
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of randomCaptcha method, of class Function.
     */
    @Test
    public void testRandomCaptcha() {
        System.out.println("randomCaptcha");
        int count = 5;
        String expResult = "";
        String result = Function.randomCaptcha(count);
        assertNotNull("not null: " +result, result);
    }

    /**
     * Test of generateNoRek method, of class Function.
     */
    @Test
    public void testGenerateNoRek() {
        System.out.println("generateNoRek");
        String nmNasabah = "Tester";
        String dob = "1990-02-02";
        String dj = "2020-04-24";
        Function instance = new Function();
        String expResult = "";
        String result = instance.generateNoRek(nmNasabah, dob, dj);
        assertNotNull("No.Rekening isn't null", result);
    }

    /**
     * Test of updatePhotoNasabah method, of class Function.
     */
    @Test
    public void testUpdatePhotoNasabah() {
        System.out.println("updatePhotoNasabah");
        Function instance = new Function();
        String expResult = "res/nasabah_photos/dummy_nasabah_NusaBank_null.png";
        String result = instance.updatePhotoNasabah(vmn, mn);
        assertEquals(expResult, result);
    }

    /**
     * Test of uploadPhotoNasabah method, of class Function.
     */
    @Test
    public void testUploadPhotoNasabah() {
        System.out.println("uploadPhotoNasabah");
        vrn = new ViewRegisNasabah();
        vrn.setIdAdmin("1");
        vrn.setFileName("test.png");
        Function instance = new Function();
        String expResult = "";
        String result = instance.uploadPhotoNasabah(vrn, mn);
        assertNotNull(expResult, result);
    }

    /**
     * Test of uploadPhotoAdmin method, of class Function.
     */
    @Test
    public void testUploadPhotoAdmin() {
        System.out.println("uploadPhotoAdmin");
        Function instance = new Function();
        String expResult = "";
        String result = instance.uploadPhotoAdmin(vma, ma);
        assertEquals(expResult, result);
    }
    
}
