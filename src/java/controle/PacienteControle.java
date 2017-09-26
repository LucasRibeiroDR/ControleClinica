package controle;

import dao.PacienteDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Paciente;

@ManagedBean(name = "pacienteControle")
@ViewScoped
public class PacienteControle implements Serializable {
    private Paciente paciente;
    private Paciente aux;
    private PacienteDao dao;
    private List<Paciente> pacientes;
    
    public PacienteControle(){
        paciente = new Paciente();
        dao = new PacienteDao();
        pacientes = dao.listarTodos();
    }
    
    public void salvarNovoPaciente(){
        dao.inserir(paciente);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente cadastrado", null));
        pacientes.add(paciente);
        paciente = new Paciente();
    }
    
    public void preparaAlterar(Paciente c){
        aux = c;
    }
    
    public void alterar(){
        System.out.println("alteracao: " + aux.getNome());
        dao.alterar(aux);
    }
    
    public void excluir(Paciente c){
        dao.excluir(c);
        pacientes.remove(c);
    }
    

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public PacienteDao getDao() {
        return dao;
    }

    public void setDao(PacienteDao dao) {
        this.dao = dao;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Paciente getAux() {
        return aux;
    }

    public void setAux(Paciente aux) {
        this.aux = aux;
    }
    
}