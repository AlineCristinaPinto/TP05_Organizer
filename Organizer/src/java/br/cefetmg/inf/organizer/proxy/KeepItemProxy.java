package br.cefetmg.inf.organizer.proxy;

import br.cefetmg.inf.organizer.dist.RMIClient;
import br.cefetmg.inf.organizer.dist.StubList;
import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepItem;
import br.cefetmg.inf.organizer.model.service.remote.IKeepItemRemote;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KeepItemProxy implements IKeepItem {
    
    private IKeepItemRemote keepItemRemote;

    public KeepItemProxy() throws SocketException, UnknownHostException, RemoteException, NotBoundException {
        keepItemRemote = (IKeepItemRemote) RMIClient.lookup(StubList.KeepItemAdapter.name());
    }

    @Override
    public boolean createItem(Item item) throws PersistenceException {
        
        boolean success = false;
        
        try {
            success = keepItemRemote.createItem(item);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemTagProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return success;
    
    }

    @Override
    public boolean updateItem(Item item) throws PersistenceException {
        
        boolean success = false;
        
        try {
            success = keepItemRemote.updateItem(item);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemTagProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return success;
       
    }

    @Override
    public boolean deleteItem(Long idItem, User user) throws PersistenceException {
        
       boolean success = false;
        
        try {
            success = keepItemRemote.deleteItem(idItem, user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemTagProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return success;
        
    }

    @Override
    public ArrayList<Item> listAllItem(User user) throws PersistenceException {
        
        ArrayList<Item> listAllItem = new ArrayList();
        
        try {
            listAllItem = keepItemRemote.listAllItem(user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemTagProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listAllItem;
        
    }
    
    @Override
    public Item searchItemById(Long idItem) throws PersistenceException {
        
        Item itemSearched = new Item();
        
        try {
            itemSearched = keepItemRemote.searchItemById(idItem);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemTagProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemSearched;
        
    }

    @Override
    public Item searchItemByName(String nomeItem) throws PersistenceException {
        
        Item itemSearched = new Item();
        
        try {
            itemSearched = keepItemRemote.searchItemByName(nomeItem);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemTagProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemSearched;
        
    }
    
    @Override
    public ArrayList<Item> searchItemByTag(List<Tag> tagList, User user) throws PersistenceException {
        
        try {
            return keepItemRemote.searchItemByTag(tagList, user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ArrayList<Item> searchItemByType(List<String> typeList, User user) throws PersistenceException {
        
        try {
            return keepItemRemote.searchItemByType(typeList, user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return null;
    }

    @Override
    public ArrayList<Item> searchItemByTagAndType(List<Tag> tagList, List<String> typeList, User user) throws PersistenceException {
        
        try {
            return keepItemRemote.searchItemByTagAndType(tagList, typeList, user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return null;
    }
    
}
