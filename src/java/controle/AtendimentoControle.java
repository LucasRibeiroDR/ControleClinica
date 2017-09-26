package controle;

import dao.AtendimentoDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Atendimento;

@ManagedBean(name = "atendimentoControle")
@ViewScoped
public class AtendimentoControle implements Serializable {
    private Atendimento atendimento;
    private Atendimento aux;
    private AtendimentoDao dao;
    private List<Atendimento> atendimentos;
    
    public AtendimentoControle(){
        atendimento = new Atendimento();
        dao = new AtendimentoDao();
        atendimentos = dao.listarTodos();
    }
    
    public void salvarNovoAtendimento(){
        dao.inserir(atendimento);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atendimento cadastrado", null));
        atendimentos.add(atendimento);
        atendimento = new Atendimento();
    }
    
    public void preparaAlterar(Atendimento c){
        aux = c;
    }
    
    public void alterar(){
        System.out.println("alteracao: " + aux.getNome());
        dao.alterar(aux);
    }
    
    public void excluir(Atendimento c){
        dao.excluir(c);
        atendimentos.remove(c);
    }
    

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public AtendimentoDao getDao() {
        return dao;
    }

    public void setDao(AtendimentoDao dao) {
        this.dao = dao;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimento) {
        this.atendimentos = atendimento;
    }

    public Atendimento getAux() {
        return aux;
    }

    public void setAux(Atendimento aux) {
        this.aux = aux;
    }
    
}