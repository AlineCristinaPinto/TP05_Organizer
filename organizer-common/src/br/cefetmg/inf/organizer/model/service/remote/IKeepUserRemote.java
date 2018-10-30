package br.cefetmg.inf.organizer.model.service.remote;

import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.util.exception.BusinessException;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IKeepUserRemote extends Remote{
    
    boolean registerUser(User user) throws PersistenceException, BusinessException, RemoteException;
    User searchUser(User user) throws PersistenceException, BusinessException, RemoteException;
    boolean updateUser(User user) throws PersistenceException, BusinessException, RemoteException;
    boolean deleteAccount(User user) throws PersistenceException, BusinessException, RemoteException;
    User getUserLogin(String email, String password) throws PersistenceException, BusinessException, RemoteException;
}
