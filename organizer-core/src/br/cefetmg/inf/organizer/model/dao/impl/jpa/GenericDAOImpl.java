package br.cefetmg.inf.organizer.model.dao.impl.jpa;

import br.cefetmg.inf.organizer.model.dao.GenericDAO;
import br.cefetmg.inf.util.db.JPAUtil;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class GenericDAOImpl implements GenericDAO {

    private EntityManager em;

    public GenericDAOImpl() {
        em = JPAUtil.getEntityManager();
    }

    @Override
    public ArrayList findByNamedQuery(String namedQuery, Map namedParams) {
        ArrayList returnList = null;
        try {

            Query query = em.createNamedQuery(namedQuery);

            if (namedParams != null) {
                Entry<String, Object> mapEntry;

                for (Iterator it = namedParams.entrySet().iterator(); it
                        .hasNext(); query.setParameter(
                                (String) mapEntry.getKey(), mapEntry.getValue())) {

                    mapEntry = (Entry<String, Object>) it.next();

                }
            }

            returnList = (ArrayList) query.getResultList();
            return returnList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnList;
    }

    @Override
    public boolean save(Object entity
    ) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(entity);
        et.commit();
        return true;
    }

    @Override
    public boolean update(Object entity
    ) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(entity);
        et.commit();
        return true;
    }

    @Override
    public boolean delete(Object entity
    ) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        if(em.contains(entity)){
            em.remove(entity);
        }else{
            Object attached = em.merge(entity);
            em.remove(attached);
        }
        
        et.commit();
        return true;
    }

}
