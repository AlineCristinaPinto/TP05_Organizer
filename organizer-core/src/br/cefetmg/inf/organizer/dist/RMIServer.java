package br.cefetmg.inf.organizer.dist;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMIServer {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        System.out.println("Segurança OK!");

        StubBuilder stubBuilder;
        try {
            stubBuilder = StubBuilder.getInstance();
            stubBuilder.registerStubs();
            System.out.println("Registro PRONTO!");
        } catch (RemoteException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
