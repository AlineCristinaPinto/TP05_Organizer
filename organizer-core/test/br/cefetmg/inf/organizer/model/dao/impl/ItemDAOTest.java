/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ItemDAOTest {
    
    public ItemDAOTest() {
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
     * Test of createItem method, of class ItemDAO.
     */
    @Test
    public void testCreateItem() throws Exception {
        System.out.println("createItem");
        /*User user = new User();
        user.setCodEmail("1");
        Item item = new Item();
        item.setUser(user);
        item.setNameItem("Teste JPA");
        item.setDescriptionItem("usando JUnit pra testar JPA");
        item.setIdentifierItem("LEM");
        ItemDAO instance = new ItemDAO();
        boolean expResult = true;
        boolean result = instance.createItem(item);
        System.out.println(result);
        //assertEquals(expResult, result);*/
    }

    /**
     * Test of updateItem method, of class ItemDAO.
     */
    @Test
    public void testUpdateItem() throws Exception {
        /*System.out.println("updateItem");
        User user = new User();
        user.setCodEmail("1");
        Item item = new Item();
        item.setUser(user);
        item.setSeqItem(new Long(1));
        item.setNameItem("Teste JPA aaaaa");
        item.setDescriptionItem("usando JUnit pra testar JPA que é uma bosta");
               
        ItemDAO instance = new ItemDAO();
        boolean expResult = true;
        boolean result = instance.updateItem(item);
        System.out.println(result);
        //assertEquals(expResult, result);*/
    }

    /**
     * Test of deleteItem method, of class ItemDAO.
     */
    @Test
    public void testDeleteItem() throws Exception {
        /*System.out.println("deleteItem");
        Long idItem = new Long(1);
        User user = new User();
        user.setCodEmail("1");
        ItemDAO instance = new ItemDAO();
        boolean expResult = true;
        boolean result = instance.deleteItem(idItem, user);
        System.out.println(result);
        //assertEquals(expResult, result);*/
    }

    /**
     * Test of listAllItem method, of class ItemDAO.
     */
    @Test
    public void testListAllItem() throws Exception {/*
        System.out.println("listAllItem");
        User user = new User();
        user.setCodEmail("1");
        user.setUserName("1");
        user.setUserPassword("1");
        user.setUserPhoto(null);
        user.setCurrentTheme(1);
        
        ItemDAO instance = new ItemDAO();
        ArrayList<Item> expResult = null;
        ArrayList<Item> result = instance.listAllItem(user);
        assertEquals(false, result.isEmpty());*/
    }

    /**
     * Test of searchItemByName method, of class ItemDAO.
     */
    @Test
    public void testSearchItemByName() throws Exception {
       /* System.out.println("searchItemByName");
        System.out.println("searchItemByName");
        String nomeItem = "";
        ItemDAO instance = new ItemDAO();
        Item expResult = null;
        Item result = instance.searchItemByName(nomeItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of searchItemById method, of class ItemDAO.
     */
    @Test
    public void testSearchItemById() throws Exception {/*
        System.out.println("searchItemById");
        Long idItem = Long.parseLong("2");
        ItemDAO instance = new ItemDAO();
        Item expResult = new Item();
        Item result = instance.searchItemById(idItem);
        assertEquals("tarefafa", result.getNameItem());*/
    }

    /**
     * Test of searchItemByTag method, of class ItemDAO.
     */
    @Test
    public void testSearchItemByTag() throws Exception {/*
        System.out.println("searchItemByTag");
        List<Tag> tagList = new ArrayList();
        Tag tag = new Tag();
        Tag tag2 = new Tag();
        Tag tag3 = new Tag();
        
        tag.setSeqTag(Long.parseLong("1"));
        tagList.add(tag);
        tag2.setSeqTag(Long.parseLong("2"));
        tagList.add(tag2);
        tag3.setSeqTag(Long.parseLong("3"));
        tagList.add(tag3);
        
        User user = new User();
        user.setCodEmail("1");
        
        ItemDAO instance = new ItemDAO();
        ArrayList<Item> expResult = null;
        ArrayList<Item> result = instance.searchItemByTag(tagList, user);
        
        result.forEach((item) -> {
            System.out.println("Seq: " +item.getSeqItem() +" Name: " +item.getNameItem());
        });
        
        assertEquals(false, result.isEmpty());*/
    }

    /**
     * Test of searchItemByType method, of class ItemDAO.
     */
    @Test
    public void testSearchItemByType() throws Exception {
       /* System.out.println("searchItemByType");
        List<String> typeList = new ArrayList();
        typeList.add("SIM");
        typeList.add("TAR");
        typeList.add("LEM");
        
        User user = new User();
        user.setCodEmail("1");
        
        ItemDAO instance = new ItemDAO();
        
        ArrayList<Item> result = instance.searchItemByType(typeList, user);
        
        result.forEach((item) -> {
            System.out.println("Seq: " +item.getSeqItem() +" Name: " +item.getNameItem());
        });
        
        assertEquals(false, result.isEmpty());*/
    }

    /**
     * Test of searchItemByTagAndType method, of class ItemDAO.
     */
    @Test
    public void testSearchItemByTagAndType() throws Exception {
       /*
        System.out.println("searchItemByTagAndType");
        List<Tag> tagList = new ArrayList();
        Tag tag = new Tag();
        Tag tag2 = new Tag();
        Tag tag3 = new Tag();
        
        tag.setSeqTag(Long.parseLong("1"));
        //tagList.add(tag);
        tag2.setSeqTag(Long.parseLong("2"));
        tagList.add(tag2);
        tag3.setSeqTag(Long.parseLong("3"));
        //tagList.add(tag3);
        
        List<String> typeList = new ArrayList();
        typeList.add("SIM");
        typeList.add("TAR");
        typeList.add("LEM");
        
        User user = new User();
        user.setCodEmail("1");
        
        ItemDAO instance = new ItemDAO();
        ArrayList<Item> expResult = null;
        ArrayList<Item> result = instance.searchItemByTagAndType(tagList, typeList, user);
        
        result.forEach((item) -> {
            System.out.println("Seq: " +item.getSeqItem() +" Name: " +item.getNameItem());
        });
        
        assertEquals(false, result.isEmpty());*/
    }

    /**
     * Test of checkIfItemAlreadyExistsToCreate method, of class ItemDAO.
     */
    @Test
    public void testCheckIfItemAlreadyExistsToCreate() throws Exception {
        /*System.out.println("checkIfItemAlreadyExistsToCreate");
        Item item = null;
        ItemDAO instance = new ItemDAO();
        boolean expResult = false;
        boolean result = instance.checkIfItemAlreadyExistsToCreate(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of checkIfItemAlreadyExistsToUpdate method, of class ItemDAO.
     */
    @Test
    public void testCheckIfItemAlreadyExistsToUpdate() throws Exception {
        /*System.out.println("checkIfItemAlreadyExistsToUpdate");
        Item item = null;
        ItemDAO instance = new ItemDAO();
        boolean expResult = false;
        boolean result = instance.checkIfItemAlreadyExistsToUpdate(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
    
}
