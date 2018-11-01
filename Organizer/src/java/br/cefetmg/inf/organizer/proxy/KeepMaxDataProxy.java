/*
 * @author Ruan Bertuce
 */

package br.cefetmg.inf.organizer.proxy;
import br.cefetmg.inf.organizer.dist.RMIClient;
import br.cefetmg.inf.organizer.dist.StubList;
import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.MaxDataObject;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepMaxData;
import br.cefetmg.inf.organizer.model.service.remote.IKeepMaxDataRemote;
import br.cefetmg.inf.util.exception.PersistenceException;
import com.google.gson.Gson;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeepMaxDataProxy implements IKeepMaxData {
    
    private IKeepMaxDataRemote keepMaxDataRemote;

    public KeepMaxDataProxy() throws SocketException, UnknownHostException, RemoteException, NotBoundException {
        keepMaxDataRemote = (IKeepMaxDataRemote) RMIClient.lookup(StubList.KeepUserAdapter.name());
    }

    @Override
    public boolean updateAllItems(MaxDataObject maxDataObject) throws PersistenceException {
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(maxDataObject));
        
        boolean result = false;
        try {
            result = keepMaxDataRemote.updateAllItems(maxDataObject);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepMaxDataProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean updateAllTags(MaxDataObject maxDataObject) throws PersistenceException {
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(maxDataObject));
        
        boolean result = false;
        try {
            result = keepMaxDataRemote.updateAllTags(maxDataObject);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepMaxDataProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean updateAllItemTag(MaxDataObject maxDataObject) throws PersistenceException {
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(maxDataObject));
        
        boolean result = false;
        try {
            result = keepMaxDataRemote.updateAllItemTag(maxDataObject);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepMaxDataProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<Item> loadItems(User user) throws PersistenceException {
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(user));
        
        ArrayList<Item> result = null;
        try {
            result = keepMaxDataRemote.loadItems(user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepMaxDataProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<Tag> loadTags(User user) throws PersistenceException {
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(user));
        
        ArrayList<Tag> result = null;
        try {
            result = keepMaxDataRemote.loadTags(user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepMaxDataProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<String> loadTagsItems(User user) throws PersistenceException {
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(user));
        
        ArrayList<String> result = null;
        try {
            result = keepMaxDataRemote.loadTagsItems(user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepMaxDataProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<String> loadItemsTags(User user) throws PersistenceException {
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(user));
        
        ArrayList<String> result = null;
        try {
            result = keepMaxDataRemote.loadItemsTags(user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepMaxDataProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
