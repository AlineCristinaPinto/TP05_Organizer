package br.cefetmg.inf.organizer.proxy;

import br.cefetmg.inf.organizer.dist.RMIClient;
import br.cefetmg.inf.organizer.dist.StubList;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepTag;
import br.cefetmg.inf.organizer.model.service.remote.IKeepTagRemote;
import br.cefetmg.inf.util.exception.BusinessException;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class KeepTagProxy implements IKeepTag {

    private final IKeepTagRemote keepTagRemote;

    public KeepTagProxy() throws SocketException, UnknownHostException, RemoteException, NotBoundException {
        keepTagRemote = (IKeepTagRemote) RMIClient.lookup(StubList.KeepTagAdapter.name());
    }

    @Override
    public boolean createTag(Tag tag) throws PersistenceException, BusinessException {

        try {
            return keepTagRemote.createTag(tag);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public Tag readTag(Tag tag) throws PersistenceException, BusinessException {

        try {
            return keepTagRemote.readTag(tag);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateTag(Tag tag) throws PersistenceException, BusinessException {

        try {
            return keepTagRemote.updateTag(tag);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateTagId(Tag tag, Long id) throws PersistenceException, BusinessException {

        try {
            return keepTagRemote.updateTagId(tag, id);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteTag(Tag tag) throws PersistenceException, BusinessException {

        try {
            return keepTagRemote.deleteTag(tag);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public ArrayList<Tag> listAlltag(User user) throws PersistenceException, BusinessException {
        /* contentPackage;
        Gson json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(user));

        RequestType requestType = RequestType.LISTALLTAG;
        contentPackage = new PseudoPackage(requestType, jsonContent);

        ArrayList<Tag> listAllTag;

        try {
            PseudoPackage receivedPackage = client.request(contentPackage);

            JsonReader reader = new JsonReader(new StringReader(receivedPackage.getContent().get(0)));
            reader.setLenient(true);

            if (receivedPackage.getContent().get(0).equals("false")) {
                return null;
            } else {
                Type type = new TypeToken<ArrayList<Tag>>() {
                }.getType();
                return json.fromJson(reader, type);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
        return null;
    }

    @Override
    public Long searchTagByName(String nomeTag, User user) throws PersistenceException, BusinessException {
        
        try {
            return keepTagRemote.searchTagByName(nomeTag, user);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Tag searchTagById(Long idTag) throws PersistenceException, BusinessException {
        
        try {
            return keepTagRemote.searchTagById(idTag);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
