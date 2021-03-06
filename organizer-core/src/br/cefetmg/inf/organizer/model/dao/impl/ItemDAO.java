/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.dao.GenericDAO;
import br.cefetmg.inf.organizer.model.dao.IItemDAO;
import br.cefetmg.inf.organizer.model.dao.impl.jpa.GenericDAOImpl;
import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.domain.jpa.ItemJPA;
import br.cefetmg.inf.organizer.model.domain.jpa.UserJPA;
import br.cefetmg.inf.util.db.ConnectionManager;
import br.cefetmg.inf.util.db.JPAUtil;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aline
 */
public class ItemDAO implements IItemDAO {
    
    private GenericDAO genericDAO;

    public ItemDAO() {
        if (JPAUtil.usingJPA) {
            genericDAO = new GenericDAOImpl();
        }
    }

    @Override
    public boolean createItem(Item item) throws PersistenceException {

        if (!JPAUtil.usingJPA) {
            try {
                Connection connection = ConnectionManager.getInstance().getConnection();
                String sql = "INSERT INTO item (nom_item, des_item, dat_item, idt_item, idt_estado, cod_email)"
                    + "VALUES(?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
              
                preparedStatement.setString(1, item.getNameItem());
                preparedStatement.setString(2, item.getDescriptionItem());
                if (item.getDateItem() == null) {
                    preparedStatement.setDate(3, null);
                } else {
                    preparedStatement.setDate(3, new java.sql.Date(item.getDateItem().getTime()));
                }
                preparedStatement.setString(4, item.getIdentifierItem());
                preparedStatement.setString(5, item.getIdentifierStatus());
                preparedStatement.setString(6, item.getUser().getCodEmail());

                preparedStatement.execute();
                preparedStatement.close();
                connection.close();

                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            System.out.println("Using JPA");
            ItemJPA itemJPA = new ItemJPA();
            
            UserJPA user = new UserJPA();            
            user.setCodEmail(item.getUser().getCodEmail());
            
            itemJPA.setCodEmail(user.getCodEmail());
            itemJPA.setIdtItem(item.getIdentifierItem());
            itemJPA.setNomItem(item.getNameItem());
            itemJPA.setDesItem(item.getDescriptionItem());
            if(item.getDateItem() == null) {
                itemJPA.setDatItem(null);
            } else {
                itemJPA.setDatItem(new java.sql.Date(item.getDateItem().getTime()));
            }
            
            if(item.getIdentifierStatus() == null){
               itemJPA.setIdtEstado('n');

            } else {
               itemJPA.setIdtEstado(item.getIdentifierStatus().charAt(0));
            }
            
            return genericDAO.save(itemJPA);
        }

    }

    @Override
    public boolean updateItem(Item item) throws PersistenceException {
        
        if (!JPAUtil.usingJPA) {
            try {
                Connection connection = ConnectionManager.getInstance().getConnection();
                String sql = "UPDATE item SET nom_item=?, des_item=?, dat_item=?, idt_estado=?"
                    + " WHERE cod_email=? and seq_item=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, item.getNameItem());
                preparedStatement.setString(2, item.getDescriptionItem());
                if (item.getDateItem() == null) {
                    preparedStatement.setDate(3, null);
                } else {
                    preparedStatement.setDate(3, new java.sql.Date(item.getDateItem().getTime()));
                }
                if (item.getIdentifierStatus() == null) {
                    preparedStatement.setString(4, null);
                } else {
                    preparedStatement.setString(4, item.getIdentifierStatus());
                }

                preparedStatement.setString(5, item.getUser().getCodEmail());
                preparedStatement.setLong(6, item.getSeqItem());

                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();

                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            System.out.println("Using JPA");
            ItemJPA itemJPA = new ItemJPA();
            
            UserJPA user = new UserJPA();            
            user.setCodEmail(item.getUser().getCodEmail());
            
            itemJPA.setSeqItem(item.getSeqItem().intValue());
            itemJPA.setCodEmail(user.getCodEmail());
            itemJPA.setIdtItem(item.getIdentifierItem());
            itemJPA.setNomItem(item.getNameItem());
            itemJPA.setDesItem(item.getDescriptionItem());
            if(item.getDateItem() == null) {
                itemJPA.setDatItem(null);
            } else {
                itemJPA.setDatItem(new java.sql.Date(item.getDateItem().getTime()));
            }
            
            if(item.getIdentifierStatus() == null){
               itemJPA.setIdtEstado('n');

            } else {
               itemJPA.setIdtEstado(item.getIdentifierStatus().charAt(0));
            }

            return genericDAO.update(itemJPA);
        }
    }

    @Override
    public boolean deleteItem(Long idItem, User user) throws PersistenceException {

        if (!JPAUtil.usingJPA) {
            try {
                Connection connection = ConnectionManager.getInstance().getConnection();
                String sql = "DELETE FROM item WHERE cod_email=? and seq_item=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, user.getCodEmail());
                preparedStatement.setLong(2, idItem);

                preparedStatement.execute();
                preparedStatement.close();
                connection.close();

                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            System.out.println("Using JPA");
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("seqItem", idItem);
            namedParams.put("codEmail", user.getCodEmail());
            
            genericDAO.findByNamedQuery("ItemJPA.deleteItem", namedParams);
            
            return true;
        }
    }

    @Override
    public ArrayList<Item> listAllItem(User user) throws PersistenceException {

        if(!JPAUtil.usingJPA){
            try {
                Connection connection = ConnectionManager.getInstance().getConnection();

                String sql = "SELECT * FROM item WHERE cod_email=? AND (idt_estado <> 'C' OR idt_estado IS NULL) ORDER BY dat_item";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, user.getCodEmail());

                ResultSet result = preparedStatement.executeQuery();

                ArrayList<Item> listAllItem = null;

                if (result.next()) {
                    listAllItem = new ArrayList<>();
                    do {
                        Item item = new Item();
                        item.setSeqItem(result.getLong("seq_item"));
                        item.setNameItem(result.getString("nom_item"));
                        item.setDescriptionItem(result.getString("des_item"));
                        item.setIdentifierItem(result.getString("idt_item"));
                        item.setDateItem(result.getDate("dat_item"));
                        item.setIdentifierStatus(result.getString("idt_estado"));

                        listAllItem.add(item);
                    } while (result.next());
                }

                result.close();
                preparedStatement.close();
                connection.close();

                return listAllItem;
            } catch (Exception ex) {
                throw new PersistenceException(ex.getMessage());
            }
        } else {
            
            Map<String, Object> namedParams = new HashMap<>();
            //namedParams.put("seqTag", tagList.get(0).getSeqTag());
            namedParams.put("codEmail", user.getCodEmail());
            ArrayList returnedObjects = genericDAO.findByNamedQuery("ItemJPA.findAll", namedParams);

            return returnedObjects;
        }
        
    }

    @Override
    public Item searchItemByName(String nomeItem) throws PersistenceException {
      
        if (!JPAUtil.usingJPA) {
            try{
                Connection connection = ConnectionManager.getInstance().getConnection();
                String sql = "SELECT * FROM item WHERE nom_item=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, nomeItem);

                ResultSet result = preparedStatement.executeQuery();

                Item item = new Item();

                if (result.next()) {

                    item.setSeqItem(result.getLong("seq_item"));
                    item.setNameItem(result.getString("nom_item"));
                    item.setDescriptionItem(result.getString("des_item"));
                    item.setIdentifierItem(result.getString("idt_item"));
                    item.setDateItem(result.getDate("dat_item"));
                    item.setIdentifierStatus(result.getString("idt_estado"));

                }

                result.close();
                preparedStatement.close();
                connection.close();

                return item;
            } catch (Exception ex) {
                throw new PersistenceException(ex.getMessage());
            }
        } else {
            System.out.println("Using JPA");
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("nomItem", nomeItem);
            
            return (Item) genericDAO.findByNamedQuery("ItemJPA.findByNomItem", namedParams).get(0);            
        }
    }

    @Override
    public Item searchItemById(Long idItem) throws PersistenceException {

        if (!JPAUtil.usingJPA) {
            try{
                Connection connection = ConnectionManager.getInstance().getConnection();
                String sql = "SELECT * FROM item WHERE seq_item=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, idItem);

                ResultSet result = preparedStatement.executeQuery();

                Item item = new Item();

                if (result.next()) {

                    item.setSeqItem(result.getLong("seq_item"));
                    item.setNameItem(result.getString("nom_item"));
                    item.setDescriptionItem(result.getString("des_item"));
                    item.setIdentifierItem(result.getString("idt_item"));
                    item.setDateItem(result.getDate("dat_item"));
                    item.setIdentifierStatus(result.getString("idt_estado"));

                }

                result.close();
                preparedStatement.close();
                connection.close();

                return item;
            } catch (Exception ex) {
                throw new PersistenceException(ex.getMessage());
            }
        } else {
            System.out.println("Using JPA");
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("seqItem", idItem);
            
            return (Item) genericDAO.findByNamedQuery("ItemJPA.findByNomItem", namedParams).get(0);            
        }
    }

    @Override
    public ArrayList<Item> searchItemByTag(List<Tag> tagList, User user) throws PersistenceException {
        
        if(!JPAUtil.usingJPA){
            try {
                //conditions of the sql's WHERE clause
                String sqlConditions = "";

                //number of sql's conditions (also number of tags in the ArrayList)
                int countConditions = tagList.size();

                //user's email
                String userEmail = user.getCodEmail();

                for (Tag tag : tagList) {
                    //conditions in the format "seq_tag = ? OR seq_tag = ? OR ..."
                    //*REMEMBER: change nom to seq after (or not)
                    sqlConditions += "nom_tag = ? OR ";
                }

                //removing the last " OR " from the String
                sqlConditions = sqlConditions.substring(0, sqlConditions.lastIndexOf(" OR "));

                try (Connection connection = ConnectionManager.getInstance().getConnection()) {

                    String sql = "SELECT A.* FROM item A JOIN item_tag B "
                            + "ON (A.seq_item = B.seq_item) JOIN tag C "
                            + "ON (B.seq_tag = C.seq_tag AND A.cod_email = C.cod_email) "
                            + "WHERE (" + sqlConditions + " AND A.cod_email = ?) "
                            + "GROUP BY 1 HAVING COUNT(*) = ? ORDER BY dat_item";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        int i;
                        for (i = 1; i <= countConditions; i++) {
                            //setting the first ?'s as tag names
                            preparedStatement.setString(i, tagList.get(i - 1).getTagName());
                        }
                        preparedStatement.setString(i, userEmail);
                        preparedStatement.setInt(i + 1, countConditions);

                        try (ResultSet result = preparedStatement.executeQuery()) {
                            ArrayList<Item> itemList = null;
                            if (result.next()) {
                                itemList = new ArrayList<>();
                                do {
                                    Item item = new Item();
                                    item.setSeqItem(result.getLong("seq_item"));
                                    item.setNameItem(result.getString("nom_item"));
                                    item.setDescriptionItem(result.getString("des_item"));
                                    item.setIdentifierItem(result.getString("idt_item"));
                                    item.setDateItem(result.getDate("dat_item"));
                                    item.setIdentifierStatus(result.getString("idt_estado"));

                                    itemList.add(item);
                                } while (result.next());
                            }

                            return itemList;
                        }
                    }
                }
            } catch (Exception ex) {
                throw new PersistenceException(ex.getMessage());
            }
        }else{
            
            ArrayList<Integer> seqTagList = new ArrayList();
            ArrayList<Item> itemList = null;
            
            for(Tag tag : tagList){
                seqTagList.add(tag.getSeqTag().intValue());
            }
            
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("seqTagList", seqTagList);
            namedParams.put("countTags", Integer.valueOf(seqTagList.size()).longValue());
            namedParams.put("codEmail", user.getCodEmail());
            ArrayList<ItemJPA> returnedObjects = genericDAO.findByNamedQuery("ItemJPA.searchItemByTag", namedParams);
            
            if(!returnedObjects.isEmpty()){
                itemList = new ArrayList();
            
                for(ItemJPA itemJPA : returnedObjects){
                    Item item = new Item();
                    item.setSeqItem(itemJPA.getSeqItem().longValue());
                    item.setNameItem(itemJPA.getNomItem());
                    item.setDateItem(itemJPA.getDatItem());
                    item.setDescriptionItem(itemJPA.getDesItem());
                    item.setUser(user);
                    item.setIdentifierStatus(String.valueOf(itemJPA.getIdtEstado()));
                    item.setIdentifierItem(itemJPA.getIdtItem());

                    itemList.add(item);
                }
            }

            return itemList;
        }
    }

    @Override
    public ArrayList<Item> searchItemByType(List<String> typeList, User user) throws PersistenceException {
        
        if(!JPAUtil.usingJPA){
            try (Connection connection = ConnectionManager.getInstance().getConnection()) {

                //conditions of the sql's WHERE clause
                String sqlConditions = "";

                //number of conditions (also number of types in the ArrayList)
                int countConditions = typeList.size();

                //user's email
                String userEmail = user.getCodEmail();

                for (String type : typeList) {
                    //filling the sqlConditions with a String in the format
                    //"idt_item = ? OR idt_item = ? OR ..."
                    sqlConditions += "idt_item = ? OR ";
                }
                //removing the last " OR " from the string
                sqlConditions = sqlConditions.substring(0, sqlConditions.lastIndexOf(" OR "));

                String sql = "SELECT * FROM item WHERE " + sqlConditions
                        + " AND cod_email = ? ORDER BY dat_item";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    int i;
                    for (i = 1; i <= countConditions; i++) {
                        preparedStatement.setString(i, typeList.get(i - 1));
                    }
                    preparedStatement.setString(i, userEmail);

                    try (ResultSet result = preparedStatement.executeQuery()) {

                        ArrayList<Item> itemList = null;
                        if (result.next()) {
                            itemList = new ArrayList<>();
                            do {
                                Item item = new Item();
                                item.setSeqItem(result.getLong("seq_item"));
                                item.setNameItem(result.getString("nom_item"));
                                item.setDescriptionItem(result.getString("des_item"));
                                item.setIdentifierItem(result.getString("idt_item"));
                                item.setDateItem(result.getDate("dat_item"));
                                item.setIdentifierStatus(result.getString("idt_estado"));

                                itemList.add(item);
                            } while (result.next());
                        }

                        return itemList;
                    }
                }
            } catch (Exception ex) {
                throw new PersistenceException(ex.getMessage());
            }
        } else {
            
            ArrayList<Item> itemList = null;
            
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("typeList", typeList);
            namedParams.put("codEmail", user.getCodEmail());
            ArrayList<ItemJPA> returnedObjects = genericDAO.findByNamedQuery("ItemJPA.searchItemByType", namedParams);
            
            if(!returnedObjects.isEmpty()){
                itemList = new ArrayList();
            
                for(ItemJPA itemJPA : returnedObjects){
                    Item item = new Item();
                    item.setSeqItem(itemJPA.getSeqItem().longValue());
                    item.setNameItem(itemJPA.getNomItem());
                    item.setDateItem(itemJPA.getDatItem());
                    item.setDescriptionItem(itemJPA.getDesItem());
                    item.setUser(user);
                    item.setIdentifierStatus(String.valueOf(itemJPA.getIdtEstado()));
                    item.setIdentifierItem(itemJPA.getIdtItem());

                    itemList.add(item);
                }
            }

            return itemList;
        }
    }

    @Override
    public ArrayList<Item> searchItemByTagAndType(List<Tag> tagList, List<String> typeList, User user) throws PersistenceException {

        if(!JPAUtil.usingJPA){
            try {
                //conditions of the sql's WHERE clause
                String sqlTagConditions = "";
                String sqlTypeConditions = "";

                //number of tag and type sql's conditions
                int countTagConditions = tagList.size();
                int countTypeConditions = typeList.size();

                //user's email
                String userEmail = user.getCodEmail();

                for (Tag tag : tagList) {
                    //conditions in the format "seq_tag = ? OR seq_tag = ? OR ..."
                    //*REMEMBER: change nom to seq after (or not)
                    sqlTagConditions += "nom_tag = ? OR ";
                }

                for (String type : typeList) {
                    //conditions in the format "idt_item = ? OR idt_item = ? OR ..."
                    sqlTypeConditions += "idt_item = ? OR ";
                }

                //removing the last " OR " from the Strings
                sqlTagConditions = sqlTagConditions.substring(0, sqlTagConditions.lastIndexOf(" OR "));
                sqlTypeConditions = sqlTypeConditions.substring(0, sqlTypeConditions.lastIndexOf(" OR "));

                try (Connection connection = ConnectionManager.getInstance().getConnection()) {

                    String sql = "SELECT A.* FROM item A JOIN item_tag B "
                            + "ON (A.seq_item = B.seq_item) JOIN tag C "
                            + "ON (B.seq_tag = C.seq_tag AND A.cod_email = C.cod_email) "
                            + "WHERE (" + sqlTagConditions + " AND (" + sqlTypeConditions
                            + ") AND A.cod_email = ?) GROUP BY 1 HAVING COUNT(*) = ? "
                            + "ORDER BY dat_item";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        int i;
                        for (i = 1; i <= countTagConditions + countTypeConditions; i++) {
                            if (i <= countTagConditions) {
                                preparedStatement.setString(i, tagList.get(i - 1).getTagName());
                            } else {
                                preparedStatement.setString(i, typeList.get(i - countTagConditions - 1));
                            }
                        }
                        preparedStatement.setString(i, userEmail);
                        preparedStatement.setInt(i + 1, countTagConditions);

                        try (ResultSet result = preparedStatement.executeQuery()) {
                            ArrayList<Item> itemList = null;
                            if (result.next()) {
                                itemList = new ArrayList<>();
                                do {
                                    Item item = new Item();
                                    item.setSeqItem(result.getLong("seq_item"));
                                    item.setNameItem(result.getString("nom_item"));
                                    item.setDescriptionItem(result.getString("des_item"));
                                    item.setIdentifierItem(result.getString("idt_item"));
                                    item.setDateItem(result.getDate("dat_item"));
                                    item.setIdentifierStatus(result.getString("idt_estado"));

                                    itemList.add(item);
                                } while (result.next());
                            }

                            return itemList;
                        }
                    }
                }
            } catch (Exception ex) {
                throw new PersistenceException(ex.getMessage());
            }
        } else {
            
            ArrayList<Integer> seqTagList = new ArrayList();
            ArrayList<Item> itemList = null;
            
            for(Tag tag : tagList){
                seqTagList.add(tag.getSeqTag().intValue());
            }
            
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("seqTagList", seqTagList);
            namedParams.put("countTags", Integer.valueOf(seqTagList.size()).longValue());
            namedParams.put("typeList", typeList);
            namedParams.put("codEmail", user.getCodEmail());
            ArrayList<ItemJPA> returnedObjects = genericDAO.findByNamedQuery("ItemJPA.searchItemByTagAndType", namedParams);
            
            if(!returnedObjects.isEmpty()){
                itemList = new ArrayList();
            
                for(ItemJPA itemJPA : returnedObjects){
                    Item item = new Item();
                    item.setSeqItem(itemJPA.getSeqItem().longValue());
                    item.setNameItem(itemJPA.getNomItem());
                    item.setDateItem(itemJPA.getDatItem());
                    item.setDescriptionItem(itemJPA.getDesItem());
                    item.setUser(user);
                    item.setIdentifierStatus(String.valueOf(itemJPA.getIdtEstado()));
                    item.setIdentifierItem(itemJPA.getIdtItem());

                    itemList.add(item);
                }
            }

            return itemList;
        }
    }

    @Override
    public boolean checkIfItemAlreadyExistsToCreate(Item item) throws PersistenceException {
                
        if (!JPAUtil.usingJPA) {
            try {
                Connection connection = ConnectionManager.getInstance().getConnection();
                String sql = "SELECT nom_item FROM item WHERE nom_item=? and idt_item=? and cod_email=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, item.getNameItem());
                preparedStatement.setString(2, item.getIdentifierItem());
                preparedStatement.setString(3, item.getUser().getCodEmail());

                ResultSet result = preparedStatement.executeQuery();

                if (result.next()) {
                    return true;
                }

                result.close();
                preparedStatement.close();
                connection.close();

                return false;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            System.out.println("Using JPA");
            ItemJPA itemJPA = new ItemJPA();
            
            UserJPA user = new UserJPA();            
            user.setCodEmail(item.getUser().getCodEmail());
            
            itemJPA.setCodEmail(user.getCodEmail());
            itemJPA.setIdtItem(item.getIdentifierItem());
            itemJPA.setNomItem(item.getNameItem());
        
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("nomItem", item.getNameItem());
            namedParams.put("codEmail", item.getUser().getCodEmail());
            namedParams.put("idtItem", item.getIdentifierItem());
            
            Item i = (Item) genericDAO.findByNamedQuery("ItemJPA.findIfItemAlreadyExistsToCreate", namedParams).get(0);    
            
            if(i == null){
                return true;
            }
        
            return false;
        }
    }
    
    @Override
    public boolean checkIfItemAlreadyExistsToUpdate(Item item) throws PersistenceException {
        
        if (!JPAUtil.usingJPA) {
            try {
                Connection connection = ConnectionManager.getInstance().getConnection();
                String sql = "SELECT nom_item FROM item WHERE nom_item=? and idt_item=? and cod_email=? and seq_item <> ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, item.getNameItem());
                preparedStatement.setString(2, item.getIdentifierItem());
                preparedStatement.setString(3, item.getUser().getCodEmail());
                preparedStatement.setLong(4, item.getSeqItem());

                ResultSet result = preparedStatement.executeQuery();

                if (result.next()) {
                    return true;
                }

                result.close();
                preparedStatement.close();
                connection.close();

                return false;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            System.out.println("Using JPA");
            ItemJPA itemJPA = new ItemJPA();
            
            UserJPA user = new UserJPA();            
            user.setCodEmail(item.getUser().getCodEmail());
            
            itemJPA.setCodEmail(user.getCodEmail());
            itemJPA.setIdtItem(item.getIdentifierItem());
            itemJPA.setNomItem(item.getNameItem());
        
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("nomItem", item.getNameItem());
            namedParams.put("codEmail", item.getUser().getCodEmail());
            namedParams.put("idtItem", item.getIdentifierItem());
            namedParams.put("seqItem", item.getSeqItem());
            
            Item i = (Item) genericDAO.findByNamedQuery("ItemJPA.findIfItemAlreadyExistsToUpdate", namedParams).get(0);    
            
            if(i == null){
                return true;
            }
        
            return false;
        }
    }
}

