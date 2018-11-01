package br.cefetmg.inf.organizer.model.service.adapter;

import br.cefetmg.inf.organizer.model.domain.ItemTag;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.service.IKeepItemTag;
import br.cefetmg.inf.organizer.model.service.impl.KeepItemTag;
import br.cefetmg.inf.organizer.model.service.remote.IKeepItemTagRemote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class KeepItemTagAdapter implements IKeepItemTagRemote{
    
    private IKeepItemTag keepItemTag;

    public KeepItemTagAdapter() {
        this.keepItemTag = new KeepItemTag();
    }

    @Override
    public boolean createTagInItem(ItemTag itemTag) throws RemoteException {
        return keepItemTag.createTagInItem(itemTag);
    }

    @Override
    public boolean deleteTagInItem(ArrayList<Tag> itemTag, Long id) throws RemoteException {
        return keepItemTag.deleteTagInItem(itemTag, id);
    }

    @Override
    public ArrayList<Tag> listAllTagInItem(Long seqItem) throws RemoteException {
        return keepItemTag.listAllTagInItem(seqItem);
    }

    @Override
    public boolean deleteTagByItemId(Long idItem) throws RemoteException {
        return keepItemTag.deleteTagByItemId(idItem);
    }

}
