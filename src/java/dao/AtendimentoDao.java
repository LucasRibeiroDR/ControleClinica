package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Atendimento;
import modelo.Atendimento;
import util.JpaUtil;

/**
 *
 * @author a120074
 */
public class AtendimentoDao implements Serializable {
    EntityManager manager;
    
    public boolean inserir(Atendimento atendimento){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(atendimento);
        tx.commit();
        manager.close();
        return true;
    }
        
        public boolean alterar(Atendimento atendimento){
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(atendimento);
        manager.getTransaction().commit();
        manager.close();
        return true;
}
    
    public Atendimento buscarPorCodigo(int cod){
        manager = JpaUtil.getEntityManager();
        Atendimento atendimento = manager.find(Atendimento.class, cod);
        manager.close();
        return atendimento;
    }
    
    public boolean excluir(Atendimento atendimento){///Esta classe exclui um atendimento a partir do codgio
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        Atendimento temp = manager.find(Atendimento.class, atendimento.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Atendimento> listarTodos(){
        EntityManager manager = JpaUtil.getEntityManager();
        CriteriaQuery<Atendimento> query = manager.getCriteriaBuilder().createQuery(Atendimento.class);
        query.select(query.from(Atendimento.class));
        List<Atendimento> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
        
    
}