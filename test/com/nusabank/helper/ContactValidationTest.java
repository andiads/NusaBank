/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.helper;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 *
 * @author User
 */
@RunWith(JUnitParamsRunner.class)
public class ContactValidationTest {
    Validation validTest = new Validation();
    
    @Test
    @FileParameters("resources/data_contact.csv")
    public void testIsValidContact(final String a, final boolean b){
        System.out.println("isValidContact");
        String val = a;  
        boolean expResult = b;
        boolean result = validTest.isValidPhoneNumber(val);
        assertEquals(expResult, result);
    }
}
