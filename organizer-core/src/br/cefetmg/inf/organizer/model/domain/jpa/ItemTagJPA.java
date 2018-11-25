/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duduf
 */
@Entity
@Table(name = "item_tag", catalog = "organizer", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemTagJPA.getAll", query = "SELECT i FROM ItemTagJPA i")
    , @NamedQuery(name = "ItemTagJPA.getBySeqItem", query = "SELECT i FROM ItemTagJPA i WHERE i.itemTagPK.seqItem = :seqItem")
    , @NamedQuery(name = "ItemTagJPA.getBySeqTag", query = "SELECT i FROM ItemTagJPA i WHERE i.itemTagPK.seqTag = :seqTag")})
public class ItemTagJPA implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemTagPKJPA itemTagPK;

    public ItemTagJPA() {
    }

    public ItemTagJPA(ItemTagPKJPA itemTagPK) {
        this.itemTagPK = itemTagPK;
    }

    public ItemTagJPA(int seqItem, int seqTag) {
        this.itemTagPK = new ItemTagPKJPA(seqItem, seqTag);
    }

    public ItemTagPKJPA getItemTagPK() {
        return itemTagPK;
    }

    public void setItemTagPK(ItemTagPKJPA itemTagPK) {
        this.itemTagPK = itemTagPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemTagPK != null ? itemTagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemTagJPA)) {
            return false;
        }
        ItemTagJPA other = (ItemTagJPA) object;
        if ((this.itemTagPK == null && other.itemTagPK != null) || (this.itemTagPK != null && !this.itemTagPK.equals(other.itemTagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cefetmg.inf.organizer.model.domain.jpa.ItemTag[ itemTagPK=" + itemTagPK + " ]";
    }
    
}
