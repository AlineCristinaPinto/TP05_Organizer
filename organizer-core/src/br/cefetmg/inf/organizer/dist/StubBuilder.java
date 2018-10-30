package br.cefetmg.inf.organizer.dist;

import java.lang.reflect.Field;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class StubBuilder {
    
    private static StubBuilder stubBuilder;
    private RegistryManager registryManager;
    private final String classPackage = "br.cefetmg.inf.organizer.service.adapter.";
    private List<String> stubNames;
    
   
    private StubBuilder() throws RemoteException{
        registryManager = RegistryManager.getInstance();
        stubNames = new ArrayList<>();
        
        Class stubList = StubList.class;
        
        Field [] stubListNames = stubList.getDeclaredFields();
        
        for(Field field : stubListNames){
            stubNames.add(field.getName());
        }

    }

    public static StubBuilder getInstance() throws RemoteException{
        if(stubBuilder!=null){
            stubBuilder = new StubBuilder();
        }
        
        return stubBuilder;
    }
    
    public void registerStubs() throws ClassNotFoundException, InstantiationException, IllegalAccessException, RemoteException{
        for(String stub:stubNames){
           Class classReal = Class.forName(classPackage + stub);
           
           Remote realObject = (Remote) classReal.newInstance();

           Remote stubObject = UnicastRemoteObject.exportObject(realObject, 0);
           
           registryManager.rebind(stub, stubObject);
           
        }
    }
}
