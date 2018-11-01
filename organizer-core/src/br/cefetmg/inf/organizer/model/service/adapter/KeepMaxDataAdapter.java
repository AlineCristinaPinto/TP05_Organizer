package br.cefetmg.inf.organizer.model.service.adapter;

import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.MaxDataObject;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepMaxData;
import br.cefetmg.inf.organizer.model.service.impl.KeepMaxData;
import br.cefetmg.inf.organizer.model.service.remote.IKeepMaxDataRemote;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.util.ArrayList;

public class KeepMaxDataAdapter implements IKeepMaxDataRemote {

    private final IKeepMaxData keepMaxData;
    
    public KeepMaxDataAdapter() {
        this.keepMaxData = new KeepMaxData();
    }
    
    //Não existem regras de negócio pois essas funções servem para alterar o BD real baseado no BD simulado do assistente MAX. Em caso de dúvidas contate os membros do grupo;

    @Override
    public ArrayList<Item> loadItems(User user) throws PersistenceException {
        return keepMaxData.loadItems(user);
    }

    @Override
    public ArrayList<Tag> loadTags(User user) throws PersistenceException {
        return keepMaxData.loadTags(user);
    }

    @Override
    public ArrayList<String> loadTagsItems(User user) throws PersistenceException {
        return keepMaxData.loadTagsItems(user);
    }

    @Override
    public ArrayList<String> loadItemsTags(User user) throws PersistenceException {
        return keepMaxData.loadItemsTags(user);
    }
    
        @Override
    public boolean updateAllItems(MaxDataObject maxDataObject) throws PersistenceException {    
        return keepMaxData.updateAllItems(maxDataObject); 
    }

    @Override
    public boolean updateAllTags(MaxDataObject maxDataObject) throws PersistenceException {        
        return keepMaxData.updateAllTags(maxDataObject);
    }

    @Override
    public boolean updateAllItemTag(MaxDataObject maxDataObject) throws PersistenceException {
        return keepMaxData.updateAllItemTag(maxDataObject);
    }
}
