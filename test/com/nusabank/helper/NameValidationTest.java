/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.helper;

import org.junit.Test;
import static org.junit.Assert.*;
import junitparams.*;
        
import org.junit.runner.RunWith;

import com.nusabank.helper.Validation;

/**
 *
 * @author User
 */
@RunWith(JUnitParamsRunner.class)
public class NameValidationTest {
    Validation validTest = new Validation();
    
    @Test
    @FileParameters("resources/data_name.csv")
    public void testIsValidName(final String a, final boolean b){
        System.out.println("isValidName");
        String val = a;  
        boolean expResult = b;
        boolean result = validTest.isValidName(val);
        assertEquals(expResult, result);
    }
}
