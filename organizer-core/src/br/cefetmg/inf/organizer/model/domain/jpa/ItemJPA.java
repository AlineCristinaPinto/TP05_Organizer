package br.cefetmg.inf.organizer.model.domain.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duduf
 */
@Entity
@Table(name = "item", catalog = "organizer", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemJPA.findAll", query = "SELECT i FROM ItemJPA i WHERE i.codEmail = :codEmail")
    , @NamedQuery(name = "ItemJPA.deleteItem", query = "DELETE FROM ItemJPA i WHERE i.seqItem = :seqItem and i.codEmail = :codEmail")
    , @NamedQuery(name = "ItemJPA.findByNomItem", query = "SELECT i FROM ItemJPA i WHERE i.nomItem = :nomItem")
    , @NamedQuery(name = "ItemJPA.findByDesItem", query = "SELECT i FROM ItemJPA i WHERE i.desItem = :desItem")
    , @NamedQuery(name = "ItemJPA.findByDatItem", query = "SELECT i FROM ItemJPA i WHERE i.datItem = :datItem")
    , @NamedQuery(name = "ItemJPA.findByIdtItem", query = "SELECT i FROM ItemJPA i WHERE i.idtItem = :idtItem")
    , @NamedQuery(name = "ItemJPA.findByIdtEstado", query = "SELECT i FROM ItemJPA i WHERE i.idtEstado = :idtEstado")
    , @NamedQuery(name = "ItemJPA.searchItemByTag", query = "SELECT i FROM ItemJPA i WHERE i.seqItem IN (SELECT it.itemTagPK.seqItem "
                                                            + "FROM ItemTagJPA it WHERE it.itemTagPK.seqTag IN :seqTagList "
                                                            + "GROUP BY it.itemTagPK.seqItem HAVING COUNT(it.itemTagPK.seqItem) = :countTags) "
                                                            + "AND i.codEmail = :codEmail")
    , @NamedQuery(name = "ItemJPA.searchItemByType", query = "SELECT i FROM ItemJPA i WHERE i.idtItem IN :typeList "
                                                            + "AND i.codEmail = :codEmail")
    , @NamedQuery(name = "ItemJPA.searchItemByTagAndType", query = "SELECT i FROM ItemJPA i WHERE i.seqItem IN (SELECT it.itemTagPK.seqItem "
                                                            + "FROM ItemTagJPA it WHERE it.itemTagPK.seqTag IN :seqTagList "
                                                            + "GROUP BY it.itemTagPK.seqItem HAVING COUNT(it.itemTagPK.seqItem) = :countTags) "
                                                            + "AND i.idtItem IN :typeList AND i.codEmail = :codEmail")})
public class ItemJPA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seq_item")
    private Integer seqItem;
    @Basic(optional = false)
    @Column(name = "nom_item")
    private String nomItem;
    @Column(name = "des_item")
    private String desItem;
    @Column(name = "dat_item")
    @Temporal(TemporalType.DATE)
    private Date datItem;
    @Basic(optional = false)
    @Column(name = "idt_item")
    private String idtItem;
    @Column(name = "idt_estado")
    private Character idtEstado;
    @JoinColumn(name = "cod_email", referencedColumnName = "cod_email")
    @ManyToOne(optional = false)
    private String codEmail;

    public ItemJPA() {
    }

    public ItemJPA(Integer seqItem) {
        this.seqItem = seqItem;
    }

    public ItemJPA(Integer seqItem, String nomItem, String idtItem) {
        this.seqItem = seqItem;
        this.nomItem = nomItem;
        this.idtItem = idtItem;
    }

    public Integer getSeqItem() {
        return seqItem;
    }

    public void setSeqItem(Integer seqItem) {
        this.seqItem = seqItem;
    }

    public String getNomItem() {
        return nomItem;
    }

    public void setNomItem(String nomItem) {
        this.nomItem = nomItem;
    }

    public String getDesItem() {
        return desItem;
    }

    public void setDesItem(String desItem) {
        this.desItem = desItem;
    }

    public Date getDatItem() {
        return datItem;
    }

    public void setDatItem(Date datItem) {
        this.datItem = datItem;
    }

    public String getIdtItem() {
        return idtItem;
    }

    public void setIdtItem(String idtItem) {
        this.idtItem = idtItem;
    }

    public Character getIdtEstado() {
        return idtEstado;
    }

    public void setIdtEstado(Character idtEstado) {
        this.idtEstado = idtEstado;
    }

    public String getCodEmail() {
        return codEmail;
    }

    public void setCodEmail(String codEmail) {
        this.codEmail = codEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqItem != null ? seqItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemJPA)) {
            return false;
        }
        ItemJPA other = (ItemJPA) object;
        if ((this.seqItem == null && other.seqItem != null) || (this.seqItem != null && !this.seqItem.equals(other.seqItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cefetmg.inf.organizer.model.domain.jpa.Item[ seqItem=" + seqItem + " ]";
    }
    
}
