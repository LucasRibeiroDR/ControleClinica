package controle;

import dao.AgendamentoDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Agendamento;

@ManagedBean(name = "agendamentoControle")
@ViewScoped
public class AgendamentoControle implements Serializable {
    private Agendamento agendamento;
    private Agendamento aux;
    private AgendamentoDao dao;
    private List<Agendamento> agendamentos;
    
    public AgendamentoControle(){
        agendamento = new Agendamento();
        dao = new AgendamentoDao();
        agendamentos = dao.listarTodos();
    }
    
    public void salvarNovoAgendamento(){
        dao.inserir(agendamento);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agendamento cadastrado", null));
        agendamentos.add(agendamento);
        agendamento = new Agendamento();
    }
    
    public void preparaAlterar(Agendamento c){
        aux = c;
    }
    
    public void alterar(){
        System.out.println("alteracao: " + aux.getNome());
        dao.alterar(aux);
    }
    
    public void excluir(Agendamento c){
        dao.excluir(c);
        agendamentos.remove(c);
    }
    

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public AgendamentoDao getDao() {
        return dao;
    }

    public void setDao(AgendamentoDao dao) {
        this.dao = dao;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamento) {
        this.agendamentos = agendamento;
    }

    public Agendamento getAux() {
        return aux;
    }

    public void setAux(Agendamento aux) {
        this.aux = aux;
    }
    
}