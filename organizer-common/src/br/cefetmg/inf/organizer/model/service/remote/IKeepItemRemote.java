package br.cefetmg.inf.organizer.model.service.remote;

import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface IKeepItemRemote extends Remote{
    
    boolean createItem (Item item) throws PersistenceException, RemoteException;
    boolean updateItem(Item item) throws PersistenceException, RemoteException;
    boolean deleteItem(Long idItem, User user) throws PersistenceException, RemoteException;
    ArrayList<Item> listAllItem(User user) throws PersistenceException, RemoteException;
    Item searchItemById(Long idItem) throws PersistenceException, RemoteException;
    Item searchItemByName(String nomeItem) throws PersistenceException, RemoteException;
    ArrayList<Item> searchItemByTag(List<Tag> tagList, User user) throws PersistenceException, RemoteException;
    ArrayList<Item> searchItemByType(List<String> typeList, User user) throws PersistenceException, RemoteException;
    ArrayList<Item> searchItemByTagAndType(List<Tag> tagList, List<String> typeList, User user) 
            throws PersistenceException, RemoteException;
    
}
