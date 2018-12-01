/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.domain.jpa;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duduf
 */
@Entity
@Table(name = "tag", catalog = "organizer", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagJPA.getAll", query = "SELECT t FROM TagJPA t")
    , @NamedQuery(name = "TagJPA.getBySeqTag", query = "SELECT t FROM TagJPA t WHERE t.seqTag = :seqTag")
    , @NamedQuery(name = "TagJPA.getByNomTag", query = "SELECT t FROM TagJPA t WHERE t.nomTag = :nomTag")})
public class TagJPA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seq_tag")
    private Integer seqTag;
    @Basic(optional = false)
    @Column(name = "nom_tag")
    private String nomTag;
    @JoinColumn(name = "cod_email", referencedColumnName = "cod_email")
    @ManyToOne(optional = false)
    private String codEmail;

    public TagJPA() {
    }

    public TagJPA(Integer seqTag) {
        this.seqTag = seqTag;
    }

    public TagJPA(Integer seqTag, String nomTag) {
        this.seqTag = seqTag;
        this.nomTag = nomTag;
    }

    public Integer getSeqTag() {
        return seqTag;
    }

    public void setSeqTag(Integer seqTag) {
        this.seqTag = seqTag;
    }

    public String getNomTag() {
        return nomTag;
    }

    public void setNomTag(String nomTag) {
        this.nomTag = nomTag;
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
        hash += (seqTag != null ? seqTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TagJPA)) {
            return false;
        }
        TagJPA other = (TagJPA) object;
        if ((this.seqTag == null && other.seqTag != null) || (this.seqTag != null && !this.seqTag.equals(other.seqTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cefetmg.inf.organizer.model.domain.jpa.Tag[ seqTag=" + seqTag + " ]";
    }
    
}
