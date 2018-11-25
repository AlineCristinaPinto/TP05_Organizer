package br.cefetmg.inf.util.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
    
    private static EntityManagerFactory emf = null;
    private static EntityManager onlyInstance = null;
    private static final String PUNAME = "organizerPU";
    public static final boolean usingJPA = true;
    
    static {
        emf = Persistence.createEntityManagerFactory(PUNAME);
    }
    
    public static EntityManager getEntityManager(){
        if(onlyInstance == null){
            onlyInstance = emf.createEntityManager();
        }
        return onlyInstance;
    }
    
}
