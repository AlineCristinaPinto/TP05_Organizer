
package br.cefetmg.inf.organizer.dist;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RegistryManager {

    private static RegistryManager onlyInstance;
    private final String serverName;
    private final int port;
    private final Registry registry;
    
    private RegistryManager() throws RemoteException{
        onlyInstance = new RegistryManager();
        serverName = "localhost";
        port = 2345;
        registry = LocateRegistry.createRegistry(port);
    }
    
    public static RegistryManager getInstance() throws RemoteException{
        if(onlyInstance == null){
            onlyInstance = new RegistryManager();
        }
        
        return onlyInstance;
    }
    
    public Registry getRegistry() throws RemoteException {
        return LocateRegistry.getRegistry(serverName, port);
    }
    
    public void rebind(String name, Remote obj) throws RemoteException{
        registry.rebind(name, obj);
    }
}
