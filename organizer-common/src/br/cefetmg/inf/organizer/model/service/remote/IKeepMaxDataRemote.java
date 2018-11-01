package br.cefetmg.inf.organizer.model.service.remote;

import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.MaxDataObject;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IKeepMaxDataRemote extends Remote{
    boolean updateAllItems(MaxDataObject maxDataObject)  throws PersistenceException, RemoteException; 
    boolean updateAllTags(MaxDataObject maxDataObject) throws PersistenceException, RemoteException; //Olhar parametros
    boolean updateAllItemTag(MaxDataObject maxDataObject) throws PersistenceException, RemoteException;
    ArrayList<Item> loadItems(User user) throws PersistenceException, RemoteException;
    ArrayList<Tag> loadTags(User user) throws PersistenceException, RemoteException;
    ArrayList<String> loadTagsItems(User user) throws PersistenceException, RemoteException;
    ArrayList<String> loadItemsTags(User user) throws PersistenceException, RemoteException;    
}
