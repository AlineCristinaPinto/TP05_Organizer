/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author duduf
 */
@Embeddable
public class ItemTagPKJPA implements Serializable {

    @Basic(optional = false)
    @Column(name = "seq_item")
    private int seqItem;
    @Basic(optional = false)
    @Column(name = "seq_tag")
    private int seqTag;

    public ItemTagPKJPA() {
    }

    public ItemTagPKJPA(int seqItem, int seqTag) {
        this.seqItem = seqItem;
        this.seqTag = seqTag;
    }

    public int getSeqItem() {
        return seqItem;
    }

    public void setSeqItem(int seqItem) {
        this.seqItem = seqItem;
    }

    public int getSeqTag() {
        return seqTag;
    }

    public void setSeqTag(int seqTag) {
        this.seqTag = seqTag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) seqItem;
        hash += (int) seqTag;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemTagPKJPA)) {
            return false;
        }
        ItemTagPKJPA other = (ItemTagPKJPA) object;
        if (this.seqItem != other.seqItem) {
            return false;
        }
        if (this.seqTag != other.seqTag) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cefetmg.inf.organizer.model.domain.jpa.ItemTagPK[ seqItem=" + seqItem + ", seqTag=" + seqTag + " ]";
    }
    
}
