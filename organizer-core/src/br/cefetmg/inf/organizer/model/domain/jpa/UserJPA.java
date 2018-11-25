/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.domain.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author duduf
 */
@Entity
@Table(name = "usuario", catalog = "organizer", schema = "public")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "UserJPA.getUserLogin", query = "SELECT u FROM UserJPA u WHERE u.codEmail = :codEmail AND u.txtSenha = :txtSenha"),
@NamedQuery(name = "UserJPA.getUser", query = "SELECT u FROM UserJPA u WHERE u.codEmail = :codEmail")})
public class UserJPA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_email")
    private String codEmail;
    @Basic(optional = false)
    @Column(name = "nom_usuario")
    private String nomUsuario;
    @Basic(optional = false)
    @Column(name = "txt_senha")
    private String txtSenha;
    @Lob
    @Column(name = "blb_imagem")
    private byte[] blbImagem;
    @Basic(optional = false)
    @Column(name = "seq_tema")
    private int seqTema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEmail")
    private Collection<ItemJPA> itemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEmail")
    private Collection<TagJPA> tagCollection;

    public UserJPA() {
    }

    public UserJPA(String codEmail) {
        this.codEmail = codEmail;
    }

    public UserJPA(String codEmail, String nomUsuario, String txtSenha, int seqTema) {
        this.codEmail = codEmail;
        this.nomUsuario = nomUsuario;
        this.txtSenha = txtSenha;
        this.seqTema = seqTema;
    }

    public String getCodEmail() {
        return codEmail;
    }

    public void setCodEmail(String codEmail) {
        this.codEmail = codEmail;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(String txtSenha) {
        this.txtSenha = txtSenha;
    }

    public byte[] getBlbImagem() {
        return blbImagem;
    }

    public void setBlbImagem(byte[] blbImagem) {
        this.blbImagem = blbImagem;
    }

    public int getSeqTema() {
        return seqTema;
    }

    public void setSeqTema(int seqTema) {
        this.seqTema = seqTema;
    }

    @XmlTransient
    public Collection<ItemJPA> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<ItemJPA> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @XmlTransient
    public Collection<TagJPA> getTagCollection() {
        return tagCollection;
    }

    public void setTagCollection(Collection<TagJPA> tagCollection) {
        this.tagCollection = tagCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmail != null ? codEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserJPA)) {
            return false;
        }
        UserJPA other = (UserJPA) object;
        if ((this.codEmail == null && other.codEmail != null) || (this.codEmail != null && !this.codEmail.equals(other.codEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cefetmg.inf.organizer.model.domain.jpa.Usuario[ codEmail=" + codEmail + " ]";
    }
    
}
