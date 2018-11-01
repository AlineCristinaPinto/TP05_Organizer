package br.cefetmg.inf.organizer.proxy;

import br.cefetmg.inf.organizer.dist.RMIClient;
import br.cefetmg.inf.organizer.dist.StubList;
import br.cefetmg.inf.organizer.model.domain.ItemTag;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.service.IKeepItemTag;
import br.cefetmg.inf.organizer.model.service.remote.IKeepItemTagRemote;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeepItemTagProxy implements IKeepItemTag{
    
    private IKeepItemTagRemote keepItemTagRemote;
    
    public KeepItemTagProxy() throws SocketException, UnknownHostException, RemoteException, NotBoundException {
        keepItemTagRemote = (IKeepItemTagRemote) RMIClient.lookup(StubList.KeepItemTagAdapter.name());
    }

    @Override
    public boolean createTagInItem(ItemTag itemTag) {
        
        boolean success = false;
        
        try {
            success = keepItemTagRemote.createTagInItem(itemTag);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemTagProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return success;
    }

    @Override
    public boolean deleteTagInItem(ArrayList<Tag> itemTag, Long id) {
        
        boolean success = false;
        
        try {
            success = keepItemTagRemote.deleteTagInItem(itemTag, id);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemTagProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return success;
    }

    @Override
    public ArrayList<Tag> listAllTagInItem(Long seqItem) {
        
        ArrayList<Tag> listAllTag = new ArrayList();
        
        try {
            listAllTag = keepItemTagRemote.listAllTagInItem(seqItem);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemTagProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return listAllTag;
    }

    @Override
    public boolean deleteTagByItemId(Long idItem) {
       
        boolean success = false;
        
        try {
            success = keepItemTagRemote.deleteTagByItemId(idItem);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepItemTagProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return success;
    }    
}
