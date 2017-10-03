package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Agendamento;
import util.JpaUtil;

/**
 *
 * @author a120074
 */
public class AgendamentoDao implements Serializable {
    EntityManager manager;
    
    public boolean inserir(Agendamento agendamento){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(agendamento);
        tx.commit();
        manager.close();
        return true;
    }
        
        public boolean alterar(Agendamento agendamento){
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(agendamento);
        manager.getTransaction().commit();
        manager.close();
        return true;
}
    
    public Agendamento buscarPorCodigo(int cod){
        manager = JpaUtil.getEntityManager();
        Agendamento agendamento = manager.find(Agendamento.class, cod);
        manager.close();
        return agendamento;
    }
    
    public boolean excluir(Agendamento agendamento){///Esta classe exclui um agendamento a partir do codgio
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        Agendamento temp = manager.find(Agendamento.class, agendamento.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Agendamento> listarTodos(){
        EntityManager manager = JpaUtil.getEntityManager();
        CriteriaQuery<Agendamento> query = manager.getCriteriaBuilder().createQuery(Agendamento.class);
        query.select(query.from(Agendamento.class));
        List<Agendamento> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
}