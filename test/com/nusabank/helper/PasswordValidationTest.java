/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.helper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
public class PasswordValidationTest {
    Validation validTest = Validation.buildPasswordRule(true, true, true, 6, 12);
    
    @Test
    @FileParameters("resources/data_password.csv")
    public void testIsValidPassword(final String a, final boolean b){
        System.out.println("isValidPassword");
        String val = a;  
        boolean expResult = b;
        boolean result = validTest.isValidPassword(val);
        assertEquals(expResult, result);
    }
}
