package br.cefetmg.inf.organizer.model.service.adapter;

import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepTag;
import br.cefetmg.inf.organizer.model.service.impl.KeepTag;
import br.cefetmg.inf.organizer.model.service.remote.IKeepTagRemote;
import br.cefetmg.inf.util.exception.BusinessException;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class KeepTagAdapter implements IKeepTagRemote {
    
    private final IKeepTag keepTag;
    
    public KeepTagAdapter(){
        
        keepTag = new KeepTag();
    }

    @Override
    public boolean createTag(Tag tag) throws PersistenceException, BusinessException, RemoteException {
       return keepTag.createTag(tag);
    }

    @Override
    public Tag readTag(Tag tag) throws PersistenceException, BusinessException, RemoteException {
        return keepTag.readTag(tag);
    }

    @Override
    public boolean updateTag(Tag tag) throws PersistenceException, BusinessException, RemoteException {
        return keepTag.updateTag(tag);
    }

    @Override
    public boolean updateTagId(Tag tag, Long id) throws PersistenceException, BusinessException, RemoteException {
        return keepTag.updateTagId(tag, id);
    }

    @Override
    public boolean deleteTag(Tag tag) throws PersistenceException, BusinessException, RemoteException {
        return keepTag.deleteTag(tag);
    }

    @Override
    public ArrayList<Tag> listAlltag(User user) throws PersistenceException, BusinessException, RemoteException {
        return keepTag.listAlltag(user);
    }

    @Override
    public Long searchTagByName(String nomeTag, User user) throws PersistenceException, BusinessException, RemoteException {
        return keepTag.searchTagByName(nomeTag, user);
    }

    @Override
    public Tag searchTagById(Long idTag) throws PersistenceException, BusinessException, RemoteException {
        return keepTag.searchTagById(idTag);
    }
 
}
