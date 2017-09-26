package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Paciente;
import util.JpaUtil;


public class PacienteDao implements Serializable {
    EntityManager manager;
    
    public boolean inserir(Paciente paciente){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(paciente);
        tx.commit();
        manager.close();
        return true;
    }
    
        public boolean alterar(Paciente paciente){
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(paciente);
        manager.getTransaction().commit();
        manager.close();
        return true;
}
    
    public Paciente buscarPorCodigo(int cod){
        manager = JpaUtil.getEntityManager();
        Paciente paciente = manager.find(Paciente.class, cod);
        manager.close();
        return paciente;
    }
    
    public boolean excluir(Paciente paciente){///Esta classe exclui um paciente a partir do codgio
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        Paciente temp = manager.find(Paciente.class, paciente.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Paciente> listarTodos(){
        EntityManager manager = JpaUtil.getEntityManager();
        CriteriaQuery<Paciente> query = manager.getCriteriaBuilder().createQuery(Paciente.class);
        query.select(query.from(Paciente.class));
        List<Paciente> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
        
    
}