
package br.cefetmg.inf.organizer.model.service.adapter;


import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepUser;
import br.cefetmg.inf.organizer.model.service.impl.KeepUser;
import br.cefetmg.inf.organizer.model.service.remote.IKeepUserRemote;
import br.cefetmg.inf.util.exception.BusinessException;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.rmi.RemoteException;


public class KeepUserAdapter implements IKeepUserRemote {

    private final IKeepUser keepUser;

    public KeepUserAdapter() {
        this.keepUser = new KeepUser();
    }
    
    @Override
    public boolean registerUser(User user) throws PersistenceException, BusinessException, RemoteException {
        return keepUser.registerUser(user);  
    }

    @Override
    public User searchUser(User user) throws PersistenceException, BusinessException, RemoteException {
        return keepUser.searchUser(user);
    }

    @Override
    public boolean updateUser(User user) throws PersistenceException, BusinessException, RemoteException {
        return keepUser.updateUser(user);
    }

    @Override
    public boolean deleteAccount(User user) throws PersistenceException, BusinessException, RemoteException {
        return keepUser.deleteAccount(user);
    }

    @Override
    public User getUserLogin(String email, String password) throws PersistenceException, BusinessException, RemoteException {
        return keepUser.getUserLogin(email, password);
    }

}
