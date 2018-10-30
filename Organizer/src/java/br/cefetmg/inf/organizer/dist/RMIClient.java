
package br.cefetmg.inf.organizer.dist;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;


public class RMIClient {
    
    private static RegistryManager registryManager;

    public RMIClient() throws RemoteException {
        this.registryManager = RegistryManager.getInstance();
    }
    
    public static Remote lookup(String serviceName) throws RemoteException, NotBoundException{
        return registryManager.getRegistry().lookup(serviceName);
    }
}
