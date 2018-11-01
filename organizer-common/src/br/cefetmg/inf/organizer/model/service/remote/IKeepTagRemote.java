package br.cefetmg.inf.organizer.model.service.remote;

import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.exception.BusinessException;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IKeepTagRemote extends Remote {
    
    boolean createTag(Tag tag) throws PersistenceException, BusinessException, RemoteException;
    Tag readTag(Tag tag) throws PersistenceException, BusinessException, RemoteException;
    boolean updateTag(Tag tag) throws PersistenceException, BusinessException, RemoteException;
    boolean updateTagId(Tag tag, Long id) throws PersistenceException, BusinessException, RemoteException;
    boolean deleteTag(Tag tag) throws PersistenceException, BusinessException, RemoteException;
    ArrayList<Tag> listAlltag(User user) throws PersistenceException, BusinessException, RemoteException;   
    Long searchTagByName(String nomeTag, User user) throws PersistenceException, BusinessException, RemoteException;    
    Tag searchTagById(Long idTag) throws PersistenceException, BusinessException, RemoteException;
}
