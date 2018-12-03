package br.cefetmg.inf.organizer.model.dao.impl;

import br.cefetmg.inf.organizer.model.dao.GenericDAO;
import br.cefetmg.inf.organizer.model.dao.ITagDAO;
import br.cefetmg.inf.organizer.model.dao.impl.jpa.GenericDAOImpl;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.domain.jpa.ItemJPA;
import br.cefetmg.inf.organizer.model.domain.jpa.UserJPA;
import br.cefetmg.inf.organizer.model.domain.jpa.TagJPA;
import br.cefetmg.inf.util.db.ConnectionManager;
import br.cefetmg.inf.util.db.JPAUtil;
import br.cefetmg.inf.util.exception.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TagDAO implements ITagDAO {

    private GenericDAO genericDAO;

    public TagDAO() {
        if (JPAUtil.usingJPA) {
            genericDAO = new GenericDAOImpl();
        }
    }

    @Override
    public boolean createTag(Tag tag) throws PersistenceException {

        if (!JPAUtil.usingJPA) {
            try (Connection connection = ConnectionManager.getInstance().getConnection()) {
                String sql = "INSERT INTO tag(nom_tag,cod_email) VALUES (?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, tag.getTagName());
                    preparedStatement.setString(2, tag.getUser().getCodEmail());

                    preparedStatement.execute();
                }
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            TagJPA tagJPA = new TagJPA();

            UserJPA user = new UserJPA();
            user.setCodEmail(tag.getUser().getCodEmail());

            tagJPA.setCodEmail(user.getCodEmail());
            tagJPA.setNomTag(tag.getTagName());

            return genericDAO.save(tagJPA);
        }
    }

    @Override
    public Tag readTag(Tag tag) throws PersistenceException {
        if (!JPAUtil.usingJPA) {
            try (Connection connection = ConnectionManager.getInstance().getConnection()) {
                String sql = "SELECT * FROM tag WHERE cod_email=? and nom_tag=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, tag.getUser().getCodEmail());
                    preparedStatement.setString(2, tag.getTagName());

                    try (ResultSet result = preparedStatement.executeQuery()) {
                        if (result.next()) {
                            tag.setSeqTag(result.getLong("seq_tag"));
                            tag.setTagName(result.getString("nom_tag"));
                        } else {
                            tag = null;
                        }
                    }
                }
                return tag;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("seqTag", tag.getSeqTag());
            namedParams.put("nomeTag", tag.getTagName());
            ArrayList returnedObjects = genericDAO.findByNamedQuery("TagJPA.readTag", namedParams);

            if (returnedObjects.isEmpty()) {
                return null;
            } else {
                return tag;
            }
        }
    }

    @Override
    public boolean updateTag(Tag tag) throws PersistenceException {
        if (!JPAUtil.usingJPA) {
            try (Connection connection = ConnectionManager.getInstance().getConnection()) {
                String sql = "UPDATE tag SET nom_tag=? WHERE cod_email=? and seq_tag=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, tag.getTagName());
                    preparedStatement.setString(2, tag.getUser().getCodEmail());
                    preparedStatement.setLong(3, tag.getSeqTag());

                    preparedStatement.execute();
                }
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            TagJPA tagJPA = new TagJPA();
            
            UserJPA user = new UserJPA();            
            user.setCodEmail(tag.getUser().getCodEmail());
            
            tagJPA.setCodEmail(user.getCodEmail());
            tagJPA.setNomTag(tag.getTagName());

            return genericDAO.update(tagJPA);
        }
    }

    @Override
    public boolean updateTagId(Tag tag, Long id) throws PersistenceException {
        if (!JPAUtil.usingJPA) {
            try (Connection connection = ConnectionManager.getInstance().getConnection()) {
                String sql = "UPDATE tag SET seq_tag=? WHERE cod_email=? and nom_tag=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setLong(1, tag.getSeqTag());
                    preparedStatement.setString(2, tag.getUser().getCodEmail());
                    preparedStatement.setString(3, tag.getTagName());

                    preparedStatement.execute();
                }
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            TagJPA tagJPA = new TagJPA();
            
            UserJPA user = new UserJPA();            
            user.setCodEmail(tag.getUser().getCodEmail());
            
            tagJPA.setCodEmail(user.getCodEmail());
            tagJPA.setNomTag(tag.getTagName());

            return genericDAO.update(tagJPA);
        }
    }

    @Override
    public boolean deleteTag(Tag tag) throws PersistenceException {
        if (!JPAUtil.usingJPA) {
            try (Connection connection = ConnectionManager.getInstance().getConnection()) {
                String sql = "DELETE FROM tag WHERE cod_email=? and nom_tag=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, tag.getUser().getCodEmail());
                    preparedStatement.setString(2, tag.getTagName());

                    preparedStatement.execute();
                }
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("seqTag", tag.getSeqTag());
            namedParams.put("codEmail", tag.getUser().getCodEmail());
            
            genericDAO.findByNamedQuery("tagJPA.deleteTag", namedParams);
            
            return true;
        }
    }

    @Override
    public ArrayList<Tag> listAlltag(User user) throws PersistenceException {
        if (!JPAUtil.usingJPA) {
            try (Connection connection = ConnectionManager.getInstance().getConnection()) {
                String sql = "SELECT * FROM tag WHERE cod_email=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, user.getCodEmail());

                    try (ResultSet result = preparedStatement.executeQuery()) {
                        ArrayList<Tag> listAllTag = null;

                        if (result.next()) {
                            listAllTag = new ArrayList<>();

                            do {
                                Tag tag = new Tag();
                                tag.setTagName(result.getString("nom_tag"));
                                tag.setSeqTag(result.getLong("seq_tag"));
                                tag.setUser(user);
                                listAllTag.add(tag);
                            } while (result.next());
                        }
                        return listAllTag;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("codEmail", user.getCodEmail());
            ArrayList returnedObjects = genericDAO.findByNamedQuery("tagJPA.findAll", namedParams);

            return returnedObjects;
        }
    }

    @Override
    public Long searchTagByName(String nomeTag, User user) throws PersistenceException {
        if (!JPAUtil.usingJPA) {
            try (Connection connection = ConnectionManager.getInstance().getConnection()) {
                Long id = null;
                String sql = "SELECT seq_tag FROM Tag WHERE nom_tag=? and cod_email=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, nomeTag);
                    preparedStatement.setString(2, user.getCodEmail());

                    try (ResultSet result = preparedStatement.executeQuery()) {
                        if (result.next()) {
                            id = result.getLong("seq_tag");
                        }
                    }
                }
                return id;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("nomeTag", nomeTag);
            namedParams.put("codEmail", user.getCodEmail());
            
            return (Long) genericDAO.findByNamedQuery("tagJPA.findByNomTag", namedParams).get(0); 
        }
    }

    @Override
    public Tag searchTagById(Long idTag) throws PersistenceException {
        if (!JPAUtil.usingJPA) {
            try (Connection connection = ConnectionManager.getInstance().getConnection()) {
                String sql = "SELECT * FROM tag WHERE seq_tag=?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setLong(1, idTag);

                    try (ResultSet result = preparedStatement.executeQuery()) {
                        Tag tag = new Tag();

                        if (result.next()) {
                            tag.setTagName(result.getString("nom_tag"));
                            tag.setSeqTag(result.getLong("seq_tag"));
                        }
                        return tag;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new PersistenceException(ex.getMessage(), ex);
            }
        } else {
            Map<String, Object> namedParams = new HashMap<>();
            namedParams.put("idTag", idTag);
            
            return (Tag) genericDAO.findByNamedQuery("tagJPA.findByIdTag", namedParams).get(0); 
        }
    }
}
