package br.cefetmg.inf.organizer.model.service.adapter;

import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepItem;
import br.cefetmg.inf.organizer.model.service.impl.KeepItem;
import br.cefetmg.inf.organizer.model.service.remote.IKeepItemRemote;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class KeepItemAdapter implements IKeepItemRemote{
    
    private IKeepItem keepItem;

    public KeepItemAdapter() {
        this.keepItem = new KeepItem();
    }

    @Override
    public boolean createItem(Item item) throws PersistenceException, RemoteException {
        return keepItem.createItem(item);
    }

    @Override
    public boolean updateItem(Item item) throws PersistenceException, RemoteException {
        return keepItem.updateItem(item);
    }

    @Override
    public boolean deleteItem(Long idItem, User user) throws PersistenceException, RemoteException {
        return keepItem.deleteItem(idItem, user);
    }

    @Override
    public ArrayList<Item> listAllItem(User user) throws PersistenceException, RemoteException {
        return keepItem.listAllItem(user);
    }

    @Override
    public Item searchItemById(Long idItem) throws PersistenceException, RemoteException {
        return keepItem.searchItemById(idItem);
    }

    @Override
    public Item searchItemByName(String nomeItem) throws PersistenceException, RemoteException {
        return keepItem.searchItemByName(nomeItem);
    }

    @Override
    public ArrayList<Item> searchItemByTag(List<Tag> tagList, User user) throws PersistenceException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Item> searchItemByType(List<String> typeList, User user) throws PersistenceException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Item> searchItemByTagAndType(List<Tag> tagList, List<String> typeList, User user) throws PersistenceException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}