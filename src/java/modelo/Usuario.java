/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author a120088
 */
@Entity
@Table(name= "usuario")//nome da tabela;
public class Usuario implements Serializable{

    /**
     * @return the codigo
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private Integer codigo;
    
    @Column(length =50, name="nome")
    private String nome;
    
    @Column(length =11, name="cpf_Usuario")
    private String cpf_Usuario;
 
    @Column(length =20, name="senhaDeAcesso")
    private String senhaDeAcesso;
    
    
    
    public Usuario(){
        this.codigo = 0;
        this.nome = "";
        this.cpf_Usuario="";
        
    }

    public Integer getUsuario() {
        return getCodigo();
    }


    public void setUsuario(Integer usuario) {
        this.setCodigo(usuario);
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    
        public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cpf_Usuario
     */
    public String getCpf_Usuario() {
        return cpf_Usuario;
    }

    /**
     * @param cpf_Usuario the cpf_Usuario to set
     */
    public void setCpf_Usuario(String cpf_Usuario) {
        this.cpf_Usuario = cpf_Usuario;
    }

    /**
     * @return the rg_Usuario
     */
   

    /**
     * @return the senhaDeAcesso
     */
    public String getSenhaDeAcesso() {
        return senhaDeAcesso;
    }

    /**
     * @param senhaDeAcesso the senhaDeAcesso to set
     */
    public void setSenhaDeAcesso(String senhaDeAcesso) {
        this.senhaDeAcesso = senhaDeAcesso;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.getCodigo());
        hash = 31 * hash + Objects.hashCode(this.getNome());
        hash = 31 * hash + Objects.hashCode(this.getCpf_Usuario());
        hash = 31 * hash + Objects.hashCode(this.getSenhaDeAcesso());

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        
        
        
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf_Usuario, other.cpf_Usuario)) {
            return false;
        }
       
        if (!Objects.equals(this.senhaDeAcesso, other.senhaDeAcesso)) {
            return false;
        }
        return true;
    }

}
