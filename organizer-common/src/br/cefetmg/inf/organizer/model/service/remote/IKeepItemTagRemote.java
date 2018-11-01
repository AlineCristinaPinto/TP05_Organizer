package br.cefetmg.inf.organizer.model.service.remote;

import br.cefetmg.inf.organizer.model.domain.ItemTag;
import br.cefetmg.inf.organizer.model.domain.Tag;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IKeepItemTagRemote extends Remote{
    
    boolean createTagInItem (ItemTag itemTag) throws RemoteException;
    boolean deleteTagInItem(ArrayList<Tag> itemTag, Long id) throws RemoteException;
    ArrayList<Tag> listAllTagInItem(Long seqItem) throws RemoteException;
    boolean deleteTagByItemId(Long idItem) throws RemoteException;
    
}
