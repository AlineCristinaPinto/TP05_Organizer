
package br.cefetmg.inf.organizer.dist;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RegistryManager {

    private static RegistryManager onlyInstance;
    private static String serverName;
    private static int port;
    private Registry registry;
    
    private RegistryManager() throws RemoteException{
        serverName = "localhost";
        port = 52365;
        registry = null;
    }
    
    public static RegistryManager getInstance() throws RemoteException{
        if(onlyInstance == null){
            onlyInstance = new RegistryManager();
        }
        return onlyInstance;
    }
    
    public static Registry getRegistry() throws RemoteException {
        return LocateRegistry.getRegistry(serverName, port);
    }
    
    public void rebind(String name, Remote obj) throws RemoteException{
        registry.rebind(name, obj);
    }
    
    public void createRegistry() throws RemoteException{
        registry = LocateRegistry.createRegistry(port);
    }
}
