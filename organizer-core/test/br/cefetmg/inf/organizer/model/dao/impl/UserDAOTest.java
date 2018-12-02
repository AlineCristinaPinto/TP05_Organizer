/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author duduf
 */
public class UserDAOTest {
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class UserDAO.
     */
    @Test
    public void testCreateUser() throws Exception {
        
        System.out.println("createUser");
        User user = new User();
        user.setCodEmail("abc@gmail.com");
        user.setUserName("Cole");
        user.setUserPassword("cole");
        user.setCurrentTheme(1);
        user.setUserPhoto(null);
        user.setCurrentTheme(1);
        
        UserDAO instance = new UserDAO();
        boolean expResult = true;
        boolean result = instance.createUser(user);
        System.out.println(result);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of readUser method, of class UserDAO.
     */
    @Test
    public void testReadUser() throws Exception {
        /*
        System.out.println("readUser");
        User user = new User();
        user.setCodEmail("abc@gmail.com");
        UserDAO instance = new UserDAO();
        User expResult = new User();
        expResult.setCodEmail("abc@gmail.com");
        expResult.setUserName("Cole");
        expResult.setUserPassword("cole");
        expResult.setCurrentTheme(1);
        expResult.setUserPhoto(null);
        expResult.setCurrentTheme(1);
        User result = instance.readUser(user);
        assertEquals(expResult, result); 
        */
    }

    /**
     * Test of updateUser method, of class UserDAO.
     */
    @Test
    public void testUpdateUser() throws Exception {
       /*
        System.out.println("updateUser");
        User user = new User();
        user.setCodEmail("abc@gmail.com");
        user.setUserName("Eduardo");
        user.setUserPassword("cole");
        user.setCurrentTheme(1);
        user.setUserPhoto(null);
        user.setCurrentTheme(1);        
        UserDAO instance = new UserDAO();
        boolean expResult = true;
        boolean result = instance.updateUser(user);
        assertEquals(expResult, result);
        */       
    }

    /**
     * Test of deleteUser method, of class UserDAO.
     */
    @Test
    public void testDeleteUser() throws Exception {
        /*
        System.out.println("deleteUser");
        User user = new User();
        user.setCodEmail("abc@gmail.com");
        user.setUserName("Cole");
        user.setUserPassword("cole");
        user.setCurrentTheme(1);
        user.setUserPhoto(null);
        user.setCurrentTheme(1);
        UserDAO instance = new UserDAO();
        boolean expResult = true;
        boolean result = instance.deleteUser(user);
        assertEquals(expResult, result);
        */
    }

    /**
     * Test of getUserLogin method, of class UserDAO.
     */
    @Test
    public void testGetUserLogin() throws Exception {
        
       /* System.out.println("getUserLogin");
        String email = "abc@gmail.com";
        String password = "cole";
        UserDAO instance = new UserDAO();
        User user = new User();
        user.setCodEmail("abc@gmail.com");
        user.setUserName("Cole");
        user.setUserPassword("cole");
        user.setCurrentTheme(1);
        user.setUserPhoto(null);
        user.setCurrentTheme(1);
        User result = instance.getUserLogin(email, password);
        assertEquals(user, result);*/

    }
    
}
