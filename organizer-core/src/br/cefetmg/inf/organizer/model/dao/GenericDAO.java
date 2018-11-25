package br.cefetmg.inf.organizer.model.dao;

import java.util.ArrayList;
import java.util.Map;

public interface GenericDAO <E> {
    ArrayList<E> findByNamedQuery(String namedQuery, Map<String, Object> namedParams);
    boolean save(E entity);
    boolean update(E entity);
    boolean delete(E entity);
}
