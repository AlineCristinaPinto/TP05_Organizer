package br.cefetmg.inf.organizer.proxy;

import br.cefetmg.inf.organizer.dist.RMIClient;
import br.cefetmg.inf.organizer.dist.StubList;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepUser;
import br.cefetmg.inf.organizer.model.service.remote.IKeepUserRemote;
import br.cefetmg.inf.util.exception.BusinessException;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeepUserProxy implements IKeepUser {
    
    private IKeepUserRemote keepUserRemote;
    
    public KeepUserProxy() throws SocketException, UnknownHostException, RemoteException, NotBoundException {
        keepUserRemote = (IKeepUserRemote) RMIClient.lookup(StubList.KeepUserAdapter.name());
    }
    
    @Override
    public boolean registerUser(User user) throws PersistenceException, BusinessException {
        boolean result = false;
        try {
            result = keepUserRemote.registerUser(user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public User searchUser(User user) throws PersistenceException, BusinessException {
        User result = null;
        try {
            result = keepUserRemote.searchUser(user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean updateUser(User user) throws PersistenceException, BusinessException {
        boolean result = false;
        try {
            result = keepUserRemote.updateUser(user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean deleteAccount(User user) throws PersistenceException, BusinessException {
        boolean result = false;
        try {
            result = keepUserRemote.deleteAccount(user);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public User getUserLogin(String email, String password) throws PersistenceException, BusinessException {
        User result = null;
        try {
            result = keepUserRemote.getUserLogin(email, password);
        } catch (RemoteException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
