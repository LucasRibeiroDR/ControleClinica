package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Usuario;
import util.JpaUtil;


public class UsuarioDao implements Serializable {
    EntityManager manager;
    
    public boolean inserir(Usuario usuario){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(usuario);
        tx.commit();
        manager.close();
        return true;
    }
    
        public boolean alterar(Usuario usuario){
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(usuario);
        manager.getTransaction().commit();
        manager.close();
        return true;
}
    
    public Usuario buscarPorCodigo(int cod){
        manager = JpaUtil.getEntityManager();
        Usuario usuario = manager.find(Usuario.class, cod);
        manager.close();
        return usuario;
    }
    
    public boolean excluir(Usuario usuario){///Esta classe exclui um usuario a partir do codgio
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        Usuario temp = manager.find(Usuario.class, usuario.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Usuario> listarTodos(){
        EntityManager manager = JpaUtil.getEntityManager();
        CriteriaQuery<Usuario> query = manager.getCriteriaBuilder().createQuery(Usuario.class);
        query.select(query.from(Usuario.class));
        List<Usuario> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
        
    
}