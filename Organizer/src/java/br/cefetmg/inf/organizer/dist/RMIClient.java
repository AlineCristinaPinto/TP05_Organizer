
package br.cefetmg.inf.organizer.dist;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;


public class RMIClient {
    
    private static RegistryManager registryManager;
    
    public static Remote lookup(String serviceName) throws RemoteException, NotBoundException{
        return RegistryManager.getRegistry().lookup(serviceName);
    }
}
