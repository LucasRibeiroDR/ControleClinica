package controle;

import dao.UsuarioDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Usuario;

@ManagedBean(name = "usuarioControle")
@ViewScoped
public class UsuarioControle implements Serializable {
    private Usuario usuario;
    private Usuario aux;
    private UsuarioDao dao;
    private List<Usuario> usuarios;
    
    public UsuarioControle(){
        usuario = new Usuario();
        dao = new UsuarioDao();
        usuarios = dao.listarTodos();
    }
    
    public void salvarNovoUsuario(){
        dao.inserir(usuario);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario cadastrado", null));
        usuarios.add(usuario);
        usuario = new Usuario();
    }
    
    public void preparaAlterar(Usuario c){
        aux = c;
    }
    
    public void alterar(){
        System.out.println("alteracao: " + aux.getNome());
        dao.alterar(aux);
    }
    
    public void excluir(Usuario c){
        dao.excluir(c);
        usuarios.remove(c);
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDao getDao() {
        return dao;
    }

    public void setDao(UsuarioDao dao) {
        this.dao = dao;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getAux() {
        return aux;
    }

    public void setAux(Usuario aux) {
        this.aux = aux;
    }
    
}