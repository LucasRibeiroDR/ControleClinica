package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Administrador;
import util.JpaUtil;


public class AdministradorDao implements Serializable {
    EntityManager manager;
    
    public Administrador autenticar(Administrador adm){
        Administrador temp = null; // administrador retornado na consulta ao banco
        manager = JpaUtil.getEntityManager();
        TypedQuery<Administrador> query = manager.createQuery("SELECT a FROM Administrador a WHERE a.codigo = :codigo AND a.senha = :senha",
                Administrador.class); 
        query.setParameter("codigo", adm.getCodigo());
        query.setParameter("senha", adm.getSenha());
        try{
            temp = query.getSingleResult(); 
        }
        catch(Exception e){ }    
        finally{
            manager.close();
        }        
        return temp;
    }
    
        public boolean inserir(Administrador administrador){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(administrador);
        tx.commit();
        manager.close();
        return true;
    }
    
}